package com.porto.portocom.portal.cliente.v1.exception;

import lombok.Getter;

@Getter
public class CadastroException extends PortalException {

	private static final long serialVersionUID = -1072472978504037645L;

	public CadastroException(String mensagem, int statusCode) {
		super(mensagem, statusCode);
	}

}
