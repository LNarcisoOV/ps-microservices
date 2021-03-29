package com.porto.portocom.portal.cliente.v1.exception;

import lombok.Getter;

@Getter
public class IntegracaoKbaException extends PortalException {

	private static final long serialVersionUID = 6540666698848141173L;

	public IntegracaoKbaException(String mensagem, int statusCode) {
		super(mensagem, statusCode);
	}

}