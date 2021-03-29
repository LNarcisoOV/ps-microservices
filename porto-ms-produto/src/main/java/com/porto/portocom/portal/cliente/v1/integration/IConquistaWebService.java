package com.porto.portocom.portal.cliente.v1.integration;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaRequestType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.ClienteArenaWSImplService;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.IsClienteCadastradoResponseType;

@Service
public interface IConquistaWebService {

	CadastrarClienteArenaResponseType cadastrarClienteArena(CadastrarClienteArenaRequestType cadastrarClienteArena,
			ClienteArenaWSImplService clienteArenaWS);

	IsClienteCadastradoResponseType isClienteArenaCadastradoCache(String cpfCnpj,
			ClienteArenaWSImplService clienteArenaWS);

	IsClienteCadastradoResponseType isClienteArenaCadastrado(String cpfCnpj, ClienteArenaWSImplService clienteArenaWS);
	
	IsClienteCadastradoResponseType obterDadosClienteArenaCadastrado(String cpfCnpj, ClienteArenaWSImplService clienteArenaWS);

	IsClienteCadastradoResponseType obterDadosClienteArenaCadastradoCache(String cpfCnpj, ClienteArenaWSImplService clienteArenaWS);
}
