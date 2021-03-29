package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;

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
import org.springframework.test.context.ActiveProfiles;

import com.porto.portocom.portal.cliente.v1.integration.facade.IComplementoCartoesFacade;
import com.porto.portocom.portal.cliente.v1.service.ComplementoCartoesService;
import com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes.ContaCartaoRetornoVO;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComplementoCartoesServiceUnitTest {

	@Mock
	private IComplementoCartoesFacade complementoCartoesFacade;

	@InjectMocks
	private ComplementoCartoesService consultaContasCartoes;

	@Before
	public void init() throws DatatypeConfigurationException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testConsultarComplementoCartoesSucesso() throws MalformedURLException {

		String cpf = "22069942830";
		String origem = "27";

		ContaCartaoRetornoVO contaCartao = new ContaCartaoRetornoVO();
		contaCartao.setCodigoRetorno(1);

		Mockito.when(complementoCartoesFacade.contaCartoes(cpf, origem)).thenReturn(Mono.just(contaCartao));

		consultaContasCartoes.consultarComplementoCartoes(cpf, origem).map(contas -> {
			assertNotNull("Contas obtidas com sucesso.", contas);
			assertEquals(1, contas.getCodigoRetorno());
			return contas;
		}).subscribe();
	}
}
