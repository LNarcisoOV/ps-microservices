package com.porto.portocom.portal.cliente.v1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.ConstantesEnum;
import com.porto.portocom.portal.cliente.v1.dto.investimento.CotistaInvestimento;
import com.porto.portocom.portal.cliente.v1.integration.facade.IInvestimentoFacade;
import com.porto.portocom.portal.cliente.v1.utils.ObjectMapperUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.wsdl.investimento.CotistaCompletoServiceVO;

import reactor.core.publisher.Mono;

@Service
public class InvestimentoService implements IInvestimentoService {

	private IInvestimentoFacade investimentoFacade;

	@Autowired
	public InvestimentoService(IInvestimentoFacade investimentoFacade) {
		this.investimentoFacade = investimentoFacade;
	}

	@Override
	public Mono<List<CotistaInvestimento>> consultaCotistas(String cpfCnpj) {
		if (ValidaCpfCnpjUtils.isValid(cpfCnpj)) {
			return investimentoFacade.cotistas(cpfCnpj).map(cotistas -> parseToCotistaInvestimento(cotistas));
		} else {
			return Mono.error(new Error(ConstantesEnum.CPF_CNPJ_INVALIDO.getDescricao()));
		}
	}

	private List<CotistaInvestimento> parseToCotistaInvestimento(final List<CotistaCompletoServiceVO> cotistas) {
		if (cotistas != null) {
			return ObjectMapperUtils.mapAll(cotistas, CotistaInvestimento.class);
		} else {
			return new ArrayList<>();
		}
	}
}
