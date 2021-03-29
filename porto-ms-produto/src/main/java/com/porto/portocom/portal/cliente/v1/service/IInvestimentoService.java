package com.porto.portocom.portal.cliente.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.dto.investimento.CotistaInvestimento;

import reactor.core.publisher.Mono;

@Service
public interface IInvestimentoService {

	Mono<List<CotistaInvestimento>> consultaCotistas(final String cpfCnpj);
}
