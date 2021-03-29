package com.porto.portocom.portal.cliente.v1.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GeraTokenAARequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6824910411453139109L;
	private String userName;
	private String orgName;
	private String profileName;

}
