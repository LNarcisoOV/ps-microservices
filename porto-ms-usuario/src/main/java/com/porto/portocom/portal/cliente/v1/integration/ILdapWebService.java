package com.porto.portocom.portal.cliente.v1.integration;

import com.porto.portocom.portal.cliente.v1.model.ContaAcessoComSenha;
import com.porto.portocom.portal.cliente.v1.wsdl.ldap.ContaAcessoVO;

public interface ILdapWebService {

	Boolean alterarSenha(String cpfcnpj, String senha);

	Boolean criarUsuarioComSenha(ContaAcessoComSenha contaAcessoComSenha);
	
	Boolean atualizarSenha(String cpfcnpj, String senha, String errorMessage);
	
	Boolean criarUsuario(ContaAcessoVO contaAcesso);	
	
}
