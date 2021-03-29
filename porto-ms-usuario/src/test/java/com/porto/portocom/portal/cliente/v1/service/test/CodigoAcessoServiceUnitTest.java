package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import com.porto.portocom.portal.cliente.entity.ParametrosSistema;
import com.porto.portocom.portal.cliente.entity.SegurancaContaPortalUsuario;
import com.porto.portocom.portal.cliente.entity.SegurancaContaPortalUsuarioId;
import com.porto.portocom.portal.cliente.entity.TipoCodigoSeguranca;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoEnvioEnum;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.EnvioCodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.GeraTokenAAException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMsMensageriaService;
import com.porto.portocom.portal.cliente.v1.model.PinVO;
import com.porto.portocom.portal.cliente.v1.model.ValidaTokenAAResponse;
import com.porto.portocom.portal.cliente.v1.repository.ISegurancaContaPortalUsuarioRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.service.CodigoAcessoService;
import com.porto.portocom.portal.cliente.v1.service.ILexisNexisService;
import com.porto.portocom.portal.cliente.v1.service.ILogPortalClienteService;
import com.porto.portocom.portal.cliente.v1.service.ITokenAAService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.service.MensagemLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CodigoAcessoServiceUnitTest {

	@Mock
	private ILogPortalClienteService logPortalClienteService;

	@Mock
	private static ParametrosLocalCacheService parametrosLocalCacheService;

	@Mock
	private ITokenAAService tokenAAService;

	@Mock
	private IPortoMsMensageriaService portoMsMensageriaService;

	@Mock
	private IUsuarioPortalService usuarioPortalService;

	@Mock
	private MensagemLocalCacheService mensagemLocalCacheService;

	@Mock
	private IUsuarioStatusContaRepository usuarioStatusContaRepository;

	@Mock
	private ISegurancaContaPortalUsuarioRepository segurancaContaPortalUsuarioRepository;

	@Mock
	private ILexisNexisService lexisNexisService;
	
	@Mock
	private LexisNexisUtils lexisNexisUtil;

	@InjectMocks
	private CodigoAcessoService codigoAcessoService;

	private static final String CPF_PADRAO = "22890390802";

	private static final String PIN_PADRAO = "12345";

	private static final String ASSUNTO_EMAIL = "Porto Seguro Portal de Clientes - Acesso de conta";

	private static final long LOG_PIN_INVALIDO = 118;
	private static final long LOG_SUBTIPO_BLOQUEIO_CONTA = 24;

	private static final String DDD = "11";

	private static final String TELEFONE = "974220722";

	private static final String LEXIS_BASE64_TEST = "eyJzZXNzaW9uSWQiOiI2MWZkOGVmNS03MzNmLTQ1NGItYjExYy04ZjA1MjFmMjM2NTYiLCJyZXF1ZXN0SWQiOiI5YzJkNzY1MS04ZTgxLTQ5ODItYmFkYS1hZWVmZjNiM2I5ZTYiLCJvcmdhbml6YXRpb25JZCI6IjZ0NHh1Z2tyIiwidmFsaWRhdGlvbiI6InZhbGlkYXRpb24ifQ==";

	private static UsuarioPortalCliente usuarioPortalCliente;

	private static TipoCodigoSeguranca tipoCodigoSeguranca;

	private static SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId;

	private static SegurancaContaPortalUsuario segurancaContaPortalUsuario;

	private PinVO pinVo;
	
	private ValidaTokenAAResponse tokenResponse;

	@Before
	public void init() throws DatatypeConfigurationException {
		MockitoAnnotations.initMocks(this);

		Map<String, ParametrosSistema> parametros = new HashMap<>();
		parametros.put("porto.ms.usuario.protocolo.email",
				new ParametrosSistema(37L, "porto.ms.usuario.protocolo.email", "http"));
		parametros.put("porto.ms.usuario.endereco.email",
				new ParametrosSistema(38L, "porto.ms.usuario.endereco.email", "otclientdevm.portoseguro.brasil"));
		parametros.put("porto.ms.usuario.remetente.email",
				new ParametrosSistema(5L, "porto.ms.usuario.remetente.email", "portaldocliente@portoseguro.com.br"));
		parametros.put("porto.ms.usuario.assunto.criar.conta.email",
				new ParametrosSistema(24L, "porto.ms.usuario.assunto.criar.conta.email",
						"Porto Seguro Portal de Clientes - Nova Conta Cadastrada"));
		parametros.put("porto.ms.usuario.nome.portal.email",
				new ParametrosSistema(28L, "porto.ms.usuario.nome.portal.email", "portaldecliente"));

		parametros.put("porto.ms.usuario.tentativas.recuperacao",
				new ParametrosSistema(1L, "porto.ms.usuario.tentativas.recuperacao", "5"));

		parametrosLocalCacheService.getParametros().putAll(parametros);

		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.protocolo.email"))
		.thenReturn("http");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.endereco.email"))
		.thenReturn("otclientdevm.portoseguro.brasil");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.remetente.email"))
		.thenReturn("portaldocliente@portoseguro.com.br");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.assunto.criar.conta.email"))
		.thenReturn("Porto Seguro Portal de Clientes - Nova Conta Cadastrada");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.nome.portal.email"))
		.thenReturn("portaldecliente");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.tentativas.recuperacao"))
		.thenReturn("5");

		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_LOGIN.getValor())).thenReturn("7");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_ACESSO_INVALIDO.getValor()))
		.thenReturn("Tentativa de validação de PIN – Acesso de conta em {data} por {aplicacao}");
		criaUsuarioPortal();

		pinVo = new PinVO(LocalDateTime.now(), LocalDateTime.now(), "12345");
		tokenResponse = new ValidaTokenAAResponse();
		tokenResponse.setValidityEndTime(LocalDateTime.now());
		tokenResponse.setValidityEndTime(LocalDateTime.now());

		criarSegurancaContaPortalUsuario();
		MDC.put(HeaderAplicacaoEnum.NOME_APLICACAO.getValor(), "teste");
		MDC.put(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), LEXIS_BASE64_TEST);
	}

	public static void criaUsuarioPortal() {
		usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(1212L);
		usuarioPortalCliente.setCodTipoPessoa("1");
		usuarioPortalCliente.setDataCadastro(new Date());
		usuarioPortalCliente.setFlgConfEnvEmail("S");
		usuarioPortalCliente.setQtdTentativaLogin(0L);
		usuarioPortalCliente.setQuantidadeAcessoLogin(0L);
		usuarioPortalCliente.setQuantidadeTentativaCriacaoConta(0L);
		usuarioPortalCliente.setDescEmail("felipe.rosa@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());
		usuarioPortalCliente.setStatusUsuario(statusConta);
		usuarioPortalCliente.setNumDddCelular(11L);
		usuarioPortalCliente.setNumCelular(974220722L);
	}

	public static void criarSegurancaContaPortalUsuario() {
		tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(12);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Segurança Acesso");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(7654321L);

		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());

		segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());
	}

	@Test
	public void testEnviaCodigoAcessoPorEmailAguardandoPrimeiroLoginSucesso() {

		usuarioPortalCliente.getStatusUsuario()
		.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus());

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_ASSUNTO_ACESSO_CONTA_EMAIL.getValor()))
		.thenReturn(ASSUNTO_EMAIL);

		Mockito.when(this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ACESSO_EMAIL.getValor()))
		.thenReturn("");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ACESSO.getValor()))
		.thenReturn("envio codigo");

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));


		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), ASSUNTO_EMAIL, "", CPF_PADRAO))
		.thenReturn(Mono.just(Boolean.TRUE));

		codigoAcessoService.enviaCodigoAcesso(CPF_PADRAO, TipoEnvioEnum.EMAIL).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), ASSUNTO_EMAIL, "", CPF_PADRAO);
		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoAcessoPorEmailTentativaRecuperacaoSucesso() {

		usuarioPortalCliente.getStatusUsuario()
		.setIdStatusConta(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus());

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_ASSUNTO_ACESSO_CONTA_EMAIL.getValor()))
		.thenReturn(ASSUNTO_EMAIL);

		Mockito.when(this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ACESSO_EMAIL.getValor()))
		.thenReturn("");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ACESSO.getValor()))
		.thenReturn("envio codigo");

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));


		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), ASSUNTO_EMAIL, "", CPF_PADRAO))
		.thenReturn(Mono.just(Boolean.TRUE));

		codigoAcessoService.enviaCodigoAcesso(CPF_PADRAO, TipoEnvioEnum.EMAIL).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), ASSUNTO_EMAIL, "", CPF_PADRAO);

		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);

	}

	@Test
	public void testEnviaCodigoAcessoPorEmailContaAtivaSucesso() {

		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_ASSUNTO_ACESSO_CONTA_EMAIL.getValor()))
		.thenReturn(ASSUNTO_EMAIL);

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ACESSO_EMAIL.getValor()))
		.thenReturn("");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ACESSO.getValor()))
		.thenReturn("envio codigo");

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));


		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), ASSUNTO_EMAIL, "", CPF_PADRAO))
		.thenReturn(Mono.just(Boolean.TRUE));

		codigoAcessoService.enviaCodigoAcesso(CPF_PADRAO, TipoEnvioEnum.EMAIL).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), ASSUNTO_EMAIL, "", CPF_PADRAO);

		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoAcessoPorEmailCodigoSegurancaException() {

		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ACESSO_EMAIL.getValor()))
		.thenReturn("");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ACESSO.getValor()))
		.thenReturn("envio codigo");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_ENVIO_EMAIL_SMS.getValor()))
		.thenReturn("Verifique seus dados cadastrais e tente de novo");

		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_ASSUNTO_ACESSO_CONTA_EMAIL.getValor()))
		.thenReturn(ASSUNTO_EMAIL);

		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_LOGIN.getValor())).thenReturn("5");

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));


		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), ASSUNTO_EMAIL, "", CPF_PADRAO))
		.thenReturn(Mono.just(Boolean.FALSE));

		codigoAcessoService.enviaCodigoAcesso(CPF_PADRAO, TipoEnvioEnum.EMAIL).onErrorResume(error -> {
			EnvioCodigoSegurancaException erro = (EnvioCodigoSegurancaException) error;
			assertEquals(HttpStatus.BAD_REQUEST.value(), erro.getStatusCode());
			assertEquals("Verifique seus dados cadastrais e tente de novo", erro.getMessage());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(mensagemLocalCacheService, Mockito.times(1))
		.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_ENVIO_EMAIL_SMS.getValor());

		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoAcessoPorEmailUsuarioInelegivel() {

		usuarioPortalCliente.getStatusUsuario()
		.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), ASSUNTO_EMAIL, "", CPF_PADRAO))
		.thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));


		codigoAcessoService.enviaCodigoAcesso(CPF_PADRAO, TipoEnvioEnum.EMAIL).onErrorResume(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertNotNull(error);
			assertEquals("testEnviaCodigoAcessoPorEmailUsuarioInelegivel", erro.getStatusCode(),
					HttpStatus.BAD_REQUEST.value());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(portoMsMensageriaService, Mockito.times(0)).enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), ASSUNTO_EMAIL, "", CPF_PADRAO);

	}

	@Test
	public void testEnviaCodigoAcessoPorSMSAtivoSucesso() {

		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());

		String message = "Porto Seguro: Para concluir o seu processo de cadastro de conta no Portal do Cliente, utilize o codigo de seguranca: {parameterReplace}.";

		message = message.replaceAll("\\{parameterReplace\\}", "1234567");

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ACESSO_CELULAR.getValor()))
		.thenReturn(message);

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_ACESSO.getValor()))
		.thenReturn("envio codigo");

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));


		Mockito.when(portoMsMensageriaService.enviaSms(DDD, TELEFONE, message, CPF_PADRAO))
		.thenReturn(Mono.just(Boolean.TRUE));

		codigoAcessoService.enviaCodigoAcesso(CPF_PADRAO, TipoEnvioEnum.CELULAR).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(mensagemLocalCacheService, Mockito.times(1))
		.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ACESSO_CELULAR.getValor());
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaSms(DDD, TELEFONE, message, CPF_PADRAO);
		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoAcessoPorSMSCodigoSegurancaException() {

		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());

		String message = "Porto Seguro: Para concluir o seu processo de cadastro de conta no Portal do Cliente, utilize o codigo de seguranca: {parameterReplace}.";

		message = message.replaceAll("\\{parameterReplace\\}", "1234567");

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_ENVIO_EMAIL_SMS.getValor()))
		.thenReturn("Verifique seus dados cadastrais e tente de novo");

		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_LOGIN.getValor())).thenReturn("5");

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));


		Mockito.when(portoMsMensageriaService.enviaSms(DDD, TELEFONE, message, CPF_PADRAO))
		.thenReturn(Mono.just(Boolean.FALSE));

		codigoAcessoService.enviaCodigoAcesso(CPF_PADRAO, TipoEnvioEnum.CELULAR).onErrorResume(error -> {
			EnvioCodigoSegurancaException erro = (EnvioCodigoSegurancaException) error;
			assertEquals(HttpStatus.BAD_REQUEST.value(), erro.getStatusCode());
			assertEquals("Verifique seus dados cadastrais e tente de novo", erro.getMessage());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(mensagemLocalCacheService, Mockito.times(1))
		.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ACESSO_CELULAR.getValor());
		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);
	}

	@Test
	public void testValidaCodigoAcessoSucesso() {
		long logSubtipoValidaCodigoSeguranca = 89;
		Long qtdLimiteLogin = 7L;
		Long qtdLogin = 0L;
		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());

		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());
		usuarioPortalCliente.setQtdTentativaLogin(null);

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente))
		.thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(tokenAAService.validaTokenCliente(CPF_PADRAO, PIN_PADRAO)).thenReturn(Mono.just(tokenResponse));

		Mockito.when(
				usuarioStatusContaRepository.findByIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus()))
		.thenReturn(statusConta);

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_ACESSO.getValor()))
		.thenReturn("Validação de código de acesso realizado em {data} por {aplicacao}");

		codigoAcessoService.validaCodigoAcesso(CPF_PADRAO, PIN_PADRAO).map(retorno -> {
			assertEquals(qtdLimiteLogin, retorno.getInfContador().getQtdTentativaLimite());
			assertEquals(qtdLogin, retorno.getInfContador().getQtdTentativa());
			return retorno;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);


		Mockito.verify(usuarioStatusContaRepository, Mockito.times(1))
		.findByIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());

		Mockito.verify(logPortalClienteService, Mockito.times(1)).geraLogPortal(usuarioPortalCliente,
				MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_ACESSO.getValor(), logSubtipoValidaCodigoSeguranca);

	}

	@Test
	public void testValidaCodigoAcessoErroStatusNPermitido() {

		usuarioPortalCliente.getStatusUsuario()
		.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO.getCodStatus());

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		codigoAcessoService.validaCodigoAcesso(CPF_PADRAO, PIN_PADRAO).onErrorResume(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertNotNull(error);
			assertEquals("testValidaCodigoAcessoErroStatusNPermitido", erro.getStatusCode(),
					HttpStatus.BAD_REQUEST.value());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
	}

	@Test
	public void testValidaCodigoAcessoErroUsuarioNEncontrado() {

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.empty());
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()))
		.thenReturn("Usuario nao encontrado");

		codigoAcessoService.validaCodigoAcesso(CPF_PADRAO, PIN_PADRAO).onErrorResume(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertNotNull(error);
			assertEquals("testValidaCodigoAcessoErroUsuarioNEncontrado", erro.getStatusCode(),
					HttpStatus.NOT_FOUND.value());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
	}

	@Test
	public void testValidaCodigoAcessoErroNumeroTentativasExcedido() {
		Long qtdLimiteLogin = 8L;

		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());
		usuarioPortalCliente.setQtdTentativaLogin(qtdLimiteLogin);

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_NUMERO_TENTATIVAS.getValor()))
		.thenReturn("Sua conta foi bloqueada. Para restaurar conta, acesse ‘esqueci minha senha’.");

		codigoAcessoService.validaCodigoAcesso(CPF_PADRAO, PIN_PADRAO).onErrorResume(error -> {
			CodigoSegurancaException erro = (CodigoSegurancaException) error;
			assertNotNull(error);
			assertEquals("testValidaCodigoAcessoErroNumeroTentativasExcedido", erro.getStatusCode(),
					HttpStatus.UNPROCESSABLE_ENTITY.value());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);

	}

	@Test
	public void testValidaCodigoAcessoErroCodigoNEncontradoETentativaExcedida() {
		Long qtdLimiteLogin = 6L;
		usuarioPortalCliente.setQtdTentativaLogin(qtdLimiteLogin);

		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente))
		.thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_NUMERO_TENTATIVAS.getValor()))
		.thenReturn("Código de segurança não encontrado.");
		
		Mockito.when(tokenAAService.validaTokenCliente(CPF_PADRAO, PIN_PADRAO))
		.thenReturn(Mono.error(
				new GeraTokenAAException("Código de segurança não encontrado.", 404)));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_CODIGO_SEGURANCA_NAO_ENCONTRADO.getValor()))
		.thenReturn("Código de segurança não encontrado.");

		codigoAcessoService.validaCodigoAcesso(CPF_PADRAO, PIN_PADRAO).onErrorResume(error -> {
			CodigoSegurancaException erro = (CodigoSegurancaException) error;
			assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), erro.getStatusCode());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);

		Mockito.verify(logPortalClienteService, Mockito.times(1)).geraLogPortal(usuarioPortalCliente,
				MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_ACESSO_INVALIDO.getValor(), LOG_PIN_INVALIDO);
		Mockito.verify(logPortalClienteService, Mockito.times(1)).geraLogPortal(usuarioPortalCliente,
				MensagemChaveEnum.USUARIO_MSG_LOG_BLOQUEIO_CONTA_ACESSO.getValor(), LOG_SUBTIPO_BLOQUEIO_CONTA);
	}

	@Test
	public void testValidaCodigoAcessoErroCodigoNEncontrado() {

		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente))
		.thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(tokenAAService.validaTokenCliente(CPF_PADRAO, PIN_PADRAO))
		.thenReturn(Mono.error(
				new GeraTokenAAException("Código de segurança não encontrado.", 404)));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_CODIGO_SEGURANCA_NAO_ENCONTRADO.getValor()))
		.thenReturn("Código de segurança não encontrado.");

		codigoAcessoService.validaCodigoAcesso(CPF_PADRAO, PIN_PADRAO).onErrorResume(error -> {
			CodigoSegurancaException erro = (CodigoSegurancaException) error;
			assertNotNull(error);
			assertEquals("testValidaCodigoAcessoErroCodigoNEncontrado", erro.getStatusCode(),
					HttpStatus.NOT_FOUND.value());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);

		Mockito.verify(tokenAAService, Mockito.times(1)).validaTokenCliente(CPF_PADRAO, PIN_PADRAO);

		Mockito.verify(logPortalClienteService, Mockito.times(1)).geraLogPortal(usuarioPortalCliente,
				MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_ACESSO_INVALIDO.getValor(), LOG_PIN_INVALIDO);
	}

	@Test
	public void testValidaCodigoAcessoErroCodigoExpirado() {

		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date(120, 01, 01));

		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente))
		.thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(tokenAAService.validaTokenCliente(CPF_PADRAO, PIN_PADRAO))
		.thenReturn(Mono.error(
				new GeraTokenAAException("Codigo expirado.", 401)));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_CODIGO_SEGURANCA_NAO_ENCONTRADO.getValor()))
		.thenReturn("Código de segurança não encontrado.");

		codigoAcessoService.validaCodigoAcesso(CPF_PADRAO, PIN_PADRAO).onErrorResume(error -> {
			CodigoSegurancaException erro = (CodigoSegurancaException) error;
			assertNotNull(error);
			assertEquals(erro.getStatusCode(), HttpStatus.UNAUTHORIZED.value());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);

		Mockito.verify(tokenAAService, Mockito.times(1)).validaTokenCliente(CPF_PADRAO, PIN_PADRAO);

		Mockito.verify(logPortalClienteService, Mockito.times(1)).geraLogPortal(usuarioPortalCliente,
				MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_ACESSO_INVALIDO.getValor(), LOG_PIN_INVALIDO);
	}

}
