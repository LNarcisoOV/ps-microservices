package com.porto.portocom.portal.cliente.v1.exception;

import com.porto.portocom.portal.cliente.v1.exception.PortalException;

import lombok.Getter;

@Getter
public class UsuarioPortalException extends PortalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1056935072306525282L;
	
	public UsuarioPortalException(String mensagem, int statusCode) {
		super(mensagem, statusCode);
		
	}

}
