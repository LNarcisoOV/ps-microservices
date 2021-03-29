package com.porto.portocom.portal.cliente.v1.controller.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.AplicacaoLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ConfirmacaoPositivaService;
import com.porto.portocom.portal.cliente.v1.service.ICadastroService;
import com.porto.portocom.portal.cliente.v1.service.IContadorAcessoService;
import com.porto.portocom.portal.cliente.v1.service.IProspectService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.vo.kba.AvalicaoRespostaVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.ClientResponsePayload.DecisionElements.Rules;
import com.porto.portocom.portal.cliente.v1.vo.kba.GeneralDataKbaAnswers;
import com.porto.portocom.portal.cliente.v1.vo.kba.KbaAnswersVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.KbaQuizPinVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.KbaQuizVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.PropertyAnswers;
import com.porto.portocom.portal.cliente.v1.vo.kba.ResponseDataVO.Answer;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("controller-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuestionarioControllerUnitTest {

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
			request.getHeaders().set(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(),
					KEY_VALUE_HEADER_LEXIS);
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
	public void testRecuperaQuestionarioSucesso() {

		Mockito.when(confirmacaoPositivaService.recuperaQuestionario("96352035353"))
				.thenReturn(Mono.just(kbaQuizPinVO));

		ResponseEntity<Response<KbaQuizPinVO>> response = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/96352035353/questionario", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<KbaQuizPinVO>>() {
				});

		Assert.assertEquals(HttpStatus.OK.value(), response.getBody().getStatus());
	}

	@Test
	public void testRecuperaQuestionarioErroBadRequest() {

		Mockito.when(confirmacaoPositivaService.recuperaQuestionario("96352035353"))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<KbaQuizPinVO>> response = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/96352035353/questionario", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<KbaQuizPinVO>>() {
				});

		Assert.assertEquals("testRecuperaQuestionarioErroBadRequest", response.getBody().getStatus(),
				HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void testRecuperaQuestionarioErroGenerico() {

		Mockito.when(confirmacaoPositivaService.recuperaQuestionario("96352035353"))
				.thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<KbaQuizPinVO>> response = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/96352035353/questionario", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<KbaQuizPinVO>>() {
				});

		Assert.assertEquals("testRecuperaQuestionarioErroGenerico", response.getBody().getStatus(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testRecuperaAvaliacaoRespostasSucesso() {

		AvalicaoRespostaVO avaliacaoRespostaVO = new AvalicaoRespostaVO();

		KbaAnswersVO kbaAnswersBuilder = new KbaAnswersVO();
		kbaAnswersBuilder.setPin("1111");
		kbaAnswersBuilder.setCpf("96352035353");
		kbaAnswersBuilder.setSessionId("5fbd668c23b4812ae7ec6af1");
		kbaAnswersBuilder.setGeneralData(Arrays.asList(generalDataKbaAnswers));

		Mockito.when(confirmacaoPositivaService.enviaRespostaQuestionario(kbaAnswersBuilder))
				.thenReturn(Mono.just(avaliacaoRespostaVO));

		HttpEntity<KbaAnswersVO> requestEntity = new HttpEntity<>(kbaAnswersBuilder);

		ResponseEntity<Response<AvalicaoRespostaVO>> avaliacaoResposta = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/avaliacao-respostas-questionario", HttpMethod.POST,
				requestEntity, new ParameterizedTypeReference<Response<AvalicaoRespostaVO>>() {
				});

		Assert.assertEquals(HttpStatus.OK.value(), avaliacaoResposta.getBody().getStatus());
	}
}