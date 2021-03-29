package com.porto.portocom.portal.cliente.v1.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidaTokenAARequest implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8853042004858883798L;
	private String userName;
	private String orgName;
	private String profileName;
	private String otp;

}
