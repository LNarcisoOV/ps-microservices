package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;
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
import org.slf4j.MDC;
import org.springframework.test.context.ActiveProfiles;

import com.porto.portocom.portal.cliente.entity.ParametrosSistema;
import com.porto.portocom.portal.cliente.entity.SegurancaContaPortalUsuario;
import com.porto.portocom.portal.cliente.entity.SegurancaContaPortalUsuarioId;
import com.porto.portocom.portal.cliente.entity.TipoCodigoSeguranca;
import com.porto.portocom.portal.cliente.entity.TipoUsuario;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoEnvioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoFluxoEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.dto.bcp.ContratoBcp;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Documentos;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.EnderecosEletronicos;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Fisica;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Pessoa;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Telefones;
import com.porto.portocom.portal.cliente.v1.dto.conquista.IsClienteArenaCadastrado;
import com.porto.portocom.portal.cliente.v1.dto.vdo.ArrayOfCotacaoVendaOnline;
import com.porto.portocom.portal.cliente.v1.dto.vdo.CotacaoVendaOnline;
import com.porto.portocom.portal.cliente.v1.dto.vdo.CotacoesVendaOnline;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.GeraTokenAAException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMsMensageriaService;
import com.porto.portocom.portal.cliente.v1.integration.facade.LdapFacade;
import com.porto.portocom.portal.cliente.v1.model.PinVO;
import com.porto.portocom.portal.cliente.v1.model.TelefoneEmailVO;
import com.porto.portocom.portal.cliente.v1.model.ValidaTokenAAResponse;
import com.porto.portocom.portal.cliente.v1.repository.ISegurancaContaPortalUsuarioRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.service.CodigoAtivacaoService;
import com.porto.portocom.portal.cliente.v1.service.ICadastroService;
import com.porto.portocom.portal.cliente.v1.service.ILexisNexisService;
import com.porto.portocom.portal.cliente.v1.service.ILogPortalClienteService;
import com.porto.portocom.portal.cliente.v1.service.IProdutoService;
import com.porto.portocom.portal.cliente.v1.service.IProspectService;
import com.porto.portocom.portal.cliente.v1.service.ITokenAAService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.service.MensagemLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.vo.bcc.EnderecoEletronico;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPF;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPJ;
import com.porto.portocom.portal.cliente.v1.vo.bcc.Telefone;
import com.porto.portocom.portal.cliente.v1.vo.bcc.TipoFinalidadeTelefone;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect.ConsultaProdutosProspectBuilder;
import com.porto.portocom.portal.cliente.v1.vo.usuario.PessoaVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TelefoneVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TipoUsuarioVO;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CodigoAtivacaoServiceUnitTest {

	@Mock
	private ILogPortalClienteService logPortalClienteService;

	@Mock
	private ParametrosLocalCacheService parametrosLocalCacheService;

	@Mock
	private ITokenAAService tokenAAService;

	@Mock
	private IPortoMsMensageriaService portoMsMensageriaService;

	@Mock
	private IProdutoService produtoService;

	@Mock
	private IUsuarioPortalService usuarioPortalService;

	@Mock
	private ISegurancaContaPortalUsuarioRepository segurancaContaPortalUsuarioRepository;

	@Mock
	private MensagemLocalCacheService mensagemLocalCacheService;

	@Mock
	private IUsuarioStatusContaRepository usuarioStatusContaRepository;

	@Mock
	private IProspectService prospectService;

	@Mock
	private ICadastroService  cadastroService;

    @Mock
    private LdapFacade ldapFacade;
    
    @Mock
    private ILexisNexisService lexisNexisService;
    
    @Mock
    private LexisNexisUtils lexisNexisUtils;
    
	@InjectMocks
	private CodigoAtivacaoService codigoAtivacaoService;

	private static final short DDD = 11;

	private static final long TELEFONE_NOVE_DIGITOS = 960624730;

	private static final long TELEFONE_OITO_DIGITOS = 60624730;

	private static final String CPF_PADRAO = "22890390802";
	
	private static final String LEXIS_BASE64_TEST = "eyJzZXNzaW9uSWQiOiI3OGVkMWFkZS01YzU3LTQ1ZTEtYmI2Yl8xMjM0NTY3ODkwIiwicmVxdWVzdElkIjoiIiwib3JnYW5pemF0aW9uSWQiOiI2dDR4dWdrciIsInZhbGlkYXRpb24iOiIiLCJpcEFkZHJlc3MiOiIyMDEuNDkuMzUuMjUwIn0=";

	private static List<Telefones> telefones;

	private static List<EnderecosEletronicos> emails;

	private static List<Pessoa> pessoas;

	private static UsuarioPortalCliente usuarioPortalCliente;

	private static TipoCodigoSeguranca tipoCodigoSeguranca;

	private static SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId;

	private static SegurancaContaPortalUsuario segurancaContaPortalUsuario;

	private PessoaVO pessoaVo;

	private TipoUsuario tipoUsuario;

	private ConsultaProdutosProspect produtosCliente;

	private ConsultaProdutosProspect produtosExCliente;

	private ConsultaProdutosProspect produtosBCCPF;

	private ConsultaProdutosProspect produtosBCCPJ;

	private ConsultaProdutosProspect produtosProspectConquista;

	private ConsultaProdutosProspect produtosProspectVDO;

	private ConsultaProdutosProspect produtosSemRelacionamento;
	
	private PinVO pinVo;
	
	private ValidaTokenAAResponse tokenResponse;

	@Before
	public void init() throws DatatypeConfigurationException {
		MockitoAnnotations.initMocks(this);

		Map<String, ParametrosSistema> parametros = new HashMap<>();
		parametros.put("porto.ms.usuario.protocolo.email",
				new ParametrosSistema(37L, "porto.ms.usuario.protocolo.email", "http"));
		parametros.put("porto.ms.usuario.endereco.email",
				new ParametrosSistema(38L, "porto.ms.usuario.endereco.email", "otclientdevm.portoseguro.brasil"));
		parametros.put("porto.ms.usuario.remetente.email",
				new ParametrosSistema(5L, "porto.ms.usuario.remetente.email", "portaldocliente@portoseguro.com.br"));
		parametros.put("porto.ms.usuario.assunto.criar.conta.email",
				new ParametrosSistema(24L, "porto.ms.usuario.assunto.criar.conta.email",
						"Porto Seguro Portal de Clientes - Nova Conta Cadastrada"));
		parametros.put("porto.ms.usuario.nome.portal.email",
				new ParametrosSistema(28L, "porto.ms.usuario.nome.portal.email", "portaldecliente"));

		parametros.put("porto.ms.usuario.tentativas.criacao.conta",
				new ParametrosSistema(1L, "porto.ms.usuario.tentativas.criacao.conta", "5"));

		parametrosLocalCacheService.getParametros().putAll(parametros);

		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.protocolo.email"))
				.thenReturn("http");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.endereco.email"))
				.thenReturn("otclientdevm.portoseguro.brasil");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.remetente.email"))
				.thenReturn("portaldocliente@portoseguro.com.br");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.assunto.criar.conta.email"))
				.thenReturn("Porto Seguro Portal de Clientes - Nova Conta Cadastrada");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.nome.portal.email"))
				.thenReturn("portaldecliente");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.tentativas.criacao.conta"))
				.thenReturn("5");
		UsuarioStatusConta usuarioStatusConta = new UsuarioStatusConta();
		usuarioStatusConta.setDescricaoStatusConta("descricao");
		usuarioStatusConta.setIdStatusConta(5L);

		Mockito.when(this.usuarioStatusContaRepository
				.findByIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus()))
				.thenReturn(usuarioStatusConta);
		
		tipoUsuario = new TipoUsuario();
		pessoaVo = new PessoaVO();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());
		pinVo = new PinVO(LocalDateTime.now(), LocalDateTime.now(), "12345");
		tokenResponse = new ValidaTokenAAResponse();
		tokenResponse.setValidityEndTime(LocalDateTime.now());
		tokenResponse.setValidityEndTime(LocalDateTime.now());
		preencheTelefones();
		preencheEmails();
		criaListaPessoaBcp();
		criaUsuarioPortal();
		criarSegurancaContaPortalUsuario();
		criaProdutosCliente();
		criaProdutosExCliente();
		criaProdutosProspectConquista();
		criaProdutosProspectVDO();
		criaProdutosSemRelacionamento();
		criaProdutosBCCPF();
		criaProdutosBCCPJ();
		
		MDC.put(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor(), "texto0");
		MDC.put(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), LEXIS_BASE64_TEST);
		Mockito.when(this.lexisNexisUtils.verificaFlagLexis()).thenReturn(true);
	}

	private void criaProdutosCliente() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNomePessoa("Teste");

		ContratoBcp.Pessoa pessoaContrato = new ContratoBcp.Pessoa();

		ConsultaProdutosProspectBuilder produtosProspectsBuilder = ConsultaProdutosProspect.builder();
		produtosProspectsBuilder.contratosBcp(Collections.singletonList(pessoaContrato));
		produtosProspectsBuilder.cotacoesVendaOnline(null);
		produtosProspectsBuilder.pessoasBcp(Arrays.asList(pessoa));
		produtosProspectsBuilder.isClienteArenaCadastrado(null);

		produtosCliente = produtosProspectsBuilder.build();
	}

	private void criaProdutosExCliente() {
		Pessoa pessoa = new Pessoa();
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
		EnderecoEletronico enderecoEletronico = new EnderecoEletronico();
		Telefone telefone = new Telefone();
		TipoFinalidadeTelefone tipoFinalidadeTelefone = new TipoFinalidadeTelefone();

		enderecoEletronico.setTextoEnderecoEletronico("adriano.santos@portoseguro.com.br");
		tipoFinalidadeTelefone.setCodigoTipoFinalidadeTelefone((short) 1);
		telefone.setTipoFinalidadeTelefone(tipoFinalidadeTelefone);

		pessoa.setDataNascimentoPessoaFisica("1995-10-11");
		pessoa.setEnderecosEletronicos(Arrays.asList(enderecoEletronico));

		pessoa.setTelefones(Arrays.asList(telefone));
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
		EnderecoEletronico enderecoEletronico = new EnderecoEletronico();
		Telefone telefone = new Telefone();
		TipoFinalidadeTelefone tipoFinalidadeTelefone = new TipoFinalidadeTelefone();

		enderecoEletronico.setTextoEnderecoEletronico("adriano.santos@portoseguro.com.br");
		tipoFinalidadeTelefone.setCodigoTipoFinalidadeTelefone((short) 1);
		telefone.setTipoFinalidadeTelefone(tipoFinalidadeTelefone);

		pessoa.setEnderecosEletronicos(Arrays.asList(enderecoEletronico));

		pessoa.setTelefones(Arrays.asList(telefone));
		pessoaBccPJ.setPessoas(Arrays.asList(pessoa));
		produtosProspectsBuilder.pessoaBccPj(pessoaBccPJ);

		produtosBCCPJ = produtosProspectsBuilder.build();
	}

	private void criaProdutosProspectConquista() {
		IsClienteArenaCadastrado isClienteArenaCadastrado = new IsClienteArenaCadastrado();
		isClienteArenaCadastrado.setIsCadastrado(null);
		isClienteArenaCadastrado.setCpfCnpj(CPF_PADRAO);

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

	public static void preencheTelefones() {
		telefones = new ArrayList<>();
		Telefones telefoneNoveDigitos = new Telefones();
		telefoneNoveDigitos.setCodigoDdd(DDD);
		telefoneNoveDigitos.setNumeroTelefone(TELEFONE_NOVE_DIGITOS);
		Telefones telefoneOitoDigitos = new Telefones();
		telefoneOitoDigitos.setCodigoDdd(DDD);
		telefoneOitoDigitos.setNumeroTelefone(TELEFONE_OITO_DIGITOS);
		Telefones telefoneNulo = null;
		telefones.add(telefoneNoveDigitos);
		telefones.add(telefoneOitoDigitos);
		telefones.add(telefoneNulo);
	}

	public static void preencheEmails() {

		emails = new ArrayList<>();
		EnderecosEletronicos emailCorreto = new EnderecosEletronicos();
		emailCorreto.setEnderecoEletronico("felipe.rosa@portoseguro.com.br");
		EnderecosEletronicos emailCorretoDoisCarac = new EnderecosEletronicos();
		emailCorretoDoisCarac.setEnderecoEletronico("fe@portoseguro.com.br");
		EnderecosEletronicos emailIncorretoComArroba = new EnderecosEletronicos();
		emailIncorretoComArroba.setEnderecoEletronico("@portoseguro.com.br");
		EnderecosEletronicos emailIncorretoSemArroba = new EnderecosEletronicos();
		emailIncorretoSemArroba.setEnderecoEletronico("portoseguro.com.br");
		EnderecosEletronicos emailIncorretoSemDominio = new EnderecosEletronicos();
		emailIncorretoSemDominio.setEnderecoEletronico("felipe.rosa@");
		emails.add(emailCorreto);
		emails.add(emailCorretoDoisCarac);
		emails.add(emailIncorretoComArroba);
		emails.add(emailIncorretoSemArroba);
		emails.add(emailIncorretoSemDominio);
	}

	public static void criaListaPessoaBcp() throws DatatypeConfigurationException {
		EnderecosEletronicos enderecoEletronico = new EnderecosEletronicos();
		enderecoEletronico.setEnderecoEletronico("endereco@eletronico.com");
		List<EnderecosEletronicos> listEndereco = new ArrayList<>();
		listEndereco.add(enderecoEletronico);

		Telefones telefones = new Telefones();
		telefones.setCodigoDdd((short) 71);
		telefones.setNumeroTelefone((long) 99999999);
		List<Telefones> listTel = new ArrayList<>();
		listTel.add(telefones);

		Pessoa pessoaBcp = new Pessoa();
		pessoaBcp.setEnderecosEletronicos(listEndereco);
		pessoaBcp.setTelefones(listTel);

		pessoas = new ArrayList<>();

		pessoas.add(pessoaBcp);
	}

	public static void criaUsuarioPortal() {
		usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(1212L);
		usuarioPortalCliente.setCodTipoPessoa("1");
		usuarioPortalCliente.setDataCadastro(new Date());
		usuarioPortalCliente.setFlgConfEnvEmail("S");
		usuarioPortalCliente.setQtdTentativaLogin(0L);
		usuarioPortalCliente.setQuantidadeAcessoLogin(0L);
		usuarioPortalCliente.setQuantidadeTentativaCriacaoConta(0L);
		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());
		usuarioPortalCliente.setStatusUsuario(statusConta);
	}

	public static void criarSegurancaContaPortalUsuario() {

		tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("criação da conta");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(1212L);
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(7654321L);
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
	}

	public static PessoaVO montaPessoa(TipoUsuarioEnum tipoUsuarioEnum, Date dataNascimento, String email,
			TelefoneVO telefoneVO) {
		TipoUsuarioVO tipoUsuarioVo = new TipoUsuarioVO();
		tipoUsuarioVo.setIdTipoUsuario(tipoUsuarioEnum.getCodTipo());
		PessoaVO pessoaVo = new PessoaVO();
		pessoaVo.setTipoUsuario(tipoUsuarioVo);
		pessoaVo.setDigitoCpfCnpj(02L);
		pessoaVo.setNumeroCpfCnpj(228903908L);
		pessoaVo.setNumeroOrdemCnpj(0L);
		pessoaVo.setNome(StringUtils.EMPTY);
		pessoaVo.setDataNascimento(dataNascimento);
		pessoaVo.setEmails(email != null ? Arrays.asList(email) : null);
		pessoaVo.setTelefones(telefoneVO != null ? Arrays.asList(telefoneVO) : null);
		return pessoaVo;
	}

	@Test
	public void testEnviaCodigoPorEmail1Sucesso() throws DatatypeConfigurationException {

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.getStatusUsuario()
				.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		Fisica pessoaFisica = new Fisica();
		Documentos documento = new Documentos();
		final GregorianCalendar now = new GregorianCalendar();
		XMLGregorianCalendar dataNascimento = DatatypeFactory.newInstance().newXMLGregorianCalendar(now);
		pessoaFisica.setDataNascimento(dataNascimento);

		produtosCliente.getPessoasBcp().get(0).setDocumentos(Arrays.asList(documento));
		produtosCliente.getPessoasBcp().get(0).setFisica(pessoaFisica);

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.CLIENTE, new Date(), usuarioPortalCliente.getDescEmail(), null);

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosCliente)).thenReturn(tipoUsuario);
		Mockito.when(usuarioPortalService.obtemClienteTitular(produtosCliente.getPessoasBcp()))
				.thenReturn(Mono.just(produtosCliente.getPessoasBcp().get(0)));
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), "Porto Seguro Portal de Clientes - Nova Conta Cadastrada", "",
				CPF_PADRAO)).thenReturn(Mono.just(Boolean.TRUE));
		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_EMAIL.getValor()))
				.thenReturn("");
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ATIVACAO.getValor()))
				.thenReturn("envio codigo");
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosCliente, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));
		
		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));
		
		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.EMAIL,TipoFluxoEnum.SIMPLES).map(result -> {
			Assert.assertTrue("Código enviado com sucesso por email.", result.getIsSucesso());
			return result;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosCliente, CPF_PADRAO);
	}

	
	@Test
	public void testEnviaCodigoPorEmailHardSucesso() throws DatatypeConfigurationException {

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.getStatusUsuario()
				.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		Fisica pessoaFisica = new Fisica();
		Documentos documento = new Documentos();
		final GregorianCalendar now = new GregorianCalendar();
		XMLGregorianCalendar dataNascimento = DatatypeFactory.newInstance().newXMLGregorianCalendar(now);
		pessoaFisica.setDataNascimento(dataNascimento);

		produtosCliente.getPessoasBcp().get(0).setDocumentos(Arrays.asList(documento));
		produtosCliente.getPessoasBcp().get(0).setFisica(pessoaFisica);

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.CLIENTE, new Date(), usuarioPortalCliente.getDescEmail(), null);

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosCliente)).thenReturn(tipoUsuario);
		Mockito.when(usuarioPortalService.obtemClienteTitular(produtosCliente.getPessoasBcp()))
				.thenReturn(Mono.just(produtosCliente.getPessoasBcp().get(0)));
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.HARD)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), "Porto Seguro Portal de Clientes - Nova Conta Cadastrada", "",
				CPF_PADRAO)).thenReturn(Mono.just(Boolean.TRUE));
		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_EMAIL.getValor()))
				.thenReturn("");
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ATIVACAO.getValor()))
				.thenReturn("envio codigo");
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosCliente, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));
		
		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));
		
		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.EMAIL,TipoFluxoEnum.HARD).map(result -> {
			Assert.assertTrue("Código enviado com sucesso por email.", result.getIsSucesso());
			return result;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosCliente, CPF_PADRAO);
	}
	@Test
	public void testEnviaCodigoPorEmail2FalhaTipoCodigoSeguranca1NaoEncontrado() {

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.getStatusUsuario()
				.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosCliente)).thenReturn(tipoUsuario);
		Mockito.when(usuarioPortalService.obtemClienteTitular(produtosCliente.getPessoasBcp()))
				.thenReturn(Mono.just((new Pessoa())));
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO))
				.thenReturn(Mono.error(
						new GeraTokenAAException("Tipo de código de segurança [1] não encontrado.", 404)));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.EMAIL,TipoFluxoEnum.SIMPLES).doOnError(error -> {
			assertTrue(error instanceof GeraTokenAAException);
			assertEquals(error.getMessage(), "Tipo de código de segurança [1] não encontrado.");
		}).subscribe();
	}



	@Test
	public void testEnviaCodigoPorEmail4SucessoSemParametros() {
		parametrosLocalCacheService.getParametros().clear();

		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_PROTOCOLO_EMAIL.getValor())).thenReturn(null);
		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_ENDERECO_EMAIL.getValor())).thenReturn(null);
		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_REMETENTE_EMAIL.getValor())).thenReturn(null);
		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_ASSUNTO_CRIAR_CONTA_EMAIL.getValor()))
				.thenReturn(null);
		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_NOME_PORTAL_EMAIL.getValor())).thenReturn(null);
		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_CRIACAO_CONTA.getValor()))
				.thenReturn(null);

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ATIVACAO.getValor()))
				.thenReturn("envio codigo");

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.getStatusUsuario()
				.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.CLIENTE, new Date(), usuarioPortalCliente.getDescEmail(), null);

		Mockito.when(this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_EMAIL.getValor()))
				.thenReturn("");

		Mockito.when(portoMsMensageriaService.enviaEmail("", usuarioPortalCliente.getDescEmail(), null, "", CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));

		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));

		Pessoa pessoaBcp = new Pessoa();
		ArrayList<Pessoa> listPessoa = new ArrayList<Pessoa>();
		listPessoa.add(pessoaBcp);

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosCliente)).thenReturn(tipoUsuario);
		Mockito.when(usuarioPortalService.obtemClienteTitular(produtosCliente.getPessoasBcp()))
				.thenReturn(Mono.just(listPessoa.get(0)));
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosCliente, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));
		
		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.EMAIL,TipoFluxoEnum.SIMPLES).map(result -> {
			Assert.assertTrue("Código enviado com sucesso por email.", result.getIsSucesso());
			return result;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosCliente, CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoPorEmail5SucessoNomeVazioSemParametros() {

		parametrosLocalCacheService.getParametros().clear();

		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_PROTOCOLO_EMAIL.getValor())).thenReturn(null);
		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_ENDERECO_EMAIL.getValor())).thenReturn(null);
		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_REMETENTE_EMAIL.getValor())).thenReturn(null);
		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_ASSUNTO_CRIAR_CONTA_EMAIL.getValor()))
				.thenReturn(null);
		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_NOME_PORTAL_EMAIL.getValor())).thenReturn(null);
		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_CRIACAO_CONTA.getValor()))
				.thenReturn(null);

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ATIVACAO.getValor()))
				.thenReturn("envio codigo");

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.getStatusUsuario()
				.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.CLIENTE, new Date(), usuarioPortalCliente.getDescEmail(), null);

		Pessoa pessoaBcp = new Pessoa();
		ArrayList<Pessoa> listPessoa = new ArrayList<Pessoa>();
		listPessoa.add(pessoaBcp);

		Mockito.when(produtoService.consultaPessoas(CPF_PADRAO)).thenReturn(Mono.just(listPessoa));

		Mockito.when(usuarioPortalService.obtemClienteTitular(listPessoa)).thenReturn(Mono.just(listPessoa.get(0)));

		Mockito.when(this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_EMAIL.getValor()))
				.thenReturn("");

		Mockito.when(portoMsMensageriaService.enviaEmail("", usuarioPortalCliente.getDescEmail(), null, "", CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosCliente)).thenReturn(tipoUsuario);
		Mockito.when(usuarioPortalService.obtemClienteTitular(produtosCliente.getPessoasBcp()))
				.thenReturn(Mono.just(listPessoa.get(0)));
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosCliente, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.EMAIL,TipoFluxoEnum.SIMPLES).map(result -> {
			Assert.assertTrue("Código enviado com sucesso por email.", result.getIsSucesso());
			return result;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosCliente, CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoPorSms1Sucesso() {

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.setNumCelular(974220722L);
		usuarioPortalCliente.setNumDddCelular(11L);
		usuarioPortalCliente.getStatusUsuario()
				.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		TipoUsuario tipoUsuarioExCliente = new TipoUsuario();
		tipoUsuarioExCliente.setIdTipoUsuario(TipoUsuarioEnum.EX_CLIENTE.getCodTipo());

		Fisica pessoaFisica = new Fisica();
		Telefones telefone = new Telefones();
		XMLGregorianCalendar dataNascimento = null;

		telefone.setCodigoDdd((short) 11);
		telefone.setNumeroTelefone(974220722L);
		pessoaFisica.setDataNascimento(dataNascimento);

		produtosCliente.getPessoasBcp().get(0).setFisica(pessoaFisica);
		produtosExCliente.getPessoasBcp().get(0).setTelefones(Arrays.asList(telefone));

		String message = "Porto Seguro: Para concluir o seu processo de cadastro de conta no Portal do Cliente, utilize o codigo de seguranca: {parameterReplace}.";

		message = message.replaceAll("\\{parameterReplace\\}", "1234567");

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.EX_CLIENTE, new Date(), null, new TelefoneVO("11", "974220722"));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor()))
				.thenReturn(message);

		Mockito.when(portoMsMensageriaService.enviaSms("11", "974220722", message, CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));
		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosExCliente)).thenReturn(tipoUsuarioExCliente);
		Mockito.when(usuarioPortalService.obtemClienteTitular(produtosExCliente.getPessoasBcp()))
				.thenReturn(Mono.just(produtosExCliente.getPessoasBcp().get(0)));
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_ATIVACAO.getValor()))
				.thenReturn("envio codigo");
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosExCliente, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));

		MDC.put(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), " ");
		
		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.CELULAR,TipoFluxoEnum.SIMPLES).map(result -> {
			Assert.assertTrue("Código enviado com sucesso por SMS.", result.getIsSucesso());
			return result;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosExCliente, CPF_PADRAO);
	}
	
	
	@Test
	public void testEnviaCodigoPorSmsHardSucesso() {

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.setNumCelular(974220722L);
		usuarioPortalCliente.setNumDddCelular(11L);
		usuarioPortalCliente.getStatusUsuario()
				.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		TipoUsuario tipoUsuarioExCliente = new TipoUsuario();
		tipoUsuarioExCliente.setIdTipoUsuario(TipoUsuarioEnum.EX_CLIENTE.getCodTipo());

		Fisica pessoaFisica = new Fisica();
		Telefones telefone = new Telefones();
		XMLGregorianCalendar dataNascimento = null;

		telefone.setCodigoDdd((short) 11);
		telefone.setNumeroTelefone(974220722L);
		pessoaFisica.setDataNascimento(dataNascimento);

		produtosCliente.getPessoasBcp().get(0).setFisica(pessoaFisica);
		produtosExCliente.getPessoasBcp().get(0).setTelefones(Arrays.asList(telefone));

		String message = "Porto Seguro: Para concluir o seu processo de cadastro de conta no Portal do Cliente, utilize o codigo de seguranca: {parameterReplace}.";

		message = message.replaceAll("\\{parameterReplace\\}", "1234567");

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.EX_CLIENTE, new Date(), null, new TelefoneVO("11", "974220722"));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor()))
				.thenReturn(message);

		Mockito.when(portoMsMensageriaService.enviaSms("11", "974220722", message, CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));
		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosExCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosExCliente)).thenReturn(tipoUsuarioExCliente);
		Mockito.when(usuarioPortalService.obtemClienteTitular(produtosExCliente.getPessoasBcp()))
				.thenReturn(Mono.just(produtosExCliente.getPessoasBcp().get(0)));
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.HARD)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_ATIVACAO.getValor()))
				.thenReturn("envio codigo");
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosExCliente, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));

		MDC.put(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), " ");
		
		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.CELULAR,TipoFluxoEnum.HARD).map(result -> {
			Assert.assertTrue("Código enviado com sucesso por SMS.", result.getIsSucesso());
			return result;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosExCliente, CPF_PADRAO);
	}


	@Test
	public void testEnviaCodigoPorSms3FalhaExcecao() {

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.setNumCelular(974220722L);
		usuarioPortalCliente.setNumDddCelular(11L);
		usuarioPortalCliente.getStatusUsuario()
				.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO))
				.thenReturn(Mono.error(
						new GeraTokenAAException("Erro Generico", 500)));


		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosCliente)).thenReturn(tipoUsuario);
		Mockito.when(usuarioPortalService.obtemClienteTitular(produtosCliente.getPessoasBcp()))
				.thenReturn(Mono.just(pessoas.get(0)));
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.CELULAR,TipoFluxoEnum.SIMPLES).doOnError(error -> {
			Assert.assertNotNull(error);
		}).subscribe();
	}

	@Test
	public void testEnviaCodigoAtivacaoPorEmailSucesso() {

		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.CLIENTE, new Date(),
				pessoas.get(0).getEnderecosEletronicos().get(0).getEnderecoEletronico(), null);

		Mockito.when(this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_EMAIL.getValor()))
				.thenReturn("");

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosCliente));
		Mockito.when(prospectService.aplicaRegraProspect(produtosCliente)).thenReturn(tipoUsuario);
		Mockito.when(usuarioPortalService.obtemClienteTitular(produtosCliente.getPessoasBcp()))
				.thenReturn(Mono.just(pessoas.get(0)));
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				pessoas.get(0).getEnderecosEletronicos().get(0).getEnderecoEletronico(),
				"Porto Seguro Portal de Clientes - Nova Conta Cadastrada", "", CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ATIVACAO.getValor()))
				.thenReturn("envio codigo {data} {aplicacao}");

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosCliente, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));
		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.EMAIL,TipoFluxoEnum.SIMPLES).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).salvar(usuarioPortalCliente);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaEmail("portaldocliente@portoseguro.com.br",
				pessoas.get(0).getEnderecosEletronicos().get(0).getEnderecoEletronico(),
				"Porto Seguro Portal de Clientes - Nova Conta Cadastrada", "", CPF_PADRAO);
		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosCliente, CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoAtivacaoPorEmailSucessoBCCPF() {

		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		PessoaBccPF.Pessoa pessoa = produtosBCCPF.getPessoaBccPf().getPessoas().get(0);

		String email = pessoa.getEnderecosEletronicos().get(0).getTextoEnderecoEletronico();
		
		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.PROSPECT_BCC, new Date(), email, null);

		Mockito.when(this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_EMAIL.getValor()))
				.thenReturn("");

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosBCCPF));
		Mockito.when(prospectService.aplicaRegraProspect(produtosBCCPF)).thenReturn(tipoUsuario);
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.obtemEmailETelefoneBCC(pessoa.getTelefones(), pessoa.getEnderecosEletronicos()))
				.thenReturn(new TelefoneEmailVO());
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br", email,
				"Porto Seguro Portal de Clientes - Nova Conta Cadastrada", "", CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ATIVACAO.getValor()))
				.thenReturn("envio codigo {data} {aplicacao}");

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));
		
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosBCCPF, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));
		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.EMAIL,TipoFluxoEnum.SIMPLES).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).salvar(usuarioPortalCliente);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaEmail("portaldocliente@portoseguro.com.br",
				email, "Porto Seguro Portal de Clientes - Nova Conta Cadastrada", "", CPF_PADRAO);
		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosBCCPF, CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoAtivacaoPorEmailSucessoBCCPJ() {

		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		PessoaBccPF.Pessoa pessoa = produtosBCCPF.getPessoaBccPf().getPessoas().get(0);

		String email = pessoa.getEnderecosEletronicos().get(0).getTextoEnderecoEletronico();

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.PROSPECT_BCC, new Date(), email, null);

		Mockito.when(this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_EMAIL.getValor()))
				.thenReturn("");

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosBCCPJ));
		Mockito.when(prospectService.aplicaRegraProspect(produtosBCCPJ)).thenReturn(tipoUsuario);
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.obtemEmailETelefoneBCC(pessoa.getTelefones(), pessoa.getEnderecosEletronicos()))
				.thenReturn(new TelefoneEmailVO());
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br", email,
				"Porto Seguro Portal de Clientes - Nova Conta Cadastrada", "", CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_ATIVACAO.getValor()))
				.thenReturn("envio codigo {data} {aplicacao}");

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));

		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosBCCPJ, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));
		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.EMAIL,TipoFluxoEnum.SIMPLES).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).salvar(usuarioPortalCliente);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaEmail("portaldocliente@portoseguro.com.br",
				email, "Porto Seguro Portal de Clientes - Nova Conta Cadastrada", "", CPF_PADRAO);
		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosBCCPJ, CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoAtivacaoPorEmailWhenUsuarioNaoExiste() {

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(0L);

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosSemRelacionamento));
		Mockito.when(prospectService.aplicaRegraProspect(produtosSemRelacionamento)).thenReturn(tipoUsuario);

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()))
				.thenReturn("Crie uma conta para acessar a Área do Cliente.");

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.EMAIL,TipoFluxoEnum.SIMPLES).doOnError(erro -> {
			UsuarioPortalException error = (UsuarioPortalException) erro;
			assertEquals("", "Crie uma conta para acessar a Área do Cliente.", error.getMessage());
			assertEquals("", 404, error.getStatusCode());
		}).subscribe();
	}

	@Test
	public void testEnviaCodigoAtivacaoPorEmailWhenCpfIsInvalido() {

		Mockito.when(prospectService.consultaProdutosProspect("111")).thenReturn(Mono.just(produtosSemRelacionamento));
		Mockito.when(prospectService.aplicaRegraProspect(produtosSemRelacionamento)).thenReturn(tipoUsuario);

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor()))
				.thenReturn("Revise os caracteres digitados e tente de novo ou acesse ‘esqueci minha senha’.");

		codigoAtivacaoService.enviaCodigoAtivacao("111", TipoEnvioEnum.EMAIL,TipoFluxoEnum.SIMPLES).doOnError(erro -> {
			CpfCnpjInvalidoException error = (CpfCnpjInvalidoException) erro;
			assertEquals("Revise os caracteres digitados e tente de novo ou acesse ‘esqueci minha senha’.",
					error.getMessage());
		}).subscribe();
	}

	@Test
	public void testEnviaCodigoAtivacaoPorEmailWhenUsuarioEhIlegivel() {

		UsuarioPortalCliente usuarioPortal = new UsuarioPortalCliente();
		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusConta);

		TipoUsuario tipoUsuarioConquista = new TipoUsuario();
		tipoUsuarioConquista.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_CONQUISTA.getCodTipo());

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.PROSPECT_CONQUISTA, new Date(), null, null);

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosProspectConquista));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectConquista)).thenReturn(tipoUsuarioConquista);
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortal));
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosProspectConquista, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.EMAIL,TipoFluxoEnum.SIMPLES).doOnError(erro -> {
			UsuarioPortalException error = (UsuarioPortalException) erro;
			assertEquals("Usuário não está elegível para receber o código de ativação.", error.getMessage());
			assertEquals(400, error.getStatusCode());
		}).subscribe();

		Mockito.verify(prospectService, Mockito.times(1)).consultaProdutosProspect(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosProspectConquista, CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoAtivacaoPorSMSSucesso() {

		usuarioPortalCliente.setNumCelular(974220722L);
		usuarioPortalCliente.setNumDddCelular(11L);
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		TipoUsuario tipoUsuarioConquista = new TipoUsuario();
		tipoUsuarioConquista.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_CONQUISTA.getCodTipo());
		produtosProspectConquista.getIsClienteArenaCadastrado().setDddNumeroTelefone(new BigDecimal("11"));
		produtosProspectConquista.getIsClienteArenaCadastrado().setNumeroTelefone("974220722");

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.PROSPECT_CONQUISTA, new Date(), null,
				new TelefoneVO("11", "974220722"));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosProspectConquista));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectConquista)).thenReturn(tipoUsuarioConquista);
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));

		String message = "Porto Seguro: Para concluir o seu processo de cadastro de conta no Portal do Cliente, utilize o codigo de seguranca: {parameterReplace}.";

		message = message.replaceAll("\\{parameterReplace\\}", "1234567");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor()))
				.thenReturn(message);

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_ATIVACAO.getValor()))
				.thenReturn("envio codigo");

		Mockito.when(portoMsMensageriaService.enviaSms("11", "974220722", message, CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosProspectConquista, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));

		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.CELULAR,TipoFluxoEnum.SIMPLES).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(prospectService, Mockito.times(1)).consultaProdutosProspect(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).salvar(usuarioPortalCliente);
		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);
		Mockito.verify(mensagemLocalCacheService, Mockito.times(1))
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor());
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaSms("11", "974220722", message, CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosProspectConquista,
				CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoAtivacaoPorSMSSucessoWhenStatusAguardandoConfirmacao() {

		usuarioPortalCliente.setNumCelular(974220722L);
		usuarioPortalCliente.setNumDddCelular(11L);
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.getStatusUsuario()
				.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus());

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		TipoUsuario tipoUsuarioVdo = new TipoUsuario();
		tipoUsuarioVdo.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_VENDA_ONLINE.getCodTipo());
		produtosProspectVDO.getCotacoesVendaOnline().setDddCelular((short) 11);
		produtosProspectVDO.getCotacoesVendaOnline().setNumeroCelular(974220722);

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.PROSPECT_VENDA_ONLINE, new Date(), null,
				new TelefoneVO("11", "974220722"));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectVDO));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectVDO)).thenReturn(tipoUsuarioVdo);
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosProspectVDO, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));

		String message = "Porto Seguro: Para concluir o seu processo de cadastro de conta no Portal do Cliente, utilize o codigo de seguranca: {parameterReplace}.";

		message = message.replaceAll("\\{parameterReplace\\}", "1234567");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_ATIVACAO.getValor()))
				.thenReturn("envio codigo");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor()))
				.thenReturn(message);

		Mockito.when(portoMsMensageriaService.enviaSms("11", "974220722", message, CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));
		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.CELULAR,TipoFluxoEnum.SIMPLES).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(prospectService, Mockito.times(1)).consultaProdutosProspect(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).salvar(usuarioPortalCliente);

		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);
		Mockito.verify(mensagemLocalCacheService, Mockito.times(1))
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor());
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaSms("11", "974220722", message, CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosProspectVDO, CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoAtivacaoPorSMSSucessoWhenClienteEhProspect() {

		usuarioPortalCliente.setNumCelular(974220722L);
		usuarioPortalCliente.setNumDddCelular(11L);
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setQtdTentativaLogin(0L);
		usuarioPortalCliente.setQuantidadeAcessoLogin(0L);
		usuarioPortalCliente.setQuantidadeTentativaCriacaoConta(0L);
		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		TipoUsuario tipoUsuarioVdo = new TipoUsuario();
		tipoUsuarioVdo.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_VENDA_ONLINE.getCodTipo());
		produtosProspectVDO.getCotacoesVendaOnline().setDddCelular((short) 11);
		produtosProspectVDO.getCotacoesVendaOnline().setNumeroCelular(974220722);

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.PROSPECT_VENDA_ONLINE, new Date(), null,
				new TelefoneVO("11", "974220722"));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO)).thenReturn(Mono.just(produtosProspectVDO));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectVDO)).thenReturn(tipoUsuarioVdo);
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.empty());
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(usuarioPortalService.criaUsuarioPortalDePessoaVo(pessoaVo)).thenReturn(usuarioPortalCliente);
		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosProspectVDO, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));

		String message = "Porto Seguro: Para concluir o seu processo de cadastro de conta no Portal do Cliente, utilize o codigo de seguranca: {parameterReplace}.";

		message = message.replaceAll("\\{parameterReplace\\}", "1234567");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_ATIVACAO.getValor()))
				.thenReturn("envio codigo");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor()))
				.thenReturn(message);

		Mockito.when(portoMsMensageriaService.enviaSms("11", "974220722", message, CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.CELULAR,TipoFluxoEnum.SIMPLES).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(prospectService, Mockito.times(1)).consultaProdutosProspect(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).salvar(usuarioPortalCliente);

		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);
		Mockito.verify(mensagemLocalCacheService, Mockito.times(1))
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor());
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaSms("11", "974220722", message, CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosProspectVDO, CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoAtivacaoPorSMSSucessoWhenStatusUsuarioTentativaCadastro() {

		usuarioPortalCliente.setNumCelular(974220722L);
		usuarioPortalCliente.setNumDddCelular(11L);
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.getStatusUsuario()
				.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		TipoUsuario tipoUsuarioConquista = new TipoUsuario();
		tipoUsuarioConquista.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_CONQUISTA.getCodTipo());
		produtosProspectConquista.getIsClienteArenaCadastrado().setDddNumeroTelefone(new BigDecimal("11"));
		produtosProspectConquista.getIsClienteArenaCadastrado().setNumeroTelefone("974220722");

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.PROSPECT_CONQUISTA, new Date(), null,
				new TelefoneVO("11", "974220722"));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosProspectConquista));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectConquista)).thenReturn(tipoUsuarioConquista);
		Mockito.when(usuarioPortalService.obtemClienteTitular(pessoas)).thenReturn(Mono.just(pessoas.get(0)));
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosProspectConquista, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));

		String message = "Porto Seguro: Para concluir o seu processo de cadastro de conta no Portal do Cliente, utilize o codigo de seguranca: {parameterReplace}.";

		message = message.replaceAll("\\{parameterReplace\\}", "1234567");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor()))
				.thenReturn(message);

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_ATIVACAO.getValor()))
				.thenReturn("envio codigo");

		Mockito.when(portoMsMensageriaService.enviaSms("11", "974220722", message, CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.CELULAR,TipoFluxoEnum.SIMPLES).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(prospectService, Mockito.times(1)).consultaProdutosProspect(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).salvar(usuarioPortalCliente);
		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(CPF_PADRAO);
		Mockito.verify(mensagemLocalCacheService, Mockito.times(1))
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor());
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaSms("11", "974220722", message, CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosProspectConquista,
				CPF_PADRAO);
	}

	@Test
	public void testEnviaCodigoAtivacaoPorSMSSucessoWhenStatusUsuarioExcluido() {

		usuarioPortalCliente.setNumCelular(974220722L);
		usuarioPortalCliente.setNumDddCelular(11L);
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.getStatusUsuario()
				.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus());

		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		TipoUsuario tipoUsuarioConquista = new TipoUsuario();
		tipoUsuarioConquista.setIdTipoUsuario(TipoUsuarioEnum.PROSPECT_CONQUISTA.getCodTipo());
		produtosProspectConquista.getIsClienteArenaCadastrado().setDddNumeroTelefone(new BigDecimal("11"));
		produtosProspectConquista.getIsClienteArenaCadastrado().setNumeroTelefone("974220722");

		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.PROSPECT_CONQUISTA, new Date(), null,
				new TelefoneVO("11", "974220722"));

		Mockito.when(prospectService.consultaProdutosProspect(CPF_PADRAO))
				.thenReturn(Mono.just(produtosProspectConquista));
		Mockito.when(prospectService.aplicaRegraProspect(produtosProspectConquista)).thenReturn(tipoUsuarioConquista);
		Mockito.when(usuarioPortalService.obtemClienteTitular(pessoas)).thenReturn(Mono.just(pessoas.get(0)));
		Mockito.when(usuarioPortalService.consultar(CPF_PADRAO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(
				usuarioPortalService.salvar(usuarioPortalService.alteraUsuarioPortal(pessoaVo, usuarioPortalCliente,TipoFluxoEnum.SIMPLES)))
				.thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosProspectConquista, CPF_PADRAO))
				.thenReturn(Mono.just(pessoaVO));

		String message = "Porto Seguro: Para concluir o seu processo de cadastro de conta no Portal do Cliente, utilize o codigo de seguranca: {parameterReplace}.";

		message = message.replaceAll("\\{parameterReplace\\}", "1234567");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor()))
				.thenReturn(message);

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_ATIVACAO.getValor()))
				.thenReturn("envio codigo");

		Mockito.when(portoMsMensageriaService.enviaSms("11", "974220722", message, CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));
		
		Mockito.when(ldapFacade.criarUsuario(Mockito.any(UsuarioPortalCliente.class),
				Mockito.any(TipoUsuarioVO.class))).thenReturn(Mono.just(Boolean.TRUE));

		codigoAtivacaoService.enviaCodigoAtivacao(CPF_PADRAO, TipoEnvioEnum.CELULAR,TipoFluxoEnum.SIMPLES).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(prospectService, Mockito.times(1)).consultaProdutosProspect(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).salvar(usuarioPortalCliente);
		Mockito.when(tokenAAService.geraPinCliente(CPF_PADRAO)).thenReturn(Mono.just(pinVo));
		Mockito.verify(mensagemLocalCacheService, Mockito.times(1))
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_ATIVACAO_CELULAR.getValor());
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaSms("11", "974220722", message, CPF_PADRAO);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).obtemPessoaPorProdutos(produtosProspectConquista,
				CPF_PADRAO);
	}

	@Test
	public void testValidarCodigoAtivacaoSucesso() {

		UsuarioStatusConta usuarioStatusConta = new UsuarioStatusConta();
		usuarioStatusConta.setIdStatusConta(4L);

		UsuarioPortalCliente usuarioPortalAtivacao = new UsuarioPortalCliente();
		usuarioPortalAtivacao.setIdUsuario(1212L);
		usuarioPortalAtivacao.setQuantidadeTentativaCriacaoConta(null);
		usuarioPortalAtivacao.setStatusUsuario(usuarioStatusConta);
		usuarioPortalAtivacao.setCnpjCpf(228903908L);
		usuarioPortalAtivacao.setCnpjOrdem(0L);
		usuarioPortalAtivacao.setCnpjCpfDigito(2L);

		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(
				Date.from(LocalDateTime.now().atZone(TimeZone.getDefault().toZoneId()).toInstant()));
		Mockito.when(usuarioPortalService.consultar("27911372039")).thenReturn(Mono.just(usuarioPortalAtivacao));

		Mockito.when(segurancaContaPortalUsuarioRepository
				.findByCodigoSegurancaUsuarioAndNumeroSequenciaUsuarioAndCodigoTipoSeguranca(1212L, 7654321L, 1))
				.thenReturn(segurancaContaPortalUsuario);

		Mockito.when(usuarioPortalService.salvar(usuarioPortalAtivacao)).thenReturn(Mono.just(usuarioPortalAtivacao));

		Mockito.when(tokenAAService.validaTokenCliente(CPF_PADRAO, "7654321")).thenReturn(Mono.just(tokenResponse));

		Mockito.when(this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_VALIDACAO_COD_ATIVACAO.getValor()))
				.thenReturn("Validação de código de ativação realizado em {data} por {aplicacao}");

		codigoAtivacaoService.validaCodigoAtivacao("27911372039", "7654321").map(retornoValidaCodigo -> {
			Assert.assertNotNull(retornoValidaCodigo);
			return retornoValidaCodigo;
		}).subscribe();
		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar("27911372039");
		Mockito.verify(segurancaContaPortalUsuarioRepository, Mockito.times(0))
				.findByCodigoSegurancaUsuarioAndNumeroSequenciaUsuarioAndCodigoTipoSeguranca(1212L, 7654321L, 1);
		Mockito.verify(usuarioPortalService, Mockito.times(1)).salvar(usuarioPortalAtivacao);
	}

	@Test
	public void testValidarCodigoAtivacaoUsuarioExcessoTentativa() {

		UsuarioStatusConta usuarioStatusConta = new UsuarioStatusConta();
		usuarioStatusConta.setIdStatusConta(5L);

		UsuarioPortalCliente usuarioPortalAtivacao = new UsuarioPortalCliente();
		usuarioPortalAtivacao.setIdUsuario(1212L);
		usuarioPortalAtivacao.setQuantidadeTentativaCriacaoConta(6L);
		usuarioPortalAtivacao.setStatusUsuario(usuarioStatusConta);

		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(
				Date.from(LocalDateTime.now().atZone(TimeZone.getDefault().toZoneId()).toInstant()));

		Mockito.when(usuarioPortalService.consultar("27911372039")).thenReturn(Mono.just(usuarioPortalAtivacao));

		codigoAtivacaoService.validaCodigoAtivacao("27911372039", "7654321").doOnError(erro -> {
			CodigoSegurancaException error = (CodigoSegurancaException) erro;
			assertEquals("", "Número de tentativas excedidas.", error.getMessage());
			assertEquals("", 404, error.getStatusCode());
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar("27911372039");
	}

	@Test
	public void testValidarCodigoAtivacaoInvalido() {

		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus());
		usuarioPortalCliente.setStatusUsuario(statusConta);
		UsuarioPortalCliente usuarioPortalAtivacao = new UsuarioPortalCliente();
		usuarioPortalAtivacao.setIdUsuario(1212L);
		usuarioPortalAtivacao.setQuantidadeTentativaCriacaoConta(null);

		Mockito.when(usuarioPortalService.consultar("27911372039")).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(segurancaContaPortalUsuarioRepository
				.findByCodigoSegurancaUsuarioAndNumeroSequenciaUsuarioAndCodigoTipoSeguranca(1212L, 7654321L, 1))
				.thenReturn(null);

		codigoAtivacaoService.validaCodigoAtivacao("27911372039", "7654321").doOnError(erro -> {
			CodigoSegurancaException error = (CodigoSegurancaException) erro;
			assertEquals("", "Código de ativação inválido.", error.getMessage());
			assertEquals("", 404, error.getStatusCode());
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar("27911372039");
		Mockito.verify(segurancaContaPortalUsuarioRepository, Mockito.times(0))
				.findByCodigoSegurancaUsuarioAndNumeroSequenciaUsuarioAndCodigoTipoSeguranca(1212L, 7654321L, 1);
	}

	@Test
	public void testValidarCodigoAtivacaoExpirado() {

		LocalDateTime localDate = LocalDateTime.of(2018, 6, 28, 19, 18);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(
				Date.from(localDate.atZone(TimeZone.getDefault().toZoneId()).toInstant()));

		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());
		usuarioPortalCliente.setStatusUsuario(statusConta);

		Mockito.when(usuarioPortalService.consultar("27911372039")).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(segurancaContaPortalUsuarioRepository
				.findByCodigoSegurancaUsuarioAndNumeroSequenciaUsuarioAndCodigoTipoSeguranca(1212L, 7654321L, 1))
				.thenReturn(segurancaContaPortalUsuario);
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));
		
		codigoAtivacaoService.validaCodigoAtivacao("27911372039", "7654321").doOnError(erro -> {
			CodigoSegurancaException error = (CodigoSegurancaException) erro;
			assertEquals("", "Código de ativação expirado.", error.getMessage());
			assertEquals("", 404, error.getStatusCode());
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar("27911372039");
		Mockito.verify(segurancaContaPortalUsuarioRepository, Mockito.times(0))
				.findByCodigoSegurancaUsuarioAndNumeroSequenciaUsuarioAndCodigoTipoSeguranca(1212L, 7654321L, 1);
	}
}
