package com.porto.portocom.portal.cliente.v1.exception;

import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContadorConta;

import lombok.Getter;

@Getter
public class ContadorAcessoException extends PortalException {

	private static final long serialVersionUID = -6887813916686514574L;
	private final InformacaoContadorConta infContador;
	
	public ContadorAcessoException(String mensagem, int statusCode, InformacaoContadorConta infContador) {
		super(mensagem, statusCode);
		this.infContador = infContador;
	}
}
