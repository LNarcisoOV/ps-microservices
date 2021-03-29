package com.porto.portocom.portal.cliente.v1.service.test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

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

import com.porto.portocom.portal.cliente.entity.SegurancaContaPortalUsuario;
import com.porto.portocom.portal.cliente.entity.SegurancaContaPortalUsuarioId;
import com.porto.portocom.portal.cliente.entity.TipoCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.repository.ISegurancaContaPortalUsuarioRepository;
import com.porto.portocom.portal.cliente.v1.service.SegurancaContaPortalUsuarioService;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SegurancaContaPortalUsuarioServiceUnitTest {

	@Mock
	private ISegurancaContaPortalUsuarioRepository segurancaContaPortalUsuarioRepository;

	@InjectMocks
	private SegurancaContaPortalUsuarioService segurancaContaPortalUsuarioService;

	private static TipoCodigoSeguranca tipoCodigoSeguranca;

	private static SegurancaContaPortalUsuarioId segurancaContaPortalUsuarioId;

	private static SegurancaContaPortalUsuario segurancaContaPortalUsuario;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		criarSegurancaContaPortalUsuario();
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

	@Test
	public void testPossuiCodigoSegurancaPortalValido() {

		LocalDateTime localDate = LocalDateTime.now();
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(
				Date.from(localDate.atZone(TimeZone.getDefault().toZoneId()).toInstant()));

		Mockito.when(segurancaContaPortalUsuarioRepository.findByCodigoSegurancaAtivacaoByCpf(228903908L, 0L, 02L))
				.thenReturn(segurancaContaPortalUsuario);

		boolean possuiCodigoSegurancaPortalValido = segurancaContaPortalUsuarioService
				.possuiCodigoSegurancaPortalValido(228903908L, 0L, 02L);

		Assert.assertTrue(possuiCodigoSegurancaPortalValido);

		Mockito.verify(segurancaContaPortalUsuarioRepository, Mockito.times(1))
				.findByCodigoSegurancaAtivacaoByCpf(228903908L, 0L, 02L);

	}

	@Test
	public void testPossuiCodigoSegurancaPortalValidoIsNull() {

		Mockito.when(segurancaContaPortalUsuarioRepository.findByCodigoSegurancaAtivacaoByCpf(228903908L, 0L, 02L))
				.thenReturn(null);

		boolean possuiCodigoSegurancaPortalValido = segurancaContaPortalUsuarioService
				.possuiCodigoSegurancaPortalValido(228903908L, 0L, 02L);

		Assert.assertFalse(possuiCodigoSegurancaPortalValido);

		Mockito.verify(segurancaContaPortalUsuarioRepository, Mockito.times(1))
				.findByCodigoSegurancaAtivacaoByCpf(228903908L, 0L, 02L);
	}
	
	@Test
	public void testPossuiCodigoSegurancaPortalInvalido() {

		LocalDateTime localDate = LocalDateTime.of(2020, 12, 15, 15, 35);
		segurancaContaPortalUsuario.setDataCriacaoCodigoSeguranca(
				Date.from(localDate.atZone(TimeZone.getDefault().toZoneId()).toInstant()));

		Mockito.when(segurancaContaPortalUsuarioRepository.findByCodigoSegurancaAtivacaoByCpf(228903908L, 0L, 02L))
				.thenReturn(segurancaContaPortalUsuario);

		boolean possuiCodigoSegurancaPortalValido = segurancaContaPortalUsuarioService
				.possuiCodigoSegurancaPortalValido(228903908L, 0L, 02L);

		Assert.assertFalse(possuiCodigoSegurancaPortalValido);

		Mockito.verify(segurancaContaPortalUsuarioRepository, Mockito.times(1))
				.findByCodigoSegurancaAtivacaoByCpf(228903908L, 0L, 02L);

	}

}
