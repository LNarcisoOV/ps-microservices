package com.porto.portocom.portal.cliente.v1.integration.facade;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes.ContaCartaoRetornoVO;

import reactor.core.publisher.Mono;

@Service
public interface IComplementoCartoesFacade {

	Mono<ContaCartaoRetornoVO> contaCartoes(String cpfCnpj, String origem);
	
}
