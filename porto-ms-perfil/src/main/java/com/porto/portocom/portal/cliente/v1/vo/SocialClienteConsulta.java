package com.porto.portocom.portal.cliente.v1.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class SocialClienteConsulta extends SocialCliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6338197568607229932L;
	
	@NotBlank(message = "O texto identificador não pode ser vazio.")
	private String textoIdentificadorAplicacaoRedeSocial;

}
