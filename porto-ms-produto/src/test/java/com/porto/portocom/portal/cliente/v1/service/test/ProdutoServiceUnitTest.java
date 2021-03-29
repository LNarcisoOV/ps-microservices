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

import com.porto.portocom.portal.cliente.v1.dto.bcp.ContratoBcp;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.dto.conquista.IsClienteArenaCadastrado;
import com.porto.portocom.portal.cliente.v1.dto.vdo.CotacoesVendaOnline;
import com.porto.portocom.portal.cliente.v1.service.IBCCService;
import com.porto.portocom.portal.cliente.v1.service.IBcpService;
import com.porto.portocom.portal.cliente.v1.service.IConquistaService;
import com.porto.portocom.portal.cliente.v1.service.IVendaOnlineService;
import com.porto.portocom.portal.cliente.v1.service.ProdutoService;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPF;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPJ;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoServiceUnitTest {

	@Mock
	private IVendaOnlineService vendaOnlineService;

	@Mock
	private IBcpService bcpService;

	@Mock
	private IConquistaService conquistaService;
	
	@Mock
	private IBCCService bccService;

	@InjectMocks
	private ProdutoService produtoService;

	@Before
	public void init() throws DatatypeConfigurationException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testConsultaProdutosProspectComDadosCpf() {

		String cpf = "22890390802";

		CotacoesVendaOnline cotacoesVendaOnline = new CotacoesVendaOnline();
		cotacoesVendaOnline.setNomeProponente("Teste");

		ContratoBcp.Pessoa contrato = new ContratoBcp.Pessoa();
		contrato.setNomePessoa("Teste");
		List<ContratoBcp.Pessoa> contratos = new ArrayList<>();
		contratos.add(contrato);

		PessoaBcp.Pessoa pessoa = new PessoaBcp.Pessoa();
		pessoa.setNomePessoa("Teste");
		List<PessoaBcp.Pessoa> pessoas = new ArrayList<>();
		pessoas.add(pessoa);
		
		IsClienteArenaCadastrado isClienteArenaCadastrado = new IsClienteArenaCadastrado();
		isClienteArenaCadastrado.setNomeCliente("Teste");
		
		PessoaBccPF pessoaBccPf = new PessoaBccPF();
		PessoaBccPF.Pessoa pessoaBcc = new PessoaBccPF.Pessoa();
		pessoaBcc.setNomeLegalPessoa("Teste");
		List<PessoaBccPF.Pessoa> pessoasBcc = new ArrayList<>();
		pessoasBcc.add(pessoaBcc);
		pessoaBccPf.setPessoas(pessoasBcc);

		Mockito.when(vendaOnlineService.pesquisaCotacoes(cpf)).thenReturn(Mono.just(cotacoesVendaOnline));
		Mockito.when(bcpService.consultarContratos(cpf)).thenReturn(Mono.just(contratos));
		Mockito.when(bcpService.consultarPessoas(cpf)).thenReturn(Mono.just(pessoas));
		Mockito.when(conquistaService.obterDadosClienteArenaCadastrado(cpf)).thenReturn(Mono.just(isClienteArenaCadastrado));
		Mockito.when(bccService.consultaPFBCC(cpf)).thenReturn(Mono.just(pessoaBccPf));

		produtoService.consultaProdutosProspect(cpf).map(result -> {
			assertNotNull("", result);
			assertEquals("Teste", result.getCotacoesVendaOnline().getNomeProponente());
			assertEquals("Teste", result.getContratosBcp().get(0).getNomePessoa());
			assertEquals("Teste", result.getPessoasBcp().get(0).getNomePessoa());
			assertEquals("Teste", result.getIsClienteArenaCadastrado().getNomeCliente());
			assertEquals("Teste", result.getPessoaBccPf().getPessoas().get(0).getNomeLegalPessoa());
			return result;
		}).subscribe();
	}
	
	@Test
	public void testConsultaProdutosProspectComDadosCnpj() {

		String cnpj = "61198164000160";

		CotacoesVendaOnline cotacoesVendaOnline = new CotacoesVendaOnline();
		cotacoesVendaOnline.setNomeProponente("Teste");

		ContratoBcp.Pessoa contrato = new ContratoBcp.Pessoa();
		contrato.setNomePessoa("Teste");
		List<ContratoBcp.Pessoa> contratos = new ArrayList<>();
		contratos.add(contrato);

		PessoaBcp.Pessoa pessoa = new PessoaBcp.Pessoa();
		pessoa.setNomePessoa("Teste");
		List<PessoaBcp.Pessoa> pessoas = new ArrayList<>();
		pessoas.add(pessoa);
		
		PessoaBccPJ pessoaBccPj = new PessoaBccPJ();
		PessoaBccPJ.Pessoa pessoaBcc = new PessoaBccPJ.Pessoa();
		pessoaBcc.setNomeLegalPessoa("Teste");
		List<PessoaBccPJ.Pessoa> pessoasBcc = new ArrayList<>();
		pessoasBcc.add(pessoaBcc);
		pessoaBccPj.setPessoas(pessoasBcc);

		IsClienteArenaCadastrado isClienteArenaCadastrado = new IsClienteArenaCadastrado();
		isClienteArenaCadastrado.setNomeCliente("Teste");

		Mockito.when(vendaOnlineService.pesquisaCotacoes(cnpj)).thenReturn(Mono.just(cotacoesVendaOnline));
		Mockito.when(bcpService.consultarContratos(cnpj)).thenReturn(Mono.just(contratos));
		Mockito.when(bcpService.consultarPessoas(cnpj)).thenReturn(Mono.just(pessoas));
		Mockito.when(conquistaService.obterDadosClienteArenaCadastrado(cnpj)).thenReturn(Mono.just(isClienteArenaCadastrado));
		Mockito.when(bccService.consultaPJBCC(cnpj)).thenReturn(Mono.just(pessoaBccPj));

		produtoService.consultaProdutosProspect(cnpj).map(result -> {
			assertNotNull("", result);
			assertEquals("Teste", result.getCotacoesVendaOnline().getNomeProponente());
			assertEquals("Teste", result.getContratosBcp().get(0).getNomePessoa());
			assertEquals("Teste", result.getPessoasBcp().get(0).getNomePessoa());
			assertEquals("Teste", result.getIsClienteArenaCadastrado().getNomeCliente());
			assertEquals("Teste", result.getPessoaBccPj().getPessoas().get(0).getNomeLegalPessoa());
			return result;
		}).subscribe();
	}
	
	@Test()
	public void testConsultaProdutosProspectCpfInvalido() {

		produtoService.consultaProdutosProspect(null).onErrorResume(error -> {
			assertEquals("CPF/CNPJ inválido.", error.getMessage());
			return Mono.empty();
		}).subscribe();
	}

}
