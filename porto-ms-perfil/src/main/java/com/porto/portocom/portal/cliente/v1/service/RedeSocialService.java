package com.porto.portocom.portal.cliente.v1.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.entity.AplicacaoRedeSocial;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioRedeSocial;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.RedeSocialException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.repository.IAplicacaoRedeSocialRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioRedeSocialRepository;
import com.porto.portocom.portal.cliente.v1.utils.TrataCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.vo.CpfCnpjVO;
import com.porto.portocom.portal.cliente.v1.vo.RedeSocial;
import com.porto.portocom.portal.cliente.v1.vo.SocialClienteConsulta;
import com.porto.portocom.portal.cliente.v1.vo.VinculoRedeSocial;

import reactor.core.publisher.Mono;

@Service
public class RedeSocialService implements IRedeSocialService {

	private static final Logger LOG = LoggerFactory.getLogger(RedeSocialService.class);

	private IUsuarioPortalClienteRepository usuarioPortalClienteRepository;

	private IUsuarioRedeSocialRepository usuarioRedeSocialRepository;

	private IAplicacaoRedeSocialRepository aplicacaoRedeSocialRepository;

	private MensagemLocalCacheService mensagemLocalCacheService;

	@Autowired
	RedeSocialService(IUsuarioPortalClienteRepository usuarioPortalClienteRepository,
			IUsuarioRedeSocialRepository usuarioRedeSocialRepository,
			IAplicacaoRedeSocialRepository aplicacaoRedeSocialRepository,
			MensagemLocalCacheService mensagemLocalCacheService) {
		this.usuarioPortalClienteRepository = usuarioPortalClienteRepository;
		this.usuarioRedeSocialRepository = usuarioRedeSocialRepository;
		this.aplicacaoRedeSocialRepository = aplicacaoRedeSocialRepository;
		this.mensagemLocalCacheService = mensagemLocalCacheService;
	}

	private Mono<UsuarioPortalCliente> consultarUsuario(String cpfCnpj) {

		if (ValidaCpfCnpjUtils.isValid(cpfCnpj)) {
			CpfCnpjVO cpfCnpjVO = TrataCpfCnpjUtils.obterCpfCnpjFormatado(cpfCnpj);

			return Mono.justOrEmpty(usuarioPortalClienteRepository.findByCpf(cpfCnpjVO.getCpfCnpjOrdem().longValue(),
					cpfCnpjVO.getCpfCnpjNumero(), cpfCnpjVO.getCpfCnpjDigito().longValue()));
		} else {
			LOG.debug(MensagemChaveEnum.COMMONS_VALIDACAO_CPF_CNPJ.getValor());
			return Mono.error(new CpfCnpjInvalidoException(this.mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_VALIDACAO_CPF_CNPJ.getValor())));
		}

	}

	@Override
	public Mono<Boolean> desvinculaRedeSocial(String cpfCnpj, String idRedeSocial) {
		return consultarUsuario(cpfCnpj)
				.switchIfEmpty(Mono.error(new UsuarioPortalException(
						MensagemUsuarioEnum.USUARIO_NAO_ENCONTRADO.getValor(), HttpStatus.NOT_FOUND.value())))
				.flatMap(
						usuario -> Mono.justOrEmpty(usuarioRedeSocialRepository.findByIdRedeSocial(idRedeSocial))
								.switchIfEmpty(Mono.error(new UsuarioPortalException(
										"Usuario não possui vinculo com rede social", HttpStatus.NOT_FOUND.value())))
								.flatMap(usuarioRedeSocial -> {
									if (usuario.getIdUsuario()
											.equals(usuarioRedeSocial.getUsuarioPortalCliente().getIdUsuario())) {
										usuarioRedeSocial.setFlagVinculoAtivo("N");
										usuarioRedeSocial.setDataUltimaAtualizacao(new Date());
										usuarioRedeSocialRepository.save(usuarioRedeSocial);
										return Mono.just(true);
									} else {
										return Mono.error(new RedeSocialException(
												this.mensagemLocalCacheService.recuperaTextoMensagem(
														MensagemChaveEnum.PERFIL_VALIDACAO_CPF_DIFERENTE_REDESOCIAL
																.getValor()),
												HttpStatus.CONFLICT.value()));
									}
								}));

	}

	@Override
	public Mono<RedeSocial> consultaPorIdRedeSocial(String idSocialCliente) {
		return Mono.justOrEmpty(usuarioRedeSocialRepository.findByIdRedeSocial(idSocialCliente))
				.switchIfEmpty(Mono.error(new UsuarioPortalException(
						this.mensagemLocalCacheService.recuperaTextoMensagem(
								MensagemChaveEnum.PERFIL_VALIDACAO_USUARIO_SEM_REDESOCIAL.getValor()),
						HttpStatus.NOT_FOUND.value())))
				.map(RedeSocial::new);
	}

	@Override
	public Mono<Boolean> vinculaRedeSocial(String cpfCnpj, VinculoRedeSocial vinculoRedeSocial) {
		return consultarUsuario(cpfCnpj).flatMap(usuarioPortal -> {
			return Mono
					.justOrEmpty(usuarioRedeSocialRepository.findByIdRedeSocialAndIdUsuario(
							vinculoRedeSocial.getIdSocialCliente(), usuarioPortal.getIdUsuario()))
					.flatMap(usuarioRedeSocial -> {

						if (usuarioPortal.getIdUsuario()
								.equals(usuarioRedeSocial.getUsuarioPortalCliente().getIdUsuario())) {
							usuarioPortal.setFlagExibirVinculoRedeSocial("S");
							usuarioPortal.setDataAtualizacaoProduto(new Date());

							String flagVinculoAtivo = usuarioRedeSocial.getFlagVinculoAtivo();

							if (flagVinculoAtivo.equals("N")) {
								usuarioRedeSocial.setIdSocialCliente(vinculoRedeSocial.getIdSocialCliente());
								usuarioRedeSocial.setFlagVinculoAtivo("S");
								usuarioRedeSocial.setDataUltimaAtualizacao(new Date());
								usuarioRedeSocialRepository.save(usuarioRedeSocial);

							} else {
								return Mono.error(
										new RedeSocialException(this.mensagemLocalCacheService.recuperaTextoMensagem(
												MensagemChaveEnum.PERFIL_VALIDACAO_USUARIO_POSSUI_REDESOCIAL
														.getValor()),
												HttpStatus.CONFLICT.value()));
							}
							usuarioPortalClienteRepository.save(usuarioPortal);

							return Mono.just(Boolean.TRUE);

						} else {
							return Mono.error(new RedeSocialException(
									this.mensagemLocalCacheService.recuperaTextoMensagem(
											MensagemChaveEnum.PERFIL_VALIDACAO_CPF_DIFERENTE_REDESOCIAL.getValor()),
									HttpStatus.CONFLICT.value()));

						}

					}).switchIfEmpty(Mono.defer(() -> criarNovoVinculoRedeSocal(usuarioPortal, vinculoRedeSocial)));

		}).switchIfEmpty(Mono.defer(() -> Mono.error(new UsuarioPortalException(
				this.mensagemLocalCacheService
						.recuperaTextoMensagem(MensagemChaveEnum.PERFIL_VALIDACAO_REDESOCIAL_NAO_ENCONTRADA.getValor()),
				HttpStatus.NOT_FOUND.value()))));
	}

	private Mono<Boolean> criarNovoVinculoRedeSocal(UsuarioPortalCliente usuarioPortalCliente,
			VinculoRedeSocial vinculoRedeSocial) {

		UsuarioRedeSocial usuarioRedeSocial = new UsuarioRedeSocial();

		AplicacaoRedeSocial aplicacaoRedeSocial = aplicacaoRedeSocialRepository
				.findBytextoIdentificadorAplicacaoRedeSocial(
						vinculoRedeSocial.getTextoIdentificadorAplicacaoRedeSocial());

		usuarioRedeSocial.setAplicacaoRedeSocial(aplicacaoRedeSocial);
		usuarioRedeSocial.setUsuarioPortalCliente(usuarioPortalCliente);
		usuarioRedeSocial.setDataUltimaAtualizacao(new Date());
		usuarioRedeSocial.setFlagVinculoAtivo("S");
		usuarioRedeSocial.setIdSocialCliente(vinculoRedeSocial.getIdSocialCliente());

		usuarioPortalCliente.setFlagExibirVinculoRedeSocial("S");
		usuarioPortalCliente.setDataAtualizacaoProduto(new Date());
		usuarioPortalClienteRepository.save(usuarioPortalCliente);
		usuarioRedeSocialRepository.save(usuarioRedeSocial);
		return Mono.just(Boolean.TRUE);
	}

	public Mono<List<RedeSocial>> consultaPorCpfCnpj(String cpfCnpj) {
		return consultarUsuario(cpfCnpj)
				.switchIfEmpty(Mono.error(new UsuarioPortalException(
						MensagemUsuarioEnum.USUARIO_NAO_ENCONTRADO.getValor(), HttpStatus.NOT_FOUND.value())))
				.flatMap(usuario -> Mono
						.justOrEmpty(usuarioRedeSocialRepository.findByIdUsuario(usuario.getIdUsuario())))
				.flatMap(listUsuarioRedeSocial -> {
					if (!listUsuarioRedeSocial.isEmpty()) {
						List<RedeSocial> listRedeSocial = new ArrayList<>();
						listUsuarioRedeSocial.forEach(usuarioRede -> listRedeSocial.add(new RedeSocial(usuarioRede)));
						return Mono.just(listRedeSocial);
					} else {
						return Mono.error(new UsuarioPortalException(
								this.mensagemLocalCacheService.recuperaTextoMensagem(
										MensagemChaveEnum.PERFIL_VALIDACAO_USUARIO_SEM_REDESOCIAL.getValor()),
								HttpStatus.NOT_FOUND.value()));
					}
				});
	}

	@Override
	public Mono<List<RedeSocial>> consultaPorIdRedeSocialAndIdentificadorRedeSocial(
			SocialClienteConsulta redeSocialConsulta) {
		return Mono
				.justOrEmpty(aplicacaoRedeSocialRepository.findBytextoIdentificadorAplicacaoRedeSocial(
						redeSocialConsulta.getTextoIdentificadorAplicacaoRedeSocial()))
				.switchIfEmpty(Mono
						.error(new RedeSocialException("Rede Social não encontrada.", HttpStatus.BAD_REQUEST.value())))
				.flatMap(aplicacaoRedeSocial -> Mono
						.justOrEmpty(usuarioRedeSocialRepository.findByIdRedeSocialAndAplicacaoRedeSocialId(
								redeSocialConsulta.getIdSocialCliente(), aplicacaoRedeSocial.getCodigoSequencial())))
				.flatMap(listUsuarioRedeSocial -> {
					if (!listUsuarioRedeSocial.isEmpty()) {
						List<RedeSocial> listRedeSocial = new ArrayList<>();
						listUsuarioRedeSocial.forEach(usuarioRede -> listRedeSocial.add(new RedeSocial(usuarioRede)));
						return Mono.just(listRedeSocial);
					} else {
						return Mono.error(new UsuarioPortalException(
								this.mensagemLocalCacheService.recuperaTextoMensagem(
										MensagemChaveEnum.PERFIL_VALIDACAO_USUARIO_SEM_REDESOCIAL.getValor()),
								HttpStatus.NOT_FOUND.value()));
					}
				});
	}

}
