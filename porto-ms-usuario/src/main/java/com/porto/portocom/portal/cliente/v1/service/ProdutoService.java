package com.porto.portocom.portal.cliente.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Pessoa;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMSProdutoWebService;

import reactor.core.publisher.Mono;

@Service
public class ProdutoService implements IProdutoService {

	private IPortoMSProdutoWebService produtoMSService;
	
	@Autowired
	public ProdutoService(IPortoMSProdutoWebService produtoMSService) {
		this.produtoMSService = produtoMSService;
	}
	
	@Override
	public Mono<List<Pessoa>> consultaPessoas(String cpfCnpj) {	
		return Mono.justOrEmpty(this.produtoMSService.consultaPessoas(cpfCnpj));
	}

}
