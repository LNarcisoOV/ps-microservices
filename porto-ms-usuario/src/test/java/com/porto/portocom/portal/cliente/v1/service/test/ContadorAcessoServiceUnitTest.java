package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static reactor.core.publisher.Mono.empty;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.entity.ParametrosSistema;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.ContadorAcessoException;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.service.ContadorAcessoService;
import com.porto.portocom.portal.cliente.v1.service.ILogPortalClienteService;
import com.porto.portocom.portal.cliente.v1.service.IPortalLexisNexisService;
import com.porto.portocom.portal.cliente.v1.service.LexisNexisService;
import com.porto.portocom.portal.cliente.v1.service.MensagemLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.UsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContador;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContadorConta;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContadorAcessoServiceUnitTest {

	private static final String KEY_ACESSO = "porto.ms.usuario.tentativas.login";
	private static final String KEY_CADASTRO = "porto.ms.usuario.tentativas.criacao.conta";
	private static final String PORTO_MS_USUARIO_TENTATIVAS_RECUPERACAO = "porto.ms.usuario.tentativas.recuperacao";

	@Mock
	private UsuarioPortalService usuarioPortalService;

	@Mock
	private ParametrosLocalCacheService parametrosLocalCacheService;

	@Mock
	private MensagemLocalCacheService mensagemLocalCacheService;

	@Mock
	private IPortalLexisNexisService portalLexisNexisService;

	@Mock
	private LexisNexisUtils lexisNexisUtil;

	@Mock
	private IUsuarioPortalClienteRepository usuarioPortalClienteRepository;

	@Mock
	private ILogPortalClienteService logPortalClienteService;

	@Mock
	private LexisNexisService lexisNexisService;

	@Spy
	@InjectMocks
	private ContadorAcessoService contadoresAcessoService;

	UsuarioPortalCliente usuario;

	UsuarioStatusConta usuarioStatus;

	private static final String cpfCnpjValid = "37488499824";

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		criaUsuarioPortal();
		Map<String, ParametrosSistema> parametros = new HashMap<>();
		parametros.put("porto.ms.usuario.tentativas.login",
				new ParametrosSistema(771L, "porto.ms.usuario.tentativas.login", "7"));
		parametrosLocalCacheService.getParametros().putAll(parametros);
	}

	@Test
	public void testConsultaContadoresAcessoCpfWhenValid() {

		when(usuarioPortalService.consultar(cpfCnpjValid)).thenReturn(Mono.just(usuario));
		when(parametrosLocalCacheService.recuperaParametro(KEY_ACESSO)).thenReturn("7");
		when(parametrosLocalCacheService.recuperaParametro(KEY_CADASTRO)).thenReturn("5");
		when(parametrosLocalCacheService.recuperaParametro(PORTO_MS_USUARIO_TENTATIVAS_RECUPERACAO)).thenReturn("6");

		contadoresAcessoService.consultaContadoresTentativaAcesso(cpfCnpjValid).map(informacaoContador -> {
			InformacaoContador informacaoResponse = new InformacaoContador(informacaoContador.getQtdTentativaAcesso(),
					informacaoContador.getQtdTentativaLimiteAcesso(), 5L, 7L, 4L, 6L, informacaoContador.isSucesso());
			Long acessoResponse = informacaoContador.getQtdTentativaAcesso();
			Long acessoUsuario = this.usuario.getQtdTentativaLogin();

			assertEquals(acessoUsuario, acessoResponse);
			parametrosLocalCacheService.getParametros().clear();

			return informacaoResponse;

		}).subscribe();

		verify(usuarioPortalService, Mockito.times(1)).consultar(cpfCnpjValid);
	}

	public void criaUsuarioPortal() {
		usuario = new UsuarioPortalCliente();
		usuario.setCodTipoPessoa("1");
		usuario.setDataCadastro(java.sql.Date.valueOf(LocalDate.now()));
		usuario.setFlgConfEnvEmail("S");
		usuario.setQtdTentativaLogin(3L);
		usuario.setQuantidadeAcessoLogin(0L);
		usuario.setQuantidadeTentativaCriacaoConta(0L);
		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());
		usuario.setStatusUsuario(statusConta);

	}

	@Test
	public void testReiniciaWhenUsuarioNaoEncontrado() {
		when(usuarioPortalService.consultar(cpfCnpjValid)).thenReturn(Mono.empty());
		when(mensagemLocalCacheService.recuperaTextoMensagem("mensagem.usuario.validacao.usuarioinvalido"))
				.thenReturn("Usuário não encontrado.");
		contadoresAcessoService.reinicia(cpfCnpjValid).onErrorResume(error -> {
			ContadorAcessoException error1 = (ContadorAcessoException) error;
			assertEquals(404, error1.getStatusCode());
			assertEquals("Usuário não encontrado.", error1.getMessage());
			return empty();
		}).subscribe();

		verify(usuarioPortalService, times(1)).consultar(cpfCnpjValid);
	}

	@Test
	public void testReiniciaSucesso() {
		when(usuarioPortalService.consultar(cpfCnpjValid)).thenReturn(Mono.just(usuario));
		when(usuarioPortalClienteRepository.save(usuario)).thenReturn(usuario);
		when(parametrosLocalCacheService.recuperaParametro(KEY_ACESSO)).thenReturn("7");
		when(parametrosLocalCacheService.recuperaParametro(KEY_CADASTRO)).thenReturn("5");
		when(parametrosLocalCacheService.recuperaParametro(PORTO_MS_USUARIO_TENTATIVAS_RECUPERACAO)).thenReturn("6");
		contadoresAcessoService.reinicia(cpfCnpjValid).map(retorno -> {

			assertTrue(retorno);
			return retorno;
		}).subscribe();

		verify(usuarioPortalService, times(2)).consultar(cpfCnpjValid);
		verify(usuarioPortalClienteRepository, times(1)).save(usuario);
	}

	@Test
	public void testReiniciaExcessoTentativas() {

		final String LIMITE_TENTATIVAS = "Conta bloqueada por excesso de tentativas de acesso com erro,"
				+ " para desbloquear sua conta acesse o 'esqueci minha senha'.";

		UsuarioPortalCliente usuario1 = usuario;
		usuario1.setQtdTentativaLogin(7L);
		when(usuarioPortalService.consultar(cpfCnpjValid)).thenReturn(Mono.just(usuario1));
		when(mensagemLocalCacheService.recuperaTextoMensagem("mensagem.usuario.validacao.numerotentativas"))
				.thenReturn(LIMITE_TENTATIVAS);

		when(parametrosLocalCacheService.recuperaParametro(KEY_ACESSO)).thenReturn("7");
		when(parametrosLocalCacheService.recuperaParametro(KEY_CADASTRO)).thenReturn("5");
		when(parametrosLocalCacheService.recuperaParametro(PORTO_MS_USUARIO_TENTATIVAS_RECUPERACAO)).thenReturn("6");

		contadoresAcessoService.reinicia(cpfCnpjValid).onErrorResume(error -> {
			ContadorAcessoException error1 = (ContadorAcessoException) error;
			assertEquals(400, error1.getStatusCode());
			assertEquals(LIMITE_TENTATIVAS, error1.getMessage());
			return empty();
		}).subscribe();

		verify(usuarioPortalService, times(2)).consultar(cpfCnpjValid);
	}

	@Test
	public void testReiniciaUsuarioBloqueado() {

		final String LIMITE_TENTATIVAS = "Conta bloqueada por excesso de tentativas de acesso com erro,"
				+ " para desbloquear sua conta acesse o 'esqueci minha senha'.";

		UsuarioPortalCliente usuario1 = usuario;
		usuario1.setQtdTentativaLogin(7L);
		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus());
		usuario1.setStatusUsuario(statusConta);
		when(usuarioPortalService.consultar(cpfCnpjValid)).thenReturn(Mono.just(usuario1));

		when(mensagemLocalCacheService.recuperaTextoMensagem("mensagem.usuario.validacao.numerotentativas"))
				.thenReturn(LIMITE_TENTATIVAS);

		when(parametrosLocalCacheService.recuperaParametro(KEY_ACESSO)).thenReturn("7");
		when(parametrosLocalCacheService.recuperaParametro(KEY_CADASTRO)).thenReturn("5");
		when(parametrosLocalCacheService.recuperaParametro(PORTO_MS_USUARIO_TENTATIVAS_RECUPERACAO)).thenReturn("6");

		when(usuarioPortalClienteRepository.save(usuario1)).thenReturn(usuario1);
		contadoresAcessoService.reinicia(cpfCnpjValid).map(retorno -> {

			assertTrue(retorno);
			return retorno;
		}).subscribe();

		verify(usuarioPortalService, times(2)).consultar(cpfCnpjValid);
		verify(usuarioPortalClienteRepository, times(1)).save(usuario);
	}

	@Test
	public void testPermiteAcessoSuccess() {
		this.usuario = new UsuarioPortalCliente();
		this.usuario.setIdUsuario(5L);
		this.usuario.setCnpjCpf(228903908L);
		this.usuario.setCnpjCpfDigito(02L);
		this.usuario.setCnpjOrdem(0L);
		this.usuarioStatus = new UsuarioStatusConta();
		this.usuarioStatus.setIdStatusConta(0L);
		when(this.usuarioPortalService.consultarUsuarioPorId(670658L)).thenReturn(Mono.just(this.usuario));

		InformacaoContador infContador = new InformacaoContador(3L, 7L, null, null, null, null, false);

		when(this.usuarioPortalService.consultaStatus("22890390802")).thenReturn(Mono.just(this.usuarioStatus));

		doReturn(Mono.just(infContador)).when(contadoresAcessoService).consultaContadoresTentativaAcesso("22890390802");

		this.contadoresAcessoService.permiteAcesso(670658L).map(result -> {
			assertTrue("testPermiteAcessoSuccess", result);
			return result;
		}).subscribe();
	}

	@Test
	public void testPermiteAcessoErroConsultarContadores() {
		this.usuario = new UsuarioPortalCliente();
		this.usuario.setIdUsuario(5L);
		this.usuario.setCnpjCpf(228903908L);
		this.usuario.setCnpjCpfDigito(02L);
		this.usuario.setCnpjOrdem(0L);
		this.usuarioStatus = new UsuarioStatusConta();
		this.usuarioStatus.setIdStatusConta(0L);
		when(this.usuarioPortalService.consultarUsuarioPorId(670658L)).thenReturn(Mono.just(this.usuario));

		when(this.usuarioPortalService.consultaStatus("22890390802")).thenReturn(Mono.just(this.usuarioStatus));

		doReturn(Mono.error(new Exception())).when(contadoresAcessoService)
				.consultaContadoresTentativaAcesso("22890390802");

		this.contadoresAcessoService.permiteAcesso(670658L).onErrorResume(result -> {
			assertNotNull("testPermiteAcessoErroConsultarContadores", result);
			return empty();
		}).subscribe();
	}

	@Test
	public void testPermiteAcessoNegado() {

		this.usuario = new UsuarioPortalCliente();
		this.usuario.setIdUsuario(5L);
		this.usuario.setCnpjCpf(228903908L);
		this.usuario.setCnpjCpfDigito(02L);
		this.usuario.setCnpjOrdem(0L);
		;
		this.usuarioStatus = new UsuarioStatusConta();
		this.usuarioStatus.setIdStatusConta(1L);
		when(this.usuarioPortalService.consultarUsuarioPorId(670658L)).thenReturn(Mono.just(this.usuario));

		when(this.usuarioPortalService.consultaStatus("22890390802")).thenReturn(Mono.just(this.usuarioStatus));

		this.contadoresAcessoService.permiteAcesso(670658L).onErrorResume(result -> {
			assertNotNull("testPermiteAcessoNegado", result);
			return empty();
		}).subscribe();

	}

	@Test
	public void testAcessoSucessoUsuarioNaoEncontrado() {

		CpfCnpjInvalidoException cpfException = new CpfCnpjInvalidoException(mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_VALIDACAO_CPF_CNPJ.getValor()));

		when(this.usuarioPortalService.consultar("22890390802")).thenReturn(Mono.error(cpfException));

		this.contadoresAcessoService.registrarAcessoSucesso("22890390802").onErrorResume(result -> {
			CpfCnpjInvalidoException cpfInvalidoException = (CpfCnpjInvalidoException) result;
			verify(this.usuarioPortalService).consultar("22890390802");
			assertEquals("testAcessoSucessoUsuarioNaoEncontrado",
					mensagemLocalCacheService
							.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_VALIDACAO_CPF_CNPJ.getValor()),
					cpfInvalidoException.getMessage());
			return empty();
		}).subscribe();
	}

	@Test
	public void testAcessoSucessoUsuarioNaoValido() {
		UsuarioPortalCliente usuarioPortal = new UsuarioPortalCliente();
		UsuarioStatusConta statusUsuario = new UsuarioStatusConta();
		statusUsuario.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuario);

		when(this.usuarioPortalService.consultar("22890390802")).thenReturn(Mono.just(usuarioPortal));

		this.contadoresAcessoService.registrarAcessoSucesso("22890390802").onErrorResume(result -> {
			UsuarioPortalException responseStatusException = (UsuarioPortalException) result;
			verify(this.usuarioPortalService).consultar("22890390802");
			assertEquals("testAcessoSucessoUsuarioNaoValido", HttpStatus.BAD_REQUEST.value(),
					responseStatusException.getStatusCode());
			return empty();
		}).subscribe();
	}

	@Test
	public void testAcessoSucessoUsuarioNaoValidoContaStatusNull() {
		UsuarioPortalCliente usuarioPortal = new UsuarioPortalCliente();
		usuarioPortal.setStatusUsuario(null);

		when(this.usuarioPortalService.consultar("22890390802")).thenReturn(Mono.just(usuarioPortal));

		this.contadoresAcessoService.registrarAcessoSucesso("22890390802").onErrorResume(result -> {
			UsuarioPortalException responseStatusException = (UsuarioPortalException) result;
			verify(this.usuarioPortalService).consultar("22890390802");
			assertEquals("testAcessoSucessoUsuarioNaoValido", HttpStatus.BAD_REQUEST.value(),
					responseStatusException.getStatusCode());
			return empty();
		}).subscribe();
	}

	@Test
	public void testAcessoSucessoUsuarioNaoValidoContaIdStatusNull() {
		UsuarioPortalCliente usuarioPortal = new UsuarioPortalCliente();
		UsuarioStatusConta statusUsuario = new UsuarioStatusConta();
		statusUsuario.setIdStatusConta(null);
		usuarioPortal.setStatusUsuario(statusUsuario);

		when(this.usuarioPortalService.consultar("22890390802")).thenReturn(Mono.just(usuarioPortal));

		this.contadoresAcessoService.registrarAcessoSucesso("22890390802").onErrorResume(result -> {
			UsuarioPortalException responseStatusException = (UsuarioPortalException) result;
			verify(this.usuarioPortalService).consultar("22890390802");
			assertEquals("testAcessoSucessoUsuarioNaoValido", HttpStatus.BAD_REQUEST.value(),
					responseStatusException.getStatusCode());
			return empty();
		}).subscribe();
	}

	@Test
	public void testAcessoSucessoWhenSucesso() {
		UsuarioPortalCliente usuarioPortal = new UsuarioPortalCliente();
		UsuarioStatusConta statusUsuario = new UsuarioStatusConta();
		statusUsuario.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuario);
		usuarioPortal.setQuantidadeAcessoLogin(2L);

		Mockito.when(this.usuarioPortalService.consultar("22890390802")).thenReturn(Mono.just(usuarioPortal));
		Mockito.when(this.usuarioPortalClienteRepository.save(usuarioPortal)).thenReturn(usuarioPortal);

		this.contadoresAcessoService.registrarAcessoSucesso("22890390802").map(deuCerto -> {
			Mockito.verify(this.usuarioPortalService).consultar("22890390802");
			Assert.assertEquals("testAcessoSucessoWhenSucesso", Boolean.TRUE, deuCerto);
			return deuCerto;
		}).subscribe();
	}

	@Test
	public void testAcessoSucessoWhenSucessoSemQuantidade() {
		UsuarioPortalCliente usuarioPortal = new UsuarioPortalCliente();
		UsuarioStatusConta statusUsuario = new UsuarioStatusConta();
		statusUsuario.setIdStatusConta(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuario);

		when(this.usuarioPortalService.consultar("22890390802")).thenReturn(Mono.just(usuarioPortal));
		when(this.usuarioPortalClienteRepository.save(usuarioPortal)).thenReturn(usuarioPortal);

		this.contadoresAcessoService.registrarAcessoSucesso("22890390802").map(deuCerto -> {
			verify(this.usuarioPortalService).consultar("22890390802");
			assertEquals("testAcessoSucessoWhenSucesso", Boolean.TRUE, deuCerto);
			return deuCerto;
		}).subscribe();
	}

	@Test
	public void testAcessoSucessoWhenSucessoSemQuantidadeContaAtiva() {
		UsuarioPortalCliente usuarioPortal = new UsuarioPortalCliente();
		UsuarioStatusConta statusUsuario = new UsuarioStatusConta();
		statusUsuario.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusUsuario);

		when(this.usuarioPortalService.consultar("22890390802")).thenReturn(Mono.just(usuarioPortal));
		when(this.usuarioPortalClienteRepository.save(usuarioPortal)).thenReturn(usuarioPortal);

		this.contadoresAcessoService.registrarAcessoSucesso("22890390802").map(deuCerto -> {
			verify(this.usuarioPortalService).consultar("22890390802");
			assertEquals("testAcessoSucessoWhenSucesso", Boolean.TRUE, deuCerto);
			return deuCerto;
		}).subscribe();
	}

	@Test
	public void testAdicionaTentativaSucesso() {
		this.usuario = new UsuarioPortalCliente();
		this.usuario.setIdUsuario(5L);
		this.usuario.setCnpjCpf(228903908L);
		this.usuario.setCnpjCpfDigito(02L);
		this.usuario.setCnpjOrdem(0L);
		this.usuarioStatus = new UsuarioStatusConta();
		this.usuarioStatus.setIdStatusConta(1L);
		this.usuario.setQtdTentativaLogin(0L);

		when(this.usuarioPortalService.consultar("22890390802")).thenReturn(Mono.just(this.usuario));
		when(this.usuarioPortalService.salvar(this.usuario)).thenReturn(Mono.just(this.usuario));
		when(this.parametrosLocalCacheService.recuperaParametro(KEY_ACESSO)).thenReturn("5");

		this.contadoresAcessoService.registrarAcessoFalha("22890390802").map(info -> {
			assertEquals(info.getQtdTentativa(), new Long(1));
			assertEquals(info.getQtdTentativaLimite(), new Long(5));
			assertEquals(Boolean.TRUE, info.isSucesso());
			return info;
		}).subscribe();
	}

	@Test
	public void testAdicionaTentativaExcedida() {
		this.usuario = new UsuarioPortalCliente();
		this.usuario.setIdUsuario(5L);
		this.usuario.setCnpjCpf(228903908L);
		this.usuario.setCnpjCpfDigito(02L);
		this.usuario.setCnpjOrdem(0L);
		this.usuarioStatus = new UsuarioStatusConta();
		this.usuarioStatus.setIdStatusConta(1L);
		this.usuario.setQtdTentativaLogin(6L);

		when(this.usuarioPortalService.consultar("22890390802")).thenReturn(Mono.just(this.usuario));
		when(this.parametrosLocalCacheService.recuperaParametro(KEY_ACESSO)).thenReturn("6");
		when(this.usuarioPortalService.salvar(this.usuario)).thenReturn(Mono.just(this.usuario));

		this.contadoresAcessoService.registrarAcessoFalha("22890390802").onErrorResume(info -> {
			CodigoSegurancaException error1 = (CodigoSegurancaException) info;
			assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), error1.getStatusCode());
			return Mono.empty();
		}).subscribe();
	}

	@Test
	public void testAdicionaTentativaErro() {
		this.usuario = new UsuarioPortalCliente();
		this.usuario.setIdUsuario(5L);
		this.usuario.setCnpjCpf(228903908L);
		this.usuario.setCnpjCpfDigito(02L);
		this.usuario.setCnpjOrdem(0L);
		this.usuarioStatus = new UsuarioStatusConta();
		this.usuarioStatus.setIdStatusConta(1L);
		this.usuario.setQtdTentativaLogin(5L);

		when(this.usuarioPortalService.consultar("22890390802")).thenReturn(Mono.just(this.usuario));
		when(this.parametrosLocalCacheService.recuperaParametro(KEY_ACESSO)).thenReturn("6");
		when(this.usuarioPortalService.salvar(this.usuario)).thenReturn(Mono.just(this.usuario));

		this.contadoresAcessoService.registrarAcessoFalha("22890390802").onErrorResume(info -> {
			CodigoSegurancaException error1 = (CodigoSegurancaException) info;
			assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), error1.getStatusCode());
			return Mono.empty();
		}).subscribe();
	}

	@Test
	public void testAdicionaTentativa404() {

		InformacaoContadorConta informacaoContadorConta = new InformacaoContadorConta(0L, 5L, true);

		when(this.usuarioPortalService.consultar("22890390802")).thenReturn(
				Mono.error(new ContadorAcessoException("erro", HttpStatus.NOT_FOUND.value(), informacaoContadorConta)));
		this.contadoresAcessoService.registrarAcessoFalha("22890390802").doOnError(info -> {
			ContadorAcessoException error1 = (ContadorAcessoException) info;
			assertEquals(HttpStatus.NOT_FOUND.value(), error1.getStatusCode());
		}).subscribe();
	}

}
