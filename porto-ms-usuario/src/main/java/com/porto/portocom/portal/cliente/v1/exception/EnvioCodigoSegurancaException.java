package com.porto.portocom.portal.cliente.v1.exception;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class EnvioCodigoSegurancaException extends PortalException implements Serializable {

	private static final long serialVersionUID = -6942294409204784034L;

	public EnvioCodigoSegurancaException(String mensagem, int statusCode) {
		super(mensagem, statusCode);
	}

}
