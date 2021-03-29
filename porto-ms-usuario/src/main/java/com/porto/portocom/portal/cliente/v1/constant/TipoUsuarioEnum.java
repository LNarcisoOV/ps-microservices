package com.porto.portocom.portal.cliente.v1.constant;

import lombok.Getter;

@Getter
public enum TipoUsuarioEnum {

	PROSPECT_VENDA_ONLINE(1L),
	PROSPECT_CONQUISTA(2L),
	EX_CLIENTE(3L),
	CLIENTE(4L),
	PROSPECT_BCC(5L);

	private Long codTipo;

	TipoUsuarioEnum(Long codTipo) {
		this.codTipo = codTipo;
	}

}
