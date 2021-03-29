package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.GeraTokenAAException;
import com.porto.portocom.portal.cliente.v1.exception.IntegracaoKbaException;
import com.porto.portocom.portal.cliente.v1.exception.ValidacaoPinException;
import com.porto.portocom.portal.cliente.v1.model.PinVO;
import com.porto.portocom.portal.cliente.v1.model.ValidaTokenAAResponse;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.service.ConfirmacaoPositivaService;
import com.porto.portocom.portal.cliente.v1.service.ILexisNexisService;
import com.porto.portocom.portal.cliente.v1.service.IPortalKbaService;
import com.porto.portocom.portal.cliente.v1.service.ITokenAAService;
import com.porto.portocom.portal.cliente.v1.service.MensagemLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
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
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConfirmacaoPositivaServiceUnitTest {

	private static final String LEXIS_BASE64_TEST = "eyJzZXNzaW9uSWQiOiI3OGVkMWFkZS01YzU3LTQ1ZTEtYmI2Yl8xMjM0NTY3ODkwIiwicmVxdWVzdElkIjoiIiwib3JnYW5pemF0aW9uSWQiOiI2dDR4dWdrciIsInZhbGlkYXRpb24iOiIiLCJpcEFkZHJlc3MiOiIyMDEuNDkuMzUuMjUwIn0=";

	@Mock
	private IUsuarioPortalClienteRepository usuarioPortalClienteRepository;

	@Mock
	private IUsuarioStatusContaRepository usuarioStatusContaRepository;

	@Mock
	private ParametrosLocalCacheService parametrosLocalCacheService;

	@Mock
	private MensagemLocalCacheService mensagemLocalCacheService;

	@Mock
	private IPortalKbaService portalKbaService;

	@Mock
	private ITokenAAService tokenAAService;

	@Mock
	private ILexisNexisService lexisNexisService;

	@Mock
	private ParametrosLocalCacheService parametroLocalCache;

	@Mock
	private LexisNexisUtils lexisNexisUtils;

	private static GeneralDataKbaAnswers generalDataKbaAnswers;

	@Spy
	@InjectMocks
	private ConfirmacaoPositivaService confirmacaoPositivaService;

	private static KbaQuizPinVO kbaQuizPinVO;

	private static PinVO pinVo;

	private static KbaQuizVO questions;

	private static final String CPF = "96352035353";

	private static final String CPF_ERROR = "9635203GUYGUY";

	private ValidaTokenAAResponse tokenResponse;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		criarPinVO();
		criarResponseKbaQuizzes();
		criarGeneralDataKbaAnswers();

		MDC.put(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor(), "texto0");
		MDC.put(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), LEXIS_BASE64_TEST);

		Mockito.when(this.lexisNexisUtils.verificaFlagLexis()).thenReturn(true);
		tokenResponse = new ValidaTokenAAResponse();
		tokenResponse.setValidityEndTime(LocalDateTime.now());
		tokenResponse.setValidityEndTime(LocalDateTime.now());

	}

	private void criarPinVO() {
		pinVo = new PinVO(LocalDateTime.now(), LocalDateTime.now(), "0894576");
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

		questions = new KbaQuizVO();
		questions.setId("5f931d94813465196fe2b8f9");
		questions.setDescription("Alguma das alternativas abaixo representa o mês e ano do seu nascimento?");
		questions.setAssessment(3.0);
		questions.setAnswers(Arrays.asList(answer));

		kbaQuizPinVO.setPin(pinVo.getPin());
		kbaQuizPinVO.setKbaQuiz(Arrays.asList(questions));
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

	@Test
	public void testRecuperaQuestionarioSucesso() throws IOException {

		Mockito.when(this.tokenAAService.geraPinServico(CPF)).thenReturn(Mono.just(pinVo));

		Mockito.when(this.portalKbaService.recuperaQuestionario(CPF)).thenReturn(kbaQuizPinVO);

		confirmacaoPositivaService.recuperaQuestionario(CPF).map(kbaQuizPin -> {
			assertEquals(kbaQuizPinVO, kbaQuizPinVO);
			return kbaQuizPin;
		}).subscribe();

		Mockito.verify(confirmacaoPositivaService, Mockito.times(1)).recuperaQuestionario(CPF);
	}

	@Test
	public void testRecuperaQuestionarioFalhaCpfCnpjInvalidoException() throws IOException {

		Mockito.when(this.tokenAAService.geraPinServico(CPF)).thenReturn(Mono.just(pinVo));

		Mockito.when(this.portalKbaService.recuperaQuestionario(CPF)).thenReturn(kbaQuizPinVO);

		confirmacaoPositivaService.recuperaQuestionario(CPF_ERROR).doOnError(erro -> {
			CpfCnpjInvalidoException error = (CpfCnpjInvalidoException) erro;
			assertEquals("Revise os caracteres digitados e tente de novo ou acesse ‘esqueci minha senha’.",
					error.getMessage());
		}).subscribe();

		Mockito.verify(confirmacaoPositivaService, Mockito.times(1)).recuperaQuestionario(CPF_ERROR);
	}

	@Test
	public void testRecuperaAvaliacaoRespostas() throws IOException {

		AvalicaoRespostaVO avaliacaoRespostaVO = new AvalicaoRespostaVO();

		KbaAnswersVO kbaAnswersVO = new KbaAnswersVO();
		kbaAnswersVO.setPin("1111");
		kbaAnswersVO.setCpf("96352035353");
		kbaAnswersVO.setSessionId("5fbd668c23b4812ae7ec6af1");
		kbaAnswersVO.setGeneralData(Arrays.asList(generalDataKbaAnswers));

		Mockito.when(tokenAAService.validaTokenServico("96352035353", "1111")).thenReturn(Mono.just(tokenResponse));

		Mockito.when(this.portalKbaService.enviaRespostaQuestionario(kbaAnswersVO))
				.thenReturn(Mono.just(avaliacaoRespostaVO));

		confirmacaoPositivaService.enviaRespostaQuestionario(kbaAnswersVO);

		Mockito.verify(confirmacaoPositivaService, Mockito.times(1)).enviaRespostaQuestionario(kbaAnswersVO);
	}

	@Test
	public void testRecuperaAvaliacaoRespostasException() throws IOException {

		KbaAnswersVO kbaAnswersVO = new KbaAnswersVO();

		kbaAnswersVO.setPin("1111");
		kbaAnswersVO.setCpf("96352035353");
		kbaAnswersVO.setSessionId("5fbd668c23b4812ae7ec6af1");
		kbaAnswersVO.setGeneralData(Arrays.asList(generalDataKbaAnswers));

		Mockito.when(tokenAAService.validaTokenServico("96352035353", "1111")).thenReturn(Mono.just(tokenResponse));

		Mockito.when(this.portalKbaService.enviaRespostaQuestionario(kbaAnswersVO))
				.thenThrow(new IntegracaoKbaException("Erro integração kba instável.", 400));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_INTEGRACAO_KBA_INSTAVEL.getValor()))
				.thenReturn("Erro integração kba instável.");

		confirmacaoPositivaService.enviaRespostaQuestionario(kbaAnswersVO).doOnError(erro -> {
			IntegracaoKbaException error = (IntegracaoKbaException) erro;
			assertEquals("Erro integração kba instável.", error.getMessage());
		}).subscribe();

		Mockito.verify(confirmacaoPositivaService, Mockito.times(1)).enviaRespostaQuestionario(kbaAnswersVO);
	}

	@Test
	public void testEnviaRespostasValidacaoPinUnauthorizedException() throws IOException {

		AvalicaoRespostaVO avaliacaoRespostaVO = new AvalicaoRespostaVO();

		KbaAnswersVO kbaAnswersVO = new KbaAnswersVO();

		kbaAnswersVO.setPin("1111");
		kbaAnswersVO.setCpf("96352035353");
		kbaAnswersVO.setSessionId("5fbd668c23b4812ae7ec6af1");
		kbaAnswersVO.setGeneralData(Arrays.asList(generalDataKbaAnswers));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_CODIGO_ATIVACAO_EXPIRADO.getValor()))
				.thenReturn("O código de ativação expirou. Por favor, solicite um novo.");

		Mockito.when(tokenAAService.validaTokenServico("96352035353", "1111"))
				.thenReturn(Mono.error(new GeraTokenAAException("Codigo expirado.", 401)));

		Mockito.when(this.portalKbaService.enviaRespostaQuestionario(kbaAnswersVO))
				.thenReturn(Mono.just(avaliacaoRespostaVO));

		confirmacaoPositivaService.enviaRespostaQuestionario(kbaAnswersVO).doOnError(erro -> {
			ValidacaoPinException errorGeraToken = (ValidacaoPinException) erro;
			assertEquals("O código de ativação expirou. Por favor, solicite um novo.", errorGeraToken.getMessage());
			assertEquals(HttpStatus.UNAUTHORIZED.value(), errorGeraToken.getStatusCode());
		}).subscribe();

		Mockito.verify(confirmacaoPositivaService, Mockito.times(1)).enviaRespostaQuestionario(kbaAnswersVO);
	}

	@Test
	public void testEnviaRespostasValidacaoPinNotFoundException() throws IOException {

		AvalicaoRespostaVO avaliacaoRespostaVO = new AvalicaoRespostaVO();

		KbaAnswersVO kbaAnswersVO = new KbaAnswersVO();

		kbaAnswersVO.setPin("12345");
		kbaAnswersVO.setCpf("96352035353");
		kbaAnswersVO.setSessionId("5fbd668c23b4812ae7ec6af1");
		kbaAnswersVO.setGeneralData(Arrays.asList(generalDataKbaAnswers));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_CODIGO_SEGURANCA_NAO_ENCONTRADO.getValor()))
				.thenReturn("Código de segurança não encontrado.");

		Mockito.when(tokenAAService.validaTokenServico("96352035353", "12345"))
				.thenReturn(Mono.error(new GeraTokenAAException("Código de segurança não encontrado.", 404)));

		Mockito.when(this.portalKbaService.enviaRespostaQuestionario(kbaAnswersVO))
				.thenReturn(Mono.just(avaliacaoRespostaVO));

		confirmacaoPositivaService.enviaRespostaQuestionario(kbaAnswersVO).doOnError(erro -> {
			ValidacaoPinException errorGeraToken = (ValidacaoPinException) erro;
			assertEquals("Código de segurança não encontrado.", errorGeraToken.getMessage());
			assertEquals(HttpStatus.NOT_FOUND.value(), errorGeraToken.getStatusCode());
		}).subscribe();

		Mockito.verify(confirmacaoPositivaService, Mockito.times(1)).enviaRespostaQuestionario(kbaAnswersVO);
	}

	@Test
	public void testEnviaRespostasValidacaoPinBadRequestException() throws IOException {

		AvalicaoRespostaVO avaliacaoRespostaVO = new AvalicaoRespostaVO();

		KbaAnswersVO kbaAnswersVO = new KbaAnswersVO();

		kbaAnswersVO.setPin("12345");
		kbaAnswersVO.setCpf("96352035353");
		kbaAnswersVO.setSessionId("5fbd668c23b4812ae7ec6af1");
		kbaAnswersVO.setGeneralData(Arrays.asList(generalDataKbaAnswers));

		Mockito.when(
				mensagemLocalCacheService.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_VALIDA_PIN.getValor()))
				.thenReturn("Código de segurança inválido.");

		Mockito.when(tokenAAService.validaTokenServico("96352035353", "12345"))
				.thenReturn(Mono.error(new GeraTokenAAException("Código de segurança inválido.", 400)));

		Mockito.when(this.portalKbaService.enviaRespostaQuestionario(kbaAnswersVO))
				.thenReturn(Mono.just(avaliacaoRespostaVO));

		confirmacaoPositivaService.enviaRespostaQuestionario(kbaAnswersVO).doOnError(erro -> {
			ValidacaoPinException errorGeraToken = (ValidacaoPinException) erro;
			assertEquals("Código de segurança inválido.", errorGeraToken.getMessage());
			assertEquals(HttpStatus.BAD_REQUEST.value(), errorGeraToken.getStatusCode());
		}).subscribe();

		Mockito.verify(confirmacaoPositivaService, Mockito.times(1)).enviaRespostaQuestionario(kbaAnswersVO);
	}

}