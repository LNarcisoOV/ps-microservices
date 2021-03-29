package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.LogSubTipoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoEnvioEnum;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMsMensageriaService;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.vo.usuario.EnviaCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoCodigoSeguranca;

import reactor.core.publisher.Mono;

@Service
public class CodigoAcessoService extends BaseCodigoSeguranca implements ICodigoAcessoService {

	public CodigoAcessoService(ITokenAAService tokenAAService,
			ILogPortalClienteService logPortalClienteService, MensagemLocalCacheService mensagemLocalCacheService,
			IUsuarioPortalService usuarioPortalService, ParametrosLocalCacheService parametrosLocalCacheService,
			IPortoMsMensageriaService portoMsMensageriaService,
			IUsuarioStatusContaRepository usuarioStatusContaRepository,
			ILexisNexisService lexisNexisService, LexisNexisUtils lexisNexisUtil) {
		super(tokenAAService, logPortalClienteService, mensagemLocalCacheService,
				usuarioPortalService, parametrosLocalCacheService, portoMsMensageriaService,
				usuarioStatusContaRepository, lexisNexisService, lexisNexisUtil);
	}

	@Override
	public Mono<InformacaoCodigoSeguranca> validaCodigoAcesso(String cpfCnpj, String codigoAcesso) {
		return usuarioPortalService.consultar(cpfCnpj)
				.flatMap(usuarioPortalCliente -> checaStatusUsuarioCodigoAcesso(
						usuarioPortalCliente.getStatusUsuario().getIdStatusConta())
								.flatMap(statusPermitido -> verificaTentativasDisponiveis(codigoAcesso,
										usuarioPortalCliente, TipoCodigoEnum.ACESSO).map(informacaoCodigo -> {
											logPortalClienteService.geraLogPortal(usuarioPortalCliente,
													MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_ACESSO.getValor(),
													LogSubTipoEnum.VALIDACAO_CODIGO_SEGURANCA.getCodigo());
											return informacaoCodigo;
										}))
				)
				.switchIfEmpty(Mono.error(new UsuarioPortalException(
						this.mensagemLocalCacheService.recuperaTextoMensagem(
								MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()),
						HttpStatus.NOT_FOUND.value())));
	}

	private Mono<Boolean> checaStatusUsuarioCodigoAcesso(Long idStatus) {
		if (idStatus
				.equals(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus())
				|| idStatus
				.equals(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus())
				|| idStatus
				.equals(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus())) {
			return Mono.just(true);
		} else {
			return Mono.error(new UsuarioPortalException(MensagemUsuarioEnum.USUARIO_INELEGIVEL.getValor(),
					HttpStatus.BAD_REQUEST.value()));
		}
	}

	@Override
	public Mono<EnviaCodigoSeguranca> enviaCodigoAcesso(String cpfCnpj, TipoEnvioEnum tipoEnvio) {
		return this.validaUsuarioParaEnvioMensagem(cpfCnpj, tipoEnvio);
	}

	private Mono<EnviaCodigoSeguranca> validaUsuarioParaEnvioMensagem(String cpfCnpj, TipoEnvioEnum tipoEnvio) {
		return this.usuarioPortalService.consultar(cpfCnpj).flatMap(
				usuarioCliente -> checaStatusUsuarioCodigoAcesso(usuarioCliente.getStatusUsuario().getIdStatusConta())
						.flatMap(statusPermitido -> this.enviaCodigoEmailOuSms(usuarioCliente, null, tipoEnvio,
								TipoCodigoEnum.ACESSO, null)))
				.switchIfEmpty(Mono.error(new UsuarioPortalException(
						this.mensagemLocalCacheService.recuperaTextoMensagem(
								MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()),
						HttpStatus.NOT_FOUND.value())));
	}

}
