package com.porto.portocom.portal.cliente.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.dto.bcp.ContratoBcp;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;

import reactor.core.publisher.Mono;

@Service
public interface IBcpService {

	Mono<List<ContratoBcp.Pessoa>> consultarContratos(String cpfCnpj);

	Mono<List<PessoaBcp.Pessoa>> consultarPessoas(String cpfCnpj);

}
