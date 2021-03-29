package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

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

import com.porto.portocom.portal.cliente.v1.integration.facade.IInvestimentoFacade;
import com.porto.portocom.portal.cliente.v1.service.InvestimentoService;
import com.porto.portocom.portal.cliente.v1.wsdl.investimento.CotistaCompletoServiceVO;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvestimentoServiceUnitTest {

	@Mock
	private IInvestimentoFacade investimentoFacade;

	@InjectMocks
	private InvestimentoService investimentoService;

	@Before
	public void init() throws DatatypeConfigurationException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testConsultaCotistaSucesso() {

		String cpf = "10854356878";

		CotistaCompletoServiceVO cotistaCompletoServiceVO = new CotistaCompletoServiceVO();
		cotistaCompletoServiceVO.setNome("Teste");

		List<CotistaCompletoServiceVO> listCotistas = new ArrayList<>();
		listCotistas.add(cotistaCompletoServiceVO);

		Mockito.when(investimentoFacade.cotistas(cpf)).thenReturn(Mono.just(listCotistas));

		investimentoService.consultaCotistas(cpf).map(cotista -> {
			assertNotNull("", cotista);
			assertEquals("Teste", cotista.get(0).getNome());
			return cotista;
		}).subscribe();
	}

}
