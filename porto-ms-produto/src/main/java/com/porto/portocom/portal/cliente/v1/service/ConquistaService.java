package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.ConstantesEnum;
import com.porto.portocom.portal.cliente.v1.dto.conquista.CadastroClienteConquista;
import com.porto.portocom.portal.cliente.v1.dto.conquista.ClienteConquistaRequest;
import com.porto.portocom.portal.cliente.v1.dto.conquista.IsClienteArenaCadastrado;
import com.porto.portocom.portal.cliente.v1.integration.facade.IConquistaFacade;
import com.porto.portocom.portal.cliente.v1.utils.ObjectMapperUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaRequestType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.IsClienteCadastradoResponseType;

import reactor.core.publisher.Mono;

@Service
public class ConquistaService implements IConquistaService {

	private IConquistaFacade conquistaFacade;

	@Autowired
	public ConquistaService(IConquistaFacade conquistaFacade) {
		this.conquistaFacade = conquistaFacade;
	}

	@Override
	public Mono<CadastroClienteConquista> cadastrarClienteArena(ClienteConquistaRequest cadastraCliente) {
		return conquistaFacade.cadastrarClienteArena(this.parseToCadastrarClienteArenaRequestType(cadastraCliente))
				.map(response -> this.parseToCadastroClienteConquista(response));
	}

	@Override
	public Mono<IsClienteArenaCadastrado> isClienteArenaCadastrado(String cpfCnpj) {
		if (ValidaCpfCnpjUtils.isValid(cpfCnpj)) {
			return conquistaFacade.isClienteArenaCadastrado(cpfCnpj)
					.map(response -> this.parseToIsClienteArenaCadastrado(response));
		} else {
			return Mono.error(new Error(ConstantesEnum.CPF_CNPJ_INVALIDO.getDescricao()));
		}
	}
	
	@Override
	public Mono<IsClienteArenaCadastrado> obterDadosClienteArenaCadastrado(String cpfCnpj) {
		if (ValidaCpfCnpjUtils.isValid(cpfCnpj)) {
			return conquistaFacade.obterDadosClienteArenaCadastrado(cpfCnpj)
					.map(response -> this.parseToIsClienteArenaCadastrado(response));
		} else {
			return Mono.error(new Error(ConstantesEnum.CPF_CNPJ_INVALIDO.getDescricao()));
		}
	}

	private CadastrarClienteArenaRequestType parseToCadastrarClienteArenaRequestType(
			final ClienteConquistaRequest cadastraCliente) {
		return ObjectMapperUtils.map(cadastraCliente, CadastrarClienteArenaRequestType.class);
	}

	private CadastroClienteConquista parseToCadastroClienteConquista(
			final CadastrarClienteArenaResponseType clienteArenaResponse) {
		return ObjectMapperUtils.map(clienteArenaResponse, CadastroClienteConquista.class);
	}

	private IsClienteArenaCadastrado parseToIsClienteArenaCadastrado(
			final IsClienteCadastradoResponseType isClienteCadastradoResponseType) {
		return ObjectMapperUtils.map(isClienteCadastradoResponseType, IsClienteArenaCadastrado.class);
	}
}
