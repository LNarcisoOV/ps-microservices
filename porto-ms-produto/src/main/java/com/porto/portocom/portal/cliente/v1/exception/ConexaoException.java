package com.porto.portocom.portal.cliente.v1.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ConexaoException extends RuntimeException {
	
	private static final long serialVersionUID = 5114388302802254016L;
	
	public ConexaoException(String message, Throwable cause) {
		super(message, cause);
	}



}
