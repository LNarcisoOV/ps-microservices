package com.porto.portocom.portal.cliente.v1.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LdapException extends RuntimeException {

	private static final long serialVersionUID = 5268464400475426000L;

	private final String codigo;

	public LdapException(Throwable cause, String codigo) {
		super(cause);
		this.codigo = codigo;
	}

	public LdapException(String message, Throwable cause, String codigo) {
		super(message, cause);
		this.codigo = codigo;
	}

	public LdapException(String message, String codigo) {
		super(message);
		this.codigo = codigo;
	}

}
