package com.porto.portocom.portal.cliente.v1.exception;

import java.io.Serializable;

public class GeraTokenAAException extends PortalException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2829918904200742881L;
	
	public GeraTokenAAException(String mensagem, int statusCode) {
		super(mensagem, statusCode);
	}

}
