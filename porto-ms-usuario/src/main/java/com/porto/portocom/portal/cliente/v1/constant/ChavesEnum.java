package com.porto.portocom.portal.cliente.v1.constant;

import lombok.Getter;

@Getter
public enum ChavesEnum {
	
	REQUEST_TIMEOUT("com.sun.xml.ws.request.timeout"), CONNECT_TIMEOUT("com.sun.xml.ws.connect.timeout");
	
	private final String valor;
	
	ChavesEnum(String valor) {
		this.valor = valor;
	}
	
	

}
