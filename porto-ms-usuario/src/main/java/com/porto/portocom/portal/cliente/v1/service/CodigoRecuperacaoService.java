package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.LogSubTipoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoEnvioEnum;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.PortalException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMsMensageriaService;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.vo.usuario.EnviaCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoCodigoSeguranca;

import reactor.core.publisher.Mono;

@Service
public class CodigoRecuperacaoService extends BaseCodigoSeguranca implements ICodigoRecuperacaoService {

	private static final String HEADER_EXCEPTION_MESSAGE = "O Header corporativoRequestHeader não foi informado ou não foi encontrado.";

	public static final Integer TIPO_CODIGOSEGURANCA_CADASTROCONTA_PORTAL = 1;

	@Autowired
	public CodigoRecuperacaoService(MensagemLocalCacheService mensagemLocalCacheService,
			IUsuarioPortalService usuarioPortalService, IPortoMsMensageriaService portoMsMensageriaService,
			ILogPortalClienteService logPortalClienteService, ITokenAAService tokenAAService,
			ParametrosLocalCacheService parametrosLocalCacheService,
			IUsuarioStatusContaRepository usuarioStatusContaRepository, ILexisNexisService lexisNexisService,
			LexisNexisUtils lexisNexisUtil) {
		super(tokenAAService, logPortalClienteService, mensagemLocalCacheService, usuarioPortalService,
				parametrosLocalCacheService, portoMsMensageriaService, usuarioStatusContaRepository, lexisNexisService,
				lexisNexisUtil);
		this.usuarioPortalService = usuarioPortalService;
		this.lexisNexisUtil = lexisNexisUtil;
	}

	@Override
	public Mono<EnviaCodigoSeguranca> enviaCodigo(String cpfCnpj, TipoEnvioEnum tipoEnvio) {
		return this.validaUsuarioParaEnvioMensagem(cpfCnpj, tipoEnvio);
	}

	private Mono<EnviaCodigoSeguranca> validaUsuarioParaEnvioMensagem(String cpfCnpj, TipoEnvioEnum tipoEnvio) {
		return this.usuarioPortalService.consultar(cpfCnpj).flatMap(usuarioCliente -> {
			if (usuarioCliente.getStatusUsuario().getIdStatusConta()
					.equals(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus())
					|| usuarioCliente.getStatusUsuario().getIdStatusConta()
							.equals(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus())
					|| usuarioCliente.getStatusUsuario().getIdStatusConta()
							.equals(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus())) {
				return enviaCodigoEmailOuSms(usuarioCliente, null, tipoEnvio, TipoCodigoEnum.RECUPERACAO, null)
						.flatMap(enviaCodigoSeguranca -> {
							if (enviaCodigoSeguranca.getIsSucesso().booleanValue()) {
								UsuarioStatusConta usuarioStatus = this.usuarioStatusContaRepository
										.findByIdStatusConta(
												StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus());
								usuarioCliente.setStatusUsuario(usuarioStatus);
								usuarioPortalService.salvar(usuarioCliente);
								return Mono.just(enviaCodigoSeguranca);

							} else {
								return Mono.just(enviaCodigoSeguranca);
							}
						});
			} else {
				return Mono.error(new UsuarioPortalException(
						MensagemUsuarioEnum.USUARIO_INELEGIVEL_RECUPERACAO.getValor(), HttpStatus.BAD_REQUEST.value()));
			}
		}).switchIfEmpty(Mono.error(new UsuarioPortalException(
				this.mensagemLocalCacheService
						.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()),
				HttpStatus.NOT_FOUND.value())));
	}

	@Override
	public Mono<InformacaoCodigoSeguranca> validaCodigo(String cpfCnpj, String codigoRecuperacao) {
		return usuarioPortalService.consultar(cpfCnpj).flatMap(usuario -> {

			if (usuario.getStatusUsuario().getIdStatusConta()
					.equals(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus())) {

				if (!lexisNexisUtil.verificaFlagLexis()) {
					return Mono.error(new PortalException(HEADER_EXCEPTION_MESSAGE, HttpStatus.BAD_REQUEST.value()));
				}

				return this.verificaTentativasDisponiveis(codigoRecuperacao, usuario, TipoCodigoEnum.RECUPERACAO)
						.map(informacaoCodigo -> {
							logPortalClienteService.geraLogPortal(usuario,
									MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_RECUPERACAO.getValor(),
									LogSubTipoEnum.VALIDACAO_CODIGO_SEGURANCA.getCodigo());
							return informacaoCodigo;
						});

			} else {
				return Mono.error(new CodigoSegurancaException(
						MensagemUsuarioEnum.USUARIO_NAO_PERMITIDO_REATIVAR_CONTA.getValor(),
						HttpStatus.BAD_REQUEST.value(),
						this.obtemInformacaoContadorConta(usuario, false, TipoCodigoEnum.RECUPERACAO)));
			}

		}).switchIfEmpty(Mono.error(new UsuarioPortalException(MensagemUsuarioEnum.USUARIO_NAO_ENCONTRADO.getValor(),
				HttpStatus.NOT_FOUND.value())));
	}

	@Override
	public Mono<InformacaoCodigoSeguranca> validaCodigo(String codigoRecuperacao, UsuarioPortalCliente usuario) {
		if (usuario.getStatusUsuario().getIdStatusConta()
				.equals(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus())) {
			return this.verificaTentativasDisponiveis(codigoRecuperacao, usuario, TipoCodigoEnum.RECUPERACAO);
		} else {
			return Mono.error(new CodigoSegurancaException(
					MensagemUsuarioEnum.USUARIO_NAO_PERMITIDO_REATIVAR_CONTA.getValor(), HttpStatus.BAD_REQUEST.value(),
					this.obtemInformacaoContadorConta(usuario, false, TipoCodigoEnum.RECUPERACAO)));
		}
	}
}
