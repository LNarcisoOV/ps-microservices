package com.porto.portocom.portal.cliente.v1.exception;

import java.io.Serializable;

import com.porto.portocom.portal.cliente.v1.exception.PortalException;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContadorConta;

import lombok.Getter;

@Getter
public class CodigoSegurancaException extends PortalException implements Serializable {

	private static final long serialVersionUID = 7644445232996763839L;
	private final InformacaoContadorConta infContador;

	public CodigoSegurancaException(String mensagem, int statusCode, InformacaoContadorConta infContador) {
		super(mensagem, statusCode);
		this.infContador = infContador;
	}

}
