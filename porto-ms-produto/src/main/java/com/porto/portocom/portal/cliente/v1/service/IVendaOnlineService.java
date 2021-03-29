package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.dto.vdo.CotacoesVendaOnline;

import reactor.core.publisher.Mono;

@Service
public interface IVendaOnlineService {

	Mono<CotacoesVendaOnline> pesquisaCotacoes(String cpfCnpj);

}
