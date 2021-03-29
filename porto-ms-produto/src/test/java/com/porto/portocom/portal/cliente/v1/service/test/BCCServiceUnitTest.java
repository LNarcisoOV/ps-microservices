package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
import com.porto.portocom.portal.cliente.v1.exception.LoginBCCException;
import com.porto.portocom.portal.cliente.v1.integration.IBCCIntegration;
import com.porto.portocom.portal.cliente.v1.service.BCCService;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPF;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPJ;
import com.porto.portocom.portal.cliente.v1.vo.login.SSOResponseVO;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BCCServiceUnitTest {

	@Mock
	private IBCCIntegration bccIntegration;

	@Spy
	@InjectMocks
	private BCCService bccService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		MDC.put(HeaderAplicacaoEnum.NOME_APLICACAO.getValor(), "teste");
	}

	@Test
	public void testRealizarLoginBCCSucesso() {

		SSOResponseVO ssoLoginResponseVO = new SSOResponseVO();
		ssoLoginResponseVO.setExpiresIn(4000L);

		bccService.setDataRequisicao(LocalDateTime.now().minusHours(2L));
		bccService.setLoginResponse(ssoLoginResponseVO);

		Mockito.when(this.bccIntegration.loginBCC()).thenReturn(Mono.just(new SSOResponseVO()));

		this.bccService.realizarLoginBCC().map(responseSSO -> {
			assertNotNull(responseSSO);
			return responseSSO;
		}).subscribe();

		Mockito.verify(this.bccIntegration, times(1)).loginBCC();
	}

	@Test
	public void testRealizarLoginBCCTokenExpirado() {

		SSOResponseVO ssoLoginResponseVO = new SSOResponseVO();
		ssoLoginResponseVO.setExpiresIn(4000L);

		bccService.setDataRequisicao(LocalDateTime.now().plusHours(2L));
		bccService.setLoginResponse(ssoLoginResponseVO);

		Mockito.when(this.bccIntegration.loginBCC()).thenReturn(Mono.just(new SSOResponseVO()));

		this.bccService.realizarLoginBCC().map(responseSSO -> {
			assertNotNull(responseSSO);
			return responseSSO;
		}).subscribe();
	}

	@Test
	public void testRealizarLoginBCCTokenInexistente() {

		bccService.setDataRequisicao(LocalDateTime.now().plusHours(2L));
		bccService.setLoginResponse(null);

		Mockito.when(this.bccIntegration.loginBCC()).thenReturn(Mono.just(new SSOResponseVO()));

		this.bccService.realizarLoginBCC().map(responseSSO -> {
			assertNotNull(responseSSO);
			return responseSSO;
		}).subscribe();
	}

	@Test
	public void testRealizarLoginBCCLoginException() {

		bccService.setDataRequisicao(LocalDateTime.now().plusHours(2L));
		bccService.setLoginResponse(null);

		Mockito.when(this.bccIntegration.loginBCC())
				.thenReturn(Mono.error(new LoginBCCException(HttpStatus.BAD_REQUEST, "Erro ao realizar Login")));

		this.bccService.realizarLoginBCC().onErrorResume(error -> {
			assertNotNull(error);
			LoginBCCException erro = (LoginBCCException) error;
			assertEquals(HttpStatus.BAD_REQUEST, erro.getStatus());
			return Mono.empty();
		}).subscribe();
	}

	@Test
	public void testRealizarConsultaBCCPFSucesso() {
		SSOResponseVO ssoLoginResponseVO = new SSOResponseVO();
		ssoLoginResponseVO.setAccessToken("aaaa-aaaa-aaaa-aaaa");

		PessoaBccPF pessoaBccPF = new PessoaBccPF();
		pessoaBccPF.setPessoas(new ArrayList<PessoaBccPF.Pessoa>());

		Mockito.doReturn(Mono.just(ssoLoginResponseVO)).when(this.bccService).realizarLoginBCC();
		Mockito.when(this.bccIntegration.consultaPessoaPF(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Mono.just(pessoaBccPF));

		this.bccService.consultaPFBCC("98765432111").map(pessoaPF -> {
			assertNotNull(pessoaPF);
			return pessoaPF;
		}).subscribe();

		Mockito.verify(this.bccIntegration, times(1)).consultaPessoaPF("98765432111",
				ssoLoginResponseVO.getAccessToken());
	}

	@Test
	public void testRealizarConsultaBCCPFFalha() {
		SSOResponseVO ssoLoginResponseVO = new SSOResponseVO();
		ssoLoginResponseVO.setAccessToken("aaaa-aaaa-aaaa-aaaa");

		PessoaBccPF pessoaBccPF = new PessoaBccPF();
		pessoaBccPF.setPessoas(new ArrayList<PessoaBccPF.Pessoa>());

		Mockito.doReturn(Mono.just(ssoLoginResponseVO)).when(this.bccService).realizarLoginBCC();
		Mockito.when(this.bccIntegration.consultaPessoaPF(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Mono.error(new LoginBCCException(HttpStatus.BAD_REQUEST, "")));

		this.bccService.consultaPFBCC("987654321111").onErrorResume(pessoaPF -> {
			LoginBCCException erro = (LoginBCCException) pessoaPF;
			assertEquals(HttpStatus.BAD_REQUEST, erro.getStatus());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(this.bccIntegration, times(1)).consultaPessoaPF("987654321111",
				ssoLoginResponseVO.getAccessToken());
	}

	@Test
	public void testRealizarConsultaBCCPJSucesso() {
		SSOResponseVO ssoLoginResponseVO = new SSOResponseVO();
		ssoLoginResponseVO.setAccessToken("aaaa-aaaa-aaaa-aaaa");

		PessoaBccPJ pessoaBccPJ = new PessoaBccPJ();
		pessoaBccPJ.setPessoas(new ArrayList<PessoaBccPJ.Pessoa>());

		Mockito.doReturn(Mono.just(ssoLoginResponseVO)).when(this.bccService).realizarLoginBCC();
		Mockito.when(this.bccIntegration.consultaPessoaPJ(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Mono.just(pessoaBccPJ));

		this.bccService.consultaPJBCC("61198164000160").map(pessoaPJ -> {
			assertNotNull(pessoaPJ);
			return pessoaPJ;
		}).subscribe();

		Mockito.verify(this.bccIntegration, times(1)).consultaPessoaPJ("61198164000160",
				ssoLoginResponseVO.getAccessToken());
	}

	@Test
	public void testRealizarConsultaBCCPJFalha() {
		SSOResponseVO ssoLoginResponseVO = new SSOResponseVO();
		ssoLoginResponseVO.setAccessToken("aaaa-aaaa-aaaa-aaaa");

		PessoaBccPJ pessoaBccPJ = new PessoaBccPJ();
		pessoaBccPJ.setPessoas(new ArrayList<PessoaBccPJ.Pessoa>());

		Mockito.doReturn(Mono.just(ssoLoginResponseVO)).when(this.bccService).realizarLoginBCC();
		Mockito.when(this.bccIntegration.consultaPessoaPJ(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Mono.error(new LoginBCCException(HttpStatus.BAD_REQUEST, "")));

		this.bccService.consultaPJBCC("61198164000160").onErrorResume(pessoaPJ -> {
			LoginBCCException erro = (LoginBCCException) pessoaPJ;
			assertEquals(HttpStatus.BAD_REQUEST, erro.getStatus());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(this.bccIntegration, times(1)).consultaPessoaPJ("61198164000160",
				ssoLoginResponseVO.getAccessToken());
	}
}
