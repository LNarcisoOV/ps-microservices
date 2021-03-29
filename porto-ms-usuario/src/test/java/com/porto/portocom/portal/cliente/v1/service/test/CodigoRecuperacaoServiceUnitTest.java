package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.apache.commons.lang3.StringUtils;
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

import com.porto.experiencia.cliente.lexisnexis.SessionQueryResponse;
import com.porto.portocom.portal.cliente.entity.ParametrosSistema;
import com.porto.portocom.portal.cliente.entity.SegurancaContaPortalUsuario;
import com.porto.portocom.portal.cliente.entity.SegurancaContaPortalUsuarioId;
import com.porto.portocom.portal.cliente.entity.TipoCodigoSeguranca;
import com.porto.portocom.portal.cliente.entity.TipoUsuario;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;
import com.porto.portocom.portal.cliente.v1.constant.LexisNexisStatusEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoEnvioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.dto.bcp.ContratoBcp;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Fisica;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Pessoa;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Telefones;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMsMensageriaService;
import com.porto.portocom.portal.cliente.v1.model.PinVO;
import com.porto.portocom.portal.cliente.v1.repository.ISegurancaContaPortalUsuarioRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.service.CodigoRecuperacaoService;
import com.porto.portocom.portal.cliente.v1.service.ILogPortalClienteService;
import com.porto.portocom.portal.cliente.v1.service.IPortalLexisNexisService;
import com.porto.portocom.portal.cliente.v1.service.IProdutoService;
import com.porto.portocom.portal.cliente.v1.service.IProspectService;
import com.porto.portocom.portal.cliente.v1.service.ITokenAAService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.service.MensagemLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect.ConsultaProdutosProspectBuilder;
import com.porto.portocom.portal.cliente.v1.vo.usuario.DadosAcessoVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.PessoaVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TelefoneVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TipoUsuarioVO;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CodigoRecuperacaoServiceUnitTest {

	private static final short DDD = 11;

	private static final long TELEFONE_NOVE_DIGITOS = 960624730;

	private static final long TELEFONE_OITO_DIGITOS = 60624730;
	
	private static List<Telefones> telefones;

	private static List<PessoaBcp.Pessoa> pessoas;

	private static UsuarioPortalCliente usuarioPortalCliente;

	private static TipoCodigoSeguranca tipoCodigoSeguranca;

	private static SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId;

	private static SegurancaContaPortalUsuario segurancaContaPortalUsuario;
	
	private ConsultaProdutosProspect produtosCliente;
	
	@Mock
	private ILogPortalClienteService logPortalClienteService;

	@Mock
	private static ParametrosLocalCacheService parametrosLocalCacheService;

	@Mock
	private ITokenAAService tokenAAService;

	@Mock
	private IPortoMsMensageriaService portoMsMensageriaService;

	@Mock
	private IProdutoService produtoService;

	@Mock
	private IProspectService defineProspectService;

	@Mock
	private IUsuarioPortalService usuarioPortalService;

	@Mock
	private ISegurancaContaPortalUsuarioRepository segurancaContaPortalUsuarioRepository;

	@Mock
	private MensagemLocalCacheService mensagemLocalCacheService;

	@Mock
	private IUsuarioStatusContaRepository usuarioStatusContaRepository;
	
	@Mock
	private IPortalLexisNexisService portalLexisNexisService;

	@InjectMocks
	private CodigoRecuperacaoService codigoRecuperacaoService;
	
	private PinVO pinVo;

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

		parametros.put("porto.ms.usuario.tentativas.recuperacao",
				new ParametrosSistema(1L, "porto.ms.usuario.tentativas.recuperacao", "5"));

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
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.tentativas.recuperacao"))
				.thenReturn("5");

		UsuarioStatusConta usuarioStatusConta = new UsuarioStatusConta();
		usuarioStatusConta.setDescricaoStatusConta("descricao");
		usuarioStatusConta.setIdStatusConta(5L);

		Mockito.when(this.usuarioStatusContaRepository
				.findByIdStatusConta(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus()))
				.thenReturn(usuarioStatusConta);
		pinVo = new PinVO(LocalDateTime.now(), LocalDateTime.now(), "12345");

		preencheTelefones();
		criaListaPessoaBcp();
		criaUsuarioPortal();
		criarSegurancaContaPortalUsuario();
		criaProdutosCliente();
		
		MDC.put(HeaderAplicacaoEnum.NOME_APLICACAO.getValor(),"teste");
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

	public static void criaListaPessoaBcp() throws DatatypeConfigurationException {
		PessoaBcp.Pessoa pessoa = new PessoaBcp.Pessoa();
		pessoa.setNumeroPessoa(1L);
		pessoa.setCodigoTipoPessoa("1");
		pessoa.setNomePessoa("Teste");
		Fisica fisica = new Fisica();
		fisica.setDataNascimento(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
		pessoa.setFisica(fisica);
		pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa);

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
	public void testEnviaCodigoAtivacaoPorSMSSucessoWhenContaAtiva() {
		String cpf = "22890390802";

		usuarioPortalCliente.setNumCelular(974220722L);
		usuarioPortalCliente.setNumDddCelular(11L);
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setQtdTentativaLogin(0L);
		usuarioPortalCliente.setQuantidadeAcessoLogin(0L);
		usuarioPortalCliente.setQuantidadeTentativaCriacaoConta(0L);
		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(12L);
		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(2L);
		tipoUsuario.setFlagTipoUsuario("S");

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());
		
		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.CLIENTE, new Date(), usuarioPortalCliente.getDescEmail(), null);

		Mockito.when(usuarioPortalService.consultar(cpf)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(tokenAAService.geraPinCliente(cpf)).thenReturn(Mono.just(pinVo));

		String message = "Porto Seguro: Para concluir o seu processo de cadastro de conta no Portal do Cliente, utilize o codigo de seguranca: {parameterReplace}.";

		message = message.replaceAll("\\{parameterReplace\\}", "1234567");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_RECUPERACAO_CELULAR.getValor()))
				.thenReturn(message);

		Mockito.when(portoMsMensageriaService.enviaSms("11", "974220722", message, "22890390802"))
				.thenReturn(Mono.just(Boolean.TRUE));
		
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_RECUPERACAO.getValor()))
				.thenReturn("envio codigo");

		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(tokenAAService.geraPinCliente(cpf)).thenReturn(Mono.just(pinVo));
		Mockito.when(portalLexisNexisService.validaRecuperacaoContaLexisNexis(Mockito.any()))
				.thenReturn(new SessionQueryResponse(LexisNexisStatusEnum.PASS.getValor(),
						"911d47c1-49b9-489e-8492-091ecd21f0a6", "success", null));
		Mockito.when(usuarioPortalService.consultarDadosAcesso(cpf)).thenReturn(Mono.just(new DadosAcessoVO()));
		Mockito.when(defineProspectService.consultaProdutosProspect(cpf)).thenReturn(Mono.just(produtosCliente));
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosCliente, cpf)).thenReturn(Mono.just(pessoaVO));

		codigoRecuperacaoService.enviaCodigo(cpf, TipoEnvioEnum.CELULAR).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(cpf);
		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(cpf);
		Mockito.verify(mensagemLocalCacheService, Mockito.times(1))
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_RECUPERACAO_CELULAR.getValor());
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaSms("11", "974220722",
				message, "22890390802");
	}

	@Test
	public void testEnviaCodigoAtivacaoPorSMSSucessoWhenAguardandoPrimeiroLogin() {
		String cpf = "22890390802";

		usuarioPortalCliente.setNumCelular(974220722L);
		usuarioPortalCliente.setNumDddCelular(11L);
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setQtdTentativaLogin(0L);
		usuarioPortalCliente.setQuantidadeAcessoLogin(0L);
		usuarioPortalCliente.setQuantidadeTentativaCriacaoConta(0L);
		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(0L);
		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(2L);
		tipoUsuario.setFlagTipoUsuario("S");

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());
		
		PessoaVO pessoaVO = montaPessoa(TipoUsuarioEnum.CLIENTE, new Date(), usuarioPortalCliente.getDescEmail(), null);

		Mockito.when(usuarioPortalService.consultar(cpf)).thenReturn(Mono.just(usuarioPortalCliente));

		String message = 
				"Porto Seguro: Para concluir o seu processo de cadastro de conta no Portal do Cliente, utilize o codigo de seguranca: {parameterReplace}.";

		message = message.replaceAll("\\{parameterReplace\\}", "1234567");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_RECUPERACAO_CELULAR.getValor()))
				.thenReturn(message);
		
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_SMS_RECUPERACAO.getValor()))
				.thenReturn("envio codigo");
		Mockito.when(tokenAAService.geraPinCliente(cpf)).thenReturn(Mono.just(pinVo));
		Mockito.when(portoMsMensageriaService.enviaSms("11", "974220722", message, "22890390802"))
				.thenReturn(Mono.just(Boolean.TRUE));
		Mockito.when(portalLexisNexisService
				.validaRecuperacaoContaLexisNexis(Mockito.any()))
				.thenReturn(new SessionQueryResponse(LexisNexisStatusEnum.PASS.getValor(),
						"911d47c1-49b9-489e-8492-091ecd21f0a6", "success", null));
		Mockito.when(usuarioPortalService.consultarDadosAcesso(cpf)).thenReturn(Mono.just(new DadosAcessoVO()));
		Mockito.when(defineProspectService.consultaProdutosProspect(cpf)).thenReturn(Mono.just(produtosCliente));
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosCliente, cpf)).thenReturn(Mono.just(pessoaVO));

		codigoRecuperacaoService.enviaCodigo(cpf, TipoEnvioEnum.CELULAR).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(cpf);
		Mockito.verify(mensagemLocalCacheService, Mockito.times(1))
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_RECUPERACAO_CELULAR.getValor());
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaSms("11", "974220722",
				message, "22890390802");
	}

	@Test
	public void testEnviaCodigoRecuperacaoPorSMSCpfInvalido() {
		String cpf = "2289039";
		String msgRetorno = "Cpf Invalido";
		
		Mockito.when(usuarioPortalService.consultar(cpf))
		.thenReturn(Mono.error(new CpfCnpjInvalidoException("Cpf Invalido")));
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_VALIDACAO_CPF_CNPJ.getValor()))
				.thenReturn(msgRetorno);
		
		codigoRecuperacaoService.enviaCodigo(cpf, TipoEnvioEnum.CELULAR).onErrorResume(error -> {
			CpfCnpjInvalidoException erro = (CpfCnpjInvalidoException) error;
			assertEquals(msgRetorno, erro.getMessage());
			return Mono.empty();
		}).subscribe();

	}
	
	
	@Test
	public void testEnviaCodigoRecuperacaoPorSMSWhenUsuarioInvalido() {
		String cpf = "22890390802";
		
		String msgRetorno = "Usuário não está elegível para receber o código de recuperação.";

		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(5L);
		TipoCodigoSeguranca tipoCodigoSeguranca = new TipoCodigoSeguranca();
		tipoCodigoSeguranca.setCodigoTipoSeguranca(1);
		tipoCodigoSeguranca.setDescricaoTipoSeguranca("Codigo Seguranca Portal de Clientes");
		tipoCodigoSeguranca.setQuantidadeTempoValidade(20);
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(2L);
		tipoUsuario.setFlagTipoUsuario("S");

		SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId = new SegurancaContaPortalUsuarioId();
		segurancaContaPortalUsuarioId.setCodigoSegurancaUsuario(1234567L);
		segurancaContaPortalUsuarioId.setNumeroSequenciaUsuario(usuarioPortalCliente.getIdUsuario());
		segurancaContaPortalUsuarioId.setTipoCodigoSeguranca(tipoCodigoSeguranca);

		SegurancaContaPortalUsuario segurancaContaPortalUsuario = new SegurancaContaPortalUsuario();
		segurancaContaPortalUsuario.setId(segurancaContaPortalUsuarioId);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(new Date());

		Mockito.when(usuarioPortalService.consultar(cpf)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(tokenAAService.geraPinCliente(cpf)).thenReturn(Mono.just(pinVo));

		String message = 
				"Porto Seguro: Para concluir o seu processo de cadastro de conta no Portal do Cliente, utilize o codigo de seguranca: {parameterReplace}.";

		message= message.replaceAll("\\{parameterReplace\\}", "1234567");

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_RECUPERACAO_CELULAR.getValor()))
				.thenReturn(message);

		Mockito.when(portoMsMensageriaService.enviaSms("11", "974220722", message, "22890390802"))
				.thenReturn(Mono.just(Boolean.TRUE));

		codigoRecuperacaoService.enviaCodigo(cpf, TipoEnvioEnum.CELULAR).onErrorResume(error -> {
			UsuarioPortalException erro = (UsuarioPortalException) error;
			assertEquals(HttpStatus.BAD_REQUEST.value(), erro.getStatusCode());
			assertEquals(msgRetorno, erro.getMessage());
			assertNotNull(error);
			return Mono.empty();
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(cpf);
		Mockito.verify(mensagemLocalCacheService, Mockito.times(0))
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_RECUPERACAO_CELULAR.getValor());
		Mockito.verify(portoMsMensageriaService, Mockito.times(0)).enviaSms("11", "974220722",
				message, "22890390802");
	}

	@Test
	public void testEnviaCodigoRecuperacaoPorEmailAguardandoPrimeiroLoginSucesso() {
		String cpf = "22890390802";
		String assuntoEmail = "Porto Seguro Portal de Clientes - Nova Conta Cadastrada";

		usuarioPortalCliente.setDescEmail("felipe.rosa@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(0L);

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
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_RECUPERACAO_EMAIL.getValor()))
				.thenReturn("");

		Mockito.when(parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_ASSUNTO_RECUPERACAO_CONTA_EMAIL.getValor()))
		.thenReturn(assuntoEmail);
		Mockito.when(usuarioPortalService.consultar(cpf)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), assuntoEmail, "",
				"22890390802")).thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(tokenAAService.geraPinCliente(cpf)).thenReturn(Mono.just(pinVo));
		
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_RECUPERACAO.getValor()))
				.thenReturn("envio codigo");
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(tokenAAService.geraPinCliente(cpf)).thenReturn(Mono.just(pinVo));
		Mockito.when(portalLexisNexisService
				.validaRecuperacaoContaLexisNexis(Mockito.any()))
				.thenReturn(new SessionQueryResponse(LexisNexisStatusEnum.PASS.getValor(),
						"911d47c1-49b9-489e-8492-091ecd21f0a6", "success", null));
		Mockito.when(usuarioPortalService.consultarDadosAcesso(cpf)).thenReturn(Mono.just(new DadosAcessoVO()));
		Mockito.when(defineProspectService.consultaProdutosProspect(cpf)).thenReturn(Mono.just(produtosCliente));
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosCliente, cpf)).thenReturn(Mono.just(pessoaVO));

		codigoRecuperacaoService.enviaCodigo(cpf, TipoEnvioEnum.EMAIL).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(cpf);
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), assuntoEmail, "",
				"22890390802");
		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(cpf);
	}

	@Test
	public void testEnviaCodigoRecuperacaoPorEmailContaAtivaSucesso() {
		String cpf = "22890390802";
		String assuntoEMail = "Porto Seguro Portal de Clientes - Nova Conta Cadastrada";

		usuarioPortalCliente.setDescEmail("felipe.rosa@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.getStatusUsuario().setIdStatusConta(12L);

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
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_CODIGO_RECUPERACAO_EMAIL.getValor()))
				.thenReturn("");

		Mockito.when(usuarioPortalService.consultar(cpf)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(usuarioPortalService.salvar(usuarioPortalCliente)).thenReturn(Mono.just(usuarioPortalCliente));
		
		Mockito.when(parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_ASSUNTO_RECUPERACAO_CONTA_EMAIL.getValor()))
		.thenReturn(assuntoEMail);
		
		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), assuntoEMail, "",
				"22890390802")).thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(tokenAAService.geraPinCliente(cpf)).thenReturn(Mono.just(pinVo));
//		
		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_EMAIL_RECUPERACAO.getValor()))
				.thenReturn("envio codigo");
		Mockito.when(tokenAAService.geraPinCliente(cpf)).thenReturn(Mono.just(pinVo));
		Mockito.when(portalLexisNexisService
				.validaRecuperacaoContaLexisNexis(Mockito.any()))
				.thenReturn(new SessionQueryResponse(LexisNexisStatusEnum.PASS.getValor(),
						"911d47c1-49b9-489e-8492-091ecd21f0a6", "success", null));
		Mockito.when(usuarioPortalService.consultarDadosAcesso(cpf)).thenReturn(Mono.just(new DadosAcessoVO()));
		Mockito.when(defineProspectService.consultaProdutosProspect(cpf)).thenReturn(Mono.just(produtosCliente));
		Mockito.when(usuarioPortalService.obtemPessoaPorProdutos(produtosCliente, cpf)).thenReturn(Mono.just(pessoaVO));
		
		codigoRecuperacaoService.enviaCodigo(cpf, TipoEnvioEnum.EMAIL).map(retorno -> {
			assertTrue(retorno.getIsSucesso());
			return retorno;
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(cpf);
		Mockito.verify(portoMsMensageriaService, Mockito.times(1)).enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), assuntoEMail, "",
				"22890390802");
		Mockito.verify(tokenAAService, Mockito.times(1)).geraPinCliente(cpf);
	}

	@Test
	public void testEnviaCodigoRecuperacaoPorEmailUsuarioInelegivelSucesso() {
		String cpf = "22890390802";

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

		Mockito.when(usuarioPortalService.consultar(cpf))
				.thenReturn(Mono.error(new UsuarioPortalException("Usuario inelegível", 400)));

		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), "Porto Seguro Portal de Clientes - Nova Conta Cadastrada", "",
				"22890390802")).thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(tokenAAService.geraPinCliente(cpf)).thenReturn(Mono.just(pinVo));

		codigoRecuperacaoService.enviaCodigo(cpf, TipoEnvioEnum.EMAIL).doOnError(error -> {
			assertNotNull(error);
		}).subscribe();

		Mockito.verify(usuarioPortalService, Mockito.times(1)).consultar(cpf);
		Mockito.verify(portoMsMensageriaService, Mockito.times(0)).enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), "Porto Seguro Portal de Clientes - Nova Conta Cadastrada", "",
				"22890390802");
	}

}
