package com.porto.portocom.portal.cliente.v1.exception;

import lombok.Getter;

@Getter
public class ValidacaoPinException extends PortalException {

	private static final long serialVersionUID = -8418307646997619943L;

	public ValidacaoPinException(String mensagem, int statusCode) {
		super(mensagem, statusCode);
	}

}