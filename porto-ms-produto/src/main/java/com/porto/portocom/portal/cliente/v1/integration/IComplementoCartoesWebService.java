package com.porto.portocom.portal.cliente.v1.integration;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes.CartaoWebPortalService;
import com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes.ContaCartaoRetornoVO;

@Service
public interface IComplementoCartoesWebService {

	ContaCartaoRetornoVO consultarContasCartoes(String cpfCnpj, String origem,
			CartaoWebPortalService cartaoWebPortalService);

	ContaCartaoRetornoVO consultarContasCartoesCache(String cpfCnpj, String origem,
			CartaoWebPortalService cartaoWebPortalService);

}
