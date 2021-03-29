package com.porto.portocom.portal.cliente.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.ConstantesEnum;
import com.porto.portocom.portal.cliente.v1.dto.bcp.ContratoBcp;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.integration.facade.IBcpFacade;
import com.porto.portocom.portal.cliente.v1.utils.ObjectMapperUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterContratoResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterPessoasResponseType;

import reactor.core.publisher.Mono;

@Service
public class BcpService implements IBcpService {

	private IBcpFacade bcpFacade;

	@Autowired
	public BcpService(IBcpFacade bcpFacade) {
		this.bcpFacade = bcpFacade;
	}

	@Override
	public Mono<List<ContratoBcp.Pessoa>> consultarContratos(String cpfCnpj) {
		if (ValidaCpfCnpjUtils.isValid(cpfCnpj)) {
			return this.bcpFacade.contratosBcp(cpfCnpj).map(listPessoas -> this.parseToContratoBcpPessoa(listPessoas));
		} else {
			return Mono.error(new Error(ConstantesEnum.CPF_CNPJ_INVALIDO.getDescricao()));
		}
	}

	@Override
	public Mono<List<PessoaBcp.Pessoa>> consultarPessoas(String cpfCnpj) {
		if (ValidaCpfCnpjUtils.isValid(cpfCnpj)) {
			return this.bcpFacade.pessoasBcp(cpfCnpj).map(listPessoas -> this.parseToPessoaBcpPessoa(listPessoas));
		} else {
			return Mono.error(new Error(ConstantesEnum.CPF_CNPJ_INVALIDO.getDescricao()));
		}
	}

	private List<ContratoBcp.Pessoa> parseToContratoBcpPessoa(final List<ObterContratoResponseType.Pessoa> pessoas) {
		return ObjectMapperUtils.mapAll(pessoas, ContratoBcp.Pessoa.class);
	}

	private List<PessoaBcp.Pessoa> parseToPessoaBcpPessoa(final List<ObterPessoasResponseType.Pessoa> pessoas) {
		return ObjectMapperUtils.mapAll(pessoas, PessoaBcp.Pessoa.class);
	}
}
