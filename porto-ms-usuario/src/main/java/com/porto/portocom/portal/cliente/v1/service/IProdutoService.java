package com.porto.portocom.portal.cliente.v1.service;

import java.util.List;

import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Pessoa;

import reactor.core.publisher.Mono;

public interface IProdutoService {
	
	Mono<List<Pessoa>> consultaPessoas(String cpfCnpj);
	

}
