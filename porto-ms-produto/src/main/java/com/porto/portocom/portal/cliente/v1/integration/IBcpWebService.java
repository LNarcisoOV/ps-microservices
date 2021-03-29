package com.porto.portocom.portal.cliente.v1.integration;

import java.util.List;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ConsultaDadosBCPWS_Service;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterContratoResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterPessoasResponseType;

@Service
public interface IBcpWebService {

	List<ObterContratoResponseType.Pessoa> obterContratos(String cpfCnpj,
			ConsultaDadosBCPWS_Service consultaDadosBCPWSService);

	List<ObterContratoResponseType.Pessoa> obterContratosCache(String cpfCnpj,
			ConsultaDadosBCPWS_Service consultaDadosBCPWSService);

	List<ObterPessoasResponseType.Pessoa> obterPessoas(String cpfCnpj,
			ConsultaDadosBCPWS_Service consultaDadosBCPWSService);

	List<ObterPessoasResponseType.Pessoa> obterPessoasCache(String cpfCnpj,
			ConsultaDadosBCPWS_Service consultaDadosBCPWSService);
}
