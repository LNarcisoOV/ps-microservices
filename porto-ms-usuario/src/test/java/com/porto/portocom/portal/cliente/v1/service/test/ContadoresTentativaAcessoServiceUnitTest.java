package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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

import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.entity.ParametrosSistema;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.service.ContadorAcessoService;
import com.porto.portocom.portal.cliente.v1.service.MensagemLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.UsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContador;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContadoresTentativaAcessoServiceUnitTest {
	
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
	private IUsuarioPortalClienteRepository usuarioPortalClienteRepository;

	@InjectMocks
	private ContadorAcessoService contadoresAcessoService;

	private UsuarioPortalCliente usuario;

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
	public void testConsultaContadoresAcessoCpfValid() {

		Mockito.when(usuarioPortalService.consultar(cpfCnpjValid)).thenReturn(Mono.just(usuario));
		Mockito.when(parametrosLocalCacheService.recuperaParametro(KEY_ACESSO)).thenReturn("7");
		Mockito.when(parametrosLocalCacheService.recuperaParametro(KEY_CADASTRO)).thenReturn("5");
		Mockito.when(parametrosLocalCacheService.recuperaParametro(PORTO_MS_USUARIO_TENTATIVAS_RECUPERACAO))
				.thenReturn("6");

		System.out.println(parametrosLocalCacheService.recuperaParametro("porto.ms.usuario.tentativas.login"));

		contadoresAcessoService.consultaContadoresTentativaAcesso(cpfCnpjValid).map(informacaoContador -> {
			InformacaoContador informacaoResponse = new InformacaoContador(informacaoContador.getQtdTentativaAcesso(),
					informacaoContador.getQtdTentativaLimiteAcesso(), 5L, 7L, 4L, 6L, informacaoContador.isSucesso());
			Long acessoResponse = informacaoContador.getQtdTentativaAcesso();
			Long acessoUsuario = this.usuario.getQtdTentativaLogin();

			assertEquals("", acessoUsuario, acessoResponse);
			parametrosLocalCacheService.getParametros().clear();

			return informacaoResponse;

		}).subscribe();

	}

	@Test
	public void testAdicionaTentativaDeAcesso() {

		Mockito.when(usuarioPortalService.consultar(cpfCnpjValid)).thenReturn(Mono.just(usuario));
		Mockito.when(parametrosLocalCacheService.recuperaParametro(KEY_ACESSO)).thenReturn("7");

		Mockito.when(parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_CRIACAO_CONTA.getValor()))
				.thenReturn("5");
		contadoresAcessoService.adicionaTentativa(cpfCnpjValid).map(informacaoContador -> {
			Long acessoResponse = informacaoContador.getQtdTentativa();
			Long acessoUsuario = this.usuario.getQtdTentativaLogin();

			assertEquals("", acessoUsuario, acessoResponse);
			parametrosLocalCacheService.getParametros().clear();

			return informacaoContador;

		}).subscribe();

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

}
