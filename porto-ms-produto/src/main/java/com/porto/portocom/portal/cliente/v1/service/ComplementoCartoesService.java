package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.ConstantesEnum;
import com.porto.portocom.portal.cliente.v1.dto.complementocartoes.ContaCartao;
import com.porto.portocom.portal.cliente.v1.integration.facade.IComplementoCartoesFacade;
import com.porto.portocom.portal.cliente.v1.utils.ObjectMapperUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes.ContaCartaoRetornoVO;

import reactor.core.publisher.Mono;

@Service
public class ComplementoCartoesService implements IComplementoCartoesService {

	private IComplementoCartoesFacade complementoCartoesFacade;

	@Autowired
	public ComplementoCartoesService(IComplementoCartoesFacade complementoCartoesFacade) {
		this.complementoCartoesFacade = complementoCartoesFacade;
	}

	@Override
	public Mono<ContaCartao> consultarComplementoCartoes(String cpfCnpj, String origem) {
		if (ValidaCpfCnpjUtils.isValid(cpfCnpj)) {
			return complementoCartoesFacade.contaCartoes(cpfCnpj, origem).map(contas -> parseToContaCartao(contas));

		} else {
			return Mono.error(new Error(ConstantesEnum.CPF_CNPJ_INVALIDO.getDescricao()));
		}
	}

	private ContaCartao parseToContaCartao(final ContaCartaoRetornoVO contas) {
		return ObjectMapperUtils.map(contas, ContaCartao.class);
	}
}
