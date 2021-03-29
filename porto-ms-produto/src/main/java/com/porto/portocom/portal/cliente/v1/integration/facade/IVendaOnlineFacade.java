package com.porto.portocom.portal.cliente.v1.integration.facade;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.wsdl.vdo.common.VendaOnlineResponse;

import reactor.core.publisher.Mono;

@Service
public interface IVendaOnlineFacade {

	Mono<VendaOnlineResponse> pesquisaCotacoes(String cpfCnpj);
	

}
