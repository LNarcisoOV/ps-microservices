package com.porto.portocom.portal.cliente.v1.model;

import java.io.Serializable;

import com.porto.portocom.portal.cliente.v1.vo.usuario.TelefoneVO;

import lombok.Data;

@Data
public class TelefoneEmailVO implements Serializable {

	private static final long serialVersionUID = 1467679145459352117L;

	private TelefoneVO telefone;
	private String email;

}
