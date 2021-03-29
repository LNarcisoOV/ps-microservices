package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.dto.complementocartoes.ContaCartao;

import reactor.core.publisher.Mono;

@Service
public interface IComplementoCartoesService {

	Mono<ContaCartao> consultarComplementoCartoes(String cpfCnpj, String origem);

}
