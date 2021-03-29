package com.porto.portocom.portal.cliente.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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

import com.porto.portocom.portal.cliente.entity.AplicacaoRedeSocial;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioRedeSocial;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.exception.RedeSocialException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.repository.IAplicacaoRedeSocialRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioRedeSocialRepository;
import com.porto.portocom.portal.cliente.v1.service.MensagemLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.RedeSocialService;
import com.porto.portocom.portal.cliente.v1.vo.RedeSocial;
import com.porto.portocom.portal.cliente.v1.vo.SocialCliente;
import com.porto.portocom.portal.cliente.v1.vo.SocialClienteConsulta;
import com.porto.portocom.portal.cliente.v1.vo.VinculoRedeSocial;


@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RedeSocialServiceUnitTest {

	@InjectMocks
	private RedeSocialService redeSocialService;

	@Mock
	private IUsuarioRedeSocialRepository usrRedeSocialRepository;

	@Mock
	private IUsuarioPortalClienteRepository usuarioPortalClienteRepository;

	@Mock
	private IAplicacaoRedeSocialRepository aplicacaoRedeSocialRepository;

	@Mock
	private MensagemLocalCacheService mensagemLocalCacheService;

	private final static String USUARIO = "30443897808";
	private final static String ID_REDESOCIAL_USUARIO = "10204409063360188";
	private final static Long ID_USUARIO = 3936L;

	private SocialCliente socialCliente;
	private UsuarioRedeSocial usuarioRedeSocial;
	private UsuarioPortalCliente usuarioPortalCliente;
	private AplicacaoRedeSocial aplicacaoRedeSocial;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		aplicacaoRedeSocial = new AplicacaoRedeSocial();
		aplicacaoRedeSocial.setTextoIdentificadorAplicacaoRedeSocial(ID_REDESOCIAL_USUARIO);
		aplicacaoRedeSocial.setCodigoSequencial(1);

		usuarioRedeSocial = new UsuarioRedeSocial();
		usuarioRedeSocial.setIdSocialCliente(ID_REDESOCIAL_USUARIO);
		usuarioRedeSocial.setAplicacaoRedeSocial(aplicacaoRedeSocial);

		usuarioPortalCliente = new UsuarioPortalCliente();
		usuarioPortalCliente.setIdUsuario(ID_USUARIO);

		usuarioRedeSocial.setUsuarioPortalCliente(usuarioPortalCliente);

		socialCliente = new SocialCliente();
		socialCliente.setIdSocialCliente(ID_REDESOCIAL_USUARIO);
	}

	@Test
	public void testDesvincularUsuarioSucesso() {

		Mockito.when(this.usuarioPortalClienteRepository.findByCpf(0L, 304438978L, 8L))
				.thenReturn(this.usuarioPortalCliente);
		Mockito.when(this.usrRedeSocialRepository.findByIdRedeSocial(ID_REDESOCIAL_USUARIO))
				.thenReturn(this.usuarioRedeSocial);
		this.redeSocialService.desvinculaRedeSocial(USUARIO, socialCliente.getIdSocialCliente())
				.map(usuarioPortalCliente -> {
					assertTrue("Usuario desvinculado com sucesso.", usuarioPortalCliente);
					return usuarioPortalCliente;
				}).subscribe();
	}

	@Test
	public void testDesvincularUsuarioCpfIdNaoConferem() {

		UsuarioPortalCliente novousuarioPortalCliente = new UsuarioPortalCliente();

		novousuarioPortalCliente.setIdUsuario(12345L);

		Mockito.when(this.usuarioPortalClienteRepository.findByCpf(0L, 374884998L, 24L))
				.thenReturn(novousuarioPortalCliente);
		Mockito.when(this.usrRedeSocialRepository.findByIdRedeSocial(ID_REDESOCIAL_USUARIO))
				.thenReturn(this.usuarioRedeSocial);
		this.socialCliente.setIdSocialCliente("10204409063360188");
		this.redeSocialService.desvinculaRedeSocial("37488499824", socialCliente.getIdSocialCliente())
				.doOnError(erro -> {
					RedeSocialException error = (RedeSocialException) erro;
					assertEquals("", "Cpf não pertence ao usuário de rede social!", error.getMessage());
					assertEquals("", 409, error.getStatusCode());
				}).subscribe();
	}

	@Test
	public void testDesvincularUsuarioNaoPossuiRedeSocial() {

		Mockito.when(this.usuarioPortalClienteRepository.findByCpf(0L, 304438978L, 8L))
				.thenReturn(this.usuarioPortalCliente);
		Mockito.when(this.usrRedeSocialRepository.findByIdRedeSocial(ID_REDESOCIAL_USUARIO)).thenReturn(null);
		this.socialCliente.setIdSocialCliente("10204409063360188");
		this.redeSocialService.desvinculaRedeSocial("30443897808", socialCliente.getIdSocialCliente())
				.doOnError(erro -> {
					RedeSocialException error = (RedeSocialException) erro;
					assertEquals("", "Usuario não possui vinculo com rede social", error.getMessage());
					assertEquals("", 404, error.getStatusCode());
				}).subscribe();
	}

	@Test
	public void testVinculaUsuarioRedeSocialInativaSucesso() {

		String cpfCnpjUsuario = "27385095844";

		usuarioPortalCliente.setCnpjCpf(273850958L);
		usuarioPortalCliente.setFlagExibirVinculoRedeSocial("N");
		usuarioPortalCliente.setIdUsuario(999L);

		AplicacaoRedeSocial aplicacaoRedeSocial = new AplicacaoRedeSocial();
		aplicacaoRedeSocial.setTextoIdentificadorAplicacaoRedeSocial("testeunitario");

		UsuarioRedeSocial usuarioRedeSocial = new UsuarioRedeSocial();
		usuarioRedeSocial.setFlagVinculoAtivo("N");
		usuarioRedeSocial.setUsuarioPortalCliente(usuarioPortalCliente);
		usuarioRedeSocial.setAplicacaoRedeSocial(aplicacaoRedeSocial);
		usuarioRedeSocial.setIdSocialCliente("idsocialcliente");

		RedeSocial redeSocial = new RedeSocial(usuarioRedeSocial);

		VinculoRedeSocial vinculoRedeSocial = new VinculoRedeSocial("idsocialcliente", "testeunitario");

		Mockito.when(usrRedeSocialRepository.findByIdRedeSocialAndIdUsuario(vinculoRedeSocial.getIdSocialCliente(),
				usuarioPortalCliente.getIdUsuario())).thenReturn(usuarioRedeSocial);
		Mockito.when(usuarioPortalClienteRepository.findByCpf(0L, 273850958L, 44L)).thenReturn(usuarioPortalCliente);
		Mockito.when(usrRedeSocialRepository.save(usuarioRedeSocial)).thenReturn(usuarioRedeSocial);
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortalCliente)).thenReturn(usuarioPortalCliente);

		redeSocialService.vinculaRedeSocial(cpfCnpjUsuario, vinculoRedeSocial).map(result -> {
			assertTrue("Vinculo rede social cadastrado com sucesso.", result);
			return result;
		}).subscribe();

		Mockito.verify(usrRedeSocialRepository, Mockito.times(1))
				.findByIdRedeSocialAndIdUsuario(redeSocial.getIdSocialCliente(), usuarioPortalCliente.getIdUsuario());
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).findByCpf(0L, 273850958L, 44L);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(usuarioPortalCliente);
		Mockito.verify(usrRedeSocialRepository, Mockito.times(1)).save(usuarioRedeSocial);

	}

	@Test
	public void testVinculaUsuarioRedeSocialSemVinculoSucesso() {

		String cpfCnpjUsuario = "27385095844";
		usuarioPortalCliente.setCnpjCpf(273850958L);
		usuarioPortalCliente.setFlagExibirVinculoRedeSocial("N");

		AplicacaoRedeSocial aplicacaoRedeSocial = new AplicacaoRedeSocial();
		aplicacaoRedeSocial.setTextoIdentificadorAplicacaoRedeSocial("testeunitario");

		UsuarioRedeSocial usuarioRedeSocial = new UsuarioRedeSocial();
		usuarioRedeSocial.setFlagVinculoAtivo("N");
		usuarioRedeSocial.setUsuarioPortalCliente(usuarioPortalCliente);
		usuarioRedeSocial.setAplicacaoRedeSocial(aplicacaoRedeSocial);
		usuarioRedeSocial.setIdSocialCliente("idsocialcliente");

		RedeSocial redeSocial = new RedeSocial(usuarioRedeSocial);

		VinculoRedeSocial vinculoRedeSocial = new VinculoRedeSocial("idsocialcliente", "testeunitario");

		Mockito.when(usuarioPortalClienteRepository.findByCpf(0L, 273850958L, 44L)).thenReturn(usuarioPortalCliente);
		Mockito.when(usuarioPortalClienteRepository.save(usuarioPortalCliente)).thenReturn(usuarioPortalCliente);
		Mockito.when(usrRedeSocialRepository.save(usuarioRedeSocial)).thenReturn(usuarioRedeSocial);
		Mockito.when(usrRedeSocialRepository.findByIdRedeSocialAndIdUsuario(redeSocial.getIdSocialCliente(),
				usuarioPortalCliente.getIdUsuario())).thenReturn(usuarioRedeSocial);

		redeSocialService.vinculaRedeSocial(cpfCnpjUsuario, vinculoRedeSocial).map(result -> {
			assertTrue("Vinculo rede social cadastrado com sucesso.", result);
			return result;
		}).subscribe();

		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).findByCpf(0L, 273850958L, 44L);
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).save(usuarioPortalCliente);
		Mockito.verify(usrRedeSocialRepository, Mockito.times(1)).save(usuarioRedeSocial);
		Mockito.verify(usrRedeSocialRepository, Mockito.times(1))
				.findByIdRedeSocialAndIdUsuario(redeSocial.getIdSocialCliente(), usuarioPortalCliente.getIdUsuario());

	}

	@Test
	public void testConsultaPorIdRedeSocialSucesso() {
		Mockito.when(this.mensagemLocalCacheService
				.recuperaTextoMensagem(MensagemChaveEnum.PERFIL_VALIDACAO_USUARIO_SEM_REDESOCIAL.getValor()))
				.thenReturn("");
		Mockito.when(usrRedeSocialRepository.findByIdRedeSocial(socialCliente.getIdSocialCliente()))
				.thenReturn(this.usuarioRedeSocial);
		this.redeSocialService.consultaPorIdRedeSocial(socialCliente.getIdSocialCliente()).map(usuarioRedeSocial -> {
			assertEquals(ID_REDESOCIAL_USUARIO, usuarioRedeSocial.getIdSocialCliente());
			assertEquals(ID_USUARIO, usuarioRedeSocial.getUsuarioPortalCliente());
			return usuarioRedeSocial;
		}).subscribe();

		Mockito.verify(usrRedeSocialRepository, Mockito.times(1))
				.findByIdRedeSocial(socialCliente.getIdSocialCliente());

	}

	@Test
	public void testConsultaPorIdRedeSocialWhenUsuarioNaoPossuiRedeSocial() {
		Mockito.when(usrRedeSocialRepository.findByIdRedeSocial(socialCliente.getIdSocialCliente())).thenReturn(null);
		this.redeSocialService.consultaPorIdRedeSocial(socialCliente.getIdSocialCliente()).doOnError(erro -> {
			UsuarioPortalException error = (UsuarioPortalException) erro;
			assertEquals("", "Usuário não possui rede social", error.getMessage());
			assertEquals("", 404, error.getStatusCode());
		}).subscribe();
		Mockito.verify(usrRedeSocialRepository, Mockito.times(1))
				.findByIdRedeSocial(socialCliente.getIdSocialCliente());
	}

	@Test
	public void testConsultaPorCpfCnpjSucesso() {

		List<UsuarioRedeSocial> listUsuario = new ArrayList<>();
		listUsuario.add(usuarioRedeSocial);
		Mockito.when(this.usuarioPortalClienteRepository.findByCpf(0L, 374884998L, 24L))
				.thenReturn(usuarioPortalCliente);
		Mockito.when(usrRedeSocialRepository.findByIdUsuario(usuarioPortalCliente.getIdUsuario()))
				.thenReturn(listUsuario);
		this.redeSocialService.consultaPorCpfCnpj("37488499824").map(listRedeSocial -> {
			assertEquals(1, listRedeSocial.size());
			assertEquals(ID_REDESOCIAL_USUARIO, listRedeSocial.get(0).getIdSocialCliente());
			assertEquals(ID_USUARIO, listRedeSocial.get(0).getUsuarioPortalCliente());
			return usuarioRedeSocial;
		}).subscribe();
		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).findByCpf(0L, 374884998L, 24L);
		Mockito.verify(usrRedeSocialRepository, Mockito.times(1)).findByIdUsuario(usuarioPortalCliente.getIdUsuario());

	}

	@Test
	public void testConsultaPorCpfCnpjWhenUsuarioNaoEncontrado() {

		Mockito.when(this.usuarioPortalClienteRepository.findByCpf(0L, 374884998L, 24L)).thenReturn(null);
		this.redeSocialService.consultaPorCpfCnpj("37488499824").doOnError(erro -> {
			UsuarioPortalException error = (UsuarioPortalException) erro;
			assertEquals(MensagemUsuarioEnum.USUARIO_NAO_ENCONTRADO.getValor(), error.getMessage());
			assertEquals(404, error.getStatusCode());
		}).subscribe();

		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).findByCpf(0L, 374884998L, 24L);

	}

	@Test
	public void testConsultaPorCpfCnpjWhenUsuarioNaoPossuiRedeSocial() {

		Mockito.when(this.usuarioPortalClienteRepository.findByCpf(0L, 374884998L, 24L))
				.thenReturn(usuarioPortalCliente);
		List<UsuarioRedeSocial> listUsuario = new ArrayList<>();
		Mockito.when(usrRedeSocialRepository.findByIdUsuario(usuarioPortalCliente.getIdUsuario()))
				.thenReturn(listUsuario);
		this.redeSocialService.consultaPorCpfCnpj("37488499824").doOnError(erro -> {
			UsuarioPortalException error = (UsuarioPortalException) erro;
			assertEquals("Usuário não possui rede social", error.getMessage());
			assertEquals(404, error.getStatusCode());
		}).subscribe();

		Mockito.verify(usuarioPortalClienteRepository, Mockito.times(1)).findByCpf(0L, 374884998L, 24L);
		Mockito.verify(usrRedeSocialRepository, Mockito.times(1)).findByIdUsuario(usuarioPortalCliente.getIdUsuario());

	}

	@Test
	public void testConsultaPorIdRedeSocialAndIdentificadorRedeSocialSucesso() {

		SocialClienteConsulta socialConsulta = new SocialClienteConsulta();
		socialConsulta.setIdSocialCliente("29763146836");
		socialConsulta.setTextoIdentificadorAplicacaoRedeSocial("G_PDC");
		List<UsuarioRedeSocial> listUsuarioRedeSocial = new ArrayList<>();
		listUsuarioRedeSocial.add(usuarioRedeSocial);

		Mockito.when(aplicacaoRedeSocialRepository
				.findBytextoIdentificadorAplicacaoRedeSocial(socialConsulta.getTextoIdentificadorAplicacaoRedeSocial()))
				.thenReturn(aplicacaoRedeSocial);
		Mockito.when(usrRedeSocialRepository.findByIdRedeSocialAndAplicacaoRedeSocialId(
				socialConsulta.getIdSocialCliente(), aplicacaoRedeSocial.getCodigoSequencial()))
				.thenReturn(listUsuarioRedeSocial);

		this.redeSocialService.consultaPorIdRedeSocialAndIdentificadorRedeSocial(socialConsulta).map(listRedeSocial -> {
			assertEquals(ID_REDESOCIAL_USUARIO, listRedeSocial.get(0).getIdSocialCliente());
			assertEquals(ID_USUARIO, listRedeSocial.get(0).getUsuarioPortalCliente());
			return listRedeSocial;
		}).subscribe();

		Mockito.verify(aplicacaoRedeSocialRepository, Mockito.times(1))
				.findBytextoIdentificadorAplicacaoRedeSocial(socialConsulta.getTextoIdentificadorAplicacaoRedeSocial());
		Mockito.verify(usrRedeSocialRepository, Mockito.times(1)).findByIdRedeSocialAndAplicacaoRedeSocialId(
				socialConsulta.getIdSocialCliente(), aplicacaoRedeSocial.getCodigoSequencial());
	}

	@Test
	public void testConsultaPorIdRedeSocialAndIdentificadorRedeSocialWhenRedeSocialException() {

		SocialClienteConsulta socialConsulta = new SocialClienteConsulta();
		socialConsulta.setIdSocialCliente("29763146836");
		socialConsulta.setTextoIdentificadorAplicacaoRedeSocial("G_PDC");

		Mockito.when(aplicacaoRedeSocialRepository
				.findBytextoIdentificadorAplicacaoRedeSocial(socialConsulta.getTextoIdentificadorAplicacaoRedeSocial()))
				.thenReturn(null);

		this.redeSocialService.consultaPorIdRedeSocialAndIdentificadorRedeSocial(socialConsulta).doOnError(erro -> {
			RedeSocialException error = (RedeSocialException) erro;
			assertEquals("Rede Social não encontrada.", error.getMessage());
			assertEquals(400, error.getStatusCode());
		}).subscribe();

		Mockito.verify(aplicacaoRedeSocialRepository, Mockito.times(1))
				.findBytextoIdentificadorAplicacaoRedeSocial(socialConsulta.getTextoIdentificadorAplicacaoRedeSocial());
	}

	@Test
	public void testConsultaPorIdRedeSocialAndIdentificadorRedeSocialWhenUsuarioPortalException() {

		SocialClienteConsulta socialConsulta = new SocialClienteConsulta();
		socialConsulta.setIdSocialCliente("29763146836");
		socialConsulta.setTextoIdentificadorAplicacaoRedeSocial("G_PDC");
		List<UsuarioRedeSocial> listUsuarioRedeSocial = new ArrayList<>();

		Mockito.when(aplicacaoRedeSocialRepository
				.findBytextoIdentificadorAplicacaoRedeSocial(socialConsulta.getTextoIdentificadorAplicacaoRedeSocial()))
				.thenReturn(aplicacaoRedeSocial);
		Mockito.when(usrRedeSocialRepository.findByIdRedeSocialAndAplicacaoRedeSocialId(
				socialConsulta.getIdSocialCliente(), aplicacaoRedeSocial.getCodigoSequencial()))
				.thenReturn(listUsuarioRedeSocial);

		this.redeSocialService.consultaPorIdRedeSocialAndIdentificadorRedeSocial(socialConsulta).doOnError(erro -> {
			UsuarioPortalException error = (UsuarioPortalException) erro;
			assertEquals("Usuário não possui rede social", error.getMessage());
			assertEquals(404, error.getStatusCode());
		}).subscribe();

		Mockito.verify(aplicacaoRedeSocialRepository, Mockito.times(1))
				.findBytextoIdentificadorAplicacaoRedeSocial(socialConsulta.getTextoIdentificadorAplicacaoRedeSocial());
		Mockito.verify(usrRedeSocialRepository, Mockito.times(1)).findByIdRedeSocialAndAplicacaoRedeSocialId(
				socialConsulta.getIdSocialCliente(), aplicacaoRedeSocial.getCodigoSequencial());
	}

}
