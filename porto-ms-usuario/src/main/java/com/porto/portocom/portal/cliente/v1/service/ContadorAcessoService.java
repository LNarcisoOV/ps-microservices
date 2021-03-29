package com.porto.portocom.portal.cliente.v1.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.LogSubTipoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.ContadorAcessoException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContador;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContadorConta;

import reactor.core.publisher.Mono;

@Service
public class ContadorAcessoService extends ValidaQuantidadeTentativaService implements IContadorAcessoService {

	private IUsuarioPortalClienteRepository usuarioPortalClienteRepository;

	@Autowired
	ContadorAcessoService(IUsuarioPortalService usuarioPortalService,
			IUsuarioPortalClienteRepository usuarioPortalClienteRepository,
			ParametrosLocalCacheService parametrosLocalCacheService,
			MensagemLocalCacheService mensagemLocalCacheService, ILogPortalClienteService logPortalClienteService,
			ILexisNexisService lexisNexisService,LexisNexisUtils lexisNexisUtil) {
		super(lexisNexisService,lexisNexisUtil);
		this.usuarioPortalService = usuarioPortalService;
		this.usuarioPortalClienteRepository = usuarioPortalClienteRepository;
		this.parametrosLocalCacheService = parametrosLocalCacheService;
		this.mensagemLocalCacheService = mensagemLocalCacheService;
		this.logPortalClienteService = logPortalClienteService;
	}

	@Override
	public Mono<Boolean> reinicia(String cpfCnpj) {
		return usuarioPortalService.consultar(cpfCnpj).flatMap(
				usuarioPortal -> this.consultaContadoresTentativaAcesso(cpfCnpj).flatMap(informacaoContador -> {
					if (informacaoContador.getQtdTentativaAcesso() < informacaoContador.getQtdTentativaLimiteAcesso()
							|| usuarioPortal.getStatusUsuario().getIdStatusConta().equals(
									StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus())) {
						usuarioPortal.setQtdTentativaLogin(0L);
						return Mono.just(usuarioPortalClienteRepository.save(usuarioPortal)).map(usuario -> true);
					} else {
						return Mono.error(new ContadorAcessoException(
								this.mensagemLocalCacheService.recuperaTextoMensagem(
										MensagemChaveEnum.USUARIO_VALIDACAO_NUMERO_TENTATIVAS.getValor()),
								HttpStatus.BAD_REQUEST.value(), null));
					}
				}))
				.switchIfEmpty(Mono.error(new ContadorAcessoException(
						this.mensagemLocalCacheService
								.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor()),
						HttpStatus.NOT_FOUND.value(), null)));
	}

	@Override
	public Mono<InformacaoContador> consultaContadoresTentativaAcesso(String cpfCnpj) {
		return usuarioPortalService.consultar(cpfCnpj).flatMap(usuarioPortal -> {
			Long numeroTentativasAcesso = 0L;
			Long numeroTentativasLimiteAcesso = 0L;

			Long numeroTentativasCadastro = 0L;
			Long numeroTentativasLimiteCadastro = 0L;

			Long numeroTentativasRecuperacao = 0L;
			Long numeroTentativasLimiteRecuperacao = 0L;

			numeroTentativasAcesso = usuarioPortal.getQtdTentativaLogin() != null ? usuarioPortal.getQtdTentativaLogin()
					: 0L;
			numeroTentativasCadastro = usuarioPortal.getQuantidadeTentativaCriacaoConta() != null
					? usuarioPortal.getQuantidadeTentativaCriacaoConta()
					: 0L;
			numeroTentativasRecuperacao = usuarioPortal.getQuantidadeTentativasRecuperacaoConta() != null
					? usuarioPortal.getQuantidadeTentativasRecuperacaoConta()
					: 0L;

			numeroTentativasLimiteRecuperacao = Long.parseLong(parametrosLocalCacheService
					.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_RECUPERACAO.getValor()));
			numeroTentativasLimiteAcesso = Long.parseLong(parametrosLocalCacheService
					.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_LOGIN.getValor()));
			numeroTentativasLimiteCadastro = Long.parseLong(parametrosLocalCacheService
					.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_CRIACAO_CONTA.getValor()));

			InformacaoContador contadorAcesso = new InformacaoContador(numeroTentativasAcesso,
					numeroTentativasLimiteAcesso, numeroTentativasCadastro, numeroTentativasLimiteCadastro,
					numeroTentativasRecuperacao, numeroTentativasLimiteRecuperacao, true);

			return Mono.just(contadorAcesso);

		}).switchIfEmpty(Mono.error(new ContadorAcessoException(
				this.mensagemLocalCacheService
						.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor()),
				HttpStatus.NOT_FOUND.value(), null)));
	}

	@Override
	public Mono<InformacaoContadorConta> adicionaTentativa(String cpfCnpj) {
		return usuarioPortalService.consultar(cpfCnpj).flatMap(usuarioPortal -> {

			final long limTentativas = Long.parseLong(parametrosLocalCacheService
					.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_LOGIN.getValor()));

			usuarioPortal.setDataTentativaLogin(
					Date.from(LocalDateTime.now().atZone(TimeZone.getDefault().toZoneId()).toInstant()));

			InformacaoContadorConta info = null;

			if (usuarioPortal.getQtdTentativaLogin() >= limTentativas) {
				info = new InformacaoContadorConta(usuarioPortal.getQtdTentativaLogin(), limTentativas, false);
				return Mono.error(new ContadorAcessoException(
						this.mensagemLocalCacheService.recuperaTextoMensagem(
								MensagemChaveEnum.USUARIO_VALIDACAO_NUMERO_TENTATIVAS.getValor()),
						HttpStatus.UNPROCESSABLE_ENTITY.value(), info));
			} else {
				final long qntTentativas = usuarioPortal.getQtdTentativaLogin() + 1L;
				usuarioPortal.setQtdTentativaLogin(qntTentativas);
				info = new InformacaoContadorConta(qntTentativas, limTentativas, true);
			}

			usuarioPortalClienteRepository.save(usuarioPortal);

			return Mono.just(info);
		}).switchIfEmpty(Mono.error(new ContadorAcessoException(
				this.mensagemLocalCacheService
						.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor()),
				HttpStatus.NOT_FOUND.value(), null)));

	}

	@Override
	public Mono<Boolean> permiteAcesso(Long idUsuario) {
		return this.usuarioPortalService.consultarUsuarioPorId(idUsuario).flatMap(usuarioPortal -> {
			String cpfCnpj = this.montaCpfCnpj(usuarioPortal);
			return this.usuarioPortalService.consultaStatus(cpfCnpj).flatMap(status -> {
				if (status.getIdStatusConta() == StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN
						.getCodStatus()
						|| status.getIdStatusConta() == StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus()) {
					return this.consultaContadoresTentativaAcesso(cpfCnpj).flatMap(contadores -> {
						if (contadores.getQtdTentativaAcesso() <= contadores.getQtdTentativaLimiteAcesso()) {
							return Mono.just(Boolean.TRUE);
						}
						return Mono.error(new ResponseStatusException(HttpStatus.FORBIDDEN,
								this.mensagemLocalCacheService.recuperaTextoMensagem(
										MensagemChaveEnum.USUARIO_VALIDACAO_NUMERO_TENTATIVAS.getValor())));
					});
				} else {
					return Mono
							.error(new ResponseStatusException(HttpStatus.FORBIDDEN, status.getDescricaoStatusConta()));
				}
			});
		});
	}

	private String montaCpfCnpj(final UsuarioPortalCliente usuarioPortal) {

		return usuarioPortal.getCnpjOrdem() == 0
				? String.format("%09d", usuarioPortal.getCnpjCpf())
						+ String.format("%02d", usuarioPortal.getCnpjCpfDigito())
				: String.format("%08d", usuarioPortal.getCnpjCpf())
						+ String.format("%04d", usuarioPortal.getCnpjOrdem())
						+ String.format("%02d", usuarioPortal.getCnpjCpfDigito());

	}

	@Override
	public Mono<Boolean> registrarAcessoSucesso(String cpfCnpj) {
		return this.usuarioPortalService.consultar(cpfCnpj).flatMap(usuarioPortal -> {

			final Long aguardandoPrimeiroLogin = StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN
					.getCodStatus();
			final Long tentativaRecuperacaoConta = StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus();
			final Long contaAtiva = StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus();

			if (usuarioPortal.getStatusUsuario() != null && usuarioPortal.getStatusUsuario().getIdStatusConta() != null
					&& (usuarioPortal.getStatusUsuario().getIdStatusConta().equals(aguardandoPrimeiroLogin)
							|| usuarioPortal.getStatusUsuario().getIdStatusConta().equals(tentativaRecuperacaoConta)
							|| usuarioPortal.getStatusUsuario().getIdStatusConta().equals(contaAtiva))) {

				usuarioPortal.setQtdTentativaLogin(0L);

				Long quantidadeAcessoLogin = usuarioPortal.getQuantidadeAcessoLogin();

				if (quantidadeAcessoLogin == null) {
					quantidadeAcessoLogin = 0L;
				}

				usuarioPortal.setQuantidadeAcessoLogin(quantidadeAcessoLogin + 1L);
				usuarioPortal.getStatusUsuario().setIdStatusConta(contaAtiva);

				logPortalClienteService.geraLogPortal(cpfCnpj,
						MensagemChaveEnum.USUARIO_MSG_LOG_LOGIN_COM_SUCESSO.getValor(),
						LogSubTipoEnum.LOGIN_SERVICO_REALIZADO_COM_SUCESSO.getCodigo());

				return Mono.just(usuarioPortalClienteRepository.save(usuarioPortal)).map(usuario -> Boolean.TRUE);
			} else {
				return Mono.error(new UsuarioPortalException(MensagemUsuarioEnum.USUARIO_INELEGIVEL.getValor(),
						HttpStatus.BAD_REQUEST.value()));
			}

		}).switchIfEmpty(Mono.error(new UsuarioPortalException(
				mensagemLocalCacheService
						.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()),
				HttpStatus.NOT_FOUND.value())));
	}

	public Mono<InformacaoContadorConta> registrarAcessoFalha(String cpfCnpj) {
		return this.usuarioPortalService.consultar(cpfCnpj).flatMap(usuario -> {

			Long numeroTentativasLimite = obtemNumeroTentativasAcessoLimite();
			Long numeroTentativasRestantes = numeroTentativasLimite - usuario.getQtdTentativaLogin();

			if (numeroTentativasRestantes <= 0) {
				return Mono.error(new CodigoSegurancaException(
						this.mensagemLocalCacheService.recuperaTextoMensagem(
								MensagemChaveEnum.USUARIO_VALIDACAO_NUMERO_TENTATIVAS.getValor()),
						HttpStatus.UNPROCESSABLE_ENTITY.value(),
						obtemInformacaoContadorConta(usuario, false, TipoCodigoEnum.ACESSO)));
			} else {
				logPortalClienteService.geraLogPortal(usuario,
						MensagemChaveEnum.USUARIO_MSG_LOG_LOGIN_COM_FALHA.getValor(),
						LogSubTipoEnum.TENTATIVA_DE_LOGIN_SERVICO_SENHA_ERRADA.getCodigo());
				return this.incrementaQuantidadeTentativa(usuario, TipoCodigoEnum.ACESSO)
						.map(limiteExcedido -> obtemInformacaoContadorConta(usuario, !limiteExcedido,
								TipoCodigoEnum.ACESSO));
			}
		}).switchIfEmpty(Mono.error(new UsuarioPortalException(
				mensagemLocalCacheService
						.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()),
				HttpStatus.NOT_FOUND.value())));
	}
}
