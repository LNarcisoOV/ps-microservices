package com.porto.portocom.portal.cliente.v1.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class SocialCliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5602496137910357991L;
	
	@NotBlank(message = "O identificador da rede social não pode ser vazio.")
	private String idSocialCliente;
	
	
	

}
