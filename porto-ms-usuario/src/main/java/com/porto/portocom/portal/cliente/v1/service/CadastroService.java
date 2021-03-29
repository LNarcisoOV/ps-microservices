package com.porto.portocom.portal.cliente.v1.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.exception.CadastroException;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.LdapException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMsMensageriaService;
import com.porto.portocom.portal.cliente.v1.integration.facade.ILdapFacade;
import com.porto.portocom.portal.cliente.v1.model.ContaAcessoComSenha;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.utils.TrataCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.vo.usuario.CadastroSenha;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TipoUsuarioVO;

import reactor.core.publisher.Mono;

@Service
public class CadastroService implements ICadastroService {

	private static final Logger LOG = LoggerFactory.getLogger(CadastroService.class);

	private static final String CODIGO_USUARIO_INVALIDO = "1";

	private static final String PARAMETRO_CORPO_EMAIL_NOME_USUARIO = "nomeUsuario";
	private static final String PARAMETRO_CORPO_EMAIL_PATH_PORTAL = "pathPortal";
	private static final String PARAMETRO_ASSUNTO_EMAIL = "assuntoEmail";
	private static final String PARAMETRO_CPF_CNPJ = "parameterCPFReplace";
	private static final String CODIGO_TELEMETRIA = "125";

	private IUsuarioPortalService usuarioPortalService;

	private MensagemLocalCacheService mensagemLocalCacheService;

	private IUsuarioPortalClienteRepository usuarioPortalClienteRepository;

	private IUsuarioStatusContaRepository usuarioStatusContaRepository;

	private ILdapFacade ldapFacade;

	private ICodigoAtivacaoService codigoAtivacaoService;

	private ICodigoRecuperacaoService codigoRecuperacaoService;

	private IPortoMsMensageriaService portoMsMensageriaService;

	private ParametrosLocalCacheService parametrosLocalCacheService;

	@Autowired
	public CadastroService(IUsuarioPortalService usuarioPortalService,
			MensagemLocalCacheService mensagemLocalCacheService,
			IUsuarioPortalClienteRepository usuarioPortalClienteRepository, ILdapFacade ldapFacade,
			IUsuarioStatusContaRepository usuarioStatusContaRepository, ICodigoAtivacaoService codigoAtivacaoService,
			ICodigoRecuperacaoService codigoRecuperacaoService, IPortoMsMensageriaService portoMsMensageriaService,
			IProspectService prospectService, ParametrosLocalCacheService parametrosLocalCacheService) {
		this.usuarioPortalService = usuarioPortalService;
		this.mensagemLocalCacheService = mensagemLocalCacheService;
		this.usuarioPortalClienteRepository = usuarioPortalClienteRepository;
		this.ldapFacade = ldapFacade;
		this.usuarioStatusContaRepository = usuarioStatusContaRepository;
		this.codigoAtivacaoService = codigoAtivacaoService;
		this.codigoRecuperacaoService = codigoRecuperacaoService;
		this.portoMsMensageriaService = portoMsMensageriaService;
		this.parametrosLocalCacheService = parametrosLocalCacheService;
	}

	@Override
	public Mono<Boolean> alteraSenhaUsuario(String cpfCnpj, String senha, String codigoRecuperacao) {
		return this.usuarioPortalService.consultar(cpfCnpj).flatMap(usuario -> this.codigoRecuperacaoService
				.validaCodigo(codigoRecuperacao, usuario).flatMap(informacaoCodigoSeguranca -> {
					if (informacaoCodigoSeguranca.getInfContador().isSucesso()) {
						return this.ldapFacade.atualizarSenha(cpfCnpj, senha, null).flatMap(senhaAlteradaComSucesso -> {
							if (senhaAlteradaComSucesso.booleanValue()) {
								UsuarioStatusConta usuarioStatus = this.usuarioStatusContaRepository
										.findByIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN
												.getCodStatus());
								usuario.setStatusUsuario(usuarioStatus);
								usuarioPortalClienteRepository.save(usuario);
								return Mono.just(senhaAlteradaComSucesso);
							} else {
								return Mono.error(new UsuarioPortalException(
										mensagemLocalCacheService.recuperaTextoMensagem(
												MensagemChaveEnum.USUARIO_ERRO_REDEFINIR_SENHA.getValor()),
										HttpStatus.BAD_REQUEST.value()));
							}
						});
					} else {
						return Mono.error(new UsuarioPortalException(
								mensagemLocalCacheService.recuperaTextoMensagem(
										MensagemChaveEnum.USUARIO_ERRO_REDEFINIR_SENHA.getValor()),
								HttpStatus.NOT_FOUND.value()));
					}
				})

		).switchIfEmpty(Mono.error(new CadastroException(
				mensagemLocalCacheService
						.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()),
				HttpStatus.NOT_FOUND.value())));
	}

	public Mono<Boolean> alteraSenhaCadastro(String cpfCnpj, String senha, String pin) {
		return this.usuarioPortalService.consultar(cpfCnpj)
				.flatMap(usuarioPortal -> this.codigoAtivacaoService.validaCodigoAtivacaoCadastroSenha(cpfCnpj, pin)
						.flatMap(infCodigo -> this.ldapFacade.atualizarSenha(cpfCnpj, senha, null)
								.doOnSuccess(onSuccess -> LOG.debug("Usuario {} atualizado: {}", cpfCnpj, onSuccess))));
	}

	@Override
	public Mono<Boolean> criarUsuarioComSenha(CadastroSenha cadastroSenha, TipoUsuarioVO tipoUsuarioVO) {
		if (ValidaCpfCnpjUtils.isValid(cadastroSenha.getUsuario())) {
			return this.codigoAtivacaoService
					.validaCodigoAtivacaoCadastroSenha(cadastroSenha.getUsuario(), cadastroSenha.getPin())
					.flatMap(informacaoCodigoseguranca -> {

						ContaAcessoComSenha.ContaAcessoComSenhaBuilder contaAcessoComSenhaBuilder = ContaAcessoComSenha
								.builder().nome(cadastroSenha.getNome()).sobreNome(cadastroSenha.getSobrenome())
								.usuario(cadastroSenha.getUsuario()).senha(cadastroSenha.getSenha());

						if (tipoUsuarioVO.getIdTipoUsuario().equals(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo())) {
							contaAcessoComSenhaBuilder.produtos(Arrays
									.asList(new String[] { CODIGO_TELEMETRIA + "#" + cadastroSenha.getUsuario() }));
						}
						return ldapFacade.criarUsuarioComSenha(contaAcessoComSenhaBuilder.build())
								.flatMap(sucesso -> ldapFacade.atualizarSenha(cadastroSenha.getUsuario(),
										cadastroSenha.getSenha(), null))
								.doOnSuccess(onSuccess -> LOG.debug("Usuario {} atualizado: {}",
										cadastroSenha.getUsuario(), onSuccess));
					}).onErrorResume(errorCriarUsuarioComSenha -> {
						if (errorCriarUsuarioComSenha instanceof LdapException && CODIGO_USUARIO_INVALIDO
								.equals(((LdapException) errorCriarUsuarioComSenha).getCodigo())) {
							return ldapFacade.atualizarSenha(cadastroSenha.getUsuario(), cadastroSenha.getSenha(),
									errorCriarUsuarioComSenha.getMessage());
						}

						return Mono.error(errorCriarUsuarioComSenha);
					});

		} else {
			return Mono.error(new CpfCnpjInvalidoException(mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor())));
		}
	}

	@Override
	public Mono<Boolean> cadastroSenha(CadastroSenha cadastro) {

		return validate(cadastro)
				.flatMap(validado -> this.usuarioPortalService.consultar(cadastro.getUsuario()).flatMap(usuario -> {

					if (usuario.getStatusUsuario() != null && usuario.getStatusUsuario().getIdStatusConta() != null
							&& StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus()
									.equals(usuario.getStatusUsuario().getIdStatusConta())) {

						return this.alteraSenhaCadastro(cadastro.getUsuario(), cadastro.getSenha(), cadastro.getPin())
								.flatMap(senhaAlteradaComSucesso -> {
									UsuarioStatusConta usuarioStatus = this.usuarioStatusContaRepository
											.findByIdStatusConta(
													StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN
															.getCodStatus());
									usuario.setStatusUsuario(usuarioStatus);
									usuarioPortalClienteRepository.save(usuario);
									enviaNotificacaoCadastro(usuario, cadastro.getUsuario());
									return Mono.just(senhaAlteradaComSucesso);
								}).onErrorResume(errorAlteraSenhaUsuario -> {
									if (errorAlteraSenhaUsuario instanceof LdapException && CODIGO_USUARIO_INVALIDO
											.equals(((LdapException) errorAlteraSenhaUsuario).getCodigo())) {
										return this.criarUsuarioComSenha(cadastro, TipoUsuarioVO.builder()
												.idTipoUsuario(usuario.getTipoUsuario().getIdTipoUsuario())
												.descricaoTipoUsuario(
														usuario.getTipoUsuario().getDescricaoTipoUsuario())
												.flagTipoUsuario(usuario.getTipoUsuario().getFlagTipoUsuario()).build())
												.map(usuarioCriadoComSucesso -> {
													UsuarioStatusConta usuarioStatus = this.usuarioStatusContaRepository
															.findByIdStatusConta(
																	StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN
																			.getCodStatus());
													usuario.setStatusUsuario(usuarioStatus);
													usuarioPortalClienteRepository.save(usuario);
													enviaNotificacaoCadastro(usuario, cadastro.getUsuario());
													return usuarioCriadoComSucesso;
												}).onErrorResume(errorCriaUsuario -> {
													LOG.error(errorCriaUsuario.getMessage(), errorCriaUsuario);
													return Mono.error(errorCriaUsuario);
												});
									}
									LOG.error(errorAlteraSenhaUsuario.getMessage(), errorAlteraSenhaUsuario);
									return Mono.error(errorAlteraSenhaUsuario);
								});
					} else {
						return Mono.error(new CadastroException(
								this.mensagemLocalCacheService.recuperaTextoMensagem(
										MensagemChaveEnum.USUARIO_VALIDACAO_CADASTRO_NAO_PERMITIDO_STATUS.getValor()),
								HttpStatus.BAD_REQUEST.value()));
					}

				}).onErrorResume(error -> {
					LOG.error(error.getMessage(), error);
					return Mono.error(error);
				})).onErrorResume(error -> {
					LOG.error(error.getMessage(), error);
					return Mono.error(error);
				});
	}

	private Mono<Boolean> validate(CadastroSenha cadastro) {
		if (cadastro != null) {
			if (StringUtils.isBlank(cadastro.getNome())) {
				return Mono.error(new CadastroException("Nome não informado.", HttpStatus.BAD_REQUEST.value()));
			}

			if (StringUtils.isBlank(cadastro.getUsuario())) {
				return Mono.error(new CadastroException("Usuário não informado", HttpStatus.BAD_REQUEST.value()));
			}

			if (StringUtils.isBlank(cadastro.getSenha())) {
				return Mono.error(new CadastroException("Senha não informada.", HttpStatus.BAD_REQUEST.value()));
			}

			if (StringUtils.isBlank(cadastro.getPin())) {
				return Mono.error(new CadastroException("Pin não informado.", HttpStatus.BAD_REQUEST.value()));
			}

			return Mono.just(Boolean.TRUE);
		} else {
			return Mono
					.error(new CadastroException(
							this.mensagemLocalCacheService
									.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_CADASTRO_VAZIO.getValor()),
							HttpStatus.BAD_REQUEST.value()));
		}
	}

	private void enviaNotificacaoCadastro(UsuarioPortalCliente usuario, String cpfCnpj) {

		enviaNotificacaoSms(usuario, cpfCnpj);
		enviaNotificacaoEmail(usuario, cpfCnpj);

	}

	private void enviaNotificacaoSms(UsuarioPortalCliente usuario, String cpfCnpj) {
		String textoSms = "";
		String mensagem;
		String dddCelular = null;
		String numeroCelular = null;

		mensagem = this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_NOVA_CONTA_CADASTRADA_SMS.getValor());

		if (mensagem != null && StringUtils.isNotBlank(mensagem)) {
			textoSms = mensagem.replaceAll("\\{parameterCPFReplace\\}", TrataCpfCnpjUtils.camuflaCpfCnpj(cpfCnpj));
		}

		if (usuario != null) {
			dddCelular = Objects.toString(usuario.getNumDddCelular(), null);
			numeroCelular = Objects.toString(usuario.getNumCelular(), null);
		}

		if (StringUtils.isNotBlank(textoSms) && dddCelular != null && numeroCelular != null) {

			this.portoMsMensageriaService.enviaSms(dddCelular, numeroCelular, textoSms, cpfCnpj);

		} else {
			LOG.info("Usuario não possui celular cadastrado");
		}

	}

	private void enviaNotificacaoEmail(UsuarioPortalCliente usuario, String cpfCnpj) {
		Map<String, String> informacoesEmail = new HashMap<>();
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

		assuntoEmail = this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_ASSUNTO_CADASTRO_CONTA_EMAIL.getValor());

		informacoesEmail.put(PARAMETRO_ASSUNTO_EMAIL, assuntoEmail);
		informacoesEmail.put(PARAMETRO_CPF_CNPJ, TrataCpfCnpjUtils.camuflaCpfCnpj(cpfCnpj));

		String nome = usuario.getNomeUsuarioPortal();
		if (StringUtils.isNotBlank(nome)) {
			final String[] nomeUsuarioSplit = nome.split(" ", 2);
			nome = nomeUsuarioSplit[0];
		}

		informacoesEmail.put(PARAMETRO_CORPO_EMAIL_NOME_USUARIO, nome);

		String corpoEmail = this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_NOVA_CONTA_CADASTRADA_EMAIL.getValor());

		for (Map.Entry<String, String> mapValue : informacoesEmail.entrySet()) {

			String valor = "";

			if (StringUtils.isNotBlank(mapValue.getValue())) {
				valor = mapValue.getValue();
			}

			corpoEmail = corpoEmail.replaceAll(mapValue.getKey(), valor);
		}

		String enderecoEletronico = usuario.getDescEmail();

		if (StringUtils.isNotBlank(enderecoEletronico)) {
			this.enviaEmail(enderecoEletronico, informacoesEmail.get(PARAMETRO_ASSUNTO_EMAIL), corpoEmail, cpfCnpj);
		} else {
			LOG.info("Usuario não possui email cadastrado");
		}

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

}
