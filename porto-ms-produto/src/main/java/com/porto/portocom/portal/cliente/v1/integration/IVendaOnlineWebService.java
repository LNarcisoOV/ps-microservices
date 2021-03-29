package com.porto.portocom.portal.cliente.v1.integration;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.wsdl.vdo.VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService;
import com.porto.portocom.portal.cliente.v1.wsdl.vdo.common.VendaOnlineResponse;

@Service
public interface IVendaOnlineWebService {

	VendaOnlineResponse pesquisaCotacoesCache(String cpfCnpj,
			VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService vendaOnlineService);

	VendaOnlineResponse pesquisaCotacoes(String cpfCnpj,
			VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService vendaOnlineService);
}
