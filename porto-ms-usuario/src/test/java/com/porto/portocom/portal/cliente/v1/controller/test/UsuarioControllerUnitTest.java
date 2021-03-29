package com.porto.portocom.portal.cliente.v1.controller.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.exception.CadastroException;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.IdInvalidoException;
//import com.porto.portocom.portal.cliente.v1.exception.LoginException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.AplicacaoLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ConfirmacaoPositivaService;
import com.porto.portocom.portal.cliente.v1.service.ICadastroService;
import com.porto.portocom.portal.cliente.v1.service.IContadorAcessoService;
import com.porto.portocom.portal.cliente.v1.service.IDadosCadastraisService;
import com.porto.portocom.portal.cliente.v1.service.IProspectService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.vo.NovoUsuarioESenhaVO;
import com.porto.portocom.portal.cliente.v1.vo.antifraude.CorporativoValidation;
import com.porto.portocom.portal.cliente.v1.vo.kba.AvalicaoRespostaVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.ClientResponsePayload.DecisionElements.Rules;
import com.porto.portocom.portal.cliente.v1.vo.kba.GeneralDataKbaAnswers;
import com.porto.portocom.portal.cliente.v1.vo.kba.KbaAnswersVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.KbaQuizPinVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.KbaQuizVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.PropertyAnswers;
import com.porto.portocom.portal.cliente.v1.vo.kba.ResponseDataVO.Answer;
import com.porto.portocom.portal.cliente.v1.vo.usuario.CadastroSenha;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificado;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioVO;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("controller-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioControllerUnitTest {

	@LocalServerPort
	private int port;

	@MockBean
	private IUsuarioPortalService usuarioPortalService;

	@MockBean
	private IContadorAcessoService contadorAcessoService;

	@MockBean
	private IProspectService prospectService;

	@MockBean
	private ICadastroService cadastroService;
	
	@MockBean
	private IDadosCadastraisService dadosCadastraisService;
	
	@MockBean
	private AplicacaoLocalCacheService aplicacaoLocalCacheService;

	@MockBean
	private ConfirmacaoPositivaService confirmacaoPositivaService;
	
	private static KbaQuizPinVO kbaQuizPinVO;
	
	private static GeneralDataKbaAnswers generalDataKbaAnswers;

	@Autowired
	private TestRestTemplate restTemplate;
	
	private static final String KEY_VALUE_HEADER_LEXIS = "eyJzZXNzaW9uSWQiOiIyMDIwOTExNjUyOTk2NzkxNTA2VDRYVUdLUiIsInJlcXVlc3RJZCI6IiIsIm9yZ2FuaXphdGlvbklkIjoiNnQ0eHVna3IiLCJ2YWxpZGF0aW9uIjoiIn0=";

	@BeforeEach
	public void init() { 
		MockitoAnnotations.initMocks(this);
		when(aplicacaoLocalCacheService.recuperaNomeAplicacao("appTeste")).thenReturn("appTeste");
		restTemplate.getRestTemplate().setInterceptors(Collections.singletonList((request, body, execution) -> {
			request.getHeaders().set("codigoAutorizacao", "appTeste");
			request.getHeaders().set(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), KEY_VALUE_HEADER_LEXIS);
			return execution.execute(request, body);
		}));
		criarResponseKbaQuizzes();
		criarGeneralDataKbaAnswers();
	}
	
	private void criarGeneralDataKbaAnswers() {

		PropertyAnswers propertyA = new PropertyAnswers();
		PropertyAnswers propertyB = new PropertyAnswers();
		PropertyAnswers propertyC = new PropertyAnswers();
		PropertyAnswers propertyD = new PropertyAnswers();
		PropertyAnswers propertyE = new PropertyAnswers();
		List<PropertyAnswers> property = new ArrayList<>();

		generalDataKbaAnswers = new GeneralDataKbaAnswers();

		propertyA.setKey("0");
		propertyB.setKey("1");
		propertyC.setKey("2");
		propertyD.setKey("3");
		propertyE.setKey("4");

		propertyA.setValue("Marizete");
		propertyB.setValue("Maria");
		propertyC.setValue("Markus");
		propertyD.setValue("Marcileia");
		propertyE.setValue("Nenhuma das anteriores");

		propertyA.setValueType("null");
		propertyB.setValueType("null");
		propertyC.setValueType("null");
		propertyD.setValueType("true");
		propertyE.setValueType("null");

		property.add(propertyA);
		property.add(propertyB);
		property.add(propertyC);
		property.add(propertyD);
		property.add(propertyE);

		generalDataKbaAnswers.setProperties(property);
		generalDataKbaAnswers.setDataName("5f9317e4813465196fe2b8d7");
		generalDataKbaAnswers.setDescription("Alguma das alternativas abaixo representa o primeiro nome da sua mãe?");

	}
	
	private void criarResponseKbaQuizzes() {

		kbaQuizPinVO = new KbaQuizPinVO();

		Rules rules = new Rules();
		rules.setRuleName("Alguma das alternativas abaixo representa o mês e ano do seu nascimento?");
		rules.setRuleId("5f931d94813465196fe2b8f9");
		rules.setRuleText("teste");

		Answer answer = new Answer();
		answer.setDescription("6 - 1977");
		answer.setId("0");

		KbaQuizVO questions = new KbaQuizVO();
		questions.setId("5f931d94813465196fe2b8f9");
		questions.setDescription("Alguma das alternativas abaixo representa o mês e ano do seu nascimento?");
		questions.setAssessment(3.0);
		questions.setAnswers(Arrays.asList(answer));

		kbaQuizPinVO.setPin("789234");
		kbaQuizPinVO.setKbaQuiz(Arrays.asList(questions));
	}

	@Test
	public void testConsultaUsuario1Sucesso() {

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");

		Mockito.when(usuarioPortalService.consultar("22890390802")).thenReturn(Mono.just(usuarioPortalCliente));

		ResponseEntity<Response<UsuarioPortalCliente>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioPortalCliente>>() {
				});

		Assert.assertTrue("Consulta realizada com sucesso.",
				usuario.getBody().getData().getIdUsuario().equals(668910L));
	}

	@Test
	public void testConsultaUsuario1Exception() {

		Mockito.when(usuarioPortalService.consultar("22890390802")).thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<UsuarioPortalCliente>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/consulta/22890390802", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioPortalCliente>>() {
				});

		Assert.assertEquals("testConsultaUsuario1Exception", HttpStatus.NOT_FOUND.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testConsultaUsuarioStutsSucesso() {

		UsuarioStatusConta usuarioStatusConta = new UsuarioStatusConta();
		usuarioStatusConta.setDescricaoStatusConta("ATIVA");
		usuarioStatusConta.setIdStatusConta(2345L);
		Mockito.when(usuarioPortalService.consultaStatus("22890390802"))
				.thenReturn(Mono.just(usuarioStatusConta));

		ResponseEntity<Response<UsuarioStatusConta>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/status", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioStatusConta>>() {
				});

		Assert.assertEquals("Consulta realizada com sucesso.", usuario.getBody().getStatus(), HttpStatus.OK.value());
	}

	@Test
	public void testConsultaStatusCpfCnpjInvalidoException() {

		Mockito.when(usuarioPortalService.consultaStatus("22890390802"))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<UsuarioStatusConta>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/status", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioStatusConta>>() {
				});

		Assert.assertEquals("testConsultaUsuario1Exception", HttpStatus.BAD_REQUEST.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testConsultaStatusUsuarioPortalException() {

		Mockito.when(usuarioPortalService.consultaStatus("22890390802"))
				.thenReturn(Mono.error(new UsuarioPortalException("Erro", HttpStatus.BAD_REQUEST.value())));

		ResponseEntity<Response<UsuarioStatusConta>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/status", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioStatusConta>>() {
				});

		Assert.assertEquals("testConsultaStatusUsuarioPortalException", HttpStatus.BAD_REQUEST.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testConsultaStatusException() {

		Mockito.when(usuarioPortalService.consultaStatus("22890390802")).thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<UsuarioStatusConta>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/status", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioStatusConta>>() {
				});

		Assert.assertEquals("testConsultaStatusException", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testRedefinirSenhaSucesso() {

		NovoUsuarioESenhaVO novoUsuario = new NovoUsuarioESenhaVO("22890390802","123123","123456");
		
		Mockito.when(this.cadastroService.alteraSenhaUsuario("22890390802", "123123", "123456"))
				.thenReturn(Mono.just(Boolean.TRUE));

		HttpEntity<NovoUsuarioESenhaVO> requestEntity = new HttpEntity<>(novoUsuario);

		ResponseEntity<Response<Boolean>> cadastro = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/redefine-senha", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertTrue("Senha cadastrada com sucesso.", cadastro.getBody().getData());
	}

	@Test
	public void testRedefinirSenhaCpfDiferenteException() {

		NovoUsuarioESenhaVO novoUsuario = new NovoUsuarioESenhaVO();
		novoUsuario.setNovoUsuario("22890390801");
		novoUsuario.setNovaSenha("123123");

		HttpEntity<NovoUsuarioESenhaVO> requestEntity = new HttpEntity<>(novoUsuario);

		ResponseEntity<Response<Boolean>> cadastro = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/redefine-senha", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("CpfCnpj divergente", cadastro.getBody().getErrors().get(0));
		Assert.assertEquals(400, cadastro.getBody().getStatus());
	}

	@Test
	public void testRedefinirSenhaException() {

		NovoUsuarioESenhaVO novoUsuario = new NovoUsuarioESenhaVO("22890390802","123123","123456");

		Mockito.when(this.cadastroService.alteraSenhaUsuario("22890390802", "123123", "123456"))
				.thenReturn(Mono.error(new Exception()));

		HttpEntity<NovoUsuarioESenhaVO> requestEntity = new HttpEntity<>(novoUsuario);

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/redefine-senha", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testRedefinirSenhaException", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testRedefinirSenhaCodigoSegurancaException() {

		NovoUsuarioESenhaVO novoUsuario = new NovoUsuarioESenhaVO("22890390802","123123","123456");

		Mockito.when(this.cadastroService.alteraSenhaUsuario("22890390802", "123123", "123456"))
				.thenReturn(Mono.error(new CodigoSegurancaException("Erro", HttpStatus.UNPROCESSABLE_ENTITY.value(), null)));

		HttpEntity<NovoUsuarioESenhaVO> requestEntity = new HttpEntity<>(novoUsuario);

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/redefine-senha", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testRedefinirSenhaCodigoSegurancaException", HttpStatus.UNPROCESSABLE_ENTITY.value(),
				usuario.getBody().getStatus());
	}
	
	@Test
	public void testRedefinirSenhaCpfCnpjInvalidoException() {

		NovoUsuarioESenhaVO novoUsuario = new NovoUsuarioESenhaVO("2289039","123123","123456");

		Mockito.when(this.cadastroService.alteraSenhaUsuario("2289039", "123123", "123456"))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("Erro")));

		HttpEntity<NovoUsuarioESenhaVO> requestEntity = new HttpEntity<>(novoUsuario);

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/2289039/redefine-senha", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testRedefinirSenhaCpfCnpjInvalidoException", HttpStatus.BAD_REQUEST.value(),
				usuario.getBody().getStatus());
	}
	
	@Test
	public void testRedefinirSenhaCadastroException() {

		NovoUsuarioESenhaVO novoUsuario = new NovoUsuarioESenhaVO("22890390802","123123","123456");

		Mockito.when(this.cadastroService.alteraSenhaUsuario("22890390802", "123123", "123456"))
				.thenReturn(Mono.error(new CadastroException("Erro", HttpStatus.NOT_FOUND.value())));

		HttpEntity<NovoUsuarioESenhaVO> requestEntity = new HttpEntity<>(novoUsuario);

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/redefine/senha/22890390802", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testRedefinirSenhaCadastroException", HttpStatus.NOT_FOUND.value(),
				usuario.getBody().getStatus());
	}
	
	
	@Test
	public void testCadastroSenhaSucesso() {

		CadastroSenha cadastroBuilder = new CadastroSenha();
		cadastroBuilder.setNome("Adriano");
		cadastroBuilder.setSobrenome("Santos");
		cadastroBuilder.setUsuario("22890390802");
		cadastroBuilder.setSenha("senha123");

		Mockito.when(cadastroService.cadastroSenha(cadastroBuilder)).thenReturn(Mono.just(Boolean.TRUE));

		HttpEntity<CadastroSenha> requestEntity = new HttpEntity<>(cadastroBuilder);

		ResponseEntity<Response<Boolean>> cadastro = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/senha", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertTrue("Senha cadastrada com sucesso.", cadastro.getBody().getData());
	}

	@Test
	public void testCadastroSenhaException() {

		CadastroSenha cadastroBuilder = new CadastroSenha();
		cadastroBuilder.setNome("Adriano");
		cadastroBuilder.setSobrenome("Santos");
		cadastroBuilder.setUsuario("22890390802");
		cadastroBuilder.setSenha("senha123");

		Mockito.when(cadastroService.cadastroSenha(cadastroBuilder)).thenReturn(Mono.error(new Exception()));

		HttpEntity<CadastroSenha> requestEntity = new HttpEntity<>(cadastroBuilder);

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/senha", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testCadastroSenhaException", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testCadastroSenhaCpfCnpjInvalidoException() {
		
		CadastroSenha cadastroBuilder = new CadastroSenha();
		cadastroBuilder.setNome("Adriano");
		cadastroBuilder.setSobrenome("Santos");
		cadastroBuilder.setUsuario("22890390802");
		cadastroBuilder.setSenha("senha123");

		Mockito.when(cadastroService.cadastroSenha(cadastroBuilder))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		HttpEntity<CadastroSenha> requestEntity = new HttpEntity<>(cadastroBuilder);

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/senha", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testCadastroSenhaCpfCnpjInvalidoException", HttpStatus.BAD_REQUEST.value(),
				usuario.getBody().getStatus());
	}

	
	@Test
	public void testCadastroSenhaCodigoSegurancaException() {

		CadastroSenha cadastroBuilder = new CadastroSenha();
		cadastroBuilder.setNome("Adriano");
		cadastroBuilder.setSobrenome("Santos");
		cadastroBuilder.setUsuario("22890390802");
		cadastroBuilder.setSenha("senha123");

		Mockito.when(cadastroService.cadastroSenha(cadastroBuilder))
				.thenReturn(Mono.error(new CodigoSegurancaException("Erro", HttpStatus.UNPROCESSABLE_ENTITY.value(), null)));

		HttpEntity<CadastroSenha> requestEntity = new HttpEntity<>(cadastroBuilder);

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/senha", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testCadastroSenhaCpfCnpjInvalidoException", HttpStatus.UNPROCESSABLE_ENTITY.value(),
				usuario.getBody().getStatus());
	}
	@Test
	public void testConsultaUsuariopPorIdSucesso() {

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setDescEmail("finha3103@gmail.com");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");

		Mockito.when(usuarioPortalService.consultarUsuarioPorId(669771L))
				.thenReturn(Mono.just(usuarioPortalCliente));

		ResponseEntity<Response<UsuarioPortalCliente>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/codigo/669771", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioPortalCliente>>() {
				});

		Assert.assertTrue("Consulta realizada com sucesso.",
				usuario.getBody().getData().getDescEmail().equals("finha3103@gmail.com"));
	}

	@Test
	public void testConsultaUsuariopPorIdNaoEncontrado() {

		Mockito.when(usuarioPortalService.consultarUsuarioPorId(669771L))
				.thenReturn(Mono.error(new IdInvalidoException()));

		ResponseEntity<Response<UsuarioPortalCliente>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/codigo/669771", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioPortalCliente>>() {
				});

		Assert.assertEquals("testCadastroSenhaCpfCnpjInvalidoException", usuario.getBody().getStatus(),
				HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void testConsultaUsuariopPorIdErroGenerico() {

		Mockito.when(usuarioPortalService.consultarUsuarioPorId(669771L))
				.thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<UsuarioPortalCliente>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/codigo/669771", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioPortalCliente>>() {
				});

		Assert.assertEquals("testCadastroSenhaCpfCnpjInvalidoException", usuario.getBody().getStatus(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testeAtualizaDadosCadastraisSucesso() {

		UsuarioSimplificado usrSimpBuilder = new UsuarioSimplificado();
		List<String> emailss = new ArrayList<String>();
		usrSimpBuilder.setNome("Adriano Santos");
		emailss.add("adriano.santos@portoseguro.com.br");
		usrSimpBuilder.setEmails(emailss);
		usrSimpBuilder.setCelulares(Collections.emptyList());

		UsuarioVO usuarioVo = new UsuarioVO();
		usuarioVo.setCelular(null);
		usuarioVo.setCpfCnpj("37488499824");
		usuarioVo.setEmail("adriano.santos@portoseguro.com.br");
		usuarioVo.setNome("Adriano Santoss");

		UsuarioSimplificado usrSimp = usrSimpBuilder;

		List<UsuarioSimplificado> listUsrSimpl = new ArrayList<>();
		listUsrSimpl.add(usrSimp);

		Mockito.when(dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.zip(Mono.just(listUsrSimpl), Mono.just(new CorporativoValidation())));

		WebClient.builder().build().patch().uri("http://localhost:" + port + "/v1/usuario?tipoCodigo=ATIVACAO")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("codigoAutorizacao", "appTeste")
				.header(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), KEY_VALUE_HEADER_LEXIS)
				.body(BodyInserters.fromPublisher(Mono.just(usuarioVo), UsuarioVO.class)).retrieve()
				.bodyToMono(new ParameterizedTypeReference<Response<List<LinkedHashMap<?, ?>>>>() {
				}).flatMap(response -> {

					List<?> emails = (List<?>) response.getData().get(0).get("emails");
					List<?> celulares = (List<?>) response.getData().get(0).get("celulares");

					Assert.assertNotNull(emails.get(0).toString());
					Assert.assertTrue(celulares.isEmpty());
					Assert.assertTrue(emails.get(0).toString().equals("adriano.santos@portoseguro.com.br"));
					Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
					return Mono.just(response);
				}).block();
	}

	@Test
	public void testatualizaDadosCadastraisCpfCnpjInvalidoException() {

		UsuarioVO usuarioVo = new UsuarioVO();
		usuarioVo.setCelular(null);
		usuarioVo.setCpfCnpj("37488499824");
		usuarioVo.setEmail("adriano.santos@portoseguro.com.br");
		usuarioVo.setNome("Adriano Santoss");

		Mockito.when(dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("Erro")));

		WebClient.builder().build().patch().uri("http://localhost:" + port + "/v1/usuario?tipoCodigo=ATIVACAO")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("codigoAutorizacao", "appTeste")
				.header(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), KEY_VALUE_HEADER_LEXIS)
				.body(BodyInserters.fromPublisher(Mono.just(usuarioVo), UsuarioVO.class)).retrieve()
				.bodyToMono(new ParameterizedTypeReference<Response<List<Object>>>() {
				}).flatMap(response -> {
					Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
					return Mono.just(response);
				}).block();
	}

	@Test
	public void testatualizaDadosCadastraisUsuarioPortalException() {

		UsuarioVO usuarioVo = new UsuarioVO();
		usuarioVo.setCelular(null);
		usuarioVo.setCpfCnpj("37488499824");
		usuarioVo.setEmail("adriano.santos@portoseguro.com.br");
		usuarioVo.setNome("Adriano Santoss");

		Mockito.when(dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.error(new UsuarioPortalException("Erro", HttpStatus.BAD_REQUEST.value())));

		WebClient.builder().build().patch().uri("http://localhost:" + port + "/v1/usuario?tipoCodigo=ATIVACAO")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("codigoAutorizacao", "appTeste")
				.header(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), KEY_VALUE_HEADER_LEXIS)
				.body(BodyInserters.fromPublisher(Mono.just(usuarioVo), UsuarioVO.class)).retrieve()
				.bodyToMono(new ParameterizedTypeReference<Response<List<Object>>>() {
				}).flatMap(response -> {
					Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
					return Mono.just(response);
				}).block();
	}

	@Test
	public void testAtualizaDadosCadastraisErroGenerico() {

		UsuarioVO usuarioVo = new UsuarioVO();
		usuarioVo.setCelular(null);
		usuarioVo.setCpfCnpj("37488499824");
		usuarioVo.setEmail("adriano.santos@portoseguro.com.br");
		usuarioVo.setNome("Adriano Santoss");

		Mockito.when(dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.error(new Exception()));

		WebClient.builder().build().patch().uri("http://localhost:" + port + "/v1/usuario")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("codigoAutorizacao", "appTeste")
				.header(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), KEY_VALUE_HEADER_LEXIS)
				.body(BodyInserters.fromPublisher(Mono.just(usuarioVo), UsuarioVO.class)).retrieve()
				.bodyToMono(new ParameterizedTypeReference<Response<List<Object>>>() {
				}).flatMap(response -> {
					Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());
					return Mono.just(response);
				}).subscribe();
	}

}