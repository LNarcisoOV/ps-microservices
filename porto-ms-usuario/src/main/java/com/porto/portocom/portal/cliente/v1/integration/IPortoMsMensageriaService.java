package com.porto.portocom.portal.cliente.v1.integration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public interface IPortoMsMensageriaService {

	Mono<Boolean> enviaEmail(String from, String to, String subject, String message, String cpfCnpj);

	Mono<Boolean> enviaSms(String ddd, String celular, String mensagem, String cpfCnpj);
}
