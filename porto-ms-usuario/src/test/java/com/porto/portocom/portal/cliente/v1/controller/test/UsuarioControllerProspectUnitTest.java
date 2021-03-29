package com.porto.portocom.portal.cliente.v1.controller.test;

import static org.mockito.Mockito.when;

import java.util.Collections;

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

import com.porto.portocom.portal.cliente.entity.TipoUsuario;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;
import com.porto.portocom.portal.cliente.v1.exception.CadastroException;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.AplicacaoLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ICadastroService;
import com.porto.portocom.portal.cliente.v1.service.IContadorAcessoService;
import com.porto.portocom.portal.cliente.v1.service.IProspectService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.vo.usuario.CadastroUsuarioProspect;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("controller-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioControllerProspectUnitTest {

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
	}

	@Test
	public void testDefineProspectSucesso() {

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");

		Mockito.when(prospectService.definirProspect("27385095844")).thenReturn(Mono.just(usuarioPortalCliente));

		ResponseEntity<Response<UsuarioPortalCliente>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/define/prospect/27385095844", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioPortalCliente>>() {
				});

		Assert.assertNotNull("Consulta realizada com sucesso.", usuario.getBody().getData());
	}

	@Test
	public void testDefineProspectCpfCnpjInvalidoException() {

		Mockito.when(prospectService.definirProspect("27385095844"))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<UsuarioPortalCliente>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/define/prospect/27385095844", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioPortalCliente>>() {
				});

		Assert.assertEquals("testDefineProspectSCpfCnpjInvalidoException", 400, usuario.getBody().getStatus());
	}

	@Test
	public void testDefineProspectUsuarioPortalException() {

		Mockito.when(prospectService.definirProspect("27385095844"))
				.thenReturn(Mono.error(new UsuarioPortalException("error", HttpStatus.NOT_FOUND.value())));

		ResponseEntity<Response<UsuarioPortalCliente>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/define/prospect/27385095844", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioPortalCliente>>() {
				});

		Assert.assertEquals("testDefineProspectSUsuarioPortalException", usuario.getBody().getStatus(),
				HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void testDefineProspectException() {

		Mockito.when(prospectService.definirProspect("27385095844")).thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<UsuarioPortalCliente>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/define/prospect/27385095844", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<UsuarioPortalCliente>>() {
				});

		Assert.assertEquals("testDefineProspectSUsuarioPortalException", usuario.getBody().getStatus(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testConsultaUsuarioProspectSucesso() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(1L);
		tipoUsuario.setDescricaoTipoUsuario("Prospect Venda Online");
		tipoUsuario.setFlagTipoUsuario("S");

		Mockito.when(prospectService.consultaProspect("27385095844")).thenReturn(Mono.just(tipoUsuario));

		ResponseEntity<Response<TipoUsuario>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/consulta/prospect/27385095844", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<TipoUsuario>>() {
				});

		Assert.assertTrue("Consulta realizada com sucesso.", usuario.getBody().getData().getIdTipoUsuario().equals(1L));
	}

	@Test
	public void testConsultaUsuarioProspectSCpfCnpjInvalidoException() {

		Mockito.when(prospectService.consultaProspect("27385095844"))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		ResponseEntity<Response<Object>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/consulta/prospect/27385095844", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<Object>>() {
				});

		Assert.assertEquals("testConsultaUsuarioProspectSCpfCnpjInvalidoException", 400, usuario.getBody().getStatus());
	}

	@Test
	public void testConsultaUsuarioProspectSUsuarioPortalException() {

		Mockito.when(prospectService.consultaProspect("27385095844"))
				.thenReturn(Mono.error(new UsuarioPortalException("", 404)));

		ResponseEntity<Response<Object>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/consulta/prospect/27385095844", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<Object>>() {
				});

		Assert.assertEquals("testConsultaUsuarioProspectSUsuarioPortalException", 404, usuario.getBody().getStatus());
	}

	@Test
	public void testConsultaUsuarioProspectException() {

		Mockito.when(prospectService.consultaProspect("27385095844")).thenReturn(Mono.error(new Exception()));

		ResponseEntity<Response<Object>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/consulta/prospect/27385095844", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<Object>>() {
				});

		Assert.assertEquals("testConsultaUsuarioProspectException", usuario.getBody().getStatus(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testCadastroProspectSucesso() {

		CadastroUsuarioProspect.CadastroUsuarioProspectBuilder usuarioProspectBuilder = CadastroUsuarioProspect
				.builder();
		usuarioProspectBuilder.nome("Francisco");
		usuarioProspectBuilder.email("francisco@email.com");
		usuarioProspectBuilder.celular("85987563349");

		Mockito.when(prospectService.cadastrarProspect("27385095844", usuarioProspectBuilder.build()))
				.thenReturn(Mono.just(Boolean.TRUE));

		HttpEntity<CadastroUsuarioProspect> requestEntity = new HttpEntity<>(usuarioProspectBuilder.build());

		ResponseEntity<Response<Boolean>> contaAtivaUsuarioProspect = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/cadastro/prospect/27385095844", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertTrue("Conta reativada com sucesso.", contaAtivaUsuarioProspect.getBody().getData());
	}

	@Test
	public void testCadastroProspectCpfCnpjInvalidoException() {
		CadastroUsuarioProspect.CadastroUsuarioProspectBuilder usuarioProspectBuilder = CadastroUsuarioProspect
				.builder();
		usuarioProspectBuilder.nome("Francisco");
		usuarioProspectBuilder.email("francisco@email.com");
		usuarioProspectBuilder.celular("85987563349");

		Mockito.when(prospectService.cadastrarProspect("27385095844", usuarioProspectBuilder.build()))
				.thenReturn(Mono.error(new CpfCnpjInvalidoException("")));

		HttpEntity<CadastroUsuarioProspect> requestEntity = new HttpEntity<>(usuarioProspectBuilder.build());

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/cadastro/prospect/27385095844", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testCadastroProspectCpfCnpjInvalidoException", 400, usuario.getBody().getStatus());
	}

	@Test
	public void testCadastroProspectUsuarioPortalException() {
		CadastroUsuarioProspect.CadastroUsuarioProspectBuilder usuarioProspectBuilder = CadastroUsuarioProspect
				.builder();
		usuarioProspectBuilder.nome("Francisco");
		usuarioProspectBuilder.email("francisco@email.com");
		usuarioProspectBuilder.celular("85987563349");

		Mockito.when(prospectService.cadastrarProspect("27385095844", usuarioProspectBuilder.build()))
				.thenReturn(Mono.error(new UsuarioPortalException("Error", HttpStatus.BAD_REQUEST.value())));

		HttpEntity<CadastroUsuarioProspect> requestEntity = new HttpEntity<>(usuarioProspectBuilder.build());

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/cadastro/prospect/27385095844", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testCadastroProspectUsuarioPortalException", usuario.getBody().getStatus(),
				HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void testCadastroProspectException() {
		CadastroUsuarioProspect.CadastroUsuarioProspectBuilder usuarioProspectBuilder = CadastroUsuarioProspect
				.builder();
		usuarioProspectBuilder.nome("Francisco");
		usuarioProspectBuilder.email("francisco@email.com");
		usuarioProspectBuilder.celular("85987563349");

		Mockito.when(prospectService.cadastrarProspect("27385095844", usuarioProspectBuilder.build()))
				.thenReturn(Mono.error(new Exception()));

		HttpEntity<CadastroUsuarioProspect> requestEntity = new HttpEntity<>(usuarioProspectBuilder.build());

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/cadastro/prospect/27385095844", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testCadastroProspectException", usuario.getBody().getStatus(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	
	@Test
	public void testCadastroProspectCadastroException() {
		
		CadastroUsuarioProspect.CadastroUsuarioProspectBuilder usuarioProspectBuilder = CadastroUsuarioProspect
				.builder();
		usuarioProspectBuilder.nome("Francisco");
		usuarioProspectBuilder.email("francisco@email.com");
		usuarioProspectBuilder.celular("85987563349");

		Mockito.when(prospectService.cadastrarProspect("27385095844", usuarioProspectBuilder.build()))
				.thenReturn(Mono.error(new CadastroException("Erro", HttpStatus.NOT_FOUND.value())));

		HttpEntity<CadastroUsuarioProspect> requestEntity = new HttpEntity<>(usuarioProspectBuilder.build());

		ResponseEntity<Response<Boolean>> usuario = restTemplate.exchange(
				"http://localhost:" + port + "/v1/usuario/cadastro/prospect/27385095844", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});

		Assert.assertEquals("testCadastroProspectException", usuario.getBody().getStatus(),
				HttpStatus.NOT_FOUND.value());
	}

	
}
