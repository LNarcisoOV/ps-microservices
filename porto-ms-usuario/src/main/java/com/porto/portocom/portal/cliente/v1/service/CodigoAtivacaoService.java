package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.entity.SegurancaContaPortalUsuario;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.LogSubTipoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoEnvioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoFluxoEnum;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.PortalException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMsMensageriaService;
import com.porto.portocom.portal.cliente.v1.integration.facade.ILdapFacade;
import com.porto.portocom.portal.cliente.v1.repository.ISegurancaContaPortalUsuarioRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.vo.usuario.EnviaCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.PessoaVO;

import reactor.core.publisher.Mono;

@Service
public class CodigoAtivacaoService extends BaseCodigoSeguranca implements ICodigoAtivacaoService {

	private static final String HEADER_EXCEPTION_MESSAGE = "O Header corporativoRequestHeader não foi informado ou não foi encontrado.";

	private IProspectService prospectService;
	private ILdapFacade ldapFacade;
	protected ISegurancaContaPortalUsuarioService segurancaContaPortalUsuarioService;

	@Autowired
	public CodigoAtivacaoService(ITokenAAService tokenAAService, IUsuarioPortalService usuarioPortalService,
			ISegurancaContaPortalUsuarioRepository segurancaContaPortalUsuarioRepository,
			IUsuarioPortalClienteRepository usuarioPortalClienteRepository,
			ParametrosLocalCacheService parametrosLocalCacheService, ILogPortalClienteService logPortalClienteService,
			MensagemLocalCacheService mensagemLocalCacheService, IPortoMsMensageriaService portoMsMensageriaService,
			IUsuarioStatusContaRepository usuarioStatusContaRepository,
			ILexisNexisService lexisNexisService, ILdapFacade ldapFacade, LexisNexisUtils lexisNexisUtil,
			ISegurancaContaPortalUsuarioService segurancaContaPortalUsuarioService, IProspectService prospectService) {
		super(tokenAAService, logPortalClienteService, mensagemLocalCacheService, usuarioPortalService,
				parametrosLocalCacheService, portoMsMensageriaService, usuarioStatusContaRepository,
				lexisNexisService, lexisNexisUtil);
		this.usuarioPortalService = usuarioPortalService;
		this.prospectService = prospectService;
		this.mensagemLocalCacheService = mensagemLocalCacheService;
		this.ldapFacade = ldapFacade;
		this.segurancaContaPortalUsuarioService = segurancaContaPortalUsuarioService;
	}

	@Override
	public Mono<InformacaoCodigoSeguranca> validaCodigoAtivacao(String cpfCnpj, String codigoAtivacao) {
		return usuarioPortalService.consultar(cpfCnpj).flatMap(usuario -> {
			if (usuario.getStatusUsuario().getIdStatusConta()
					.equals(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus())) {
				
				if (!lexisNexisUtil.verificaFlagLexis()) {
					return Mono.error(new PortalException(HEADER_EXCEPTION_MESSAGE, HttpStatus.BAD_REQUEST.value()));
				}

				return this.verificaTentativasDisponiveis(codigoAtivacao, usuario, TipoCodigoEnum.ATIVACAO)
						.map(informacaoCodigoSeguranca -> {
							logPortalClienteService.geraLogPortal(usuario,
									MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_ATIVACAO.getValor(),
									LogSubTipoEnum.VALIDACAO_CODIGO_SEGURANCA.getCodigo());
							return informacaoCodigoSeguranca;
						});
			} else {
				return Mono.error(new CodigoSegurancaException(
						MensagemUsuarioEnum.USUARIO_NAO_PERMITIDO_REATIVAR_CONTA.getValor(),
						HttpStatus.BAD_REQUEST.value(),
						this.obtemInformacaoContadorConta(usuario, false, TipoCodigoEnum.ATIVACAO)));
			}

		}).switchIfEmpty(Mono.error(new UsuarioPortalException(MensagemUsuarioEnum.USUARIO_NAO_ENCONTRADO.getValor(),
				HttpStatus.NOT_FOUND.value())));
	}

	@Override
	public Mono<InformacaoCodigoSeguranca> validaCodigoAtivacaoCadastroSenha(String cpfCnpj, String codigoAtivacao) {

		return usuarioPortalService.consultar(cpfCnpj).flatMap(usuario -> {
			if (usuario.getStatusUsuario().getIdStatusConta()
					.equals(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus())) {
				return (this.verificaTentativasDisponiveis(codigoAtivacao, usuario, TipoCodigoEnum.ATIVACAO));
			} else {
				return Mono.error(new CodigoSegurancaException(
						MensagemUsuarioEnum.USUARIO_NAO_PERMITIDO_REATIVAR_CONTA.getValor(),
						HttpStatus.BAD_REQUEST.value(),
						this.obtemInformacaoContadorConta(usuario, false, TipoCodigoEnum.ATIVACAO)));
			}

		}).switchIfEmpty(Mono.error(new UsuarioPortalException(MensagemUsuarioEnum.USUARIO_NAO_ENCONTRADO.getValor(),
				HttpStatus.NOT_FOUND.value())));
	}

	@Override
	public Mono<EnviaCodigoSeguranca> enviaCodigoAtivacao(String cpfCnpj, TipoEnvioEnum tipoEnvio,
			TipoFluxoEnum tipoCadastro) {

		if (!ValidaCpfCnpjUtils.isValid(cpfCnpj)) {
			return Mono.error(new CpfCnpjInvalidoException(mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_VALIDACAO_CPF_CNPJ.getValor())));
		}

		return this.prospectService.consultaProdutosProspect(cpfCnpj).flatMap(produtos -> usuarioPortalService
				.obtemPessoaPorProdutos(produtos, cpfCnpj)
				.flatMap(pessoaVo -> validaUsuarioParaEnvioMensagem(cpfCnpj, pessoaVo, tipoCadastro)
						.flatMap(usuarioPortal -> ldapFacade.criarUsuario(usuarioPortal, pessoaVo.getTipoUsuario())
								.map(isSucesso -> usuarioPortal))
						.flatMap(usuarioCliente -> enviaCodigoEmailOuSms(usuarioCliente, pessoaVo, tipoEnvio,
								TipoCodigoEnum.ATIVACAO, tipoCadastro).flatMap(enviaCodigo -> {
									if (enviaCodigo.getIsSucesso().booleanValue()) {
										UsuarioStatusConta usuarioStatus = this.usuarioStatusContaRepository
												.findByIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO
														.getCodStatus());
										usuarioCliente.setStatusUsuario(usuarioStatus);
										usuarioPortalService.salvar(usuarioCliente);
										return Mono.just(enviaCodigo);

									} else {
										return Mono.just(enviaCodigo);
									}
								}))));
	}

	private Mono<UsuarioPortalCliente> validaUsuarioParaEnvioMensagem(String cpfCnpj, PessoaVO pessoaVo,
			TipoFluxoEnum tipoCadastro) {

		return usuarioPortalService.consultar(cpfCnpj).flatMap(usuarioCliente -> {
			if (usuarioCliente.getStatusUsuario().getIdStatusConta()
					.equals(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus())
					|| usuarioCliente.getStatusUsuario().getIdStatusConta()
							.equals(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus())
					|| usuarioCliente.getStatusUsuario().getIdStatusConta()
							.equals(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus())) {
				return usuarioPortalService
						.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioCliente, tipoCadastro));
			} else {
				return Mono.error(new UsuarioPortalException(MensagemUsuarioEnum.USUARIO_INELEGIVEL.getValor(),
						HttpStatus.BAD_REQUEST.value()));
			}
		}).switchIfEmpty(Mono
				.defer(() -> usuarioPortalService.salvar(usuarioPortalService.criaUsuarioPortalDePessoaVo(pessoaVo))));
	}

	public Mono<SegurancaContaPortalUsuario> obtemCodigoAtivacao(String token, String cpfCnpj) {
		return usuarioPortalService.consultar(cpfCnpj).flatMap(usuario -> this.segurancaContaPortalUsuarioService
				.obtemCodigoAtivacao(usuario.getIdUsuario(), Long.parseLong(token)));

	}

}
