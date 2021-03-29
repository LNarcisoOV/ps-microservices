package com.porto.portocom.portal.cliente.v1.integration;

import org.springframework.stereotype.Service;

@Service
public interface IPortalLogService {

	void enviaLogIntegracao(String siglaIntegracao, String metodo, String cpfCnpj, Object request, Object response,
			int responseCode, long connectionTime, long executionTime, Exception exception, String trace);
}
