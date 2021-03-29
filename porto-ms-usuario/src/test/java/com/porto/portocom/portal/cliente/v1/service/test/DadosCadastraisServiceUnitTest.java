package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

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
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import com.porto.portocom.portal.cliente.entity.TipoUsuario;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.EnderecosEletronicos;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.service.DadosCadastraisService;
import com.porto.portocom.portal.cliente.v1.service.ILexisNexisService;
import com.porto.portocom.portal.cliente.v1.service.ILogPortalClienteService;
import com.porto.portocom.portal.cliente.v1.service.IProspectService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalClienteService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.service.MensagemLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.vo.antifraude.CorporativoValidation;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect.ConsultaProdutosProspectBuilder;
import com.porto.portocom.portal.cliente.v1.vo.usuario.PessoaVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioVO;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DadosCadastraisServiceUnitTest {

	private static final String CPF_PADRAO = "37488499824";

	private static final String LEXIS_BASE64_TEST = "eyJzZXNzaW9uSWQiOiI3OGVkMWFkZS01YzU3LTQ1ZTEtYmI2Yl8xMjM0NTY3ODkwIiwicmVxdWVzdElkIjoiIiwib3JnYW5pemF0aW9uSWQiOiI2dDR4dWdrciIsInZhbGlkYXRpb24iOiIiLCJpcEFkZHJlc3MiOiIyMDEuNDkuMzUuMjUwIn0=";

	private UsuarioVO usuarioVo;

	private UsuarioPortalCliente usuarioPortal;

	private ConsultaProdutosProspect produtosClienteExCliente;

	@Mock
	private ParametrosLocalCacheService parametrosLocalCacheService;

	@Mock
	private MensagemLocalCacheService mensagemLocalCacheService;

	@Mock
	private LexisNexisUtils lexisNexisUtils;

	@Mock
	private IUsuarioPortalClienteRepository usuarioPortalClienteRepository;

	@Mock
	private IUsuarioStatusContaRepository usuarioStatusContaRepository;

	@Mock
	private IUsuarioPortalClienteService usuarioPortalClienteService;

	@Mock
	private IUsuarioPortalService usuarioPortalService;

	@Mock
	private ILexisNexisService lexisNexisService;

	@Mock
	private ILogPortalClienteService logPortalClienteService;

	@Mock
	private IProspectService prospectService;

	@InjectMocks
	private DadosCadastraisService dadosCadastraisService;

	@Before
	public void init() throws DatatypeConfigurationException {
		MockitoAnnotations.initMocks(this);

		usuarioVo = new UsuarioVO();
		usuarioVo.setCpfCnpj(CPF_PADRAO);
		usuarioVo.setEmail("teste@teste.com");
		usuarioVo.setNome("Emerson");
		usuarioVo.setCelular("85999312341");

		usuarioPortal = new UsuarioPortalCliente();
		usuarioPortal.setIdUsuario(1222L);
		usuarioPortal.setCnpjCpf(374884998L);
		usuarioPortal.setCnpjOrdem(0L);
		usuarioPortal.setCnpjCpfDigito(24L);
		usuarioPortal.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortal.setNomeUsuarioPortal("Emerson");

		this.criaProdutosClienteExCliente();

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

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisDesautorizado() {
		usuarioVo.setCelular("85998647532");
		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).doOnError(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertEquals(HttpStatus.UNAUTHORIZED.value(), erro.getStatusCode());
		}).subscribe();
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisEmailCelularVazios() {
		usuarioVo.setEmail("");
		usuarioVo.setCelular(null);
		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).doOnError(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertEquals(HttpStatus.BAD_REQUEST.value(), erro.getStatusCode());
		}).subscribe();

	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisCelularInvalido() {
		usuarioVo.setEmail("");
		usuarioVo.setCelular("85998645");
		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).doOnError(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertEquals(HttpStatus.FORBIDDEN.value(), erro.getStatusCode());
		}).subscribe();
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisEmailInvalido() {
		usuarioVo.setEmail("@email.com");
		usuarioVo.setCelular(null);
		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).doOnError(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertEquals(HttpStatus.BAD_REQUEST.value(), erro.getStatusCode());
		}).subscribe();
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisSucesso() {

		usuarioVo.setCelular(null);

		UsuarioStatusConta statusUsuarioConta = new UsuarioStatusConta();
		statusUsuarioConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuarioConta);

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortal));
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortal)).thenReturn(usuarioPortal);
		Mockito.when(lexisNexisService.validaLexisNexis(CPF_PADRAO, usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.just(new CorporativoValidation()));

		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).map(usuarioSimplificado -> {
			assertEquals("t***e@t***e.com", usuarioSimplificado.getT1().get(0).getEmails().get(0));
			assertTrue(usuarioSimplificado.getT1().get(0).getCelulares().isEmpty());
			assertNotNull(usuarioSimplificado);
			return usuarioSimplificado;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(2)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(usuarioPortal);
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisStatusExcluidoSucesso() {

		usuarioVo.setCelular(null);
		usuarioVo.setEmail("teste@teste.com");

		UsuarioStatusConta statusUsuarioConta = new UsuarioStatusConta();
		statusUsuarioConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuarioConta);

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortal));
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortal)).thenReturn(usuarioPortal);
		Mockito.when(lexisNexisService.validaLexisNexis(CPF_PADRAO, usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.just(new CorporativoValidation()));

		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).map(usuarioSimplificado -> {
			assertEquals("t***e@t***e.com", usuarioSimplificado.getT1().get(0).getEmails().get(0));
			assertTrue(usuarioSimplificado.getT1().get(0).getCelulares().isEmpty());
			assertNotNull(usuarioSimplificado);
			return usuarioSimplificado;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(2)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(usuarioPortal);
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisStatusTentativaCadastroSucesso() {

		usuarioVo.setCelular(null);
		usuarioVo.setEmail("teste@teste.com");

		UsuarioStatusConta statusUsuarioConta = new UsuarioStatusConta();
		statusUsuarioConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuarioConta);

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortal));
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortal)).thenReturn(usuarioPortal);
		Mockito.when(lexisNexisService.validaLexisNexis(CPF_PADRAO, usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.just(new CorporativoValidation()));

		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).map(usuarioSimplificado -> {
			assertEquals("t***e@t***e.com", usuarioSimplificado.getT1().get(0).getEmails().get(0));
			assertTrue(usuarioSimplificado.getT1().get(0).getCelulares().isEmpty());
			assertNotNull(usuarioSimplificado);
			return usuarioSimplificado;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(2)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(usuarioPortal);
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisStatusTentativaCadastroTelefoneSucesso() {

		usuarioVo.setCelular("8598476951");
		usuarioVo.setEmail("");

		UsuarioStatusConta statusUsuarioConta = new UsuarioStatusConta();
		statusUsuarioConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuarioConta);

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortal));
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortal)).thenReturn(usuarioPortal);
		Mockito.when(lexisNexisService.validaLexisNexis(CPF_PADRAO, usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.just(new CorporativoValidation()));

		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).map(usuarioSimplificado -> {
			assertEquals("(85)*****-6951", usuarioSimplificado.getT1().get(0).getCelulares().get(0));
			assertTrue(usuarioSimplificado.getT1().get(0).getNome().length() <= 100);
			assertTrue(usuarioSimplificado.getT1().get(0).getEmails().isEmpty());
			assertNotNull(usuarioSimplificado.getT1().get(0).getNome());
			return usuarioSimplificado;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(2)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(usuarioPortal);
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisValidaNomeSucesso() {
		String nome = "Emerson Algusto Henrique Pereira Everton Rafael João Lima Azevedo Pereira Brido da Maseno Oliveira de Jetulio Soares";

		usuarioVo.setCelular("8598476951");
		usuarioVo.setEmail("");
		usuarioVo.setNome(nome);

		UsuarioStatusConta statusUsuarioConta = new UsuarioStatusConta();
		statusUsuarioConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuarioConta);

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortal));
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortal)).thenReturn(usuarioPortal);
		Mockito.when(lexisNexisService.validaLexisNexis(CPF_PADRAO, usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.just(new CorporativoValidation()));

		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).map(usuarioSimplificado -> {
			assertEquals("(85)*****-6951", usuarioSimplificado.getT1().get(0).getCelulares().get(0));
			assertTrue(usuarioSimplificado.getT1().get(0).getNome().length() <= 100);
			assertTrue(usuarioSimplificado.getT1().get(0).getEmails().isEmpty());
			assertNotNull(usuarioSimplificado.getT1().get(0).getNome());
			return usuarioSimplificado;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(2)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(usuarioPortal);
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisValidaNumeroSucesso() {

		usuarioVo.setCelular("8598476951");
		usuarioVo.setEmail("");
		usuarioVo.setNome(null);

		UsuarioStatusConta statusUsuarioConta = new UsuarioStatusConta();
		statusUsuarioConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuarioConta);

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortal));
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortal)).thenReturn(usuarioPortal);
		Mockito.when(lexisNexisService.validaLexisNexis(CPF_PADRAO, usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.just(new CorporativoValidation()));

		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).map(usuarioSimplificado -> {
			assertEquals("(85)*****-6951", usuarioSimplificado.getT1().get(0).getCelulares().get(0));
			assertTrue(usuarioSimplificado.getT1().get(0).getEmails().isEmpty());
			assertNull(usuarioSimplificado.getT1().get(0).getNome());
			return usuarioSimplificado;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(2)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(usuarioPortal);
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisFluxoAlternativoSucesso() {
		usuarioPortal = new UsuarioPortalCliente();

		usuarioVo.setCelular(null);
		usuarioVo.setEmail("teste@teste.com");

		UsuarioStatusConta usuarioStatusConta = new UsuarioStatusConta();
		usuarioStatusConta.setDescricaoStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.toString());
		usuarioStatusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());
		usuarioPortal.setStatusUsuario(usuarioStatusConta);

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.EX_CLIENTE.getCodTipo());

		EnderecosEletronicos enderecosEletronicos = new EnderecosEletronicos();
		enderecosEletronicos.setEnderecoEletronico("teste1@emailteste.com");
		produtosClienteExCliente.getPessoasBcp().get(0).setEnderecosEletronicos(Arrays.asList(enderecosEletronicos));

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.empty());
		Mockito.when(usuarioPortalClienteRepository.save(Mockito.any(UsuarioPortalCliente.class)))
				.thenReturn(usuarioPortal);
		Mockito.when(lexisNexisService.validaLexisNexis(CPF_PADRAO, usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.just(new CorporativoValidation()));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosClienteExCliente));

		Mockito.when(prospectService.aplicaRegraProspect(produtosClienteExCliente)).thenReturn(tipoUsuario);

		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosClienteExCliente, CPF_PADRAO))
				.thenReturn(Mono.just(new PessoaVO()));

		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).map(usuarioSimplificado -> {
			assertEquals("t***e@t***e.com", usuarioSimplificado.getT1().get(0).getEmails().get(0));
			assertTrue(usuarioSimplificado.getT1().get(0).getCelulares().isEmpty());
			assertNotNull(usuarioSimplificado);
			return usuarioSimplificado;
		}).subscribe();

		Mockito.verify(prospectService, Mockito.times(1)).consultaProdutosProspect(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(Mockito.any());
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisStatusFalha() {

		usuarioVo.setCelular(null);

		UsuarioStatusConta statusUsuarioConta = new UsuarioStatusConta();
		statusUsuarioConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuarioConta);

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortal));

		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).doOnError(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertEquals(400, erro.getStatusCode());
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisAguardandoPrimeiroLoginSucesso() {

		usuarioVo.setCelular(null);

		UsuarioStatusConta statusUsuarioConta = new UsuarioStatusConta();
		statusUsuarioConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuarioConta);

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortal));
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortal)).thenReturn(usuarioPortal);
		Mockito.when(lexisNexisService.validaLexisNexis(CPF_PADRAO, usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.just(new CorporativoValidation()));

		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).map(usuarioSimplificado -> {
			assertEquals("t***e@t***e.com", usuarioSimplificado.getT1().get(0).getEmails().get(0));
			assertTrue(usuarioSimplificado.getT1().get(0).getCelulares().isEmpty());
			assertNotNull(usuarioSimplificado);
			return usuarioSimplificado;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(2)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(usuarioPortal);
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisStatusRecuperacaoContaSucesso() {

		usuarioVo.setCelular(null);

		UsuarioStatusConta statusUsuarioConta = new UsuarioStatusConta();
		statusUsuarioConta.setIdStatusConta(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuarioConta);

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortal));
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortal)).thenReturn(usuarioPortal);
		Mockito.when(lexisNexisService.validaLexisNexis(CPF_PADRAO, usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.just(new CorporativoValidation()));

		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).map(usuarioSimplificado -> {
			assertEquals("t***e@t***e.com", usuarioSimplificado.getT1().get(0).getEmails().get(0));
			assertTrue(usuarioSimplificado.getT1().get(0).getCelulares().isEmpty());
			assertNotNull(usuarioSimplificado);
			return usuarioSimplificado;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(2)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(usuarioPortal);
	}

	@Test
	public void testeValidaUsuarioAtualizacaoDadosCadastraisStatusUsuarioAtivoSucesso() {

		usuarioVo.setCelular(null);

		UsuarioStatusConta statusUsuarioConta = new UsuarioStatusConta();
		statusUsuarioConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuarioConta);

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortal));
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortal)).thenReturn(usuarioPortal);
		Mockito.when(lexisNexisService.validaLexisNexis(CPF_PADRAO, usuarioVo, TipoCodigoEnum.ATIVACAO))
				.thenReturn(Mono.just(new CorporativoValidation()));

		dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, TipoCodigoEnum.ATIVACAO).map(usuarioSimplificado -> {
			assertEquals("t***e@t***e.com", usuarioSimplificado.getT1().get(0).getEmails().get(0));
			assertTrue(usuarioSimplificado.getT1().get(0).getCelulares().isEmpty());
			assertNotNull(usuarioSimplificado);
			return usuarioSimplificado;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(2)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(usuarioPortal);
	}

}
