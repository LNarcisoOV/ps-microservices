package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

import com.porto.portocom.portal.cliente.v1.dto.conquista.ClienteConquista;
import com.porto.portocom.portal.cliente.v1.dto.conquista.ClienteConquistaRequest;
import com.porto.portocom.portal.cliente.v1.integration.facade.IConquistaFacade;
import com.porto.portocom.portal.cliente.v1.service.ConquistaService;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaRequestType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.ClienteArenaType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.IsClienteCadastradoResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.TipoCriticaEnum;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConquistaServiceUnitTest {

	@Mock
	private IConquistaFacade conquistaFacade;

	@InjectMocks
	private ConquistaService conquistaService;

	@Before
	public void init() throws DatatypeConfigurationException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testIsClienteArenaCadastradoFalse() {

		String cpf = "07473180690";

		IsClienteCadastradoResponseType isClienteCadastradoResponseType = new IsClienteCadastradoResponseType();
		isClienteCadastradoResponseType.setNomeCliente("Teste");
		isClienteCadastradoResponseType.setIsCadastrado(false);

		Mockito.when(conquistaFacade.isClienteArenaCadastrado(cpf))
				.thenReturn(Mono.just(isClienteCadastradoResponseType));

		conquistaService.isClienteArenaCadastrado("07473180690").map(cadastro -> {
			assertFalse("Cliente não cadastrado.", cadastro.getIsCadastrado());
			assertEquals("Teste", cadastro.getNomeCliente());
			return cadastro;
		}).subscribe();
	}

	@Test
	public void testIsClienteArenaCadastradoTrue() {

		String cpf = "07473180690";

		IsClienteCadastradoResponseType isClienteCadastradoResponseType = new IsClienteCadastradoResponseType();
		isClienteCadastradoResponseType.setNomeCliente("Teste");
		isClienteCadastradoResponseType.setIsCadastrado(true);

		Mockito.when(conquistaFacade.isClienteArenaCadastrado(cpf))
				.thenReturn(Mono.just(isClienteCadastradoResponseType));

		conquistaService.isClienteArenaCadastrado("07473180690").map(cadastro -> {
			assertTrue("Cliente cadastrado.", cadastro.getIsCadastrado());
			assertEquals("Teste", cadastro.getNomeCliente());
			return cadastro;
		}).subscribe();

	}

	@Test(expected = Exception.class)
	public void testIsClienteArenaCadastradoNulo() {

		conquistaService.isClienteArenaCadastrado(null).map(cadastro -> {
			return cadastro;
		}).subscribe();
	}

	@Test
	public void testCadastrarClienteArenaComClienteCadastrado() {

		String cpf = "07473180690";

		ClienteConquista clienteConquista = new ClienteConquista();
		clienteConquista.setNome("Teste");
		clienteConquista.setCpfCnpj(cpf);

		ClienteConquistaRequest clienteConquistaRequest = new ClienteConquistaRequest();
		clienteConquistaRequest.setClienteArena(clienteConquista);

		ClienteArenaType clienteArenaType = new ClienteArenaType();
		clienteArenaType.setNome("Teste");
		clienteArenaType.setCpfCnpj(cpf);

		CadastrarClienteArenaRequestType cadastrarClienteArenaRequestType = new CadastrarClienteArenaRequestType();
		cadastrarClienteArenaRequestType.setClienteArena(clienteArenaType);

		CadastrarClienteArenaResponseType.Message message = new CadastrarClienteArenaResponseType.Message();
		message.setMensagem("SUCESSO");
		message.setTipoCritica(TipoCriticaEnum.SUCESSO);

		CadastrarClienteArenaResponseType cadastrarClienteArenaResponseType = new CadastrarClienteArenaResponseType();
		cadastrarClienteArenaResponseType.setClienteArena(clienteArenaType);
		cadastrarClienteArenaResponseType.setMesagem("CPF já cadastrado.");
		cadastrarClienteArenaResponseType.setMessage(message);

		Mockito.when(conquistaFacade.cadastrarClienteArena(Mockito.any(CadastrarClienteArenaRequestType.class)))
				.thenReturn(Mono.just(cadastrarClienteArenaResponseType));

		conquistaService.cadastrarClienteArena(clienteConquistaRequest).map(cadastrarClienteConquistaRetorno -> {
			assertEquals("CPF já cadastrado.", cadastrarClienteConquistaRetorno.getMesagem());
			assertEquals("SUCESSO", cadastrarClienteConquistaRetorno.getMessage().getMensagem());
			assertEquals(com.porto.portocom.portal.cliente.v1.constant.TipoCriticaEnum.SUCESSO,
					cadastrarClienteConquistaRetorno.getMessage().getTipoCritica());
			return cadastrarClienteConquistaRetorno;
		}).subscribe();
	}

	@Test
	public void testCadastrarClienteArenaValidacaoComErro() {

		String cpf = "5373";

		ClienteConquista clienteConquista = new ClienteConquista();
		clienteConquista.setNome("Teste");
		clienteConquista.setCpfCnpj(cpf);

		ClienteConquistaRequest clienteConquistaRequest = new ClienteConquistaRequest();
		clienteConquistaRequest.setClienteArena(clienteConquista);

		ClienteArenaType clienteArenaType = new ClienteArenaType();
		clienteArenaType.setNome("Teste");
		clienteArenaType.setCpfCnpj(cpf);

		CadastrarClienteArenaRequestType cadastrarClienteArenaRequestType = new CadastrarClienteArenaRequestType();
		cadastrarClienteArenaRequestType.setClienteArena(clienteArenaType);

		CadastrarClienteArenaResponseType.Message message = new CadastrarClienteArenaResponseType.Message();
		message.setMensagem("VALIDACAO");
		message.setTipoCritica(TipoCriticaEnum.CRITICA_VALIDACAO);

		CadastrarClienteArenaResponseType cadastrarClienteArenaResponseType = new CadastrarClienteArenaResponseType();
		cadastrarClienteArenaResponseType.setClienteArena(clienteArenaType);
		cadastrarClienteArenaResponseType.setMesagem("Erro ao validar os campos");
		cadastrarClienteArenaResponseType.setMessage(message);

		Mockito.when(conquistaFacade.cadastrarClienteArena(Mockito.any(CadastrarClienteArenaRequestType.class)))
				.thenReturn(Mono.just(cadastrarClienteArenaResponseType));

		conquistaService.cadastrarClienteArena(clienteConquistaRequest).map(cadastrarClienteConquistaRetorno -> {
			assertEquals("Erro ao validar os campos", cadastrarClienteConquistaRetorno.getMesagem());
			assertEquals("VALIDACAO", cadastrarClienteConquistaRetorno.getMessage().getMensagem());
			assertEquals(com.porto.portocom.portal.cliente.v1.constant.TipoCriticaEnum.CRITICA_VALIDACAO,
					cadastrarClienteConquistaRetorno.getMessage().getTipoCritica());
			return cadastrarClienteConquistaRetorno;
		}).subscribe();
	}

	@Test(expected = Exception.class)
	public void testCadastrarClienteArenaNullPointer() {

		conquistaService.cadastrarClienteArena(null).map(cadastrarClienteConquistaRetorno -> {
			return cadastrarClienteConquistaRetorno;
		}).subscribe();
	}
}
