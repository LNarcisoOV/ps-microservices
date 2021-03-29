package com.porto.portocom.portal.cliente.v1.integration.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterContratoResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterPessoasResponseType;

import reactor.core.publisher.Mono;

@Service
public interface IBcpFacade {


	Mono<List<ObterContratoResponseType.Pessoa>> contratosBcp(final String cpfCnpj);

	Mono<List<ObterPessoasResponseType.Pessoa>> pessoasBcp(final String cpfCnpj);
	
}
