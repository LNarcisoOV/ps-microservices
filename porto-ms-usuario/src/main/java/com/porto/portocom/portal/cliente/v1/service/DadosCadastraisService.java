package com.porto.portocom.portal.cliente.v1.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.v1.constant.LogSubTipoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.exception.PortalException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.utils.AplicaMascaraUtil;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.utils.TrataCelularUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCelularUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaEmailUtils;
import com.porto.portocom.portal.cliente.v1.vo.antifraude.CorporativoValidation;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TelefoneVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificado;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioVO;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
public class DadosCadastraisService implements IDadosCadastraisService {

	private static final String HEADER_EXCEPTION_MESSAGE = "O Header corporativoRequestHeader não foi informado ou não foi encontrado.";

	private IProspectService prospectService;
	private IUsuarioPortalService usuarioPortalService;
	private IUsuarioPortalClienteRepository usuarioPortalClienteRepository;
	private ILogPortalClienteService logPortalClienteService;
	private ILexisNexisService lexisNexisService;
	private MensagemLocalCacheService mensagemLocalCacheService;
	private LexisNexisUtils lexisNexisUtils;

	@Autowired
	public DadosCadastraisService(IProspectService prospectService, IUsuarioPortalService usuarioPortalService,
			IUsuarioPortalClienteRepository usuarioPortalClienteRepository,
			ILogPortalClienteService logPortalClienteService, ILexisNexisService lexisNexisService,
			MensagemLocalCacheService mensagemLocalCacheService, LexisNexisUtils lexisNexisUtils) {
		this.prospectService = prospectService;
		this.usuarioPortalService = usuarioPortalService;
		this.usuarioPortalClienteRepository = usuarioPortalClienteRepository;
		this.logPortalClienteService = logPortalClienteService;
		this.lexisNexisService = lexisNexisService;
		this.mensagemLocalCacheService = mensagemLocalCacheService;
		this.lexisNexisUtils = lexisNexisUtils;
	}

	@Override
	public Mono<Tuple2<List<UsuarioSimplificado>, CorporativoValidation>> atualizaDadosCadastrais(UsuarioVO usuarioVo,
			TipoCodigoEnum tipoCodigo) {

		if (!lexisNexisUtils.verificaFlagLexis()) {
			return Mono.error(new PortalException(HEADER_EXCEPTION_MESSAGE, HttpStatus.BAD_REQUEST.value()));
		}

		return this.validaUsuarioAtualizacaoDadosCadastrais(usuarioVo.getEmail(), usuarioVo.getCelular()).flatMap(
				isValid -> this.usuarioPortalService.consultar(usuarioVo.getCpfCnpj()).flatMap(usuarioPortal -> {
					if (usuarioPortal.getStatusUsuario().getIdStatusConta()
							.equals(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus())
							|| usuarioPortal.getStatusUsuario().getIdStatusConta()
									.equals(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus())
							|| usuarioPortal.getStatusUsuario().getIdStatusConta()
									.equals(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus())
							|| usuarioPortal.getStatusUsuario().getIdStatusConta()
									.equals(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus())
							|| usuarioPortal.getStatusUsuario().getIdStatusConta()
									.equals(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus())
							|| usuarioPortal.getStatusUsuario().getIdStatusConta()
									.equals(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus())) {
						return this.lexisNexisService.validaLexisNexis(usuarioVo.getCpfCnpj(), usuarioVo, tipoCodigo)
								.flatMap(corporativoValidation -> Mono.zip(this.alteraDadosCadastrais(usuarioVo),
										Mono.just(corporativoValidation)));
					} else {
						return Mono.error(new UsuarioPortalException(
								mensagemLocalCacheService.recuperaTextoMensagem(
										MensagemChaveEnum.USUARIO_ERRO_ATUALIZAR_DADOS_STATUS_INVALIDO.getValor()),
								HttpStatus.BAD_REQUEST.value()));
					}
				}).switchIfEmpty(Mono.defer(
						() -> this.lexisNexisService.validaLexisNexis(usuarioVo.getCpfCnpj(), usuarioVo, tipoCodigo)
								.flatMap(corporativoValidation -> preCadastraUsuarioPortal(usuarioVo.getCpfCnpj())
										.flatMap(usuario -> this.alteraDadosCadastrais(usuarioVo))
										.flatMap(usuarioSimplificado -> Mono.zip(Mono.just(usuarioSimplificado),
												Mono.just(corporativoValidation)))))));
	}

	private Mono<UsuarioSimplificado> montaUsuarioSimplificado(UsuarioPortalCliente usuario) {

		UsuarioSimplificado usuarioSimplificadoBuilder = new UsuarioSimplificado();

		if (usuario.getNomeUsuarioPortal() != null) {
			usuarioSimplificadoBuilder.setNome(usuario.getNomeUsuarioPortal().split(" ")[0]);
		}

		TelefoneVO telefone = new TelefoneVO();
		if (usuario.getNumDddCelular() != null) {
			telefone.setDdd(usuario.getNumDddCelular().toString());
		}

		telefone.setNumeroTelefone(usuario.getNumCelular() != null ? usuario.getNumCelular().toString() : null);

		PessoaBcp.EnderecosEletronicos emailAcesso = new PessoaBcp.EnderecosEletronicos();
		emailAcesso.setEnderecoEletronico(usuario.getDescEmail());

		usuarioSimplificadoBuilder.setCelulares(AplicaMascaraUtil.formatarCelular(telefone));
		usuarioSimplificadoBuilder.setEmails(AplicaMascaraUtil.formatarEmail(emailAcesso.getEnderecoEletronico()));

		return Mono.just(usuarioSimplificadoBuilder);
	}

	private void geraLogPortalAtualizacaoCadastral(UsuarioPortalCliente usuarioPortalCliente) {
		logPortalClienteService.geraLogPortal(usuarioPortalCliente,
				MensagemChaveEnum.USUARIO_MSG_LOG_ALTERACAO_NOME_PORTAL_CONFIRMACAO_POSITIVA.getValor(),
				LogSubTipoEnum.ALTERACAO_NOME_PORTAL_CONFIRMACAO_POSITIVA.getCodigo());
		logPortalClienteService.geraLogPortal(usuarioPortalCliente,
				MensagemChaveEnum.USUARIO_MSG_LOG_ALTERACAO_EMAIL_DE_ACESSO_CONFIRMACAO_POSITIVA.getValor(),
				LogSubTipoEnum.ALTERACAO_EMAIL_DE_ACESSO_CONFIRMACAO_POSITIVA.getCodigo());
		logPortalClienteService.geraLogPortal(usuarioPortalCliente,
				MensagemChaveEnum.USUARIO_MSG_LOG_ALTERACAO_CELULAR_DE_ACESSO_CONFIRMACAO_POSITIVA.getValor(),
				LogSubTipoEnum.ALTERACAO_CELULAR_DE_ACESSO_CONFIRMACAO_POSITIVA.getCodigo());
	}

	private Mono<UsuarioSimplificado> salvaUsuarioSimplificado(UsuarioPortalCliente usuarioPortal, boolean geraLog) {

		return Mono.justOrEmpty(this.usuarioPortalClienteRepository.save(usuarioPortal)).flatMap(usuario -> {
			if (geraLog) {
				geraLogPortalAtualizacaoCadastral(usuario);
			}
			return montaUsuarioSimplificado(usuario);
		});
	}

	private Mono<UsuarioSimplificado> preCadastraUsuarioPortal(String cpfCnpj) {

		return prospectService.consultaProdutosProspect(cpfCnpj)
				.flatMap(produtos -> this.usuarioPortalService.obtemPessoaPorProdutos(produtos, cpfCnpj)
						.flatMap(pessoaVo -> this.salvaUsuarioSimplificado(
								this.usuarioPortalService.criaUsuarioPortalDePessoaVo(pessoaVo), false)));
	}

	private Mono<List<UsuarioSimplificado>> alteraDadosCadastrais(UsuarioVO usuarioVo) {

		return this.usuarioPortalService.consultar(usuarioVo.getCpfCnpj()).flatMap(usuarioCliente -> {
			if (StringUtils.isNotBlank(usuarioVo.getNome())) {
				usuarioCliente
						.setNomeUsuarioPortal(usuarioVo.getNome().length() > 100 ? usuarioVo.getNome().substring(0, 99)
								: usuarioVo.getNome());
			} else {
				usuarioCliente.setNomeUsuarioPortal(null);
			}
			usuarioCliente.setNumCelular(
					StringUtils.isBlank(usuarioVo.getEmail()) ? TrataCelularUtils.extrairNumero(usuarioVo.getCelular())
							: null);
			usuarioCliente.setNumDddCelular(
					StringUtils.isBlank(usuarioVo.getEmail()) ? TrataCelularUtils.extrairDdd(usuarioVo.getCelular())
							: null);
			usuarioCliente.setDescEmail(
					StringUtils.isBlank(usuarioVo.getCelular()) ? usuarioVo.getEmail() : StringUtils.EMPTY);

			return this.salvaUsuarioSimplificado(usuarioCliente, true).flatMap(usuarioSimplificado -> {
				List<UsuarioSimplificado> listaUsuarioSimplificado = new ArrayList<>();
				listaUsuarioSimplificado.add(usuarioSimplificado);
				return Mono.just(listaUsuarioSimplificado);
			});
		});
	}

	private Mono<Boolean> validaUsuarioAtualizacaoDadosCadastrais(String email, String celular) {

		if ((StringUtils.isNotBlank(celular)) && (StringUtils.isNotBlank(email))) {
			return Mono.error(new UsuarioPortalException(
					mensagemLocalCacheService.recuperaTextoMensagem(
							MensagemChaveEnum.USUARIO_ERRO_EMAIL_E_CELULAR_INFORMADOS.getValor()),
					HttpStatus.UNAUTHORIZED.value()));
		}

		if ((StringUtils.isBlank(celular)) && (StringUtils.isBlank(email))) {
			return Mono.error(new UsuarioPortalException(
					mensagemLocalCacheService.recuperaTextoMensagem(
							MensagemChaveEnum.USUARIO_ERRO_EMAIL_E_CELULAR_NAO_INFORMADOS.getValor()),
					HttpStatus.BAD_REQUEST.value()));
		}

		if ((StringUtils.isNotBlank(celular)) && !ValidaCelularUtils.isValid(celular)) {
			return Mono
					.error(new UsuarioPortalException(
							mensagemLocalCacheService
									.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_CELULAR_INVALIDO.getValor()),
							HttpStatus.FORBIDDEN.value()));
		}

		if ((StringUtils.isNotBlank(email)) && !ValidaEmailUtils.isValid(email)) {
			return Mono
					.error(new UsuarioPortalException(
							mensagemLocalCacheService
									.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_EMAIL_INVALIDO.getValor()),
							HttpStatus.BAD_REQUEST.value()));
		}
		return Mono.just(true);
	}
}
