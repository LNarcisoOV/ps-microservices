package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertArrayEquals;
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

import com.porto.portocom.portal.cliente.v1.integration.facade.IBcpFacade;
import com.porto.portocom.portal.cliente.v1.service.BcpService;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterContratoResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterPessoasResponseType;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BcpServiceUnitTest {

	@Mock
	private IBcpFacade bcpFacade;

	@InjectMocks
	private BcpService bcpService;

	@Before
	public void init() throws DatatypeConfigurationException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testConsultaContratosSucesso() {

		ObterContratoResponseType.Pessoa pessoa1 = new ObterContratoResponseType.Pessoa();
		pessoa1.setNomePessoa("Teste");

		List<ObterContratoResponseType.Pessoa> listPessoas = new ArrayList<>();
		listPessoas.add(pessoa1);

		String cpf = "37488499824";

		Mockito.when(bcpFacade.contratosBcp(cpf)).thenReturn(Mono.just(listPessoas));

		this.bcpService.consultarContratos(cpf).map(contrato -> {
			assertNotNull("", contrato);
			assertArrayEquals("", new String[] { "Teste" }, new String[] { contrato.get(0).getNomePessoa() });
			return contrato;
		}).subscribe();
	}

	@Test
	public void testConsultaPessoasSucesso() {

		ObterPessoasResponseType.Pessoa pessoa1 = new ObterPessoasResponseType.Pessoa();
		pessoa1.setNomePessoa("Teste");

		List<ObterPessoasResponseType.Pessoa> listPessoas = new ArrayList<>();
		listPessoas.add(pessoa1);

		String cpf = "37488499824";

		Mockito.when(bcpFacade.pessoasBcp(cpf)).thenReturn(Mono.just(listPessoas));

		this.bcpService.consultarPessoas(cpf).map(contrato -> {
			assertNotNull("", contrato);
			assertArrayEquals("", new String[] { "Teste" }, new String[] { contrato.get(0).getNomePessoa() });
			return contrato;
		}).subscribe();
	}
}
