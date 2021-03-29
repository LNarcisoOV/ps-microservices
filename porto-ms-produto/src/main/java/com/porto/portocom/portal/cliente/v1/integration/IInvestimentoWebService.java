package com.porto.portocom.portal.cliente.v1.integration;

import java.util.List;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.wsdl.investimento.ConsultarCotistaServiceService;
import com.porto.portocom.portal.cliente.v1.wsdl.investimento.CotistaCompletoServiceVO;

@Service
public interface IInvestimentoWebService {

	List<CotistaCompletoServiceVO> consultar(final String cpfCnpj,
			ConsultarCotistaServiceService consultarCotistaService);

	List<CotistaCompletoServiceVO> consultarCache(final String cpfCnpj,
			ConsultarCotistaServiceService consultarCotistaService);

}
