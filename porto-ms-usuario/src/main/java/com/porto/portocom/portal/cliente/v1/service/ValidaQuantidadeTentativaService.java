package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.LexisNexisChallengeStatusEnum;
import com.porto.portocom.portal.cliente.v1.constant.LexisNexisTagContextEnum;
import com.porto.portocom.portal.cliente.v1.constant.LogSubTipoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContadorConta;

import reactor.core.publisher.Mono;

public class ValidaQuantidadeTentativaService {

	protected ILogPortalClienteService logPortalClienteService;
	protected ParametrosLocalCacheService parametrosLocalCacheService;
	protected IUsuarioPortalService usuarioPortalService;
	protected MensagemLocalCacheService mensagemLocalCacheService;
	protected LexisNexisUtils lexisNexisUtil;
	protected ILexisNexisService lexisNexisService;

	@Autowired
	public ValidaQuantidadeTentativaService(ILexisNexisService lexisNexisService, LexisNexisUtils lexisNexisUtil) {
		this.lexisNexisService = lexisNexisService;
		this.lexisNexisUtil = lexisNexisUtil;
	}

	protected long obtemNumeroTentativasRecuperacaoLimite() {
		return Long.parseLong(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_RECUPERACAO.getValor()));
	}

	protected long obtemNumeroTentativasCadastroLimite() {
		return Long.parseLong(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_CRIACAO_CONTA.getValor()));
	}

	protected long obtemNumeroTentativasAcessoLimite() {
		return Long.parseLong(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_LOGIN.getValor()));
	}

	protected InformacaoContadorConta obtemInformacaoContadorConta(UsuarioPortalCliente usuario, Boolean isSucesso,
			TipoCodigoEnum tipoCodigo) {
		if (tipoCodigo == TipoCodigoEnum.RECUPERACAO) {
			return new InformacaoContadorConta(usuario.getQuantidadeTentativasRecuperacaoConta(),
					this.obtemNumeroTentativasRecuperacaoLimite(), isSucesso);
		} else if (tipoCodigo == TipoCodigoEnum.ATIVACAO) {
			return new InformacaoContadorConta(usuario.getQuantidadeTentativaCriacaoConta(),
					this.obtemNumeroTentativasCadastroLimite(), isSucesso);
		} else {
			return new InformacaoContadorConta(usuario.getQtdTentativaLogin(), this.obtemNumeroTentativasAcessoLimite(),
					isSucesso);
		}
	}

	protected Mono<Boolean> incrementaQuantidadeTentativa(UsuarioPortalCliente usuario, TipoCodigoEnum tipoCodigo) {
		Boolean limiteTentativaExcedido = false;
		return Mono.just(limiteTentativaExcedido).map(limiteExcedido -> {
			if (tipoCodigo == TipoCodigoEnum.RECUPERACAO) {
				return incrementaTentativaRecuperacao(usuario);
			} else if (tipoCodigo == TipoCodigoEnum.ATIVACAO) {
				return incrementaTentativaAtivacao(usuario);
			} else if (tipoCodigo == TipoCodigoEnum.ACESSO) {
				return incrementaTentativaAcesso(usuario);
			}
			return Mono.just(limiteExcedido);
		}).flatMap(limite -> this.usuarioPortalService.salvar(usuario).flatMap(usr -> limite.flatMap(limiteExcedido -> {
			if (Boolean.TRUE.equals(limiteExcedido)) {
				this.lexisNexisService.atualizaLexisNexis(LexisNexisChallengeStatusEnum.CHALLENGE_FAIL.getValor(),
						LexisNexisTagContextEnum.OTPH.getValor());
				return Mono.error(new CodigoSegurancaException(
						this.mensagemLocalCacheService.recuperaTextoMensagem(
								MensagemChaveEnum.USUARIO_VALIDACAO_NUMERO_TENTATIVAS.getValor()),
						HttpStatus.UNPROCESSABLE_ENTITY.value(),
						obtemInformacaoContadorConta(usuario, false, tipoCodigo)));
			} else {
				return Mono.just(limiteExcedido);
			}
		})));
	}

	private Mono<Boolean> incrementaTentativaAcesso(UsuarioPortalCliente usuario) {
		Long numeroTentativasAcessoLimite = obtemNumeroTentativasAcessoLimite();
		usuario.setQtdTentativaLogin(usuario.getQtdTentativaLogin() + 1);
		if (numeroTentativasAcessoLimite.equals(usuario.getQtdTentativaLogin())) {
			logPortalClienteService.geraLogPortal(usuario,
					MensagemChaveEnum.USUARIO_MSG_LOG_BLOQUEIO_CONTA_ACESSO.getValor(),
					LogSubTipoEnum.BLOQUEIO_DE_CONTA.getCodigo());
			return Mono.just(true);
		} else {
			return Mono.just(false);
		}
	}

	private Mono<Boolean> incrementaTentativaAtivacao(UsuarioPortalCliente usuario) {
		usuario.setQuantidadeTentativaCriacaoConta(usuario.getQuantidadeTentativaCriacaoConta() + 1);
		Long numeroTentativasCadastroLimite = obtemNumeroTentativasCadastroLimite();
		if (numeroTentativasCadastroLimite.equals(usuario.getQuantidadeTentativaCriacaoConta())) {
			logPortalClienteService.geraLogPortal(usuario,
					MensagemChaveEnum.USUARIO_MSG_LOG_BLOQUEIO_CONTA_ATIVACAO.getValor(),
					LogSubTipoEnum.BLOQUEIO_DE_CONTA.getCodigo());
			return Mono.just(true);
		} else {
			return Mono.just(false);
		}
	}

	private Mono<Boolean> incrementaTentativaRecuperacao(UsuarioPortalCliente usuario) {
		usuario.setQuantidadeTentativasRecuperacaoConta(usuario.getQuantidadeTentativasRecuperacaoConta() + 1);
		Long numeroTentativasRecuperacaoLimite = obtemNumeroTentativasRecuperacaoLimite();
		if (numeroTentativasRecuperacaoLimite.equals(usuario.getQuantidadeTentativasRecuperacaoConta())) {
			logPortalClienteService.geraLogPortal(usuario,
					MensagemChaveEnum.USUARIO_MSG_LOG_BLOQUEIO_CONTA_RECUPERACAO.getValor(),
					LogSubTipoEnum.BLOQUEIO_DE_CONTA.getCodigo());
			return Mono.just(true);
		} else {
			return Mono.just(false);
		}
	}

}
