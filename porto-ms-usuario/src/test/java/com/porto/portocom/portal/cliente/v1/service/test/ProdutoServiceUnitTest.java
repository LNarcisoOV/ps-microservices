package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Pessoa;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMSProdutoWebService;
import com.porto.portocom.portal.cliente.v1.service.ProdutoService;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoServiceUnitTest {


	@Mock
	private IPortoMSProdutoWebService produtoMSService;

	@InjectMocks
	private ProdutoService produtoService;


	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void testConsultaPessoasSucesso() {
		Mockito.when(produtoMSService.consultaPessoas("2223334446"))
		.thenReturn(this.criaListaPessoaBcp());
		
		produtoService.consultaPessoas("2223334446")
		.map(listPessoa -> {
			assertEquals(this.criaListaPessoaBcp(), listPessoa);
			return listPessoa;
		}).subscribe();
		
		Mockito.verify(produtoMSService, Mockito.times(1)).consultaPessoas("2223334446");
	}
	
		
	private List<PessoaBcp.Pessoa> criaListaPessoaBcp() {
		PessoaBcp.Pessoa pessoa = new PessoaBcp.Pessoa();
		pessoa.setNumeroPessoa(1L);
		pessoa.setCodigoTipoPessoa("1");
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa);
		return pessoas;
		
	}
	

}
