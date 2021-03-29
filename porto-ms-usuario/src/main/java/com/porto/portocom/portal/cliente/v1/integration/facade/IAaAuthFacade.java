package com.porto.portocom.portal.cliente.v1.integration.facade;

public interface IAaAuthFacade {
	
	void validaPinServico(String cpfCnpj, String pin);
	
	void validaPinCliente(String cpfCnpj, String pin);

}
