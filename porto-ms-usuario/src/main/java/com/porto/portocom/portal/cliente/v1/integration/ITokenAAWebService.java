package com.porto.portocom.portal.cliente.v1.integration;

import com.porto.portocom.portal.cliente.v1.model.GeraTokenAAResponse;
import com.porto.portocom.portal.cliente.v1.model.ValidaTokenAAResponse;

import reactor.core.publisher.Mono;

public interface ITokenAAWebService {
	
	Mono<GeraTokenAAResponse> geraTokenAA(String cpfCnpj, String profile);
	
	Mono<ValidaTokenAAResponse> validaTokenAA(String cpfCnpj, String token, String profile);
	

}
