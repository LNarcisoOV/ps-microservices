package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.ConstantesEnum;
import com.porto.portocom.portal.cliente.v1.dto.vdo.CotacoesVendaOnline;
import com.porto.portocom.portal.cliente.v1.integration.facade.IVendaOnlineFacade;
import com.porto.portocom.portal.cliente.v1.utils.ObjectMapperUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.wsdl.vdo.common.VendaOnlineResponse;

import reactor.core.publisher.Mono;

@Service
public class VendaOnlineService implements IVendaOnlineService {

	private IVendaOnlineFacade vendaOnlineFacade;

	@Autowired
	public VendaOnlineService(IVendaOnlineFacade vendaOnlineFacade) {
		this.vendaOnlineFacade = vendaOnlineFacade;
	}

	@Override
	public Mono<CotacoesVendaOnline> pesquisaCotacoes(String cpfCnpj) {
		if (ValidaCpfCnpjUtils.isValid(cpfCnpj)) {
			return vendaOnlineFacade.pesquisaCotacoes(cpfCnpj).map(cotistas -> {
				return parseToVendaOnlineResponse(cotistas);
			});
		} else {
			return Mono.error(new Error(ConstantesEnum.CPF_CNPJ_INVALIDO.getDescricao()));
		}
	}

	private CotacoesVendaOnline parseToVendaOnlineResponse(final VendaOnlineResponse cotacoes) {
		return ObjectMapperUtils.map(cotacoes, CotacoesVendaOnline.class);
	}
}
