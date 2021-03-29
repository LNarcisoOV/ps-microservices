package com.porto.portocom.portal.cliente.v1.controller.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
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

import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.IBcpService;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("controller-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BcpControllerUnitTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private IBcpService bcpService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testConsultaPessoasSucesso() {

		PessoaBcp.Pessoa pessoa1 = new PessoaBcp.Pessoa();
		pessoa1.setNomePessoa("Teste");

		List<PessoaBcp.Pessoa> listPessoas = new ArrayList<PessoaBcp.Pessoa>();
		listPessoas.add(pessoa1);

		Mono<List<PessoaBcp.Pessoa>> pessoas = Mono.just(listPessoas);

		Mockito.when(bcpService.consultarPessoas("22890390802")).thenReturn(pessoas);

		ResponseEntity<Response<List<PessoaBcp.Pessoa>>> response = restTemplate.exchange(
				"http://localhost:" + port + "/v1/bcp/22890390802/pessoas", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<PessoaBcp.Pessoa>>>() {
				});

		Assert.assertEquals("testConsultaPessoasSucesso", response.getBody().getStatus(), HttpStatus.OK.value());
	}

}