package com.porto.portocom.portal.cliente.v1.exception;

import lombok.Getter;

@Getter
public class LexisNexisHeaderException extends PortalException {

	private static final long serialVersionUID = 2690988818800711638L;

	public LexisNexisHeaderException(String mensagem, int statusCode) {
		super(mensagem, statusCode);
	}

}