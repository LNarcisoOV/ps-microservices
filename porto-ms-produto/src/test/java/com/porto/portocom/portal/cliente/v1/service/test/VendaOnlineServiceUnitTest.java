package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.porto.portocom.portal.cliente.v1.integration.facade.IVendaOnlineFacade;
import com.porto.portocom.portal.cliente.v1.service.VendaOnlineService;
import com.porto.portocom.portal.cliente.v1.wsdl.vdo.common.VendaOnlineResponse;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendaOnlineServiceUnitTest {

	@Mock
	private IVendaOnlineFacade vendaOnlineFacade;

	@InjectMocks
	private VendaOnlineService vendaOnlineService;

	@Before
	public void init() throws DatatypeConfigurationException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testPesquisaCotacoesAtivas() {

		String cpf = "47879031014";

		VendaOnlineResponse vendaOnlineResponse = new VendaOnlineResponse();
		vendaOnlineResponse.setNomeProponente("Teste");

		Mockito.when(vendaOnlineFacade.pesquisaCotacoes(cpf)).thenReturn(Mono.just(vendaOnlineResponse));

		vendaOnlineService.pesquisaCotacoes(cpf).map(cotacoes -> {
			assertNotNull("Retorno com sucesso.", cotacoes);
			assertEquals("Teste", cotacoes.getNomeProponente());
			return cotacoes;
		}).subscribe();
	}

	@Test
	public void testPesquisaCotacoesInativas() {

		String cpf = "80287257088";

		VendaOnlineResponse vendaOnlineResponse = new VendaOnlineResponse();
		vendaOnlineResponse.setNomeProponente("Teste");

		Mockito.when(vendaOnlineFacade.pesquisaCotacoes(cpf)).thenReturn(Mono.just(vendaOnlineResponse));

		vendaOnlineService.pesquisaCotacoes(cpf).map(cotacoes -> {
			assertNotNull("Retorno com sucesso.", cotacoes);
			assertEquals("Teste", cotacoes.getNomeProponente());
			return cotacoes;
		}).subscribe();
	}
}
