package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;

import reactor.core.publisher.Mono;

@Service
public interface IProdutoService {

	Mono<ConsultaProdutosProspect> consultaProdutosProspect(String cpfCnpj);

}
