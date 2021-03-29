package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import com.porto.portocom.portal.cliente.entity.TipoUsuario;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.EnderecosEletronicos;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Fisica;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Pessoa;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Telefones;
import com.porto.portocom.portal.cliente.v1.dto.conquista.IsClienteArenaCadastrado;
import com.porto.portocom.portal.cliente.v1.dto.vdo.CotacoesVendaOnline;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.model.TelefoneEmailVO;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.service.ILogPortalClienteService;
import com.porto.portocom.portal.cliente.v1.service.IProspectService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalClienteService;
import com.porto.portocom.portal.cliente.v1.service.MensagemLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.UsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.vo.bcc.EnderecoEletronico;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPF;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPJ;
import com.porto.portocom.portal.cliente.v1.vo.bcc.Telefone;
import com.porto.portocom.portal.cliente.v1.vo.bcc.TipoLinhaTelefonica;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect.ConsultaProdutosProspectBuilder;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioPortalServiceUnitTest {

	@Mock
	private IUsuarioPortalClienteRepository usuarioPortalClienteRepository;

	@Mock
	private IUsuarioStatusContaRepository usuarioStatusContaRepository;

	@Mock
	private ParametrosLocalCacheService parametrosLocalCacheService;

	@Mock
	private MensagemLocalCacheService mensagemLocalCacheService;

	@Mock
	private IProspectService prospectService;

	@Mock
	private ILogPortalClienteService logPortalClienteService;
	
	@Mock
	private IUsuarioPortalClienteService usuarioPortalClienteService;
	
	@Mock
	private LexisNexisUtils lexisNexisUtils;

	@Spy
	@InjectMocks
	private UsuarioPortalService usuarioPortalService;

	private Optional<UsuarioPortalCliente> usuarioPortalCliente;

	private UsuarioPortalCliente usrPortal;

	private ConsultaProdutosProspect produtosClienteExCliente;

	private ConsultaProdutosProspect produtosProspectConquista;

	private ConsultaProdutosProspect produtosProspectVDO;

	private ConsultaProdutosProspect produtosProspectBCCPF;

	private ConsultaProdutosProspect produtosProspectBCCPJ;

	private static final String CPF_PADRAO = "37488499824";

	private static final String CNPJ_PADRAO = "61198164000160";
	
	private static final String LEXIS_BASE64_TEST = "eyJzZXNzaW9uSWQiOiI3OGVkMWFkZS01YzU3LTQ1ZTEtYmI2Yl8xMjM0NTY3ODkwIiwicmVxdWVzdElkIjoiIiwib3JnYW5pemF0aW9uSWQiOiI2dDR4dWdrciIsInZhbGlkYXRpb24iOiIiLCJpcEFkZHJlc3MiOiIyMDEuNDkuMzUuMjUwIn0=";

	private static UsuarioPortalCliente usuarioPortal;
	
	private static Pessoa pessoaBcp;
	
	@Before
	public void init() throws DatatypeConfigurationException {
		MockitoAnnotations.initMocks(this);
		usrPortal = new UsuarioPortalCliente();
		usrPortal.setDescEmail("email@email.com");
		usrPortal.setIdUsuario(1222L);
		usrPortal.setNomeUsuarioPortal("Emerson");
		usrPortal.setNumDddCelular(84L);
		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus());
		usrPortal.setStatusUsuario(statusConta);
		usuarioPortalCliente = Optional.of(usrPortal);
		criaProdutosClienteExCliente();
		criaProdutosProspectConquista();
		criaProdutosProspectVDO();
		criaProdutosProspectBCCPF();
		criaProdutosProspectBCCPJ();
		criaPessoaBcp();
		
		MDC.put(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor(), "texto0");
		MDC.put(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), LEXIS_BASE64_TEST);

		Mockito.when(this.lexisNexisUtils.verificaFlagLexis()).thenReturn(true);
	}

	private void criaProdutosClienteExCliente() {
		PessoaBcp.Pessoa pessoa = new PessoaBcp.Pessoa();
		pessoa.setNomePessoa("Teste");
		pessoa.setCodigoTipoPessoa("F");

		ConsultaProdutosProspectBuilder produtosProspectsBuilder = ConsultaProdutosProspect.builder();
		produtosProspectsBuilder.contratosBcp(null);
		produtosProspectsBuilder.cotacoesVendaOnline(null);
		produtosProspectsBuilder.pessoasBcp(Arrays.asList(pessoa));
		produtosProspectsBuilder.isClienteArenaCadastrado(null);

		produtosClienteExCliente = produtosProspectsBuilder.build();
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
		CotacoesVendaOnline cotacoes = new CotacoesVendaOnline();

		ConsultaProdutosProspectBuilder produtosProspectsBuilder = ConsultaProdutosProspect.builder();
		produtosProspectsBuilder.contratosBcp(null);
		produtosProspectsBuilder.cotacoesVendaOnline(cotacoes);
		produtosProspectsBuilder.pessoasBcp(null);
		produtosProspectsBuilder.isClienteArenaCadastrado(null);

		produtosProspectVDO = produtosProspectsBuilder.build();
	}

	private void criaProdutosProspectBCCPF() {
		PessoaBccPJ pessoaBccPj = new PessoaBccPJ();
		PessoaBccPF pessoaBccPf = new PessoaBccPF();
		pessoaBccPf.setPessoas(Arrays.asList(new PessoaBccPF.Pessoa()));

		ConsultaProdutosProspectBuilder produtosProspectsBuilder = ConsultaProdutosProspect.builder();
		produtosProspectsBuilder.contratosBcp(null);
		produtosProspectsBuilder.cotacoesVendaOnline(null);
		produtosProspectsBuilder.pessoasBcp(null);
		produtosProspectsBuilder.isClienteArenaCadastrado(null);
		produtosProspectsBuilder.pessoaBccPj(null);
		produtosProspectsBuilder.pessoaBccPj(pessoaBccPj);
		produtosProspectsBuilder.pessoaBccPf(pessoaBccPf);

		produtosProspectBCCPF = produtosProspectsBuilder.build();
	}

	private void criaProdutosProspectBCCPJ() {
		PessoaBccPF pessoaBccPf = new PessoaBccPF();
		PessoaBccPJ pessoaBccPj = new PessoaBccPJ();
		pessoaBccPj.setPessoas(Arrays.asList(new PessoaBccPJ.Pessoa()));

		ConsultaProdutosProspectBuilder produtosProspectsBuilder = ConsultaProdutosProspect.builder();
		produtosProspectsBuilder.contratosBcp(null);
		produtosProspectsBuilder.cotacoesVendaOnline(null);
		produtosProspectsBuilder.pessoasBcp(null);
		produtosProspectsBuilder.isClienteArenaCadastrado(null);
		produtosProspectsBuilder.pessoaBccPf(pessoaBccPf);
		produtosProspectsBuilder.pessoaBccPj(pessoaBccPj);

		produtosProspectBCCPJ = produtosProspectsBuilder.build();
	}
	
	public void criaPessoaBcp() throws DatatypeConfigurationException {
		
		EnderecosEletronicos enderecoEletronico = new EnderecosEletronicos();
		enderecoEletronico.setEnderecoEletronico("endereco@eletronico.com");
		List<EnderecosEletronicos> listEndereco = new ArrayList<>();
		listEndereco.add(enderecoEletronico);

		Telefones telefones = new Telefones();
		telefones.setCodigoDdd((short) 71);
		telefones.setNumeroTelefone((long) 99999999);
		List<Telefones> listTel = new ArrayList<>();
		listTel.add(telefones);
		
		Fisica fisica = new Fisica();		
		fisica.setDataNascimento( DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
		
		Pessoa pessoaBcpBuilder = new Pessoa();
		pessoaBcpBuilder.setTelefones(listTel);
		pessoaBcpBuilder.setNomePessoa("Emerson Pedro");
		pessoaBcpBuilder.setEnderecosEletronicos(listEndereco);	
		pessoaBcpBuilder.setFisica(fisica);		
		pessoaBcp = pessoaBcpBuilder;

	}

	@Test
	public void testDesvincularUsuarioSucesso() {

		Mockito.when(this.usuarioPortalClienteRepository.findById(1222L)).thenReturn(this.usuarioPortalCliente);
		this.usuarioPortalService.consultarUsuarioPorId(1222L).map(usuarioPortalCliente -> {
			System.out.println(usuarioPortalCliente.getNomeUsuarioPortal());
			assertEquals("testDesvincularUsuarioSucesso", "Emerson", usuarioPortalCliente.getNomeUsuarioPortal());
			return usuarioPortalCliente;
		}).subscribe();
	}

	@Test
	public void testConsultarCpfInvalido() {
		String msgErro = "Cpf Invalido";
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_VALIDACAO_CPF_CNPJ.getValor())).thenReturn(msgErro);
		this.usuarioPortalService.consultar("123").onErrorResume(error -> {
			CpfCnpjInvalidoException erro = (CpfCnpjInvalidoException) error;
			assertEquals(msgErro, erro.getMessage());
			return Mono.empty();
		}).subscribe();
	}

	@Test
	public void testDesvincularUsuarioNulo() {
		String msgErro = "Usuario Invalido";
		Mockito.when(this.usuarioPortalClienteRepository.findById(1222L)).thenReturn(Optional.empty());
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()))
				.thenReturn(msgErro);

		this.usuarioPortalService.consultarUsuarioPorId(1222L).onErrorResume(error -> {
			ResponseStatusException erro = (ResponseStatusException) error;
			assertEquals(msgErro, erro.getMessage());
			return Mono.empty();
		});
	}

	private void preparaBloqueioTentativas() {
		usrPortal.setQtdTentativaLogin(2L);
		usrPortal.setQuantidadeTentativaCriacaoConta(2L);
		usrPortal.setQuantidadeTentativasRecuperacaoConta(2L);


		Mockito.when(this.usuarioPortalClienteService.consultaPorCpfCnpj(CPF_PADRAO)).thenReturn(this.usrPortal);

		Mockito.when(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_LOGIN.getValor())).thenReturn("3");

		Mockito.when(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_CRIACAO_CONTA.getValor()))
				.thenReturn("3");

		Mockito.when(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_RECUPERACAO.getValor())).thenReturn("3");

	}

	@Test
	public void testBloqueiTentativasDeAcesso() {
		this.preparaBloqueioTentativas();
		Mockito.when(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_LOGIN.getValor())).thenReturn("1");

		UsuarioStatusConta usuarioStatusConta = new UsuarioStatusConta();
		usuarioStatusConta
				.setDescricaoStatusConta(StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_ACESSO.toString());
		usuarioStatusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_ACESSO.getCodStatus());

		Mockito.when(this.usuarioStatusContaRepository
				.findByIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_ACESSO.getCodStatus()))
				.thenReturn(usuarioStatusConta);

		this.usuarioPortalService.consultaStatus(CPF_PADRAO).map(statusConta -> {
			assertEquals("testBloqueiTentativasDeAcesso",
					StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_ACESSO.toString(),
					statusConta.getDescricaoStatusConta());
			assertEquals("testBloqueiTentativasDeAcesso",
					StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_ACESSO.getCodStatus(),
					statusConta.getIdStatusConta());
			return statusConta;
		}).subscribe();

	}

	@Test
	public void testBloqueioTentativasDeAtivacao() {
		this.preparaBloqueioTentativas();
		Mockito.when(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_CRIACAO_CONTA.getValor()))
				.thenReturn("1");

		UsuarioStatusConta usuarioStatusConta = new UsuarioStatusConta();
		usuarioStatusConta.setDescricaoStatusConta(
				StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_ATIVACAO_CONTA.toString());
		usuarioStatusConta
				.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_ATIVACAO_CONTA.getCodStatus());

		Mockito.when(this.usuarioStatusContaRepository.findByIdStatusConta(
				StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_ATIVACAO_CONTA.getCodStatus()))
				.thenReturn(usuarioStatusConta);

		this.usuarioPortalService.consultaStatus(CPF_PADRAO).map(statusConta -> {
			assertEquals("testBloqueioTentativasDeAtivacao",
					StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_ATIVACAO_CONTA.toString(),
					statusConta.getDescricaoStatusConta());
			assertEquals("testBloqueioTentativasDeAtivacao",
					StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_ATIVACAO_CONTA.getCodStatus(),
					statusConta.getIdStatusConta());
			return statusConta;
		}).subscribe();
	}

	@Test
	public void testBloqueioTentativasDeRecuperacao() {
		this.preparaBloqueioTentativas();
		Mockito.when(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_RECUPERACAO.getValor())).thenReturn("1");

		UsuarioStatusConta usuarioStatusConta = new UsuarioStatusConta();
		usuarioStatusConta.setDescricaoStatusConta(
				StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_RECUPERACAO_CONTA.toString());
		usuarioStatusConta.setIdStatusConta(
				StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_RECUPERACAO_CONTA.getCodStatus());

		Mockito.when(this.usuarioStatusContaRepository.findByIdStatusConta(
				StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_RECUPERACAO_CONTA.getCodStatus()))
				.thenReturn(usuarioStatusConta);

		this.usuarioPortalService.consultaStatus(CPF_PADRAO).map(statusConta -> {
			assertEquals("testBloqueioTentativasDeRecuperacao",
					StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_RECUPERACAO_CONTA.toString(),
					statusConta.getDescricaoStatusConta());
			assertEquals("testBloqueioTentativasDeRecuperacao",
					StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_RECUPERACAO_CONTA.getCodStatus(),
					statusConta.getIdStatusConta());
			return statusConta;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoClienteVazio() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosClienteExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosClienteExCliente)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoExClienteVazio() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.EX_CLIENTE.getCodTipo());

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosClienteExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosClienteExCliente)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoClienteTelefonesVazio() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		produtosClienteExCliente.getPessoasBcp().get(0).setTelefones(new ArrayList<PessoaBcp.Telefones>());

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosClienteExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosClienteExCliente)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			Assert.assertTrue(result.get(0).getCelulares().isEmpty());
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoClienteComTelefone() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		Telefones telefone = new Telefones();
		telefone.setCodigoDdd((short) 11);
		telefone.setNumeroTelefone(99893241L);

		produtosClienteExCliente.getPessoasBcp().get(0).setTelefones(Arrays.asList(telefone));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosClienteExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosClienteExCliente)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			Assert.assertFalse(result.get(0).getCelulares().isEmpty());
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoClienteSemDDD() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		Telefones telefone = new Telefones();
		telefone.setNumeroTelefone(99893241L);

		produtosClienteExCliente.getPessoasBcp().get(0).setTelefones(Arrays.asList(telefone));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosClienteExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosClienteExCliente)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			Assert.assertFalse(result.get(0).getCelulares().isEmpty());
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoClienteSemNumeroTelefone() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		Telefones telefone = new Telefones();
		telefone.setCodigoDdd((short) 11);

		produtosClienteExCliente.getPessoasBcp().get(0).setTelefones(Arrays.asList(telefone));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosClienteExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosClienteExCliente)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			Assert.assertTrue(result.get(0).getCelulares().isEmpty());
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoClienteComEmail() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		EnderecosEletronicos email = new EnderecosEletronicos();
		email.setEnderecoEletronico("renan.lima@portoseguro.com.br");

		produtosClienteExCliente.getPessoasBcp().get(0).setEnderecosEletronicos(Arrays.asList(email));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosClienteExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosClienteExCliente)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			Assert.assertFalse(result.get(0).getEmails().isEmpty());
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoClienteComListEmailsVazio() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		produtosClienteExCliente.getPessoasBcp().get(0)
				.setEnderecosEletronicos(new ArrayList<PessoaBcp.EnderecosEletronicos>());

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosClienteExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosClienteExCliente)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			Assert.assertTrue(result.get(0).getEmails().isEmpty());
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoClienteComEmailInvalido() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		EnderecosEletronicos email = new EnderecosEletronicos();
		email.setEnderecoEletronico("@renan.lima.portoseguro.com.br");

		produtosClienteExCliente.getPessoasBcp().get(0).setEnderecosEletronicos(Arrays.asList(email));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosClienteExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosClienteExCliente)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			Assert.assertFalse(result.get(0).getEmails().isEmpty());
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectConquistaVazio() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_CONQUISTA.getCodTipo());

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosProspectConquista));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectConquista)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectConquistaComTelefone() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_CONQUISTA.getCodTipo());

		Telefones telefone = new Telefones();
		telefone.setCodigoDdd((short) 11);
		telefone.setNumeroTelefone(99893241L);

		produtosProspectConquista.getIsClienteArenaCadastrado().setDddNumeroTelefone(new BigDecimal("11"));
		produtosProspectConquista.getIsClienteArenaCadastrado().setNumeroTelefone("99898032");

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosProspectConquista));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectConquista)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			Assert.assertFalse(result.get(0).getCelulares().isEmpty());
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectVDOVazio() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_VENDA_ONLINE.getCodTipo());

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectVDO));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectVDO)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectVDOComNome() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_VENDA_ONLINE.getCodTipo());

		produtosProspectVDO.getCotacoesVendaOnline().setNomeProponente("Teste");

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectVDO));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectVDO)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectVDOComTelefone() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_VENDA_ONLINE.getCodTipo());

		produtosProspectVDO.getCotacoesVendaOnline().setDddCelular((short) 11);
		produtosProspectVDO.getCotacoesVendaOnline().setNumeroCelular(999894231);

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectVDO));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectVDO)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			Assert.assertFalse(result.get(0).getCelulares().isEmpty());
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectBCCPFComNome() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());
		produtosProspectBCCPF.getPessoaBccPf().getPessoas().get(0).setNomeTratamentoPessoaFisica("Nome teste");

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectBCCPF));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectBCCPF)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectBCCPFVazio() {
		TipoUsuario tipoUsuario = new TipoUsuario();

		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());
		produtosProspectBCCPF.getPessoaBccPf().getPessoas().get(0).setEnderecosEletronicos(null);
		produtosProspectBCCPF.getPessoaBccPf().getPessoas().get(0).setTelefones(null);

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectBCCPF));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectBCCPF)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectBCCPFComTelefone() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());

		Telefone telefone = new Telefone();
		TipoLinhaTelefonica tipoLinhaTelefonica = new TipoLinhaTelefonica();
		tipoLinhaTelefonica.setCodigoTipoLinhaTelefonica((short) 1);
		telefone.setCodigoDDDTelefone((short) 11);
		telefone.setNumeroTelefone(99893241L);
		telefone.setTipoLinhaTelefonica(tipoLinhaTelefonica);

		produtosProspectBCCPF.getPessoaBccPf().getPessoas().get(0).setTelefones(Arrays.asList(telefone));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectBCCPF));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectBCCPF)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectBCCPFComEmail() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());

		EnderecoEletronico email = new EnderecoEletronico();
		email.setTextoEnderecoEletronico("francisco.pereira@portoseguro.com.br");

		produtosProspectBCCPF.getPessoaBccPf().getPessoas().get(0).setEnderecosEletronicos(Arrays.asList(email));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectBCCPF));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectBCCPF)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectBCCPJVazio() {
		TipoUsuario tipoUsuario = new TipoUsuario();

		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());
		produtosProspectBCCPJ.getPessoaBccPj().getPessoas().get(0).setEnderecosEletronicos(null);
		produtosProspectBCCPJ.getPessoaBccPj().getPessoas().get(0).setTelefones(null);

		Mockito.when(prospectService.consultaProdutosProspect(CNPJ_PADRAO))
				.thenReturn(Mono.just(produtosProspectBCCPJ));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectBCCPJ)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CNPJ_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectBCCPJComNome() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());
		produtosProspectBCCPJ.getPessoaBccPj().getPessoas().get(0).setNomeLegalPessoa("Empresa Teste");

		Mockito.when(prospectService.consultaProdutosProspect(CNPJ_PADRAO))
				.thenReturn(Mono.just(produtosProspectBCCPJ));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectBCCPJ)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CNPJ_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectBCCPJComTelefone() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());

		TipoLinhaTelefonica tipoLinhaTelefonica = new TipoLinhaTelefonica();
		tipoLinhaTelefonica.setCodigoTipoLinhaTelefonica((short) 1);
		Telefone telefone = new Telefone();
		telefone.setCodigoDDDTelefone((short) 11);
		telefone.setNumeroTelefone(99893241L);
		telefone.setTipoLinhaTelefonica(tipoLinhaTelefonica);

		produtosProspectBCCPJ.getPessoaBccPj().getPessoas().get(0).setTelefones(Arrays.asList(telefone));

		Mockito.when(prospectService.consultaProdutosProspect(CNPJ_PADRAO))
				.thenReturn(Mono.just(produtosProspectBCCPJ));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectBCCPJ)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CNPJ_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoProspectBCCPJComEmail() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());

		EnderecoEletronico email = new EnderecoEletronico();
		email.setTextoEnderecoEletronico("francisco.pereira@portoseguro.com.br");

		produtosProspectBCCPJ.getPessoaBccPj().getPessoas().get(0).setEnderecosEletronicos(Arrays.asList(email));

		Mockito.when(prospectService.consultaProdutosProspect(CNPJ_PADRAO))
				.thenReturn(Mono.just(produtosProspectBCCPJ));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectBCCPJ)).thenReturn(tipoUsuario);

		this.usuarioPortalService.consultaUsuarioSimplificado(CNPJ_PADRAO, null).map(result -> {
			Assert.assertNotNull(result);
			return result;
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoCpfInvalido() {

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor()))
				.thenReturn("Revise os caracteres digitados e tente de novo ou acesse ‘esqueci minha senha’.");

		this.usuarioPortalService.consultaUsuarioSimplificado("1", null).doOnError(erro -> {
			CpfCnpjInvalidoException error = (CpfCnpjInvalidoException) erro;
			assertEquals("Revise os caracteres digitados e tente de novo ou acesse ‘esqueci minha senha’.",
					error.getMessage());
		}).subscribe();
	}

	@Test
	public void testconsultaUsuarioSimplificadoSemRelacionamento() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(0L);

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectVDO));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectVDO)).thenReturn(tipoUsuario);
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()))
				.thenReturn("Crie uma conta para acessar a Área do Cliente.");

		this.usuarioPortalService.consultaUsuarioSimplificado(CPF_PADRAO, null).doOnError(erro -> {
			UsuarioPortalException error = (UsuarioPortalException) erro;
			assertEquals("Crie uma conta para acessar a Área do Cliente.", error.getMessage());
			assertEquals(404, error.getStatusCode());
		}).subscribe();
	}

	@Test
	public void testeConsultaUsuarioSimplificadoRecuperacaoSucesso() {

		Mockito.when(usuarioPortalClienteService.consultaPorCpfCnpj(CPF_PADRAO)).thenReturn(usrPortal);

		usuarioPortalService.consultaUsuarioSimplificadoRecuperacao(CPF_PADRAO).map(usuarioSimplificado -> {
			assertEquals("Emerson", usuarioSimplificado.get(0).getNome());
			assertTrue(usuarioSimplificado.size() == 1);
			return usuarioSimplificado;
		}).subscribe();

		Mockito.verify(usuarioPortalClienteService, Mockito.times(1)).consultaPorCpfCnpj(CPF_PADRAO);
	}

	@Test
	public void testeConsultaUsuarioSimplificadoRecuperacaoUsuarioNElegivel() {

		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());
		usrPortal.setStatusUsuario(statusConta);
		Mockito.when(usuarioPortalClienteService.consultaPorCpfCnpj(CPF_PADRAO)).thenReturn(usrPortal);

		usuarioPortalService.consultaUsuarioSimplificadoRecuperacao(CPF_PADRAO).onErrorResume(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertEquals(MensagemUsuarioEnum.USUARIO_INELEGIVEL_RECUPERACAO.getValor(), erro.getMessage());
			assertEquals(HttpStatus.BAD_REQUEST.value(), erro.getStatusCode());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalClienteService, Mockito.times(1)).consultaPorCpfCnpj(CPF_PADRAO);
	}

	@Test
	public void testeConsultaUsuarioSimplificadoRecuperacaoUsuarioNEncontrado() {

		String msgErro = "Crie uma conta para acessar a Área do Cliente.";

		Mockito.when(usuarioPortalClienteService.consultaPorCpfCnpj(CPF_PADRAO)).thenReturn(null);
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()))
				.thenReturn(msgErro);

		usuarioPortalService.consultaUsuarioSimplificadoRecuperacao(CPF_PADRAO).onErrorResume(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertEquals(msgErro, erro.getMessage());
			assertEquals(HttpStatus.NOT_FOUND.value(), erro.getStatusCode());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalClienteService, Mockito.times(1)).consultaPorCpfCnpj(CPF_PADRAO);
		Mockito.verify(mensagemLocalCacheService, Mockito.times(1))
				.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor());
	}

	@Test
	public void testeConsultaStatusUsuarioNEncontrado() {

		String msgErro = "Crie uma conta para acessar a Área do Cliente.";

		Mockito.when(usuarioPortalClienteService.consultaPorCpfCnpj(CPF_PADRAO)).thenReturn(null);
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor()))
				.thenReturn(msgErro);

		usuarioPortalService.consultaStatus(CPF_PADRAO).onErrorResume(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertEquals(msgErro, erro.getMessage());
			assertEquals(HttpStatus.NOT_FOUND.value(), erro.getStatusCode());
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalClienteService, Mockito.times(1)).consultaPorCpfCnpj(CPF_PADRAO);
		Mockito.verify(mensagemLocalCacheService, Mockito.times(1))
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor());
	}

	@Test
	public void testeConsultaStatusRetornoStatusSucesso() {

		usrPortal.setQtdTentativaLogin(1L);
		usrPortal.setQuantidadeTentativaCriacaoConta(1L);
		usrPortal.setQuantidadeTentativasRecuperacaoConta(1L);

		Mockito.when(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_LOGIN.getValor())).thenReturn("2");
		Mockito.when(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_CRIACAO_CONTA.getValor()))
				.thenReturn("2");
		Mockito.when(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_RECUPERACAO.getValor())).thenReturn("2");

		Mockito.when(usuarioPortalClienteService.consultaPorCpfCnpj(CPF_PADRAO)).thenReturn(usrPortal);
		usuarioPortalService.consultaStatus(CPF_PADRAO).map(status -> {
			assertEquals(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus(),
					status.getIdStatusConta());
			return status;
		}).subscribe();

	}

	@Test
	public void testeSalvarusuarioSucesso() {

		Mockito.when(usuarioPortalClienteRepository.save(usrPortal)).thenReturn(usrPortal);
		usuarioPortalService.salvar(usrPortal).map(usuario -> {
			assertNotNull(usuario);
			assertEquals(usrPortal.toString(), usuario.toString());
			return usuario;
		}).subscribe();

		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(usrPortal);
	}

	@Test
	public void testeDadosAcessoSucesso() {

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(1L);
		usuarioPortalCliente.setDescEmail("test@portoseguro.com.br");
		usuarioPortalCliente.setNumDddCelular(85L);
		usuarioPortalCliente.setNumCelular(999189621L);
		usuarioPortalCliente.setDataCadastro(new Date());

		Mockito.when(usuarioPortalClienteService.consultaPorCpfCnpj(CPF_PADRAO)).thenReturn(usuarioPortalCliente);
		Mockito.when(logPortalClienteService.getMaxCelularLogData(usuarioPortalCliente.getIdUsuario()))
				.thenReturn(LocalDateTime.now());
		Mockito.when(logPortalClienteService.getMaxEmailLogData(usuarioPortalCliente.getIdUsuario()))
				.thenReturn(LocalDateTime.now());

		usuarioPortalService.consultarDadosAcesso(CPF_PADRAO).map(usuario -> {
			assertNotNull(usuario);
			assertEquals(usuarioPortalCliente.getDescEmail(), "test@portoseguro.com.br");
			return usuario;
		}).subscribe();

		Mockito.verify(usuarioPortalClienteService, Mockito.times(1)).consultaPorCpfCnpj(CPF_PADRAO);
	}

	@Test
	public void testeDadosAcessoEmpty() {
		Mockito.when(usuarioPortalClienteService.consultaPorCpfCnpj("22890390802")).thenReturn(null);
		usuarioPortalService.consultarDadosAcesso("22890390802").onErrorResume(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertEquals(HttpStatus.NOT_FOUND.value(), erro.getStatusCode());
			return Mono.empty();
		}).subscribe();
		Mockito.verify(usuarioPortalClienteService, Mockito.times(1)).consultaPorCpfCnpj("22890390802");
	}

	

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisStatusFalha02() {

		usuarioPortal = new UsuarioPortalCliente();
		usuarioPortal.setIdUsuario(1222L);
		usuarioPortal.setCnpjCpf(374884998L);
		usuarioPortal.setCnpjOrdem(0L);
		usuarioPortal.setCnpjCpfDigito(24L);
		usuarioPortal.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortal.setNomeUsuarioPortal("Emerson");

		UsuarioStatusConta statusUsuarioConta = new UsuarioStatusConta();
		statusUsuarioConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuarioConta);

			Mockito.when(usuarioPortalClienteService.consultaPorCpfCnpj(CPF_PADRAO)).thenReturn(usuarioPortal);

		usuarioPortalService.consultar(CPF_PADRAO).map(usuarioPortalCliente -> {

			assertFalse(usuarioPortalCliente.getStatusUsuario().getIdStatusConta()
					.equals(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus()));
			assertFalse(usuarioPortalCliente.getStatusUsuario().getIdStatusConta()
					.equals(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus()));
			assertFalse(usuarioPortalCliente.getStatusUsuario().getIdStatusConta()
					.equals(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus()));
			assertNotNull(usuarioPortalCliente);

			return usuarioPortalCliente;
		}).subscribe();
		Mockito.verify(usuarioPortalClienteService, Mockito.times(1)).consultaPorCpfCnpj(CPF_PADRAO);

	}

	@Test
	public void testeObtemPessoaBccPfSucesso() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());

		Telefone telefone = new Telefone();
		TipoLinhaTelefonica tipoLinhaTelefonica = new TipoLinhaTelefonica();
		tipoLinhaTelefonica.setCodigoTipoLinhaTelefonica((short) 1);
		telefone.setCodigoDDDTelefone((short) 11);
		telefone.setNumeroTelefone(99893241L);
		telefone.setTipoLinhaTelefonica(tipoLinhaTelefonica);

		produtosProspectBCCPF.getPessoaBccPf().getPessoas().get(0).setTelefones(Arrays.asList(telefone));
		produtosProspectBCCPF.getPessoaBccPf().getPessoas().get(0).setDataNascimentoPessoaFisica("1995-10-11");

		PessoaBccPF.Pessoa pessoa = produtosProspectBCCPF.getPessoaBccPf().getPessoas().get(0);

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectBCCPF));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectBCCPF)).thenReturn(tipoUsuario);
		Mockito.when(
				usuarioPortalService.obtemEmailETelefoneBCC(pessoa.getTelefones(), pessoa.getEnderecosEletronicos()))
				.thenReturn(new TelefoneEmailVO());

		usuarioPortalService.obtemPessoaPorProdutos(produtosProspectBCCPF, CPF_PADRAO).flatMap(pessoaVo -> {
			Assert.assertNotNull(pessoaVo);
			Assert.assertNotNull(pessoaVo.getDataNascimento().toString());
			return Mono.just(pessoaVo);
		}).subscribe();

	}

	@Test
	public void testeObtemPessoaBccPfSemPjSucesso() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());

		Telefone telefone = new Telefone();
		TipoLinhaTelefonica tipoLinhaTelefonica = new TipoLinhaTelefonica();
		tipoLinhaTelefonica.setCodigoTipoLinhaTelefonica((short) 1);
		telefone.setCodigoDDDTelefone((short) 11);
		telefone.setNumeroTelefone(99893241L);
		telefone.setTipoLinhaTelefonica(tipoLinhaTelefonica);

		produtosProspectBCCPF.getPessoaBccPf().getPessoas().get(0).setTelefones(Arrays.asList(telefone));
		produtosProspectBCCPF.getPessoaBccPj().setPessoas(null);

		PessoaBccPF.Pessoa pessoa = produtosProspectBCCPF.getPessoaBccPf().getPessoas().get(0);

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectBCCPF));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectBCCPF)).thenReturn(tipoUsuario);
		Mockito.when(
				usuarioPortalService.obtemEmailETelefoneBCC(pessoa.getTelefones(), pessoa.getEnderecosEletronicos()))
				.thenReturn(new TelefoneEmailVO());

		usuarioPortalService.obtemPessoaPorProdutos(produtosProspectBCCPF, CPF_PADRAO).flatMap(pessoaVo -> {
			Assert.assertNotNull(pessoaVo);
			return Mono.just(pessoaVo);
		}).subscribe();

	}

	@Test
	public void testeObtemPessoaBccPjSucesso() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());

		Telefone telefone = new Telefone();
		TipoLinhaTelefonica tipoLinhaTelefonica = new TipoLinhaTelefonica();
		tipoLinhaTelefonica.setCodigoTipoLinhaTelefonica((short) 1);
		telefone.setCodigoDDDTelefone((short) 11);
		telefone.setNumeroTelefone(99893241L);
		telefone.setTipoLinhaTelefonica(tipoLinhaTelefonica);

		produtosProspectBCCPJ.getPessoaBccPj().getPessoas().get(0).setTelefones(Arrays.asList(telefone));

		PessoaBccPJ.Pessoa pessoa = produtosProspectBCCPJ.getPessoaBccPj().getPessoas().get(0);

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectBCCPJ));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectBCCPJ)).thenReturn(tipoUsuario);
		Mockito.when(
				usuarioPortalService.obtemEmailETelefoneBCC(pessoa.getTelefones(), pessoa.getEnderecosEletronicos()))
				.thenReturn(new TelefoneEmailVO());

		usuarioPortalService.obtemPessoaPorProdutos(produtosProspectBCCPJ, CPF_PADRAO).flatMap(pessoaVo -> {
			Assert.assertNotNull(pessoaVo);
			Assert.assertNull(pessoaVo.getDataNascimento());
			Assert.assertEquals(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo(),
					pessoaVo.getTipoUsuario().getIdTipoUsuario());
			return Mono.just(pessoaVo);
		}).subscribe();

	}

	@Test
	public void testeObtemPessoaBcpSucesso() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		produtosClienteExCliente.getPessoasBcp().get(0).setNomeTratamento("Emerson");

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosClienteExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosClienteExCliente)).thenReturn(tipoUsuario);
		Mockito.when(usuarioPortalService.obtemClienteTitular(produtosClienteExCliente.getPessoasBcp()))
				.thenReturn(Mono.just(pessoaBcp));

		usuarioPortalService.obtemPessoaPorProdutos(produtosClienteExCliente, CPF_PADRAO).flatMap(pessoaVo -> {
			Assert.assertNotNull(pessoaVo);
			Assert.assertNotNull(pessoaVo.getTelefones());
			Assert.assertNotNull(pessoaVo.getDataNascimento());
			Assert.assertNotNull(pessoaVo.getEmails().get(0).toString());
			Assert.assertNotNull(pessoaVo.getTelefones().get(0).getNumeroTelefone());
			Assert.assertTrue(pessoaVo.getTelefones().get(0).getDdd().equals("71"));
			Assert.assertTrue(pessoaVo.getEmails().get(0).toString().equals("endereco@eletronico.com"));
			Assert.assertTrue(pessoaVo.getTelefones().get(0).getNumeroTelefone().equals("99999999"));
			Assert.assertEquals(TipoUsuarioEnum.CLIENTE.getCodTipo(), pessoaVo.getTipoUsuario().getIdTipoUsuario());
			return Mono.just(pessoaVo);
		}).subscribe();

	}

	@Test
	public void testeObtemPessoaBcpSemDataNascimentoSucesso() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		produtosClienteExCliente.getPessoasBcp().get(0).setNomeTratamento("Emerson");
		pessoaBcp.setEnderecosEletronicos(null);
		pessoaBcp.getFisica().setDataNascimento(null);

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosClienteExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosClienteExCliente)).thenReturn(tipoUsuario);
		Mockito.when(usuarioPortalService.obtemClienteTitular(produtosClienteExCliente.getPessoasBcp()))
				.thenReturn(Mono.just(pessoaBcp));

		usuarioPortalService.obtemPessoaPorProdutos(produtosClienteExCliente, CPF_PADRAO).flatMap(pessoaVo -> {
			Assert.assertNull(pessoaVo.getEmails());
			Assert.assertNull(pessoaVo.getDataNascimento());
			Assert.assertNotNull(pessoaVo);
			Assert.assertNotNull(pessoaVo.getTelefones());
			Assert.assertNotNull(pessoaVo.getTelefones().get(0).getNumeroTelefone());
			Assert.assertTrue(pessoaVo.getTelefones().get(0).getDdd().equals("71"));
			Assert.assertTrue(pessoaVo.getTelefones().get(0).getNumeroTelefone().equals("99999999"));
			Assert.assertEquals(TipoUsuarioEnum.CLIENTE.getCodTipo(), pessoaVo.getTipoUsuario().getIdTipoUsuario());
			return Mono.just(pessoaVo);
		}).subscribe();

	}

	@Test
	public void testeObtemPessoaPorProdutosConquistaSucesso() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_CONQUISTA.getCodTipo());

		Telefones telefone = new Telefones();
		telefone.setCodigoDdd((short) 11);
		telefone.setNumeroTelefone(99893241L);

		produtosProspectConquista.getIsClienteArenaCadastrado().setDddNumeroTelefone(new BigDecimal("11"));
		produtosProspectConquista.getIsClienteArenaCadastrado().setNumeroTelefone("99898032");

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosProspectConquista));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectConquista)).thenReturn(tipoUsuario);

		usuarioPortalService.obtemPessoaPorProdutos(produtosProspectConquista, CPF_PADRAO).flatMap(pessoaVo -> {
			Assert.assertNull(pessoaVo.getEmails());
			Assert.assertNull(pessoaVo.getDataNascimento());
			Assert.assertNotNull(pessoaVo);
			Assert.assertNotNull(pessoaVo.getTelefones());
			Assert.assertTrue(pessoaVo.getTelefones().get(0).getDdd().equals("11"));
			Assert.assertTrue(pessoaVo.getTelefones().get(0).getNumeroTelefone().equals("99898032"));
			return Mono.just(pessoaVo);
		}).subscribe();

	}

	@Test
	public void testeObtemPessoaPorProdutosConquistaDataNascimentoAtualizadaSucesso() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_CONQUISTA.getCodTipo());

		Telefones telefone = new Telefones();
		telefone.setCodigoDdd((short) 11);
		telefone.setNumeroTelefone(99893241L);

		produtosProspectConquista.getIsClienteArenaCadastrado().setDddNumeroTelefone(new BigDecimal("11"));
		produtosProspectConquista.getIsClienteArenaCadastrado().setNumeroTelefone("99898032");
		produtosProspectConquista.getIsClienteArenaCadastrado()
				.setDataNascimento(pessoaBcp.getFisica().getDataNascimento());

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosProspectConquista));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectConquista)).thenReturn(tipoUsuario);

		usuarioPortalService.obtemPessoaPorProdutos(produtosProspectConquista, CPF_PADRAO).flatMap(pessoaVo -> {
			Assert.assertNotNull(pessoaVo);
			Assert.assertNotNull(pessoaVo.getTelefones());
			Assert.assertNotNull(pessoaVo.getDataNascimento());
			Assert.assertTrue(pessoaVo.getTelefones().get(0).getDdd().equals("11"));
			Assert.assertTrue(pessoaVo.getTelefones().get(0).getNumeroTelefone().equals("99898032"));
			return Mono.just(pessoaVo);
		}).subscribe();

	}

	@Test
	public void testeObtemPessoaPorProdutoVdoSemDataNascimentoSucesso() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_VENDA_ONLINE.getCodTipo());

		produtosProspectVDO.getCotacoesVendaOnline().setDddCelular((short) 11);
		produtosProspectVDO.getCotacoesVendaOnline().setNumeroCelular(999894231);

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectVDO));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectVDO)).thenReturn(tipoUsuario);

		usuarioPortalService.obtemPessoaPorProdutos(produtosProspectVDO, CPF_PADRAO).flatMap(pessoaVo -> {
			Assert.assertNull(pessoaVo.getEmails());
			Assert.assertNull(pessoaVo.getDataNascimento());
			Assert.assertNotNull(pessoaVo);
			Assert.assertNotNull(pessoaVo.getTelefones());
			Assert.assertTrue(pessoaVo.getTelefones().get(0).getDdd().equals("11"));
			Assert.assertTrue(pessoaVo.getTelefones().get(0).getNumeroTelefone().equals("999894231"));
			return Mono.just(pessoaVo);
		}).subscribe();

	}

	@Test
	public void testeObtemPessoaPorProdutoVdoSucesso() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_VENDA_ONLINE.getCodTipo());

		produtosProspectVDO.getCotacoesVendaOnline().setDddCelular((short) 11);
		produtosProspectVDO.getCotacoesVendaOnline().setNumeroCelular(999894231);
		produtosProspectVDO.getCotacoesVendaOnline()
				.setDataNascimentoCliente(pessoaBcp.getFisica().getDataNascimento());

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectVDO));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectVDO)).thenReturn(tipoUsuario);

		usuarioPortalService.obtemPessoaPorProdutos(produtosProspectVDO, CPF_PADRAO).flatMap(pessoaVo -> {
			Assert.assertNotNull(pessoaVo);
			Assert.assertNotNull(pessoaVo.getTelefones());
			Assert.assertNotNull(pessoaVo.getDataNascimento());
			Assert.assertTrue(pessoaVo.getTelefones().get(0).getDdd().equals("11"));
			Assert.assertTrue(pessoaVo.getTelefones().get(0).getNumeroTelefone().equals("999894231"));
			return Mono.just(pessoaVo);
		}).subscribe();

	}

	@Test
	public void testeObtemPessoaPorProdutosFalha() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(0L);

		produtosProspectVDO.getCotacoesVendaOnline().setDddCelular((short) 11);
		produtosProspectVDO.getCotacoesVendaOnline().setNumeroCelular(999894231);
		produtosProspectVDO.getCotacoesVendaOnline()
				.setDataNascimentoCliente(pessoaBcp.getFisica().getDataNascimento());

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectVDO));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectVDO)).thenReturn(tipoUsuario);

		usuarioPortalService.obtemPessoaPorProdutos(produtosProspectVDO, CPF_PADRAO).onErrorResume(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertEquals(HttpStatus.NOT_FOUND.value(), erro.getStatusCode());
			return Mono.empty();
		}).subscribe();

	}
}
