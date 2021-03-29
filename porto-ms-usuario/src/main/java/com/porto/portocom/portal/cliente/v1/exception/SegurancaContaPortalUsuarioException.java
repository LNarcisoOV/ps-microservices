package com.porto.portocom.portal.cliente.v1.exception;

public class SegurancaContaPortalUsuarioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SegurancaContaPortalUsuarioException(String message) {
		super(message);
	}

	public SegurancaContaPortalUsuarioException(String message, Throwable cause) {
		super(message, cause);
	}
}
