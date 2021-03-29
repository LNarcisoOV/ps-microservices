package com.porto.portocom.portal.cliente.v1.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class IdInvalidoException extends RuntimeException {

	private static final long serialVersionUID = -8171194938391229734L;
	
	public IdInvalidoException() {
		super("Usuário não encontrado.");
	}
	
	

}
