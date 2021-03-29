package com.porto.portocom.portal.cliente.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidaPinRequest {
	
	private String cpfCnpj;
	private String pin;
	private String profile;
	

}
