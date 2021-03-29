package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
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

import com.porto.portocom.portal.cliente.entity.TipoUsuario;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.dto.bcp.ContratoBcp.Pessoa;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.dto.conquista.IsClienteArenaCadastrado;
import com.porto.portocom.portal.cliente.v1.dto.vdo.ArrayOfCotacaoVendaOnline;
import com.porto.portocom.portal.cliente.v1.dto.vdo.CotacaoVendaOnline;
import com.porto.portocom.portal.cliente.v1.dto.vdo.CotacoesVendaOnline;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMSProdutoWebService;
import com.porto.portocom.portal.cliente.v1.repository.ITipoUsuarioRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalClienteService;
import com.porto.portocom.portal.cliente.v1.service.ProspectService;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPF;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPJ;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect.ConsultaProdutosProspectBuilder;
import com.porto.portocom.portal.cliente.v1.vo.usuario.CadastroUsuarioProspect;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProspectServiceUnitTest {

	private static final String CPF_CLIENTE_ARENA = "37488499824";

	@Mock
	private IPortoMSProdutoWebService produtoWebService;

	@Mock
	private IUsuarioPortalClienteRepository usuarioPortalClienteRepository;
	
	@Mock
	private IUsuarioPortalClienteService usuarioPortalClienteService;

	@Mock
	private ITipoUsuarioRepository tipoUsuarioRepository;

	@InjectMocks
	private ProspectService prospectService;

	private UsuarioPortalCliente usuarioPortalCliente;

	private ConsultaProdutosProspect produtosCliente;

	private ConsultaProdutosProspect produtosExCliente;

	private ConsultaProdutosProspect produtosBCCPF;

	private ConsultaProdutosProspect produtosBCCPJ;

	private ConsultaProdutosProspect produtosProspectConquista;

	private ConsultaProdutosProspect produtosProspectVDO;

	private ConsultaProdutosProspect produtosSemRelacionamento;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		criaUsuarioPortal();
		criaProdutosCliente();
		criaProdutosExCliente();
		criaProdutosProspectConquista();
		criaProdutosProspectVDO();
		criaProdutosSemRelacionamento();
		criaProdutosBCCPF();
		criaProdutosBCCPJ();
	}

	private void criaUsuarioPortal() {
		usuarioPortalCliente = new UsuarioPortalCliente();
	}

	private void criaProdutosCliente() {
		PessoaBcp.Pessoa pessoa = new PessoaBcp.Pessoa();
		pessoa.setNomePessoa("Teste");

		Pessoa pessoaContrato = new Pessoa();

		ConsultaProdutosProspectBuilder produtosProspectsBuilder = ConsultaProdutosProspect.builder();
		produtosProspectsBuilder.contratosBcp(Collections.singletonList(pessoaContrato));
		produtosProspectsBuilder.cotacoesVendaOnline(null);
		produtosProspectsBuilder.pessoasBcp(Arrays.asList(pessoa));
		produtosProspectsBuilder.isClienteArenaCadastrado(null);

		produtosCliente = produtosProspectsBuilder.build();
	}

	private void criaProdutosExCliente() {
		PessoaBcp.Pessoa pessoa = new PessoaBcp.Pessoa();
		pessoa.setNomePessoa("Teste");

		ConsultaProdutosProspectBuilder produtosProspectsBuilder = ConsultaProdutosProspect.builder();
		produtosProspectsBuilder.contratosBcp(null);
		produtosProspectsBuilder.cotacoesVendaOnline(null);
		produtosProspectsBuilder.pessoasBcp(Arrays.asList(pessoa));
		produtosProspectsBuilder.isClienteArenaCadastrado(null);

		produtosExCliente = produtosProspectsBuilder.build();
	}

	private void criaProdutosBCCPF() {
		ConsultaProdutosProspectBuilder produtosProspectsBuilder = ConsultaProdutosProspect.builder();
		PessoaBccPF pessoaBccPF = new PessoaBccPF();
		PessoaBccPF.Pessoa pessoa = new PessoaBccPF.Pessoa();

		pessoaBccPF.setPessoas(Arrays.asList(pessoa));
		produtosProspectsBuilder.contratosBcp(null);
		produtosProspectsBuilder.cotacoesVendaOnline(null);
		produtosProspectsBuilder.isClienteArenaCadastrado(null);
		produtosProspectsBuilder.pessoaBccPf(pessoaBccPF);

		produtosBCCPF = produtosProspectsBuilder.build();
	}

	private void criaProdutosBCCPJ() {
		ConsultaProdutosProspectBuilder produtosProspectsBuilder = ConsultaProdutosProspect.builder();
		PessoaBccPJ pessoaBccPJ = new PessoaBccPJ();
		PessoaBccPJ.Pessoa pessoa = new PessoaBccPJ.Pessoa();

		pessoaBccPJ.setPessoas(Arrays.asList(pessoa));
		produtosProspectsBuilder.pessoaBccPj(pessoaBccPJ);

		produtosBCCPJ = produtosProspectsBuilder.build();
	}

	private void criaProdutosProspectConquista() {
		IsClienteArenaCadastrado isClienteArenaCadastrado = new IsClienteArenaCadastrado();
		isClienteArenaCadastrado.setIsCadastrado(null);

		ConsultaProdutosProspectBuilder produtosProspectsBuilder = ConsultaProdutosProspect.builder();
		produtosProspectsBuilder.contratosBcp(null);
		produtosProspectsBuilder.cotacoesVendaOnline(null);
		produtosProspectsBuilder.pessoasBcp(null);
		produtosProspectsBuilder.isClienteArenaCadastrado(isClienteArenaCadastrado);

		produtosProspectConquista = produtosProspectsBuilder.build();
	}

	private void criaProdutosProspectVDO() {
		CotacoesVendaOnline cotacoesVdo = new CotacoesVendaOnline();
		ArrayOfCotacaoVendaOnline arrayCotacoes = new ArrayOfCotacaoVendaOnline();
		cotacoesVdo.setCotacoesVendaOnline(arrayCotacoes);

		CotacaoVendaOnline cotacaoVendaOnlineVO = new CotacaoVendaOnline();

		arrayCotacoes.setCotacaoVendaOnlineVO(Collections.singletonList(cotacaoVendaOnlineVO));
		ConsultaProdutosProspectBuilder produtosProspectsBuilder = ConsultaProdutosProspect.builder();
		produtosProspectsBuilder.contratosBcp(null);
		produtosProspectsBuilder.cotacoesVendaOnline(cotacoesVdo);
		produtosProspectsBuilder.pessoasBcp(null);
		produtosProspectsBuilder.isClienteArenaCadastrado(null);

		produtosProspectVDO = produtosProspectsBuilder.build();
	}

	private void criaProdutosSemRelacionamento() {
		ConsultaProdutosProspectBuilder produtosProspectsBuilder = ConsultaProdutosProspect.builder();
		produtosProspectsBuilder.contratosBcp(null);
		produtosProspectsBuilder.cotacoesVendaOnline(null);
		produtosProspectsBuilder.pessoasBcp(null);
		produtosProspectsBuilder.isClienteArenaCadastrado(null);

		produtosSemRelacionamento = produtosProspectsBuilder.build();
	}

	@Test
	public void testConsultaUsuarioProspect() {
		when(produtoWebService.consultaProdutosProspect(CPF_CLIENTE_ARENA)).thenReturn(produtosProspectConquista);

		Mockito.when(usuarioPortalClienteService.consultaPorCpfCnpj(CPF_CLIENTE_ARENA)).thenReturn(usuarioPortalCliente);

		prospectService.consultaProspect(CPF_CLIENTE_ARENA).doOnError(error -> {
			UsuarioPortalException error1 = (UsuarioPortalException) error;
			assertEquals(404, error1.getStatusCode());
			assertEquals("Usuário não encontrado.", error1.getMessage());
		}).subscribe();

		verify(produtoWebService, times(1)).consultaProdutosProspect(CPF_CLIENTE_ARENA);
	}

	@Test
	public void testReativarContaProspectSucesso() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(2L);

		UsuarioStatusConta usuarioStatusConta = new UsuarioStatusConta();
		usuarioStatusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());

		usuarioPortalCliente.setNumCelular(974220722L);
		usuarioPortalCliente.setNumDddCelular(11L);
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);

		usuarioPortalCliente.setTipoUsuario(tipoUsuario);
		usuarioPortalCliente.setStatusUsuario(usuarioStatusConta);

		Mockito.when(usuarioPortalClienteService.consultaPorCpfCnpj(CPF_CLIENTE_ARENA)).thenReturn(usuarioPortalCliente);
		Mockito.when(produtoWebService.consultaProdutosProspect(CPF_CLIENTE_ARENA))
				.thenReturn(produtosProspectConquista);
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortalCliente)).thenReturn(usuarioPortalCliente);
		Mockito.when(tipoUsuarioRepository.findByIdTipoUsuario(2L)).thenReturn(tipoUsuario);

		CadastroUsuarioProspect usuarioProspect = new CadastroUsuarioProspect("Francisco", "francisco@email.com",
				"85987563349");

		prospectService.cadastrarProspect(CPF_CLIENTE_ARENA, usuarioProspect).map(result -> {
			Assert.assertTrue("Prospect cadastrado com sucesso.", result);
			return result;
		}).subscribe();

		Mockito.when(usuarioPortalClienteService.consultaPorCpfCnpj(CPF_CLIENTE_ARENA)).thenReturn(usuarioPortalCliente);
		Mockito.verify(produtoWebService, Mockito.times(1)).consultaProdutosProspect(CPF_CLIENTE_ARENA);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(2)).save(usuarioPortalCliente);
		Mockito.verify(tipoUsuarioRepository, Mockito.times(1)).findByIdTipoUsuario(2L);
	}

	@Test
	public void testCriarContaProspectSucesso() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(2L);

		UsuarioStatusConta usuarioStatusConta = new UsuarioStatusConta();
		usuarioStatusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());

		usuarioPortalCliente.setTipoUsuario(tipoUsuario);
		usuarioPortalCliente.setStatusUsuario(usuarioStatusConta);
		usuarioPortalCliente.setNumDddCelular(85L);
		usuarioPortalCliente.setNumCelular(987563349L);
		usuarioPortalCliente.setQtdTentativaLogin(0L);
		usuarioPortalCliente.setQuantidadeTentativaCriacaoConta(0L);
		usuarioPortalCliente.setDescEmail("francisco@email.com");
		usuarioPortalCliente.setCodTipoPessoa("F");
		usuarioPortalCliente.setCnpjCpfDigito(24L);
		usuarioPortalCliente.setCnpjCpf(374884998L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setStatusUsuario(usuarioStatusConta);
		usuarioPortalCliente.setNomeUsuarioPortal("Francisco");

		Mockito.when(usuarioPortalClienteService.consultaPorCpfCnpj(CPF_CLIENTE_ARENA)).thenReturn(usuarioPortalCliente);
		Mockito.when(produtoWebService.consultaProdutosProspect(CPF_CLIENTE_ARENA))
				.thenReturn(produtosProspectConquista);
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortalCliente)).thenReturn(usuarioPortalCliente);
		Mockito.when(tipoUsuarioRepository.findByIdTipoUsuario(2L)).thenReturn(tipoUsuario);

		CadastroUsuarioProspect usuarioProspect = new CadastroUsuarioProspect("Francisco", "francisco@email.com",
				"85987563349");

		prospectService.cadastrarProspect(CPF_CLIENTE_ARENA, usuarioProspect).map(result -> {
			Assert.assertTrue("Prospect cadastrado com sucesso.", result);
			return result;
		}).subscribe();

		Mockito.verify(produtoWebService, Mockito.times(1)).consultaProdutosProspect(CPF_CLIENTE_ARENA);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(2)).save(usuarioPortalCliente);
		Mockito.verify(tipoUsuarioRepository, Mockito.times(1)).findByIdTipoUsuario(2L);
	}
	
	@Test
	public void testeAplicaRegraProspectCliente() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(4L);

		Mockito.when(tipoUsuarioRepository.findByIdTipoUsuario(4L)).thenReturn(tipoUsuario);
		TipoUsuario retorno = this.prospectService.aplicaRegraProspect(produtosCliente);

		Assert.assertNotNull(tipoUsuario);
		Assert.assertEquals(tipoUsuario.getIdTipoUsuario(), retorno.getIdTipoUsuario());
	}

	@Test
	public void testeAplicaRegraProspectExCliente() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(3L);

		Mockito.when(tipoUsuarioRepository.findByIdTipoUsuario(3L)).thenReturn(tipoUsuario);
		TipoUsuario retorno = this.prospectService.aplicaRegraProspect(produtosExCliente);

		Assert.assertNotNull(tipoUsuario);
		Assert.assertEquals(tipoUsuario.getIdTipoUsuario(), retorno.getIdTipoUsuario());
	}

	@Test
	public void testeAplicaRegraProspectBCCPF() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(5L);

		Mockito.when(tipoUsuarioRepository.findByIdTipoUsuario(5L)).thenReturn(tipoUsuario);
		TipoUsuario retorno = this.prospectService.aplicaRegraProspect(produtosBCCPF);

		Assert.assertNotNull(tipoUsuario);
		Assert.assertEquals(tipoUsuario.getIdTipoUsuario(), retorno.getIdTipoUsuario());
	}
	
	@Test
	public void testeAplicaRegraProspectBCCPJ() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(5L);

		Mockito.when(tipoUsuarioRepository.findByIdTipoUsuario(5L)).thenReturn(tipoUsuario);
		TipoUsuario retorno = this.prospectService.aplicaRegraProspect(produtosBCCPJ);

		Assert.assertNotNull(tipoUsuario);
		Assert.assertEquals(tipoUsuario.getIdTipoUsuario(), retorno.getIdTipoUsuario());
	}

	@Test
	public void testeAplicaRegraProspectConquista() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(2L);

		Mockito.when(tipoUsuarioRepository.findByIdTipoUsuario(2L)).thenReturn(tipoUsuario);
		TipoUsuario retorno = this.prospectService.aplicaRegraProspect(produtosProspectConquista);

		Assert.assertNotNull(tipoUsuario);
		Assert.assertEquals(tipoUsuario.getIdTipoUsuario(), retorno.getIdTipoUsuario());
	}

	@Test
	public void testeAplicaRegraProspectVDO() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(1L);

		Mockito.when(tipoUsuarioRepository.findByIdTipoUsuario(1L)).thenReturn(tipoUsuario);
		TipoUsuario retorno = this.prospectService.aplicaRegraProspect(produtosProspectVDO);

		Assert.assertNotNull(tipoUsuario);
		Assert.assertEquals(tipoUsuario.getIdTipoUsuario(), retorno.getIdTipoUsuario());
	}

	@Test
	public void testeAplicaRegraSemRelacionamento() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(0L);

		TipoUsuario retorno = this.prospectService.aplicaRegraProspect(produtosSemRelacionamento);

		Assert.assertNotNull(tipoUsuario);
		Assert.assertEquals(tipoUsuario.getIdTipoUsuario(), retorno.getIdTipoUsuario());
	}

}
