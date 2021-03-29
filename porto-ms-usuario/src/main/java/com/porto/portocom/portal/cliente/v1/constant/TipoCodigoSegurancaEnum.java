package com.porto.portocom.portal.cliente.v1.constant;

import lombok.Getter;

@Getter
public enum TipoCodigoSegurancaEnum {

	/**
	 * Código de segurança para cadastro de conta do portal
	 */
	TIPO_CODIGOSEGURANCA_CADASTROCONTA_PORTAL(1),

	/**
	 * Código de segurança para redefinição de senha do portal
	 */
	TIPO_CODIGOSEGURANCA_REDEFINIRSENHA(2),

	/**
	 * Código de segurança para bloqueio de conta do portal
	 */
	TIPO_CODIGOSEGURANCA_BLOQUEAR_CONTA(5),
	/**
	 * Código de segurança para autenticação de dois fatores
	 */
	TIPO_CODIGOSEGURANCA_ACESSO(12);

	private Integer codigo;

	TipoCodigoSegurancaEnum(Integer codigo){
		this.codigo = codigo;
	}

}
