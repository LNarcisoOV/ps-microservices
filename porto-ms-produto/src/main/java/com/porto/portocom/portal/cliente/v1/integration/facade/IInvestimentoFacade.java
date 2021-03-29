package com.porto.portocom.portal.cliente.v1.integration.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.wsdl.investimento.CotistaCompletoServiceVO;

import reactor.core.publisher.Mono;

@Service
public interface IInvestimentoFacade {

	Mono<List<CotistaCompletoServiceVO>> cotistas(final String cpfCnpj);
	

}
