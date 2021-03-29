package com.porto.portocom.portal.cliente.v1.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.LexisNexisChallengeStatusEnum;
import com.porto.portocom.portal.cliente.v1.constant.LexisNexisTagContextEnum;
import com.porto.portocom.portal.cliente.v1.constant.LogSubTipoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoEnvioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoFluxoEnum;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.EnvioCodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.GeraTokenAAException;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMsMensageriaService;
import com.porto.portocom.portal.cliente.v1.model.PinVO;
import com.porto.portocom.portal.cliente.v1.model.ValidaTokenAAResponse;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.utils.TrataCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.vo.usuario.EnviaCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContadorConta;
import com.porto.portocom.portal.cliente.v1.vo.usuario.PessoaVO;

import reactor.core.publisher.Mono;

public abstract class BaseCodigoSeguranca extends ValidaQuantidadeTentativaService {

	private static final Logger LOG = LoggerFactory.getLogger(BaseCodigoSeguranca.class);

	private static final String PARAMETRO_CORPO_EMAIL_NOME_USUARIO = "nomeUsuario";
	private static final String PARAMETRO_CORPO_EMAIL_PATH_PORTAL = "pathPortal";
	private static final String PARAMETRO_CORPO_EMAIL_SMS_CODIGO_SEGURANCA = "codigoSeguranca";
	private static final String PARAMETRO_ASSUNTO_EMAIL = "assuntoEmail";

	protected IUsuarioStatusContaRepository usuarioStatusContaRepository;

	private IPortoMsMensageriaService portoMsMensageriaService;

	protected ITokenAAService tokenAAService;

	@Autowired
	public BaseCodigoSeguranca(ITokenAAService tokenAAService, ILogPortalClienteService logPortalClienteService,
			MensagemLocalCacheService mensagemLocalCacheService, IUsuarioPortalService usuarioPortalService,
			ParametrosLocalCacheService parametrosLocalCacheService, IPortoMsMensageriaService portoMsMensageriaService,
			IUsuarioStatusContaRepository usuarioStatusContaRepository, ILexisNexisService lexisNexisService,
			LexisNexisUtils lexisNexisUtil) {
		super(lexisNexisService, lexisNexisUtil);
		this.tokenAAService = tokenAAService;
		this.logPortalClienteService = logPortalClienteService;
		this.mensagemLocalCacheService = mensagemLocalCacheService;
		this.usuarioPortalService = usuarioPortalService;
		this.parametrosLocalCacheService = parametrosLocalCacheService;
		this.portoMsMensageriaService = portoMsMensageriaService;
		this.usuarioStatusContaRepository = usuarioStatusContaRepository;
	}

	private Mono<EnviaCodigoSeguranca> enviaCodigoPorEmail(UsuarioPortalCliente usuarioPortalCliente, PessoaVO pessoaVo,
			TipoCodigoEnum tipoCodigo, TipoFluxoEnum tipoCadastro) {
		String cpfCnpj = TrataCpfCnpjUtils.formatarCPFCNPJSemMascara(usuarioPortalCliente.getCnpjCpf(),
				usuarioPortalCliente.getCnpjOrdem(), usuarioPortalCliente.getCnpjCpfDigito());
		return this.tokenAAService.geraPinCliente(cpfCnpj)
				.flatMap(pinRetorno -> montaInformacoesEmail(usuarioPortalCliente, pinRetorno.getPin(), tipoCodigo)
						.flatMap(informacoesEmail -> enviaEmailMontado(usuarioPortalCliente, pessoaVo, informacoesEmail,
								tipoCodigo, tipoCadastro).flatMap(isSucesso -> {
									if (isSucesso.booleanValue()) {
										return Mono.just(criaEnviaCodigoSeguranca(isSucesso, pinRetorno));
									}
									return Mono.error(new EnvioCodigoSegurancaException(
											this.mensagemLocalCacheService.recuperaTextoMensagem(
													MensagemChaveEnum.USUARIO_ERRO_ENVIO_EMAIL_SMS.getValor()),
											HttpStatus.BAD_REQUEST.value()));
								})))
				.onErrorResume(error -> {
					LOG.error(error.getMessage(), error);
					return Mono.error(error);
				});
	}

	private Mono<Map<String, String>> montaInformacoesEmail(final UsuarioPortalCliente usuarioPortalCliente,
			final String codigoAtivacao, TipoCodigoEnum tipoCodigo) {

		final Map<String, String> informacoesEmail = new HashMap<>();

		informacoesEmail.put(PARAMETRO_CORPO_EMAIL_SMS_CODIGO_SEGURANCA, codigoAtivacao);

		String protocolo;
		String server;
		String assuntoEmail;
		String pathPortal;

		protocolo = this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_PROTOCOLO_EMAIL.getValor());

		server = this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_ENDERECO_EMAIL.getValor());

		String parametroNomePortal = this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_NOME_PORTAL_EMAIL.getValor());
		pathPortal = protocolo + "://" + server + "/" + parametroNomePortal;

		informacoesEmail.put(PARAMETRO_CORPO_EMAIL_PATH_PORTAL, pathPortal);

		String chaveParametro;

		if (tipoCodigo == TipoCodigoEnum.ATIVACAO) {
			chaveParametro = ChavesParamEnum.PORTO_MS_USUARIO_ASSUNTO_CRIAR_CONTA_EMAIL.getValor();

		} else if (tipoCodigo == TipoCodigoEnum.RECUPERACAO) {
			chaveParametro = ChavesParamEnum.PORTO_MS_USUARIO_ASSUNTO_RECUPERACAO_CONTA_EMAIL.getValor();

		} else {
			chaveParametro = ChavesParamEnum.PORTO_MS_USUARIO_ASSUNTO_ACESSO_CONTA_EMAIL.getValor();
		}

		assuntoEmail = this.parametrosLocalCacheService.recuperaParametro(chaveParametro);

		informacoesEmail.put(PARAMETRO_ASSUNTO_EMAIL, assuntoEmail);

		String nome = usuarioPortalCliente.getNomeUsuarioPortal();
		if (StringUtils.isNotBlank(nome)) {
			final String[] nomeUsuarioSplit = nome.split(" ", 2);
			nome = nomeUsuarioSplit[0];
		}

		informacoesEmail.put(PARAMETRO_CORPO_EMAIL_NOME_USUARIO, nome);

		return Mono.just(informacoesEmail);
	}

	private Mono<Boolean> enviaEmailMontado(UsuarioPortalCliente usuarioPortalCliente, PessoaVO pessoaVo,
			Map<String, String> informacoesEmail, TipoCodigoEnum tipoCodigo, TipoFluxoEnum tipoCadastro) {

		String corpoEmail = this.criaCorpoEmail(informacoesEmail, tipoCodigo);
		String cpfCnpj = TrataCpfCnpjUtils.formatarCPFCNPJSemMascara(usuarioPortalCliente.getCnpjCpf(),
				usuarioPortalCliente.getCnpjOrdem(), usuarioPortalCliente.getCnpjCpfDigito());

		String chaveMensagem;
		Long subTipo;

		if (tipoCodigo == TipoCodigoEnum.ATIVACAO) {
			chaveMensagem = MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ATIVACAO.getValor();
			subTipo = LogSubTipoEnum.ENVIO_CODIGO_SEGURANCA_EMAIL.getCodigo();

		} else if (tipoCodigo == TipoCodigoEnum.RECUPERACAO) {
			chaveMensagem = MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_RECUPERACAO.getValor();
			subTipo = LogSubTipoEnum.ENVIO_CODIGO_SEGURANCA_EMAIL_RECUPERACAO_DE_CONTA.getCodigo();

		} else {
			chaveMensagem = MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ACESSO.getValor();
			subTipo = LogSubTipoEnum.ENVIO_CODIGO_SEGURANCA_EMAIL_ACESSO_DE_CONTA.getCodigo();
		}

		String enderecoEletronico = usuarioPortalCliente.getDescEmail();

		if (tipoCadastro != null && tipoCadastro.equals(TipoFluxoEnum.HARD)) {
			enderecoEletronico = usuarioPortalCliente.getDescEmail();
		} else if (pessoaVo != null && CollectionUtils.isNotEmpty(pessoaVo.getEmails())
				&& StringUtils.isNotBlank(pessoaVo.getEmails().get(0))) {
			enderecoEletronico = pessoaVo.getEmails().get(0);
		}

		if (StringUtils.isNotBlank(enderecoEletronico)) {
			return this
					.enviaEmail(enderecoEletronico, informacoesEmail.get(PARAMETRO_ASSUNTO_EMAIL), corpoEmail, cpfCnpj)
					.map(retornoEnviaEmail -> {
						logPortalClienteService.geraLogPortal(usuarioPortalCliente, chaveMensagem, subTipo);
						return retornoEnviaEmail;
					});
		} else {
			LOG.info("Usuario não possui email cadastrado");
			return Mono.just(Boolean.FALSE);
		}
	}

	/**
	 * Cria a mensagem de corpo do email de forma dinamica consultando o template do
	 * email na tabela de mensagens e utilizando as informacoes mapeadas no Map
	 * informacoesEmail.
	 *
	 * @param informacoesEmail Map com as informacoes a serem substituidas no corpo
	 *                         do email
	 * @return String Corpo do Email
	 */
	private String criaCorpoEmail(final Map<String, String> informacoesEmail, TipoCodigoEnum tipoCodigo) {

		String corpoEmail = "";
		if (tipoCodigo == TipoCodigoEnum.ATIVACAO) {
			corpoEmail = this.mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_EMAIL.getValor());

		} else if (tipoCodigo == TipoCodigoEnum.RECUPERACAO) {
			corpoEmail = this.mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_RECUPERACAO_EMAIL.getValor());

		} else if (tipoCodigo == TipoCodigoEnum.ACESSO) {
			corpoEmail = this.mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ACESSO_EMAIL.getValor());
		}

		for (Map.Entry<String, String> mapValue : informacoesEmail.entrySet()) {

			String valor = "";

			if (StringUtils.isNotBlank(mapValue.getValue())) {
				valor = mapValue.getValue();
			}

			corpoEmail = corpoEmail.replaceAll(mapValue.getKey(), valor);
		}

		return corpoEmail;
	}

	private Mono<Boolean> enviaEmail(final String destinatario, final String assuntoEmail, final String corpoEmail,
			final String cpfCnpj) {

		String mailfrom = "";
		String emailRemetente = this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_REMETENTE_EMAIL.getValor());
		if (emailRemetente != null) {
			mailfrom = emailRemetente;
		}

		return this.portoMsMensageriaService.enviaEmail(mailfrom, destinatario, assuntoEmail, corpoEmail, cpfCnpj);
	}

	public Mono<EnviaCodigoSeguranca> enviaCodigoPorSms(UsuarioPortalCliente usuarioPortalCliente, PessoaVO pessoaVo,
			TipoCodigoEnum tipoCodigo, TipoFluxoEnum tipoCadastro) {
		String cpfCnpj = TrataCpfCnpjUtils.formatarCPFCNPJSemMascara(usuarioPortalCliente.getCnpjCpf(),
				usuarioPortalCliente.getCnpjOrdem(), usuarioPortalCliente.getCnpjCpfDigito());
		return this.tokenAAService.geraPinCliente(cpfCnpj).flatMap(
				pinVO -> montaInformacoesSms(pinVO).flatMap(informacoesSms -> enviaSmsMontado(usuarioPortalCliente,
						pessoaVo, informacoesSms, tipoCodigo, tipoCadastro).flatMap(isSucesso -> {
							if (isSucesso.booleanValue()) {
								return Mono.just(criaEnviaCodigoSeguranca(isSucesso, pinVO));
							}
							return Mono.error(new EnvioCodigoSegurancaException(
									this.mensagemLocalCacheService.recuperaTextoMensagem(
											MensagemChaveEnum.USUARIO_ERRO_ENVIO_EMAIL_SMS.getValor()),
									HttpStatus.BAD_REQUEST.value()));
						})))
				.onErrorResume(error -> {
					LOG.error(error.getMessage(), error);
					return Mono.error(error);
				});
	}

	private Mono<Map<String, String>> montaInformacoesSms(final PinVO pinVO) {
		final Map<String, String> informacoesSms = new HashMap<>();

		informacoesSms.put(PARAMETRO_CORPO_EMAIL_SMS_CODIGO_SEGURANCA, pinVO.getPin());

		return Mono.just(informacoesSms);
	}

	private Mono<Boolean> enviaSmsMontado(UsuarioPortalCliente usuarioPortalCliente, PessoaVO pessoaVo,
			Map<String, String> informacoesSms, TipoCodigoEnum tipoCodigo, TipoFluxoEnum tipoCadastro) {

		String textoSms = "";
		String mensagem;
		String dddCelular = null;
		String numeroCelular = null;
		String chaveMensagem;
		Long subTipo;

		if (tipoCodigo == TipoCodigoEnum.ATIVACAO) {
			chaveMensagem = MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_ATIVACAO.getValor();
			subTipo = LogSubTipoEnum.ENVIO_CODIGO_SEGURANCA_CELULAR.getCodigo();
			mensagem = this.mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor());

			if (tipoCadastro != null && tipoCadastro.equals(TipoFluxoEnum.HARD)) {
				dddCelular = usuarioPortalCliente.getNumDddCelular() != null
						? String.valueOf(usuarioPortalCliente.getNumDddCelular())
						: "";
				numeroCelular = usuarioPortalCliente.getNumCelular() != null
						? String.valueOf(usuarioPortalCliente.getNumCelular())
						: "";
			} else if (pessoaVo != null && CollectionUtils.isNotEmpty(pessoaVo.getTelefones())) {
				dddCelular = pessoaVo.getTelefones().get(0).getDdd();
				numeroCelular = pessoaVo.getTelefones().get(0).getNumeroTelefone();
			}

		} else if (tipoCodigo == TipoCodigoEnum.RECUPERACAO) {
			chaveMensagem = MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_RECUPERACAO.getValor();
			subTipo = LogSubTipoEnum.ENVIO_CODIGO_SEGURANCA_SMS_RECUPERACAO_DE_CONTA.getCodigo();
			mensagem = this.mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_RECUPERACAO_CELULAR.getValor());
			dddCelular = Objects.toString(usuarioPortalCliente.getNumDddCelular(), null);
			numeroCelular = Objects.toString(usuarioPortalCliente.getNumCelular(), null);

		} else {
			chaveMensagem = MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_ACESSO.getValor();
			subTipo = LogSubTipoEnum.ENVIO_CODIGO_SEGURANCA_SMS_ACESSO_DE_CONTA.getCodigo();
			mensagem = this.mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ACESSO_CELULAR.getValor());
			dddCelular = Objects.toString(usuarioPortalCliente.getNumDddCelular(), null);
			numeroCelular = Objects.toString(usuarioPortalCliente.getNumCelular(), null);
		}

		if (mensagem != null && StringUtils.isNotBlank(mensagem)) {
			textoSms = mensagem.replaceAll("\\{parameterReplace\\}",
					informacoesSms.get(PARAMETRO_CORPO_EMAIL_SMS_CODIGO_SEGURANCA));
		}

		if (StringUtils.isNotBlank(textoSms) && dddCelular != null && numeroCelular != null) {
			String cpfCnpj = TrataCpfCnpjUtils.formatarCPFCNPJSemMascara(usuarioPortalCliente.getCnpjCpf(),
					usuarioPortalCliente.getCnpjOrdem(), usuarioPortalCliente.getCnpjCpfDigito());

			return this.portoMsMensageriaService.enviaSms(dddCelular, numeroCelular, textoSms, cpfCnpj)
					.map(retornoEnvioSMS -> {

						logPortalClienteService.geraLogPortal(usuarioPortalCliente, chaveMensagem, subTipo);
						return retornoEnvioSMS;
					});

		} else {
			LOG.info("Usuario não possui celular cadastrado");
			return Mono.just(Boolean.FALSE);
		}
	}

	private EnviaCodigoSeguranca criaEnviaCodigoSeguranca(boolean isSucesso, PinVO pinVo) {
		return new EnviaCodigoSeguranca(pinVo.getDataCriacao(), pinVo.getDataExpiracao(), isSucesso);
	}

	protected Mono<EnviaCodigoSeguranca> enviaCodigoEmailOuSms(UsuarioPortalCliente usuarioPortal, PessoaVO pessoaVo,
			TipoEnvioEnum tipoEnvio, TipoCodigoEnum tipoCodigo, TipoFluxoEnum tipoCadastro) {
		if (TipoEnvioEnum.EMAIL == tipoEnvio) {
			return this.enviaCodigoPorEmail(usuarioPortal, pessoaVo, tipoCodigo, tipoCadastro);
		} else {
			return this.enviaCodigoPorSms(usuarioPortal, pessoaVo, tipoCodigo, tipoCadastro);
		}
	}

	protected Mono<InformacaoCodigoSeguranca> verificaTentativasDisponiveis(String token, UsuarioPortalCliente usuario,
			TipoCodigoEnum tipoCodigo) {
		if (usuario.getQuantidadeTentativaCriacaoConta() == null) {
			usuario.setQuantidadeTentativaCriacaoConta(0L);
		}

		if (usuario.getQuantidadeTentativasRecuperacaoConta() == null) {
			usuario.setQuantidadeTentativasRecuperacaoConta(0L);
		}

		if (usuario.getQtdTentativaLogin() == null) {
			usuario.setQtdTentativaLogin(0L);
		}

		Long numeroTentativasLimite;
		Long numeroTentativasRestantes;

		if (tipoCodigo == TipoCodigoEnum.RECUPERACAO) {
			numeroTentativasLimite = obtemNumeroTentativasRecuperacaoLimite();
			numeroTentativasRestantes = numeroTentativasLimite - usuario.getQuantidadeTentativasRecuperacaoConta();

		} else if (tipoCodigo == TipoCodigoEnum.ATIVACAO) {
			numeroTentativasLimite = obtemNumeroTentativasCadastroLimite();
			numeroTentativasRestantes = numeroTentativasLimite - usuario.getQuantidadeTentativaCriacaoConta();
		} else {
			numeroTentativasLimite = obtemNumeroTentativasAcessoLimite();
			numeroTentativasRestantes = numeroTentativasLimite - usuario.getQtdTentativaLogin();
		}

		if (numeroTentativasRestantes <= 0) {
			return Mono.error(new CodigoSegurancaException(
					this.mensagemLocalCacheService
							.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_NUMERO_TENTATIVAS.getValor()),
					HttpStatus.UNPROCESSABLE_ENTITY.value(), obtemInformacaoContadorConta(usuario, false, tipoCodigo)));
		} else {
			return validaTentativa(token, usuario, tipoCodigo);
		}

	}

	private Mono<InformacaoCodigoSeguranca> validaTentativa(String token, UsuarioPortalCliente usuario,
			TipoCodigoEnum tipoCodigo) {
		String cpfCnpj = TrataCpfCnpjUtils.formatarCPFCNPJSemMascara(usuario.getCnpjCpf(), usuario.getCnpjOrdem(),
				usuario.getCnpjCpfDigito());

		String chaveMensagem;
		if (tipoCodigo == TipoCodigoEnum.RECUPERACAO) {
			chaveMensagem = MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_RECUPERACAO_INVALIDO.getValor();
		} else if (tipoCodigo == TipoCodigoEnum.ATIVACAO) {
			chaveMensagem = MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_ATIVACAO_INVALIDO.getValor();
		} else {
			chaveMensagem = MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_ACESSO_INVALIDO.getValor();
		}

		return tokenAAService.validaTokenCliente(cpfCnpj, token).flatMap(tokenAA -> {
			this.lexisNexisService.atualizaLexisNexis(LexisNexisChallengeStatusEnum.CHALLENGE_PASS.getValor(),
					LexisNexisTagContextEnum.OTPH.getValor());
			return obtemInformacaoCodigoSeguranca(usuario, tipoCodigo, tokenAA);
		}).onErrorResume(error -> {
			if (error instanceof GeraTokenAAException) {
				GeraTokenAAException errorGeraToken = (GeraTokenAAException) error;
				if (HttpStatus.NOT_FOUND.value() == errorGeraToken.getStatusCode()) {
					logPortalClienteService.geraLogPortal(usuario, chaveMensagem,
							LogSubTipoEnum.PIN_INVALIDO.getCodigo());
					return incrementaQuantidadeTentativa(usuario, tipoCodigo)
							.flatMap(limiteExcedido -> Mono.error(new CodigoSegurancaException(
									this.mensagemLocalCacheService.recuperaTextoMensagem(
											MensagemChaveEnum.USUARIO_ERRO_CODIGO_SEGURANCA_NAO_ENCONTRADO.getValor()),
									HttpStatus.NOT_FOUND.value(),
									this.obtemInformacaoContadorConta(usuario, false, tipoCodigo))));
				} else if (HttpStatus.UNAUTHORIZED.value() == errorGeraToken.getStatusCode()) {
					logPortalClienteService.geraLogPortal(usuario, chaveMensagem,
							LogSubTipoEnum.PIN_INVALIDO.getCodigo());
					return incrementaQuantidadeTentativa(usuario, tipoCodigo)
							.flatMap(limiteExcedido -> Mono.error(new CodigoSegurancaException(
									this.mensagemLocalCacheService.recuperaTextoMensagem(
											MensagemChaveEnum.USUARIO_VALIDACAO_CODIGO_ATIVACAO_EXPIRADO.getValor()),
									HttpStatus.UNAUTHORIZED.value(),
									this.obtemInformacaoContadorConta(usuario, false, tipoCodigo))));
				} else {
					return Mono.error(new CodigoSegurancaException(
							this.mensagemLocalCacheService
									.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_VALIDA_PIN.getValor()),
							HttpStatus.BAD_REQUEST.value(),
							this.obtemInformacaoContadorConta(usuario, false, tipoCodigo)));
				}
			} else {
				return Mono.error(new CodigoSegurancaException(
						this.mensagemLocalCacheService
								.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_VALIDA_PIN.getValor()),
						HttpStatus.BAD_REQUEST.value(), this.obtemInformacaoContadorConta(usuario, false, tipoCodigo)));
			}

		});
	}

	private Mono<InformacaoCodigoSeguranca> obtemInformacaoCodigoSeguranca(UsuarioPortalCliente usuario,
			TipoCodigoEnum tipoCodigo, ValidaTokenAAResponse tokenAAResponse) {

		UsuarioStatusConta usuarioStatus;
		InformacaoContadorConta validacaoCodigo;

		if (tipoCodigo == TipoCodigoEnum.RECUPERACAO) {
			usuarioStatus = this.usuarioStatusContaRepository
					.findByIdStatusConta(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus());
			usuario.setStatusUsuario(usuarioStatus);

			usuario.setQuantidadeTentativasRecuperacaoConta(0L);
			usuario.setQtdTentativaLogin(0L);

			validacaoCodigo = new InformacaoContadorConta(usuario.getQuantidadeTentativasRecuperacaoConta(),
					this.obtemNumeroTentativasRecuperacaoLimite(), true);
		} else if (tipoCodigo == TipoCodigoEnum.ATIVACAO) {
			usuarioStatus = this.usuarioStatusContaRepository
					.findByIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus());
			usuario.setStatusUsuario(usuarioStatus);

			usuario.setQuantidadeTentativaCriacaoConta(0L);
			usuario.setQtdTentativaLogin(0L);
			usuario.setQuantidadeTentativasRecuperacaoConta(0L);

			validacaoCodigo = new InformacaoContadorConta(usuario.getQuantidadeTentativaCriacaoConta(),
					this.obtemNumeroTentativasCadastroLimite(), true);

		} else {
			usuarioStatus = this.usuarioStatusContaRepository
					.findByIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());
			usuario.setQtdTentativaLogin(0L);
			usuario.setStatusUsuario(usuarioStatus);
			validacaoCodigo = new InformacaoContadorConta(usuario.getQtdTentativaLogin(),
					this.obtemNumeroTentativasAcessoLimite(), true);
		}
		return usuarioPortalService.salvar(usuario).map(usuarioPortal -> {
			return new InformacaoCodigoSeguranca(tokenAAResponse.getValidityStartTime(),
					tokenAAResponse.getValidityEndTime(), validacaoCodigo);
		});

	}
}
