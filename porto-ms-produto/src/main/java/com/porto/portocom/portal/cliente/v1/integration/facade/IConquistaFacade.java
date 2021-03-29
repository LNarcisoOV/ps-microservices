package com.porto.portocom.portal.cliente.v1.integration.facade;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaRequestType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.IsClienteCadastradoResponseType;

import reactor.core.publisher.Mono;

@Service
public interface IConquistaFacade {

	Mono<CadastrarClienteArenaResponseType> cadastrarClienteArena(
			CadastrarClienteArenaRequestType cadastrarClienteArena);

	Mono<IsClienteCadastradoResponseType> isClienteArenaCadastrado(String cpfCnpj);
	
	Mono<IsClienteCadastradoResponseType> obterDadosClienteArenaCadastrado(String cpfCnpj);
	
}
