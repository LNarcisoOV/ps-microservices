package com.porto.portocom.portal.cliente.controller.test;

import static org.mockito.Mockito.when;

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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.porto.portocom.portal.cliente.entity.UsuarioRedeSocial;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.RedeSocialException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.AplicacaoLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.IRedeSocialService;
import com.porto.portocom.portal.cliente.v1.vo.RedeSocial;
import com.porto.portocom.portal.cliente.v1.vo.SocialCliente;
import com.porto.portocom.portal.cliente.v1.vo.SocialClienteConsulta;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("controller-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RedeSocialControllerUnitTest {

	@LocalServerPort
	private int port;

	@MockBean
	private IRedeSocialService redeSocialService;
	
	@MockBean
	private AplicacaoLocalCacheService aplicacaoLocalCacheService;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		when(aplicacaoLocalCacheService.recuperaNomeAplicacao("appTeste")).thenReturn("appTeste");
		restTemplate.getRestTemplate().setInterceptors(Collections.singletonList((request, body, execution) -> {
			request.getHeaders().set("codigoAutorizacao", "appTeste");
			return execution.execute(request, body);
		}));
	}

	@Test
	public void testDesvinculaUsuarioSucesso() {

		SocialCliente socialCliente = new SocialCliente();
		socialCliente.setIdSocialCliente("1234");

		when(redeSocialService.desvinculaRedeSocial("85378473217", "1234")).thenReturn(Mono.just(true));

		HttpEntity<SocialCliente> requestEntity = new HttpEntity<>(socialCliente);

		ResponseEntity<Response<Boolean>> desvincularConta = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/85378473217/desvincula/", HttpMethod.POST,
				requestEntity, new ParameterizedTypeReference<Response<Boolean>>() {
				});

		System.out.println("Retorno " + desvincularConta);

		Assert.assertTrue("DesvinculaUsuario.", desvincularConta.getBody().getData());
	}

	@Test
	public void testDesvinculaUsuarioCpfCnpjInvalidoException() {

		SocialCliente socialCliente = new SocialCliente();
		socialCliente.setIdSocialCliente("1234");

		String textoMensagem = "CPF ou CNPJ inválido.";
		when(redeSocialService.desvinculaRedeSocial("66899900047", "1234"))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("CPF ou CNPJ inválido.")));

		HttpEntity<SocialCliente> requestEntity = new HttpEntity<>(socialCliente);

		ResponseEntity<Response<Boolean>> redeSocialReturns = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/66899900047/desvincula/", HttpMethod.POST,
				requestEntity, new ParameterizedTypeReference<Response<Boolean>>() {
				});

		System.out.println("Retorno " + redeSocialReturns);

		Assert.assertEquals("testDesvinculaUsuarioCpfCnpjInvalidoException", HttpStatus.OK,
				redeSocialReturns.getStatusCode());
		Assert.assertEquals("testDesvinculaUsuarioCpfCnpjInvalidoException", HttpStatus.BAD_REQUEST.value(),
				redeSocialReturns.getBody().getStatus());
		Assert.assertEquals("testDesvinculaUsuarioCpfCnpjInvalidoException", textoMensagem,
				redeSocialReturns.getBody().getErrors().get(0));
	}

	@Test
	public void testDesvinculaUsuarioPortalException() {

		SocialCliente socialCliente = new SocialCliente();
		socialCliente.setIdSocialCliente("1234");

		String textoMensagem = "Usuario não possui rede social";

		when(redeSocialService.desvinculaRedeSocial("66899900047", "1234"))
				.thenReturn(Mono.error(new UsuarioPortalException(textoMensagem, HttpStatus.NOT_FOUND.value())));

		HttpEntity<SocialCliente> requestEntity = new HttpEntity<>(socialCliente);

		ResponseEntity<Response<Boolean>> redeSocialReturns = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/66899900047/desvincula/", HttpMethod.POST,
				requestEntity, new ParameterizedTypeReference<Response<Boolean>>() {
				});

		System.out.println("Retorno " + redeSocialReturns);

		Assert.assertEquals("testDesvinculaUsuarioCpfCnpjInvalidoException", HttpStatus.OK,
				redeSocialReturns.getStatusCode());
		Assert.assertEquals("testDesvinculaUsuarioCpfCnpjInvalidoException", HttpStatus.NOT_FOUND.value(),
				redeSocialReturns.getBody().getStatus());
		Assert.assertEquals("testDesvinculaUsuarioCpfCnpjInvalidoException", textoMensagem,
				redeSocialReturns.getBody().getErrors().get(0));
	}

	@Test
	public void testDesvinculaUsuarioRedeSocialException() {

		SocialCliente socialCliente = new SocialCliente();
		socialCliente.setIdSocialCliente("1234");

		String textoMensagem = "Usuario não possui rede social";

		when(redeSocialService.desvinculaRedeSocial("66899900047", "1234"))
				.thenReturn(Mono.error(new RedeSocialException(textoMensagem, HttpStatus.NOT_FOUND.value())));

		HttpEntity<SocialCliente> requestEntity = new HttpEntity<>(socialCliente);

		ResponseEntity<Response<Boolean>> redeSocialReturns = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/66899900047/desvincula/", HttpMethod.POST,
				requestEntity, new ParameterizedTypeReference<Response<Boolean>>() {
				});

		System.out.println("Retorno " + redeSocialReturns);

		Assert.assertEquals("testDesvinculaUsuarioCpfCnpjInvalidoException", HttpStatus.OK,
				redeSocialReturns.getStatusCode());
		Assert.assertEquals("testDesvinculaUsuarioCpfCnpjInvalidoException", HttpStatus.NOT_FOUND.value(),
				redeSocialReturns.getBody().getStatus());
		Assert.assertEquals("testDesvinculaUsuarioCpfCnpjInvalidoException", textoMensagem,
				redeSocialReturns.getBody().getErrors().get(0));
	}

	@Test
	public void testDesvinculaUsuarioDefaultException() {

		SocialCliente socialCliente = new SocialCliente();
		socialCliente.setIdSocialCliente("1234");

		String textoMensagem = "Error";

		when(redeSocialService.desvinculaRedeSocial("85378473217", "1234"))
				.thenReturn(Mono.error(new Exception(textoMensagem)));

		HttpEntity<SocialCliente> requestEntity = new HttpEntity<>(socialCliente);

		ResponseEntity<Response<Boolean>> redeSocialReturns = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/85378473217/desvincula/", HttpMethod.POST,
				requestEntity, new ParameterizedTypeReference<Response<Boolean>>() {
				});

		System.out.println("Retorno " + redeSocialReturns);

		Assert.assertEquals("testDesvinculaUsuarioCpfCnpjInvalidoException", HttpStatus.INTERNAL_SERVER_ERROR,
				redeSocialReturns.getStatusCode());
		Assert.assertEquals("testDesvinculaUsuarioCpfCnpjInvalidoException", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				redeSocialReturns.getBody().getStatus());
		Assert.assertEquals("testDesvinculaUsuarioCpfCnpjInvalidoException", textoMensagem,
				redeSocialReturns.getBody().getErrors().get(0));
	}

	@Test
	public void testDesvinculaUsuarioErroPayload() {

		SocialCliente socialCliente = new SocialCliente();
		socialCliente.setIdSocialCliente("1234");

		when(redeSocialService.desvinculaRedeSocial("85378473217", "1234")).thenReturn(Mono.just(true));

		ResponseEntity<Response<Boolean>> desvincularConta = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/85378473217/desvincula/", HttpMethod.POST,
				null, new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("Unsupported media type", 415, desvincularConta.getBody().getStatus());
	}

	@Test
	public void testConsultaPorCpfSucesso() {

		RedeSocial redeSocial = new RedeSocial(new UsuarioRedeSocial());
		List<RedeSocial> listRedeSocial = new ArrayList<>();
		listRedeSocial.add(redeSocial);
		when(redeSocialService.consultaPorCpfCnpj("66899900047")).thenReturn(Mono.just(listRedeSocial));

		ResponseEntity<Response<List<RedeSocial>>> redeSocialReturns = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/66899900047", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<RedeSocial>>>() {
				});

		System.out.println("Retorno " + redeSocialReturns);

		Assert.assertEquals("testConsultaPorCpfSucesso", HttpStatus.OK, redeSocialReturns.getStatusCode());
	}

	@Test
	public void testConsultaPorCpfWhenException() {

		String textoMensagem = "Error";
		when(redeSocialService.consultaPorCpfCnpj("66899900047")).thenReturn(Mono.error(new Exception(textoMensagem)));

		ResponseEntity<Response<List<RedeSocial>>> redeSocialReturns = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/66899900047", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<RedeSocial>>>() {
				});

		System.out.println("Retorno " + redeSocialReturns);

		Assert.assertEquals("testConsultaPorCpfWhenException", HttpStatus.INTERNAL_SERVER_ERROR,
				redeSocialReturns.getStatusCode());
		Assert.assertEquals("testConsultaPorCpfWhenException", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				redeSocialReturns.getBody().getStatus());
		Assert.assertEquals("testConsultaPorCpfWhenException", textoMensagem,
				redeSocialReturns.getBody().getErrors().get(0));
	}

	@Test
	public void testConsultaPorCpfWhenUsuarioPortalException() {

		String textoMensagem = "Error";
		when(redeSocialService.consultaPorCpfCnpj("66899900047"))
				.thenReturn(Mono.error(new UsuarioPortalException(textoMensagem, 404)));

		ResponseEntity<Response<List<RedeSocial>>> redeSocialReturns = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/66899900047", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<RedeSocial>>>() {
				});

		System.out.println("Retorno " + redeSocialReturns);

		Assert.assertEquals("testConsultaPorCpfWhenUsuarioPortalException", HttpStatus.OK,
				redeSocialReturns.getStatusCode());
		Assert.assertEquals("testConsultaPorCpfWhenUsuarioPortalException", HttpStatus.NOT_FOUND.value(),
				redeSocialReturns.getBody().getStatus());
		Assert.assertEquals("testConsultaPorCpfWhenUsuarioPortalException", textoMensagem,
				redeSocialReturns.getBody().getErrors().get(0));
	}

	@Test
	public void testConsultaPorCpfWhenCpfCnpjInvalidoException() {

		String textoMensagem = "CPF ou CNPJ inválido.";
		when(redeSocialService.consultaPorCpfCnpj("66899900047"))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("CPF ou CNPJ inválido.")));

		ResponseEntity<Response<List<RedeSocial>>> redeSocialReturns = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/66899900047", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<RedeSocial>>>() {
				});

		System.out.println("Retorno " + redeSocialReturns);

		Assert.assertEquals("testConsultaPorCpfWhenCpfCnpjInvalidoException", HttpStatus.OK,
				redeSocialReturns.getStatusCode());
		Assert.assertEquals("testConsultaPorCpfWhenCpfCnpjInvalidoException", HttpStatus.BAD_REQUEST.value(),
				redeSocialReturns.getBody().getStatus());
		Assert.assertEquals("testConsultaPorCpfWhenCpfCnpjInvalidoException", textoMensagem,
				redeSocialReturns.getBody().getErrors().get(0));
	}

	@Test
	public void testConsultaPorIdSocialAndTextRedeSocialWhenUsuarioPortalException() {

		String textoMensagem = "Usuário não possui rede social";
		SocialClienteConsulta socialConsulta = new SocialClienteConsulta();
		socialConsulta.setIdSocialCliente("29763146836");
		socialConsulta.setTextoIdentificadorAplicacaoRedeSocial("G_PDC");

		when(redeSocialService.consultaPorIdRedeSocialAndIdentificadorRedeSocial(socialConsulta))
				.thenReturn(Mono.error(new UsuarioPortalException(textoMensagem, 404)));

		HttpEntity<SocialClienteConsulta> requestEntity = new HttpEntity<>(socialConsulta);
		ResponseEntity<Response<List<RedeSocial>>> redeSocialReturns = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<List<RedeSocial>>>() {
				});

		System.out.println("Retorno " + redeSocialReturns);

		Assert.assertEquals("testConsultaPorIdSocialAndTextRedeSocialWhenUsuarioPortalException", HttpStatus.OK,
				redeSocialReturns.getStatusCode());
		Assert.assertEquals("testConsultaPorIdSocialAndTextRedeSocialWhenUsuarioPortalException",
				HttpStatus.NOT_FOUND.value(), redeSocialReturns.getBody().getStatus());
		Assert.assertEquals("testConsultaPorIdSocialAndTextRedeSocialWhenUsuarioPortalException", textoMensagem,
				redeSocialReturns.getBody().getErrors().get(0));
		Mockito.verify(redeSocialService, Mockito.times(1))
				.consultaPorIdRedeSocialAndIdentificadorRedeSocial(socialConsulta);

	}

	@Test
	public void testConsultaPorIdSocialAndTextRedeSocialWhenRedeSocialException() {

		String textoMensagem = "Rede Social não encontrada.";
		SocialClienteConsulta socialConsulta = new SocialClienteConsulta();
		socialConsulta.setIdSocialCliente("29763146836");
		socialConsulta.setTextoIdentificadorAplicacaoRedeSocial("G_PDC");

		when(redeSocialService.consultaPorIdRedeSocialAndIdentificadorRedeSocial(socialConsulta))
				.thenReturn(Mono.error(new UsuarioPortalException(textoMensagem, 400)));

		HttpEntity<SocialClienteConsulta> requestEntity = new HttpEntity<>(socialConsulta);
		ResponseEntity<Response<List<RedeSocial>>> redeSocialReturns = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<List<RedeSocial>>>() {
				});

		System.out.println("Retorno " + redeSocialReturns);

		Assert.assertEquals("testConsultaPorIdSocialAndTextRedeSocialWhenRedeSocialException", HttpStatus.OK,
				redeSocialReturns.getStatusCode());
		Assert.assertEquals("testConsultaPorIdSocialAndTextRedeSocialWhenRedeSocialException",
				HttpStatus.BAD_REQUEST.value(), redeSocialReturns.getBody().getStatus());
		Assert.assertEquals("testConsultaPorIdSocialAndTextRedeSocialWhenRedeSocialException", textoMensagem,
				redeSocialReturns.getBody().getErrors().get(0));
		Mockito.verify(redeSocialService, Mockito.times(1))
				.consultaPorIdRedeSocialAndIdentificadorRedeSocial(socialConsulta);

	}

	@Test
	public void testConsultaPorIdSocialAndTextRedeSocialWhenException() {

		String textoMensagem = "Erro";
		SocialClienteConsulta socialConsulta = new SocialClienteConsulta();
		socialConsulta.setIdSocialCliente("29763146836");
		socialConsulta.setTextoIdentificadorAplicacaoRedeSocial("G_PDC");

		when(redeSocialService.consultaPorIdRedeSocialAndIdentificadorRedeSocial(socialConsulta))
				.thenReturn(Mono.error(new Exception(textoMensagem)));

		HttpEntity<SocialClienteConsulta> requestEntity = new HttpEntity<>(socialConsulta);
		ResponseEntity<Response<List<RedeSocial>>> redeSocialReturns = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<List<RedeSocial>>>() {
				});

		System.out.println("Retorno " + redeSocialReturns);

		Assert.assertEquals("testConsultaPorIdSocialAndTextRedeSocialWhenException", HttpStatus.INTERNAL_SERVER_ERROR,
				redeSocialReturns.getStatusCode());
		Assert.assertEquals("testConsultaPorIdSocialAndTextRedeSocialWhenException",
				HttpStatus.INTERNAL_SERVER_ERROR.value(), redeSocialReturns.getBody().getStatus());
		Assert.assertEquals("testConsultaPorIdSocialAndTextRedeSocialWhenException", textoMensagem,
				redeSocialReturns.getBody().getErrors().get(0));
		Mockito.verify(redeSocialService, Mockito.times(1))
				.consultaPorIdRedeSocialAndIdentificadorRedeSocial(socialConsulta);

	}

	@Test
	public void testConsultaPorIdSocialAndTextRedeSocialSucesso() {

		SocialClienteConsulta socialConsulta = new SocialClienteConsulta();
		socialConsulta.setIdSocialCliente("29763146836");
		socialConsulta.setTextoIdentificadorAplicacaoRedeSocial("G_PDC");

		UsuarioRedeSocial usuarioRedeSocial = new UsuarioRedeSocial();
		usuarioRedeSocial.setIdSocialCliente("123");
		RedeSocial rs = new RedeSocial(usuarioRedeSocial);
		List<RedeSocial> listRedeSocial = new ArrayList<>();
		listRedeSocial.add(rs);

		when(redeSocialService.consultaPorIdRedeSocialAndIdentificadorRedeSocial(socialConsulta))
				.thenReturn(Mono.just(listRedeSocial));

		HttpEntity<SocialClienteConsulta> requestEntity = new HttpEntity<>(socialConsulta);
		ResponseEntity<Response<List<RedeSocial>>> redeSocialReturns = restTemplate.exchange(
				"http://localhost:" + port + "/v1/redesocial/", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<List<RedeSocial>>>() {
				});

		System.out.println("Retorno " + redeSocialReturns);

		Assert.assertEquals("testConsultaPorIdSocialAndTextRedeSocialSucesso", HttpStatus.OK,
				redeSocialReturns.getStatusCode());
		Assert.assertEquals("testConsultaPorIdSocialAndTextRedeSocialSucesso", HttpStatus.OK.value(),
				redeSocialReturns.getBody().getStatus());
		Assert.assertEquals("testConsultaPorIdSocialAndTextRedeSocialSucesso", "123",
				redeSocialReturns.getBody().getData().get(0).getIdSocialCliente());
		Mockito.verify(redeSocialService, Mockito.times(1))
				.consultaPorIdRedeSocialAndIdentificadorRedeSocial(socialConsulta);

	}

}
