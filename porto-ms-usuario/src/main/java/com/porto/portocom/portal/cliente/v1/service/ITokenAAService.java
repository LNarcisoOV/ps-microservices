package com.porto.portocom.portal.cliente.v1.service;

import com.porto.portocom.portal.cliente.v1.model.PinVO;
import com.porto.portocom.portal.cliente.v1.model.ValidaTokenAAResponse;

import reactor.core.publisher.Mono;

public interface ITokenAAService {
	
	Mono<PinVO> geraPinServico(String cpfCnpj);
	
	Mono<PinVO> geraPinCliente(String cpfCnpj);
	
	Mono<ValidaTokenAAResponse> validaTokenServico(String cpfCnpj, String token);
	
	Mono<ValidaTokenAAResponse> validaTokenCliente(String cpfCnpj, String token);
	
	
	

}
