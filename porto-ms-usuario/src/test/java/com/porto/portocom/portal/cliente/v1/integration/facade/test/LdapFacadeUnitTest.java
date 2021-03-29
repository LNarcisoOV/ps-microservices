package com.porto.portocom.portal.cliente.v1.integration.facade.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.v1.constant.TipoUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.integration.LdapWebService;
import com.porto.portocom.portal.cliente.v1.integration.facade.LdapFacade;
import com.porto.portocom.portal.cliente.v1.model.ContaAcessoComSenha;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TipoUsuarioVO;
import com.porto.portocom.portal.cliente.v1.wsdl.ldap.ContaAcessoVO;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class LdapFacadeUnitTest {

	private static final String NOME = "Adriano";
	private static final String SOBRENOME = "Santos";
	private static final String USUARIO = "22890390802";
	private static final String SENHA = "senha123";

	private static UsuarioPortalCliente usuarioPortalCliente;

	@Mock
	private LdapWebService ldapWebServiceMock;

	@InjectMocks
	private LdapWebService ldapWebService;

	@InjectMocks
	private LdapFacade ldapFacade;

	@BeforeEach
	public void init() throws DatatypeConfigurationException {
		System.out.println("before");
		MockitoAnnotations.initMocks(this);
		criaUsuarioPortalCliente();
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
	void testAtualizarSenhaSucesso() {

		Mockito.when(ldapWebServiceMock.atualizarSenha(USUARIO, SENHA, null)).thenReturn(Boolean.TRUE);

		this.ldapFacade.atualizarSenha(USUARIO, SENHA, null).map(retorno -> {
			assertEquals(true, retorno);
			return retorno;
		}).subscribe();

	}

	@Test
	void testAtualizarSenhaFalha() {

		Mockito.when(ldapWebServiceMock.atualizarSenha(USUARIO, SENHA, null)).thenReturn(Boolean.FALSE);

		this.ldapFacade.atualizarSenha(USUARIO, SENHA, null).map(retorno -> {
			assertEquals(false, retorno);
			return retorno;
		}).subscribe();

	}

	@Test
	void testCriarUsuarioComSenhaSucesso() {
		List<String> ContaAcessoProdutos = new ArrayList<String>();

		Mockito.when(ldapWebServiceMock.criarUsuarioComSenha(Mockito.any(ContaAcessoComSenha.class)))
				.thenReturn(Boolean.TRUE);

		this.ldapFacade.criarUsuarioComSenha(ContaAcessoComSenha.builder().nome(NOME).produtos(ContaAcessoProdutos)
				.sobreNome(SOBRENOME).senha(SENHA).build()).map(retorno -> {
					assertEquals(true, retorno);
					return retorno;
				}).subscribe();
	}

	@Test
	void testCriarUsuarioComSenhaFalha() {
		List<String> ContaAcessoProdutos = new ArrayList<String>();

		Mockito.when(ldapWebServiceMock.criarUsuarioComSenha(Mockito.any(ContaAcessoComSenha.class)))
				.thenReturn(Boolean.FALSE);

		this.ldapFacade.criarUsuarioComSenha(ContaAcessoComSenha.builder().nome(NOME).produtos(ContaAcessoProdutos)
				.sobreNome(SOBRENOME).senha(SENHA).build()).map(retorno -> {
					assertEquals(false, retorno);
					return retorno;
				}).subscribe();
	}

	@Test
	void testCriarUsuarioSucesso() {
		Mockito.when(ldapWebServiceMock.criarUsuario(Mockito.any(ContaAcessoVO.class))).thenReturn(Boolean.TRUE);

		this.ldapFacade
				.criarUsuario(usuarioPortalCliente,
						TipoUsuarioVO.builder().idTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo()).build())
				.map(retorno -> {
					assertEquals(true, retorno);
					return retorno;
				}).subscribe();
	}

	@Test
	void testCriarUsuarioFalha() {

		Mockito.when(ldapWebServiceMock.criarUsuario(Mockito.any(ContaAcessoVO.class))).thenReturn(Boolean.FALSE);

		this.ldapFacade
				.criarUsuario(usuarioPortalCliente,
						TipoUsuarioVO.builder().idTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo()).build())
				.map(retorno -> {
					assertEquals(false, retorno);
					return retorno;
				}).subscribe();
	}

}