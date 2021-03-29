package com.porto.portocom.portal.cliente.v1.controller.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoEnvioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoFluxoEnum;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.ContadorAcessoException;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.AplicacaoLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ICadastroService;
import com.porto.portocom.portal.cliente.v1.service.ICodigoAcessoService;
import com.porto.portocom.portal.cliente.v1.service.ICodigoAtivacaoService;
import com.porto.portocom.portal.cliente.v1.service.ICodigoRecuperacaoService;
import com.porto.portocom.portal.cliente.v1.service.IContadorAcessoService;
import com.porto.portocom.portal.cliente.v1.service.IProspectService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.vo.usuario.DadosAcessoVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.EnviaCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContador;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContadorConta;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContadorConta.InformacaoContadorContaBuilder;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificado;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificadoAtivacao;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("controller-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioAcessoControllerUnitTest {

	@LocalServerPort
	private int port;

	@MockBean
	private IUsuarioPortalService usuarioPortalService;

	@MockBean
	private IContadorAcessoService contadorAcessoService;

	@MockBean
	private ICodigoAtivacaoService codigoAtivacaoService;

	@MockBean
	private ICodigoRecuperacaoService codigoRecuperacaoService;

	@MockBean
	private ICodigoAcessoService codigoAcessoService;

	@MockBean
	private IProspectService prospectService;

	@MockBean
	private ICadastroService cadastroService;

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private AplicacaoLocalCacheService aplicacaoLocalCacheService;
	
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
	}

	private static final String VALIDA_CODIGO_RECUPERACAO_URL = "http://localhost:{port}/v1/usuario/{cpfCnpj}/valida-codigo-recuperacao/{pin}";
	private static final String VALIDACAO_CODIGO_ACESSO_URL = "http://localhost:{port}/v1/usuario/{cpfCnpj}/valida-codigo-acesso/{pin}";
	private static final String DADOS_ACESSO_URL = "http://localhost:{port}/v1/usuario/{cpfCnpj}/dados-acesso";
	private static final String DEFAULT_CPF = "22890390802";
	private static final String DEFAULT_PIN = "ABCXYZ";

	private static String validaRecuperacaoURL(Integer port, String cpf, String pin) {
		return VALIDA_CODIGO_RECUPERACAO_URL.replace("{port}", port.toString()).replace("{cpfCnpj}", cpf)
				.replace("{pin}", pin);
	}
	
	private static String validacaoCodigoAcessoURL(Integer port, String cpf, String pin) {
		return VALIDACAO_CODIGO_ACESSO_URL.replace("{port}", port.toString()).replace("{cpfCnpj}", cpf)
				.replace("{pin}", pin);
	}

	private static String dadosAcessoURL(Integer port, String cpf, String pin) {
		return DADOS_ACESSO_URL.replace("{port}", port.toString()).replace("{cpfCnpj}", cpf)
				.replace("{pin}", pin);
	}

	@Test
	public void testValidaCodigoAtivacaoSucesso() {

		InformacaoContadorContaBuilder informacaoContadorBuilder = InformacaoContadorConta.builder();

		InformacaoContadorConta infContador = informacaoContadorBuilder.qtdTentativa(5L).qtdTentativaLimite(7L)
				.sucesso(true).build();

		InformacaoCodigoSeguranca InformacaoCodigoAtivacaoRecuperacaoBuilder = new InformacaoCodigoSeguranca(
				LocalDateTime.now(), LocalDateTime.now(), infContador);

		when(codigoAtivacaoService.validaCodigoAtivacao("37488499824", "1111"))
				.thenReturn(Mono.just(InformacaoCodigoAtivacaoRecuperacaoBuilder));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/valida-codigo-ativacao/1111", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoAtivacaoSucesso", tentativaValida.getBody().getStatus(),
				HttpStatus.OK.value());
	}

	@Test
	public void testValidaCodigoAtivacaoCpfCnpjInvalidoException() {

		when(codigoAtivacaoService.validaCodigoAtivacao("37488499824", "1111"))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/valida-codigo-ativacao/1111", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoAtivacaoCpfCnpjInvalidoException", 400,
				tentativaValida.getBody().getStatus());
	}

	@Test
	public void testValidaCodigoAtivacaoCodigoSegurancaException() {

		when(codigoAtivacaoService.validaCodigoAtivacao("37488499824", "1111"))
				.thenReturn(Mono.error(new CodigoSegurancaException("Erro", HttpStatus.UNPROCESSABLE_ENTITY.value(), null)));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/valida-codigo-ativacao/1111", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoAtivacaoCodigoAtivacaoException", tentativaValida.getBody().getStatus(),
				HttpStatus.UNPROCESSABLE_ENTITY.value());
	}
	
	@Test
	public void testValidaCodigoAtivacaoEmailUsuarioPortalException() {

		when(codigoAtivacaoService.validaCodigoAtivacao("37488499824", "1111"))
		.thenReturn(Mono.error(new UsuarioPortalException("erro", HttpStatus.NOT_FOUND.value())));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/valida/codigo/ativacao/37488499824/1111", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoAtivacaoEmailUsuarioPortalException", tentativaValida.getBody().getStatus(),
				HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testValidaCodigoAtivacaoException() {

		when(codigoAtivacaoService.validaCodigoAtivacao("37488499824", "1111")).thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/valida-codigo-ativacao/1111", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoAtivacaoException", tentativaValida.getBody().getStatus(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	
	@Test
	public void testEnviaCodigoAtivacaoEmailNumeroTentativasExcedido() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.EMAIL, TipoFluxoEnum.SIMPLES))
		.thenReturn(Mono.error(new CodigoSegurancaException("", HttpStatus.UNPROCESSABLE_ENTITY.value(),null)));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoEmailNumeroTentativasExcedido", HttpStatus.UNPROCESSABLE_ENTITY.value(),
				tentativaValida.getBody().getStatus());
	}

	@Test
	public void testEnviaCodigoAtivacaoEmailSucesso() {
		
		EnviaCodigoSeguranca enviaCodigoAtivacao = new EnviaCodigoSeguranca(LocalDateTime.now(), LocalDateTime.now(),
				true);

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.EMAIL, TipoFluxoEnum.SIMPLES))
				.thenReturn(Mono.just(enviaCodigoAtivacao));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoEmailSucesso", tentativaValida.getBody().getStatus(),
				HttpStatus.OK.value());
	}

	@Test
	public void testEnviaCodigoAtivacaoEmailCpfCnpjInvalidoException() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.EMAIL,TipoFluxoEnum.SIMPLES))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoEmailCpfCnpjInvalidoException",
				tentativaValida.getBody().getStatus(), HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void testEnviaCodigoAtivacaoEmailUsuarioPortalException() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.EMAIL,TipoFluxoEnum.SIMPLES))
				.thenReturn(Mono.error(new UsuarioPortalException("erro", HttpStatus.NOT_FOUND.value())));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/envia/codigo/ativacao/email/37488499824", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoEmailUsuarioPortalException", tentativaValida.getBody().getStatus(),
				HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testEnviaCodigoAtivacaoEmailException() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.EMAIL, TipoFluxoEnum.SIMPLES))
				.thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoEmailSucesso", tentativaValida.getBody().getStatus(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testEnviaCodigoAtivacaoCelularSucesso() {

		EnviaCodigoSeguranca enviaCodigoAtivacao = new EnviaCodigoSeguranca(LocalDateTime.now(), LocalDateTime.now(),
				true);

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.CELULAR,TipoFluxoEnum.SIMPLES))
				.thenReturn(Mono.just(enviaCodigoAtivacao));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao/celular", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoCelularSucesso", tentativaValida.getBody().getStatus(),
				HttpStatus.OK.value());
	}
	
	@Test
	public void testEnviaCodigoAtivacaoSmsNumeroTentativasExcedido() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.CELULAR,TipoFluxoEnum.SIMPLES))
		.thenReturn(Mono.error(new CodigoSegurancaException("", HttpStatus.UNPROCESSABLE_ENTITY.value(),null)));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao/celular", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoSmsNumeroTentativasExcedido", HttpStatus.UNPROCESSABLE_ENTITY.value(),
				tentativaValida.getBody().getStatus());
	}

	@Test
	public void testEnviaCodigoAtivacaoCelularUsuarioPortalException() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.CELULAR,TipoFluxoEnum.SIMPLES))
				.thenReturn(Mono.error(new UsuarioPortalException("erro", HttpStatus.NOT_FOUND.value())));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/envia/codigo/ativacao/celular/37488499824", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoCelularUsuarioPortalException",
				tentativaValida.getBody().getStatus(), HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testEnviaCodigoAtivacaoCelularCpfCnpjInvalidoException() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.CELULAR,TipoFluxoEnum.SIMPLES))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao/celular", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoCelularCpfCnpjInvalidoException", 400,
				tentativaValida.getBody().getStatus());
	}

	@Test
	public void testEnviaCodigoAtivacaoCelularException() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.CELULAR,TipoFluxoEnum.SIMPLES))
				.thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao/celular", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoCelularSucesso", tentativaValida.getBody().getStatus(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testIncrementaContadorTentativaLoginSucesso() {

		InformacaoContadorContaBuilder informacaoContadorContaBuilder = InformacaoContadorConta.builder();

		InformacaoContadorConta infContador = informacaoContadorContaBuilder.qtdTentativa(5L).qtdTentativaLimite(7L)
				.sucesso(true).build();

		when(contadorAcessoService.adicionaTentativa("37488499824")).thenReturn(Mono.just(infContador));

		ResponseEntity<Response<InformacaoContadorConta>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/incrementa-tentativa-acesso", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoContadorConta>>() {
				});

		Assert.assertTrue("Tentativa de incremento.", tentativaValida.getBody().getData().isSucesso());
	}

	@Test
	public void testIncrementaContadorTentativaLoginCpfCnpjInvalidoException() {

		when(contadorAcessoService.adicionaTentativa("37488499824"))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<Boolean>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/incrementa-tentativa-acesso", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testIncrementaContadorTentativaLoginCpfCnpjInvalidoException", 400,
				tentativaValida.getBody().getStatus());
	}

	@Test
	public void testIncrementaContadorTentativaLoginContadorAcessoException() {

		when(contadorAcessoService.adicionaTentativa("37488499824"))
				.thenReturn(Mono.error(new ContadorAcessoException("error", HttpStatus.NOT_FOUND.value(), null)));

		ResponseEntity<Response<Boolean>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/incrementa/tentativa/acesso/37488499824", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testIncrementaContadorTentativaLoginContadorAcessoException", HttpStatus.NOT_FOUND.value(),
				tentativaValida.getBody().getStatus());
	}

	@Test
	public void testIncrementaContadorTentativaLoginException() {

		when(contadorAcessoService.adicionaTentativa("37488499824")).thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<Boolean>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/incrementa-tentativa-acesso", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testIncrementaContadorTentativaLoginException", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				tentativaValida.getBody().getStatus());
	}

	@Test
	public void testReiniciarTentativaAcessoSucesso() {

		when(contadorAcessoService.reinicia("37488499824")).thenReturn(Mono.just(true));

		ResponseEntity<Response<Boolean>> retorno = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/reinicia-tentativa-acesso", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		System.out.println("testReiniciarTentativaAcessoSucesso" + retorno.getBody().getData());

		Assert.assertTrue("testReiniciarTentativaAcessoSucesso", retorno.getBody().getData());
		Assert.assertEquals(retorno.getStatusCodeValue(), HttpStatus.OK.value());
	}

	@Test
	public void testReiniciarTentativaContadorAcessoException() {

		when(contadorAcessoService.reinicia("37488499a824"))
				.thenReturn(Mono.error(new ContadorAcessoException("Usuário não encontrado.", 404, null)));

		ResponseEntity<Response<Boolean>> retorno = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499a824/reinicia-tentativa-acesso", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		System.out.println("testReiniciarTentativaContadorAcessoException" + retorno.getBody().getData());

		Assert.assertFalse("testReiniciarTentativaContadorAcessoException", retorno.getBody().getData());
		Assert.assertEquals("", HttpStatus.OK.value(), retorno.getStatusCodeValue());
		Assert.assertEquals("", "Usuário não encontrado.", retorno.getBody().getErrors().get(0));
		Assert.assertEquals("", HttpStatus.NOT_FOUND.value(), retorno.getBody().getStatus());
		verify(contadorAcessoService, Mockito.times(1)).reinicia("37488499a824");
	}

	@Test
	public void testReiniciarTentativaCpfInvalidoException() {

		when(contadorAcessoService.reinicia("37488499a824"))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("CPF ou CNPJ inválido.")));

		ResponseEntity<Response<Boolean>> retorno = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499a824/reinicia-tentativa-acesso", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		System.out.println("testReiniciarTentativaCpfInvalidoException" + retorno.getBody().getData());

		Assert.assertFalse("testReiniciarTentativaCpfInvalidoException", retorno.getBody().getData());
		Assert.assertEquals("", HttpStatus.OK.value(), retorno.getStatusCodeValue());
		Assert.assertEquals("", "CPF ou CNPJ inválido.", retorno.getBody().getErrors().get(0));
		verify(contadorAcessoService, Mockito.times(1)).reinicia("37488499a824");
	}

	@Test
	public void testReiniciarTentativaExcecaoGenerica() {

		when(contadorAcessoService.reinicia("37488499a824")).thenReturn(Mono.error(new Exception("Erro")));

		ResponseEntity<Response<Boolean>> retorno = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499a824/reinicia-tentativa-acesso", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		System.out.println("testReiniciarTentativaExcecaoGenerica " + retorno.getBody().getData());

		Assert.assertFalse("testReiniciarTentativaExcecaoGenerica", retorno.getBody().getData());
		Assert.assertEquals("", HttpStatus.OK.value(), retorno.getStatusCodeValue());
		Assert.assertEquals("", "Erro", retorno.getBody().getErrors().get(0));
		verify(contadorAcessoService, Mockito.times(1)).reinicia("37488499a824");
	}

	@Test
	public void testConsultaContadorAcessoSucesso() {

		InformacaoContador informacaoContador = new InformacaoContador(3L, 7L, 3L, 7L, 4L, 5L, true);
		Mockito.when(contadorAcessoService.consultaContadoresTentativaAcesso("22890390802"))
				.thenReturn(Mono.just(informacaoContador));

		ResponseEntity<Response<InformacaoContador>> responseInformacaoContador = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/contadores", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<InformacaoContador>>() {
				});
		Assert.assertTrue("Consulta realizada com sucesso.",
				responseInformacaoContador.getBody().getData().isSucesso());
	}

	@Test
	public void testConsultaContadorAcessoUsuarioCpfCnpjInvalidoException() {

		Mockito.when(contadorAcessoService.consultaContadoresTentativaAcesso("29606830055"))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<InformacaoContador>> responseInformacaoContador = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/29606830055/contadores", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<InformacaoContador>>() {
				});
		Assert.assertEquals("testConsultaContadorAcessoUsuarioCpfCnpjInvalidoException", 400,
				responseInformacaoContador.getBody().getStatus());
	}

	@Test
	public void testConsultaContadorAcessoUsuarioContadorAcessoException() {

		Mockito.when(contadorAcessoService.consultaContadoresTentativaAcesso("29606830055"))
				.thenReturn(Mono.error(new ContadorAcessoException("Usuário não encontrado.", 404, null)));

		ResponseEntity<Response<InformacaoContador>> responseInformacaoContador = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/consulta/contadores/29606830055", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<InformacaoContador>>() {
				});
		Assert.assertEquals("testConsultaContadorAcessoUsuarioContadorAcessoException", 404,
				responseInformacaoContador.getBody().getStatus());
	}

	@Test
	public void testConsultaContadorAcessoUsuarioException() {

		Mockito.when(contadorAcessoService.consultaContadoresTentativaAcesso("29606830055"))
				.thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<InformacaoContador>> responseInformacaoContador = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/29606830055/contadores", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<InformacaoContador>>() {
				});
		Assert.assertEquals("testConsultaContadorAcessoUsuarioException", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				responseInformacaoContador.getBody().getStatus());
	}

	@Test
	public void testConsultaUsuarioSimplificadoSucesso() {

		UsuarioSimplificadoAtivacao usrSimp = new UsuarioSimplificadoAtivacao();
		List<String> emails = new ArrayList<String>();
		List<String> celulares = new ArrayList<String>();
		
		emails.add("adriano.santos@portoseguro.com.br");
		celulares.add("999999999");
		
		usrSimp.setNome("Adriano Santos");
		usrSimp.setCelulares(celulares);
		usrSimp.setEmails(emails);

		List<UsuarioSimplificadoAtivacao> listUsrSimpl = new ArrayList<>();
		listUsrSimpl.add(usrSimp);

		Mockito.when(usuarioPortalService.consultaUsuarioSimplificado("22890390802", null))
				.thenReturn(Mono.just(listUsrSimpl));

		ResponseEntity<Response<List<UsuarioSimplificadoAtivacao>>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/ativacao", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<UsuarioSimplificadoAtivacao>>>() {
				});

		Assert.assertEquals("testConsultaUsuarioSimplificadoSucesso", "Adriano Santos",
				usuario.getBody().getData().get(0).getNome());
	}

	@Test
	public void testConsultaUsuarioSimplificadoException() {

		Mockito.when(usuarioPortalService.consultaUsuarioSimplificado("22890390802", null))
				.thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<List<UsuarioSimplificado>>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/ativacao", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<UsuarioSimplificado>>>() {
				});

		Assert.assertEquals("testConsultaUsuarioSimplificadoException", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testConsultaUsuarioSimplificadoCpfInvalidoException() {

		Mockito.when(usuarioPortalService.consultaUsuarioSimplificado("22890390802", null))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("cpf inválido")));

		ResponseEntity<Response<List<UsuarioSimplificado>>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/ativacao", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<UsuarioSimplificado>>>() {
				});

		Assert.assertEquals("testConsultaUsuarioSimplificadoCpfInvalidoException", HttpStatus.BAD_REQUEST.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testConsultaUsuarioSimplificadoCpfNaoEncontradoException() {

		Mockito.when(usuarioPortalService.consultaUsuarioSimplificado("22890390802", null))
				.thenReturn(Mono.error(new UsuarioPortalException("cpf inválido", 404)));

		ResponseEntity<Response<List<UsuarioSimplificado>>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/simplificado/ativacao/22890390802", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<UsuarioSimplificado>>>() {
				});

		Assert.assertEquals("testConsultaUsuarioSimplificadoCpfNaoEncontradoException", HttpStatus.NOT_FOUND.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testConsultaSimplificadaRecuperacaoSuccess() {

		
		UsuarioSimplificado usrSimp = new UsuarioSimplificado();
		
		List<String> emails = new ArrayList<String>();
		List<String> celulares = new ArrayList<String>();
		
		emails.add("adriano.santos@portoseguro.com.br");
		celulares.add("999999999");
		
		usrSimp.setNome("Adriano Santos");
		usrSimp.setCelulares(celulares);
		usrSimp.setEmails(emails);

		List<UsuarioSimplificado> listUsrSimpl = new ArrayList<>();
		listUsrSimpl.add(usrSimp);

		Mockito.when(usuarioPortalService.consultaUsuarioSimplificadoRecuperacao("22890390802"))
				.thenReturn(Mono.just(listUsrSimpl));

		ResponseEntity<Response<List<UsuarioSimplificado>>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/recuperacao", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<UsuarioSimplificado>>>() {
				});

		Assert.assertEquals("testConsultaSimplificadaRecuperacaoSuccess", HttpStatus.OK.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testConsultaSimplificadaRecuperacaoNotFoundException() {

		Mockito.when(usuarioPortalService.consultaUsuarioSimplificadoRecuperacao("22890390802"))
				.thenReturn(Mono.error(new UsuarioPortalException("cpf nao encontrado", 404)));

		ResponseEntity<Response<List<UsuarioSimplificado>>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/simplificado/recuperacao/22890390802", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<UsuarioSimplificado>>>() {
				});

		Assert.assertEquals("testConsultaSimplificadaRecuperacaoException", HttpStatus.NOT_FOUND.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testConsultaSimplificadaRecuperacaoBadRequestException() {

		Mockito.when(usuarioPortalService.consultaUsuarioSimplificadoRecuperacao("22890390802"))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<List<UsuarioSimplificado>>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/recuperacao", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<UsuarioSimplificado>>>() {
				});

		Assert.assertEquals("testConsultaSimplificadaRecuperacaoBadRequestException", HttpStatus.BAD_REQUEST.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testConsultaSimplificadaRecuperacaoException() {

		Mockito.when(usuarioPortalService.consultaUsuarioSimplificadoRecuperacao("22890390802"))
				.thenReturn(Mono.error(new Exception("")));

		ResponseEntity<Response<List<UsuarioSimplificado>>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/recuperacao", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<UsuarioSimplificado>>>() {
				});

		Assert.assertEquals("testConsultaSimplificadaRecuperacaoBadRequestException",
				HttpStatus.INTERNAL_SERVER_ERROR.value(), usuario.getBody().getStatus());
	}

	@Test
	public void testConsultaSimplificadaRecuperacaoEmpty() {

		Mockito.when(usuarioPortalService.consultaUsuarioSimplificadoRecuperacao("22890390802"))
				.thenReturn(Mono.just(Collections.emptyList()));

		ResponseEntity<Response<List<UsuarioSimplificado>>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/recuperacao", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<UsuarioSimplificado>>>() {
				});

		Assert.assertEquals("testConsultaSimplificadaRecuperacaoEmpty", HttpStatus.OK.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testEnviaCodigoRecuperacaoCelularSucesso() {
		
		EnviaCodigoSeguranca enviaCodigoAtivacaoERecuperacao = new EnviaCodigoSeguranca(LocalDateTime.now(),
				LocalDateTime.now(), false);
		
		when(this.codigoRecuperacaoService.enviaCodigo("37488499824", TipoEnvioEnum.CELULAR))
				.thenReturn(Mono.just(enviaCodigoAtivacaoERecuperacao));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-recuperacao/celular", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoRecuperacaoCelularSucesso", tentativaValida.getBody().getStatus(),
				HttpStatus.OK.value());
	}
	
	
	@Test
	public void testEnviaCodigoRecuperacaoEmailNumeroTentativasExcedido() {

		when(codigoRecuperacaoService.enviaCodigo("37488499824", TipoEnvioEnum.EMAIL))
		.thenReturn(Mono.error(new CodigoSegurancaException("", HttpStatus.UNPROCESSABLE_ENTITY.value(),null)));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-recuperacao/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoRecuperacaoEmailNumeroTentativasExcedido", HttpStatus.UNPROCESSABLE_ENTITY.value(),
				tentativaValida.getBody().getStatus());
	}

	@Test
	public void testEnviaCodigoRecuperacaoCelularCpfInvalidoException() {

		when(this.codigoRecuperacaoService.enviaCodigo("37488499824", TipoEnvioEnum.CELULAR))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("erro")));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-recuperacao/celular", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoRecuperacaoCelularCpfInvalidoException",
				tentativaValida.getBody().getStatus(), HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void testEnviaCodigoRecuperacaoCelularUsuarioPortalException() {

		when(this.codigoRecuperacaoService.enviaCodigo("37488499824", TipoEnvioEnum.CELULAR))
				.thenReturn(Mono.error(new UsuarioPortalException("erro", 404)));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/envia/codigo/recuperacao/celular/37488499824", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoRecuperacaoCelularUsuarioPortalException",
				tentativaValida.getBody().getStatus(), HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testEnviaCodigoRecuperacaoCelularGenericException() {

		when(this.codigoRecuperacaoService.enviaCodigo("37488499824", TipoEnvioEnum.CELULAR))
				.thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-recuperacao/celular/", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoRecuperacaoCelularGenericException",
				tentativaValida.getBody().getStatus(), HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testEnviaCodigoAtivacaoCelularCodigoRecuperacaoException() {

		when(this.codigoRecuperacaoService.enviaCodigo("37488499824", TipoEnvioEnum.CELULAR))
				.thenReturn(Mono.error(new CodigoSegurancaException("", HttpStatus.NOT_FOUND.value(), null)));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/envia/codigo/recuperacao/celular/37488499824", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoCelularCodigoRecuperacaoException",
				tentativaValida.getBody().getStatus(), HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testEnviaCodigoRecuperacaoEmailSucesso() {
		
		EnviaCodigoSeguranca enviaCodigoAtivacaoERecuperacao = new EnviaCodigoSeguranca(LocalDateTime.now(),
				LocalDateTime.now(), false);
		
		when(this.codigoRecuperacaoService.enviaCodigo("37488499824", TipoEnvioEnum.EMAIL))
				.thenReturn(Mono.just(enviaCodigoAtivacaoERecuperacao));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-recuperacao/email", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoRecuperacaoEmailSucesso", tentativaValida.getBody().getStatus(),
				HttpStatus.OK.value());
	}

	@Test
	public void testEnviaCodigoRecuperacaoEmailCpfInvalidoException() {

		when(this.codigoRecuperacaoService.enviaCodigo("37488499824", TipoEnvioEnum.EMAIL))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("erro")));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-recuperacao/email", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoRecuperacaoEmailCpfInvalidoException",
				tentativaValida.getBody().getStatus(), HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void testEnviaCodigoRecuperacaoEmailUsuarioPortalException() {

		when(this.codigoRecuperacaoService.enviaCodigo("37488499824", TipoEnvioEnum.EMAIL))
				.thenReturn(Mono.error(new UsuarioPortalException("erro", 404)));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/envia/codigo/recuperacao/email/37488499824", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoRecuperacaoEmailUsuarioPortalException",
				tentativaValida.getBody().getStatus(), HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testEnviaCodigoRecuperacaoEmailGenericException() {

		when(this.codigoRecuperacaoService.enviaCodigo("37488499824", TipoEnvioEnum.EMAIL))
				.thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-recuperacao/email", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoRecuperacaoEmailGenericException",
				tentativaValida.getBody().getStatus(), HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testValidaCodigoRecuperacaoCPFInvalido() {

		when(this.codigoRecuperacaoService.validaCodigo(DEFAULT_CPF, DEFAULT_PIN))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> usuario = restTemplate.exchange(
				validaRecuperacaoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoRecuperacaoCPFInvalido", HttpStatus.BAD_REQUEST.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testValidaCodigoRecuperacaoUsuarioNaoAtivoNemPrimeiroLogin() {

		when(this.codigoRecuperacaoService.validaCodigo(DEFAULT_CPF, DEFAULT_PIN)).thenReturn(Mono
				.error(new CodigoSegurancaException(MensagemUsuarioEnum.USUARIO_NAO_PERMITIDO_REATIVAR_CONTA.getValor(),
						HttpStatus.BAD_REQUEST.value(), null)));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> usuario = restTemplate.exchange(
				validaRecuperacaoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoRecuperacaoUsuarioNaoAtivoNemPrimeiroLogin",
				HttpStatus.BAD_REQUEST.value(), usuario.getBody().getStatus());
	}

	@Test
	public void testValidaCodigoRecuperacaoMaximoTentativasExcedido() {

		when(this.codigoRecuperacaoService.validaCodigo(DEFAULT_CPF, DEFAULT_PIN))
				.thenReturn(Mono.error(new CodigoSegurancaException("", HttpStatus.BAD_REQUEST.value(), null)));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> usuario = restTemplate.exchange(
				validaRecuperacaoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoRecuperacaoMaximoTentativasExcedido", HttpStatus.BAD_REQUEST.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testValidaCodigoRecuperacaoSucesso() {

		InformacaoCodigoSeguranca informacaoCodAtivacao = new InformacaoCodigoSeguranca(LocalDateTime.now(),
				LocalDateTime.now(), new InformacaoContadorConta(5L, 7L, true));

		when(this.codigoRecuperacaoService.validaCodigo(DEFAULT_CPF, DEFAULT_PIN))
				.thenReturn(Mono.just(informacaoCodAtivacao));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> usuario = restTemplate.exchange(
				validaRecuperacaoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodiguRecuperacaoSucesso", HttpStatus.OK.value(), usuario.getBody().getStatus());
	}

	@Test
	public void testValidaCodigoRecuperacaoUsuarioNaoEncontrado() {

		when(this.codigoRecuperacaoService.validaCodigo(DEFAULT_CPF, DEFAULT_PIN))
				.thenReturn(Mono.error(new UsuarioPortalException("", HttpStatus.NOT_FOUND.value())));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> usuario = restTemplate.exchange(
				validaRecuperacaoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoRecuperacaoCPFInvalido", HttpStatus.NOT_FOUND.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testValidaCodigoRecuperacaoUsuarioErroGenerico() {

		when(this.codigoRecuperacaoService.validaCodigo(DEFAULT_CPF, DEFAULT_PIN))
				.thenReturn(Mono.error(new RuntimeException("")));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> usuario = restTemplate.exchange(
				validaRecuperacaoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoRecuperacaoCPFInvalido", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testPermiteAcessoSucesso() {

		when(this.contadorAcessoService.permiteAcesso(670658L)).thenReturn(Mono.just(Boolean.TRUE));

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/670658/acesso", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testPermiteAcessoSucesso", HttpStatus.OK.value(), usuario.getBody().getStatus());
	}
	
	@Test
	public void acessoLoginSucessoSucesso() {
		
		when(this.contadorAcessoService.registrarAcessoSucesso("37488499824"))
		.thenReturn(Mono.just(Boolean.TRUE));
		
		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				 "http://localhost:"+port+"/v1/usuario/37488499824/acesso-sucesso", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});
		
		Assert.assertEquals("acessoLoginSucessoSucesso", HttpStatus.OK.value(), usuario.getBody().getStatus());
		Assert.assertEquals("acessoLoginSucessoSucesso", HttpStatus.OK, usuario.getStatusCode());
		Assert.assertEquals("acessoLoginSucessoSucesso", Boolean.TRUE, usuario.getBody().getData());
		Mockito.verify(this.contadorAcessoService).registrarAcessoSucesso("37488499824");
	}
	
	@Test
	public void acessoLoginSucessoGenericException() {
		
		when(this.contadorAcessoService.registrarAcessoSucesso("37488499824"))
		.thenReturn(Mono.error(new SQLException("Exception no banco de dados")));
		
		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				 "http://localhost:"+port+"/v1/usuario/37488499824/acesso-sucesso", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});
		
		Assert.assertEquals("acessoLoginSucessoGenericException", HttpStatus.INTERNAL_SERVER_ERROR.value(), usuario.getBody().getStatus());
		Assert.assertEquals("acessoLoginSucessoGenericException", HttpStatus.INTERNAL_SERVER_ERROR, usuario.getStatusCode());
		Mockito.verify(this.contadorAcessoService).registrarAcessoSucesso("37488499824");
	}
	
	@Test
	public void acessoLoginSucessoContadorAcessoException() {
		
		InformacaoContadorConta infContador = null;
		
		when(this.contadorAcessoService.registrarAcessoSucesso("37488499824"))
		.thenReturn(Mono.error(new ContadorAcessoException("Contador Acesso Exception", HttpStatus.NOT_FOUND.value(),infContador)));
		
		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				 "http://localhost:"+port+"/v1/usuario/37488499824/acesso-sucesso", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});
		
		Assert.assertEquals("acessoLoginSucessoContadorAcessoException", HttpStatus.OK, usuario.getStatusCode());
		Assert.assertEquals("acessoLoginSucessoContadorAcessoException", "Contador Acesso Exception", usuario.getBody().getErrors().get(0));
		Assert.assertEquals("acessoLoginSucessoContadorAcessoException", HttpStatus.NOT_FOUND.value(), usuario.getBody().getStatus());
				
	}
	
	@Test
	public void acessoLoginSucessoResponseStatusException() {
		
		when(this.contadorAcessoService.registrarAcessoSucesso("37488499824"))
		.thenReturn(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST)));
		
		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				 "http://localhost:"+port+"/v1/usuario/37488499824/acesso-sucesso", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});
		
		Mockito.verify(this.contadorAcessoService).registrarAcessoSucesso("37488499824");
		Assert.assertEquals("testPermiteAcessoSucesso", HttpStatus.OK, usuario.getStatusCode());
		Assert.assertEquals("testPermiteAcessoSucesso", HttpStatus.BAD_REQUEST.value(), usuario.getBody().getStatus());
				
	}
	
	  @Test 
	  public void testAdicionaTentativaSucesso() { 
		  
		  InformacaoContadorConta informacaoContadorConta = new InformacaoContadorConta(0L, 0L, true);

		  Mockito.when(this.contadorAcessoService.registrarAcessoFalha("22890390802")).thenReturn(
				  Mono.just(informacaoContadorConta));

		  ResponseEntity<Response<InformacaoContadorConta>> usuario = restTemplate.exchange(
				  "http://localhost:"+port+"/v1/usuario/22890390802/acesso-falha", HttpMethod.POST,
				  null, new ParameterizedTypeReference<Response<InformacaoContadorConta>>() { });	  
	  
		  assertEquals(usuario.getBody().getData().getQtdTentativa(), new Long(0L) );
		  assertEquals(usuario.getBody().getData().getQtdTentativaLimite(), new Long(0L) );
		  assertEquals(usuario.getBody().getData().isSucesso(), Boolean.TRUE);	  
	  }
	  	 

	@Test
	public void testAdicionaTentativa404() {

		InformacaoContadorConta informacaoContadorConta = new InformacaoContadorConta(0L, 0L, true);

		Mockito.when(this.contadorAcessoService.registrarAcessoFalha("22890390802")).thenReturn(
				Mono.error(new ContadorAcessoException("erro", HttpStatus.NOT_FOUND.value(), informacaoContadorConta)));

		ResponseEntity<Response<InformacaoContadorConta>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/acesso/falha", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoContadorConta>>() {
				});

		assertEquals(HttpStatus.NOT_FOUND.value(), usuario.getBody().getStatus());
	}
	
	@Test
	public void testAdicionaTentativaGenericException() {

		Mockito.when(this.contadorAcessoService.registrarAcessoFalha("22890390802")).thenReturn(
				Mono.error(new SQLException()));

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/22890390802/acesso-falha", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), usuario.getBody().getStatus());
	}
	
	@Test
	void testEnviaCodigoAcessoEmailSucesso() {

		EnviaCodigoSeguranca enviaCodigoAtivacao = new EnviaCodigoSeguranca(LocalDateTime.now(), LocalDateTime.now(),
				false);

		when(codigoAcessoService.enviaCodigoAcesso("37488499824", TipoEnvioEnum.EMAIL))
				.thenReturn(Mono.just(enviaCodigoAtivacao));

		ResponseEntity<Response<EnviaCodigoSeguranca>> envioCodigoEmail = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-acesso/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAcessoEmailSucesso", envioCodigoEmail.getBody().getStatus(),
				HttpStatus.OK.value());
	}

	@Test
	void testEnviaCodigoAcessoEmailCpfCnpjInvalidoException() {

		when(codigoAcessoService.enviaCodigoAcesso("37488499824", TipoEnvioEnum.EMAIL))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<EnviaCodigoSeguranca>> envioCodigoEmail = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-acesso/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAcessoEmailCpfCnpjInvalidoException", envioCodigoEmail.getBody().getStatus(),
				HttpStatus.BAD_REQUEST.value());
	}

	@Test
	void testEnviaCodigoAcessoEmailCodigoSegurancaExceptio() {

		when(codigoAcessoService.enviaCodigoAcesso("37488499824", TipoEnvioEnum.EMAIL))
				.thenReturn(Mono.error(new CodigoSegurancaException("", HttpStatus.NOT_FOUND.value(), null)));

		ResponseEntity<Response<EnviaCodigoSeguranca>> envioCodigoEmail = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia/codigo/acesso/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAcessoCodigoSegurancaExceptionException", HttpStatus.NOT_FOUND.value(),
				envioCodigoEmail.getBody().getStatus());
	}

	@Test
	void testEnviaCodigoAcessoEmailUsuarioPortalException() {

		when(codigoAcessoService.enviaCodigoAcesso("37488499824", TipoEnvioEnum.EMAIL))
				.thenReturn(Mono.error(new UsuarioPortalException("erro", HttpStatus.NOT_FOUND.value())));

		ResponseEntity<Response<EnviaCodigoSeguranca>> envioCodigoEmail = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia/codigo/acesso/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAcessoEmailUsuarioPortalException", envioCodigoEmail.getBody().getStatus(),
				HttpStatus.NOT_FOUND.value());
	}

	@Test
	void testEnviaCodigoAcessoEmailException() {

		when(codigoAcessoService.enviaCodigoAcesso("37488499824", TipoEnvioEnum.EMAIL))
				.thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<EnviaCodigoSeguranca>> envioCodigoEmail = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-acesso/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAcessoEmailException", envioCodigoEmail.getBody().getStatus(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	@Test
	void testEnviaCodigoAcessoCelularSucesso() {

		EnviaCodigoSeguranca enviaCodigoAtivacao = new EnviaCodigoSeguranca(LocalDateTime.now(), LocalDateTime.now(),
				false);

		when(codigoAcessoService.enviaCodigoAcesso("37488499824", TipoEnvioEnum.CELULAR))
				.thenReturn(Mono.just(enviaCodigoAtivacao));

		ResponseEntity<Response<EnviaCodigoSeguranca>> envioCodigoCelular = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-acesso/celular", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAcessoEmailSucesso", envioCodigoCelular.getBody().getStatus(),
				HttpStatus.OK.value());
	}
	
	@Test
	void testEnviaCodigoAcessoCelularCpfCnpjInvalidoException() {

		when(codigoAcessoService.enviaCodigoAcesso("37488499824", TipoEnvioEnum.CELULAR))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<EnviaCodigoSeguranca>> envioCodigoCelular = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-acesso/celular", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAcessoEmailCpfCnpjInvalidoException", envioCodigoCelular.getBody().getStatus(),
				HttpStatus.BAD_REQUEST.value());
	}

	@Test
	void testEnviaCodigoAcessoCelularCodigoSegurancaExceptionException() {

		when(codigoAcessoService.enviaCodigoAcesso("37488499824", TipoEnvioEnum.CELULAR))
				.thenReturn(Mono.error(new CodigoSegurancaException("", HttpStatus.NOT_FOUND.value(), null)));

		ResponseEntity<Response<EnviaCodigoSeguranca>> envioCodigoCelular = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia/codigo/acesso/celular", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAcessoCodigoSegurancaExceptionException", HttpStatus.NOT_FOUND.value(),
				envioCodigoCelular.getBody().getStatus());
	}

	@Test
	void testEnviaCodigoAcessoCelularUsuarioPortalException() {

		when(codigoAcessoService.enviaCodigoAcesso("37488499824", TipoEnvioEnum.CELULAR))
				.thenReturn(Mono.error(new UsuarioPortalException("erro", HttpStatus.NOT_FOUND.value())));

		ResponseEntity<Response<EnviaCodigoSeguranca>> envioCodigoCelular = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-acesso/celular", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAcessoEmailUsuarioPortalException", envioCodigoCelular.getBody().getStatus(),
				HttpStatus.NOT_FOUND.value());
	}

	@Test
	void testEnviaCodigoAcessoCelularException() {

		when(codigoAcessoService.enviaCodigoAcesso("37488499824", TipoEnvioEnum.CELULAR))
				.thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<EnviaCodigoSeguranca>> envioCodigoCelular = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-acesso/celular", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAcessoEmailException", envioCodigoCelular.getBody().getStatus(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	@Test
	public void testValidaCodigoAcessoErroGenerico() {

		when(this.codigoAcessoService.validaCodigoAcesso(DEFAULT_CPF, DEFAULT_PIN))
				.thenReturn(Mono.error(new RuntimeException("")));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> usuario = restTemplate.exchange(
				validacaoCodigoAcessoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoAcessoErroGenerico", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				usuario.getBody().getStatus());
	}
	
	@Test
	public void testValidaCodigoAcessoSucesso() {

		InformacaoCodigoSeguranca informacaoCodAtivacao = new InformacaoCodigoSeguranca(LocalDateTime.now(),
				LocalDateTime.now(), new InformacaoContadorConta(5L, 7L, true));

		when(this.codigoAcessoService.validaCodigoAcesso(DEFAULT_CPF, DEFAULT_PIN))
				.thenReturn(Mono.just(informacaoCodAtivacao));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> usuario = restTemplate.exchange(
				validacaoCodigoAcessoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoAcessoSucesso", HttpStatus.OK.value(), usuario.getBody().getStatus());
	}

	@Test
	public void testValidaCodigoAcessoUsuarioNaoEncontrado() {

		when(this.codigoAcessoService.validaCodigoAcesso(DEFAULT_CPF, DEFAULT_PIN))
				.thenReturn(Mono.error(new UsuarioPortalException("", HttpStatus.NOT_FOUND.value())));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> usuario = restTemplate.exchange(
				validacaoCodigoAcessoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoAcessoUsuarioNaoEncontrado", HttpStatus.NOT_FOUND.value(),
				usuario.getBody().getStatus());
	}

	
	@Test
	public void testValidaCodigoAcessoUsuarioNumeroTentativasExcedido() {

		when(this.codigoAcessoService.validaCodigoAcesso(DEFAULT_CPF, DEFAULT_PIN))
				.thenReturn(Mono.error(new CodigoSegurancaException("", HttpStatus.UNPROCESSABLE_ENTITY.value(),null)));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> usuario = restTemplate.exchange(
				validacaoCodigoAcessoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoAcessoUsuarioNumeroTentativasExcedido", HttpStatus.UNPROCESSABLE_ENTITY.value(),
				usuario.getBody().getStatus());
	}
	
	@Test
	public void testValidaCodigoAcessoUsuarioCpfInvalido() {

		when(this.codigoAcessoService.validaCodigoAcesso("1234", DEFAULT_PIN))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("CpfInvalido")));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> usuario = restTemplate.exchange(
				validacaoCodigoAcessoURL(port, "1234", DEFAULT_PIN), HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testValidaCodigoAcessoUsuarioCpfInvalido", HttpStatus.BAD_REQUEST.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testDadosAcessoSucesso() {

		DadosAcessoVO dadosAcessoVO = new DadosAcessoVO();

		when(this.usuarioPortalService.consultarDadosAcesso(DEFAULT_CPF))
				.thenReturn(Mono.just(dadosAcessoVO));

		ResponseEntity<Response<DadosAcessoVO>> usuario = restTemplate.exchange(
				dadosAcessoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<DadosAcessoVO>>() {
				});

		Assert.assertEquals("testDadosAcessoSucesso", HttpStatus.OK.value(), usuario.getBody().getStatus());
	}

	@Test
	public void testDadosAcessoUsuarioNaoEncontrado() {

		when(this.usuarioPortalService.consultarDadosAcesso(DEFAULT_CPF))
				.thenReturn(Mono.error(new UsuarioPortalException("", HttpStatus.NOT_FOUND.value())));

		ResponseEntity<Response<DadosAcessoVO>> usuario = restTemplate.exchange(
				dadosAcessoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<DadosAcessoVO>>() {
				});

		Assert.assertEquals("testDadosAcessoUsuarioNaoEncontrado", HttpStatus.NOT_FOUND.value(),
				usuario.getBody().getStatus());
	}


	@Test
	public void testDadosAcessoUsuarioNumeroTentativasExcedido() {

		when(this.usuarioPortalService.consultarDadosAcesso(DEFAULT_CPF))
				.thenReturn(Mono.error(new CodigoSegurancaException("", HttpStatus.UNPROCESSABLE_ENTITY.value(),null)));

		ResponseEntity<Response<DadosAcessoVO>> usuario = restTemplate.exchange(
				dadosAcessoURL(port, DEFAULT_CPF, DEFAULT_PIN), HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<DadosAcessoVO>>() {
				});

		Assert.assertEquals("testDadosAcessoUsuarioNumeroTentativasExcedido", HttpStatus.UNPROCESSABLE_ENTITY.value(),
				usuario.getBody().getStatus());
	}

	@Test
	public void testDadosAcessoUsuarioCpfInvalido() {

		when(this.usuarioPortalService.consultarDadosAcesso(DEFAULT_CPF))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("CpfInvalido")));

		ResponseEntity<Response<DadosAcessoVO>> usuario = restTemplate.exchange(
				dadosAcessoURL(port, "1234", DEFAULT_PIN), HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<DadosAcessoVO>>() {
				});

		Assert.assertEquals("testDadosAcessoUsuarioCpfInvalido", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				usuario.getBody().getStatus());
	}

	
	@Test
	public void testEnviaCodigoAtivacaoEmailHardNumeroTentativasExcedido() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.EMAIL, TipoFluxoEnum.HARD))
		.thenReturn(Mono.error(new CodigoSegurancaException("", HttpStatus.UNPROCESSABLE_ENTITY.value(),null)));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao-hard/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoEmailHardNumeroTentativasExcedido", HttpStatus.UNPROCESSABLE_ENTITY.value(),
				tentativaValida.getBody().getStatus());
	}

	@Test
	public void testEnviaCodigoAtivacaoEmailHardSucesso() {
		
		EnviaCodigoSeguranca enviaCodigoAtivacao = new EnviaCodigoSeguranca(LocalDateTime.now(), LocalDateTime.now(),
				true);

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.EMAIL,TipoFluxoEnum.HARD))
				.thenReturn(Mono.just(enviaCodigoAtivacao));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao-hard/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoEmailHardSucesso", tentativaValida.getBody().getStatus(),
				HttpStatus.OK.value());
	}

	@Test
	public void testEnviaCodigoAtivacaoEmailHardCpfCnpjInvalidoException() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.EMAIL,TipoFluxoEnum.HARD))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao-hard/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoEmailHardCpfCnpjInvalidoException",
				tentativaValida.getBody().getStatus(), HttpStatus.BAD_REQUEST.value());
	}


	@Test
	public void testEnviaCodigoAtivacaoEmailHardException() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.EMAIL, TipoFluxoEnum.HARD))
				.thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao-hard/email", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoEmailHardException", tentativaValida.getBody().getStatus(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	@Test
	public void testEnviaCodigoAtivacaoCelularHardSucesso() {

		EnviaCodigoSeguranca enviaCodigoAtivacao = new EnviaCodigoSeguranca(LocalDateTime.now(), LocalDateTime.now(),
				true);
		
		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.CELULAR,TipoFluxoEnum.HARD))
				.thenReturn(Mono.just(enviaCodigoAtivacao));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao-hard/celular", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoCelularHardSucesso", tentativaValida.getBody().getStatus(),
				HttpStatus.OK.value());
	}
	
	@Test
	public void testEnviaCodigoAtivacaoSmsHardNumeroTentativasExcedido() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.CELULAR,TipoFluxoEnum.HARD))
		.thenReturn(Mono.error(new CodigoSegurancaException("", HttpStatus.UNPROCESSABLE_ENTITY.value(),null)));

		ResponseEntity<Response<InformacaoCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao-hard/celular", HttpMethod.POST, null,
				new ParameterizedTypeReference<Response<InformacaoCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoSmsHardNumeroTentativasExcedido", HttpStatus.UNPROCESSABLE_ENTITY.value(),
				tentativaValida.getBody().getStatus());
	}


	@Test
	public void testEnviaCodigoAtivacaoCelularHardCpfCnpjInvalidoException() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.CELULAR,TipoFluxoEnum.HARD))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao-hard/celular", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoCelularHardCpfCnpjInvalidoException", 400,
				tentativaValida.getBody().getStatus());
	}

	@Test
	public void testEnviaCodigoAtivacaoCelularHardException() {

		when(codigoAtivacaoService.enviaCodigoAtivacao("37488499824", TipoEnvioEnum.CELULAR,TipoFluxoEnum.HARD))
				.thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<EnviaCodigoSeguranca>> tentativaValida = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/37488499824/envia-codigo-ativacao-hard/celular", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<EnviaCodigoSeguranca>>() {
				});

		Assert.assertEquals("testEnviaCodigoAtivacaoCelularHardException", tentativaValida.getBody().getStatus(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	
}
