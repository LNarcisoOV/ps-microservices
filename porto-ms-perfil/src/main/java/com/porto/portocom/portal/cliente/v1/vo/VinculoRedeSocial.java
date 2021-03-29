package com.porto.portocom.portal.cliente.v1.vo;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class VinculoRedeSocial {
	
	@NotBlank(message = "O id social do cliente não pode estar vazio!")
	private String idSocialCliente;
	
	@NotBlank(message = "O texto identificador da rede social não pode estar vazio!")
	private String textoIdentificadorAplicacaoRedeSocial;

}
