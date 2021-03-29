package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

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

import com.porto.portocom.portal.cliente.entity.ParametrosSistema;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.exception.CadastroException;
import com.porto.portocom.portal.cliente.v1.exception.LdapException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMsMensageriaService;
import com.porto.portocom.portal.cliente.v1.integration.facade.LdapFacade;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.service.CadastroService;
import com.porto.portocom.portal.cliente.v1.service.ICodigoAtivacaoService;
import com.porto.portocom.portal.cliente.v1.service.ICodigoRecuperacaoService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.service.MensagemLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.vo.usuario.CadastroSenha;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContadorConta;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TipoUsuarioVO;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastroServiceUnitTest {

	private static final String NOME = "Adriano";
	private static final String SOBRENOME = "Santos";
	private static final String USUARIO = "22890390802";
	private static final String SENHA = "senha123";
	private static final String PIN = "123456";

	private static final String CODIGO_USUARIO_INVALIDO = "1";

	@Mock
	private IUsuarioPortalService usuarioPortalService;

	@Mock
	private MensagemLocalCacheService mensagemLocalCacheService;

	@Mock
	private ICodigoRecuperacaoService codigoRecuperacaoService;

	@Mock
	private ICodigoAtivacaoService codigoAtivacaoService;

	@Mock
	private LdapFacade ldapFacade;

	@Mock
	private CadastroService cadastroServiceMock;

	@Mock
	private IUsuarioPortalClienteRepository usuarioPortalClienteRepository;

	@Mock
	private IUsuarioStatusContaRepository usuarioStatusContaRepository;

	@Mock
	private static ParametrosLocalCacheService parametrosLocalCacheService;

	@Mock
	private IPortoMsMensageriaService portoMsMensageriaService;

	@InjectMocks
	private CadastroService cadastroService;

	private static CadastroSenha cadastro;

	private static UsuarioPortalCliente usuarioPortalCliente;

	private static InformacaoCodigoSeguranca informacacaoCodigoSeguranca;

	private static final String CPF_PADRAO = "22890390802";

	private static final String ASSUNTO_EMAIL = "Porto Seguro Portal de Clientes - Conta Cadastrada";

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
		parametros.put("porto.ms.usuario.nome.portal.email",
				new ParametrosSistema(28L, "porto.ms.usuario.nome.portal.email", "portaldecliente"));
		parametros.put("porto.ms.usuario.assunto.cadastro.conta.email", new ParametrosSistema(845L,
				"porto.ms.usuario.assunto.cadastro.conta.email", "Porto Seguro Portal de Clientes - Conta Cadastrada"));
		parametrosLocalCacheService.getParametros().putAll(parametros);

		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.protocolo.email"))
				.thenReturn("http");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.endereco.email"))
				.thenReturn("otclientdevm.portoseguro.brasil");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.remetente.email"))
				.thenReturn("portaldocliente@portoseguro.com.br");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.nome.portal.email"))
				.thenReturn("portaldecliente");
		Mockito.when(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.assunto.cadastro.conta.email"))
				.thenReturn("Porto Seguro Portal de Clientes - Conta Cadastrada");

		criaCadastroSenha();
		criaUsuarioPortalCliente();
		criaInformacaoCodigoSeguranca();
	}

	public static void criaCadastroSenha() {
		CadastroSenha cadastroBuilder = new CadastroSenha();
		cadastroBuilder.setNome(NOME);
		cadastroBuilder.setSobrenome(SOBRENOME);
		cadastroBuilder.setUsuario(USUARIO);
		cadastroBuilder.setSenha(SENHA);
		cadastroBuilder.setPin(PIN);
		cadastro = cadastroBuilder;
	}

	public static void criaInformacaoCodigoSeguranca() {
		InformacaoContadorConta infContador = new InformacaoContadorConta(0L, 0L, Boolean.TRUE);
		informacacaoCodigoSeguranca = new InformacaoCodigoSeguranca(null, null, infContador);
	}

	public static void criaUsuarioPortalCliente() {
		usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(668910L);
		usuarioPortalCliente.setCnpjCpf(228903908L);
		usuarioPortalCliente.setCnpjOrdem(0L);
		usuarioPortalCliente.setCnpjCpfDigito(2L);
		usuarioPortalCliente.setDescEmail("adriano.santos@portoseguro.com.br");
		usuarioPortalCliente.setNomeUsuarioPortal("Adriano Santos");
	}

	@Test
	public void testCadastroSenha01SucessoAlterar() {

		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus());
		usuarioPortalCliente.setStatusUsuario(statusConta);

		Mockito.when(this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_NOVA_CONTA_CADASTRADA_EMAIL.getValor()))
				.thenReturn("");

		Mockito.when(this.usuarioPortalService.consultar(USUARIO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(this.cadastroServiceMock.alteraSenhaCadastro(USUARIO, SENHA, PIN))
				.thenReturn(Mono.just(Boolean.TRUE));
		Mockito.when(this.usuarioPortalClienteRepository.save(usuarioPortalCliente)).thenReturn(usuarioPortalCliente);
		Mockito.when(this.codigoAtivacaoService.validaCodigoAtivacaoCadastroSenha(USUARIO, PIN)).thenReturn(Mono
				.just(new InformacaoCodigoSeguranca(null, null, new InformacaoContadorConta(0L, 0L, Boolean.TRUE))));
		Mockito.when(this.ldapFacade.atualizarSenha(USUARIO, SENHA, null)).thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), ASSUNTO_EMAIL, "", CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));

		this.cadastroService.cadastroSenha(cadastro).map(sucesso -> {
			assertTrue("Senha cadastrada com sucesso.", sucesso);
			return sucesso;
		}).subscribe();
	}

	@Test
	public void testCadastroSenha02SucessoCriar() {

		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus());
		usuarioPortalCliente.setStatusUsuario(statusConta);
		
		Mockito.when(this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_MENSAGEM_NOVA_CONTA_CADASTRADA_EMAIL.getValor()))
				.thenReturn("");

		Mockito.when(this.usuarioPortalService.consultar(USUARIO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(this.cadastroServiceMock.alteraSenhaCadastro(USUARIO, SENHA, PIN))
				.thenReturn(Mono.error(new UsuarioPortalException("Usuário inválido", 404)));
		Mockito.when(this.usuarioPortalClienteRepository.save(usuarioPortalCliente)).thenReturn(usuarioPortalCliente);
		Mockito.when(this.cadastroServiceMock.criarUsuarioComSenha(
				CadastroSenha.builder().nome(NOME).pin(PIN).senha(SENHA).sobrenome(SOBRENOME).usuario(USUARIO).build(),
				TipoUsuarioVO.builder().idTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo()).build()))
				.thenReturn(Mono.just(Boolean.TRUE));

		Mockito.when(this.codigoAtivacaoService.validaCodigoAtivacaoCadastroSenha(USUARIO, PIN)).thenReturn(Mono
				.just(new InformacaoCodigoSeguranca(null, null, new InformacaoContadorConta(0L, 0L, Boolean.TRUE))));
		Mockito.when(this.ldapFacade.atualizarSenha(USUARIO, SENHA, null)).thenReturn(Mono.just(Boolean.TRUE));
		
		Mockito.when(portoMsMensageriaService.enviaEmail("portaldocliente@portoseguro.com.br",
				usuarioPortalCliente.getDescEmail(), ASSUNTO_EMAIL, "", CPF_PADRAO))
				.thenReturn(Mono.just(Boolean.TRUE));

		this.cadastroService.cadastroSenha(cadastro).map(sucesso -> {
			assertTrue("Senha cadastrada com sucesso.", sucesso);
			return sucesso;
		}).subscribe();
	}

	@Test
	public void testCadastroSenha03FalhaStatusNuloAgua() {

		usuarioPortalCliente.setStatusUsuario(null);

		Mockito.when(usuarioPortalService.consultar(USUARIO)).thenReturn(Mono.just(usuarioPortalCliente));

		this.cadastroService.cadastroSenha(cadastro).doOnError(erro -> {
			CadastroException error = (CadastroException) erro;
			assertEquals("", "Status da conta do usuário diferente de Aguardando primeiro login.", error.getMessage());
			assertEquals("", 404, error.getStatusCode());
		}).subscribe();
	}

	@Test
	public void testCadastroSenha04FalhaIdStatusNulo() {
		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(null);
		usuarioPortalCliente.setStatusUsuario(statusConta);

		Mockito.when(usuarioPortalService.consultar(USUARIO)).thenReturn(Mono.just(usuarioPortalCliente));

		this.cadastroService.cadastroSenha(cadastro).doOnError(erro -> {
			CadastroException error = (CadastroException) erro;
			assertEquals("", "Status da conta do usuário diferente de Aguardando primeiro login.", error.getMessage());
			assertEquals("", 404, error.getStatusCode());
		}).subscribe();
	}

	@Test
	public void testCadastroSenha05FalhaIdStatusDiferenteAguardandoPrimeiroLogin() {
		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());
		usuarioPortalCliente.setStatusUsuario(statusConta);

		Mockito.when(usuarioPortalService.consultar(USUARIO)).thenReturn(Mono.just(usuarioPortalCliente));

		this.cadastroService.cadastroSenha(cadastro).doOnError(erro -> {
			CadastroException error = (CadastroException) erro;
			assertEquals("", "Status da conta do usuário diferente de Aguardando primeiro login.", error.getMessage());
			assertEquals("", 404, error.getStatusCode());
		}).subscribe();
	}

	@Test
	public void testRedefineSenhaSucesso() {

		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus());
		usuarioPortalCliente.setStatusUsuario(statusConta);

		Mockito.when(usuarioPortalService.consultar(USUARIO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(this.codigoRecuperacaoService.validaCodigo(PIN, usuarioPortalCliente))
				.thenReturn(Mono.just(informacacaoCodigoSeguranca));

		Mockito.when(this.ldapFacade.atualizarSenha(USUARIO, SENHA, null)).thenReturn(Mono.just(Boolean.TRUE));

		this.cadastroService.alteraSenhaUsuario(USUARIO, SENHA, PIN).map(sucesso -> {
			assertTrue("Senha alterada com sucesso.", sucesso);
			return sucesso;
		}).subscribe();
	}

	@Test
	public void testRedefineSenhaValidacaoRetornaFalse() {

		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus());
		usuarioPortalCliente.setStatusUsuario(statusConta);

		Mockito.when(usuarioStatusContaRepository
				.findByIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus()))
				.thenReturn(statusConta);

		Mockito.when(usuarioPortalService.consultar(USUARIO)).thenReturn(Mono.just(usuarioPortalCliente));

		Mockito.when(this.codigoRecuperacaoService.validaCodigo(PIN, usuarioPortalCliente)).thenReturn(Mono
				.just(new InformacaoCodigoSeguranca(null, null, new InformacaoContadorConta(0L, 0L, Boolean.FALSE))));

		Mockito.when(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_REDEFINIR_SENHA.getValor()))
				.thenReturn("Erro ao validar senha.");

		this.cadastroService.alteraSenhaUsuario(USUARIO, SENHA, PIN).doOnError(erro -> {
			assertEquals("", "Erro ao validar senha.", erro.getMessage());
		}).subscribe();
	}

	@Test
	public void testRedefineSenha06FalhaAlterarExcecaoGenerica() {

		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus());
		usuarioPortalCliente.setStatusUsuario(statusConta);

		Mockito.when(usuarioPortalService.consultar(USUARIO)).thenReturn(Mono.error(new Exception()));

		this.cadastroService.cadastroSenha(cadastro).doOnError(erro -> {
			assertEquals("", "Exceção genérica.", erro.getMessage());
		}).subscribe();
	}

	@Test
	public void testRedefineSenha07FalhaAlterarCodigoGenerico() {

		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus());
		usuarioPortalCliente.setStatusUsuario(statusConta);

		Mockito.when(usuarioPortalService.consultar(USUARIO)).thenReturn(Mono.error(new Exception()));

		this.cadastroService.cadastroSenha(cadastro).doOnError(erro -> {
			assertEquals("", "Não foi possível redefinir a senha.", erro.getMessage());
		}).subscribe();
	}

	@Test
	public void testCadastroSenha08FalhaAlterarECriar() {

		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus());
		usuarioPortalCliente.setStatusUsuario(statusConta);

		Mockito.when(usuarioPortalService.consultar(USUARIO)).thenReturn(Mono.just(usuarioPortalCliente));
		Mockito.when(this.cadastroServiceMock.alteraSenhaCadastro(USUARIO, SENHA, PIN))
				.thenReturn(Mono.error(new LdapException("Usuário inválido", CODIGO_USUARIO_INVALIDO)));
		Mockito.when(this.cadastroServiceMock.criarUsuarioComSenha(
				CadastroSenha.builder().nome(NOME).pin(PIN).senha(SENHA).sobrenome(SOBRENOME).usuario(USUARIO).build(),
				TipoUsuarioVO.builder().idTipoUsuario(usuarioPortalCliente.getTipoUsuario().getIdTipoUsuario())
						.build()))
				.thenReturn(Mono.error(new Exception("Exceção genérica.")));

		Mockito.when(this.codigoAtivacaoService.validaCodigoAtivacao(USUARIO, PIN)).thenReturn(Mono
				.just(new InformacaoCodigoSeguranca(null, null, new InformacaoContadorConta(0L, 0L, Boolean.TRUE))));
		Mockito.when(this.ldapFacade.atualizarSenha(USUARIO, SENHA, null)).thenReturn(Mono.just(Boolean.TRUE));
		this.cadastroService.cadastroSenha(cadastro).doOnError(erro -> {
			assertEquals("", "Exceção genérica.", erro.getMessage());
		}).subscribe();
	}

	@Test
	public void testCadastroSenha09FalhaCadastroNulo() {

		this.cadastroService.cadastroSenha(null).doOnError(erro -> {
			assertEquals("", "Cadastro vazio.", erro.getMessage());
		}).subscribe();
	}

	@Test
	public void testCadastroSenha10FalhaCadastroNomeNulo() {
		CadastroSenha cadastroBuilder = new CadastroSenha();
		cadastroBuilder.setSobrenome(SOBRENOME);
		cadastroBuilder.setUsuario(USUARIO);
		cadastroBuilder.setSenha(SENHA);

		this.cadastroService.cadastroSenha(cadastroBuilder).doOnError(erro -> {
			assertEquals("", "Nome não informado.", erro.getMessage());
		}).subscribe();
	}

	@Test
	public void testCadastroSenha11FalhaCadastroSobrenomeNulo() {
		CadastroSenha cadastroBuilder = new CadastroSenha();
		cadastroBuilder.setNome(NOME);
		cadastroBuilder.setUsuario(USUARIO);
		cadastroBuilder.setSenha(SENHA);

		this.cadastroService.cadastroSenha(cadastroBuilder).doOnError(erro -> {
			assertEquals("", "Sobrenome não informado", erro.getMessage());
		}).subscribe();
	}

	@Test
	public void testCadastroSenha12FalhaCadastroUsuarioNulo() {
		CadastroSenha cadastroBuilder = new CadastroSenha();
		cadastroBuilder.setNome(NOME);
		cadastroBuilder.setSobrenome(SOBRENOME);
		cadastroBuilder.setSenha(SENHA);

		this.cadastroService.cadastroSenha(cadastroBuilder).doOnError(erro -> {
			assertEquals("", "Usuário não informado", erro.getMessage());
		}).subscribe();
	}

	@Test
	public void testCadastroSenha13FalhaCadastroSenhaNulo() {
		CadastroSenha cadastroBuilder = new CadastroSenha();
		cadastroBuilder.setNome(NOME);
		cadastroBuilder.setSobrenome(SOBRENOME);
		cadastroBuilder.setUsuario(USUARIO);

		this.cadastroService.cadastroSenha(cadastroBuilder).doOnError(erro -> {
			assertEquals("", "Senha não informada.", erro.getMessage());
		}).subscribe();
	}

}
