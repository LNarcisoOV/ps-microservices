package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.dto.conquista.CadastroClienteConquista;
import com.porto.portocom.portal.cliente.v1.dto.conquista.ClienteConquistaRequest;
import com.porto.portocom.portal.cliente.v1.dto.conquista.IsClienteArenaCadastrado;

import reactor.core.publisher.Mono;

@Service
public interface IConquistaService {
	
	Mono<CadastroClienteConquista> cadastrarClienteArena(ClienteConquistaRequest cadastraCliente);
	
	Mono<IsClienteArenaCadastrado> isClienteArenaCadastrado(String cpfCnpj);
	
	Mono<IsClienteArenaCadastrado> obterDadosClienteArenaCadastrado(String cpfCnpj);

}
