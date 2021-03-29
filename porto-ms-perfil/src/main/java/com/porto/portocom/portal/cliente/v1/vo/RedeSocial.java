package com.porto.portocom.portal.cliente.v1.vo;

import java.io.Serializable;
import java.util.Date;

import com.porto.portocom.portal.cliente.entity.UsuarioRedeSocial;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Builder
@AllArgsConstructor
@Value
public class RedeSocial implements Serializable {
	
	private static final long serialVersionUID = -2096414257239628464L;
	
	private String idSocialCliente;
	
	private String aplicacaoRedeSocial;
	
	private Long usuarioPortalCliente;
	
	private String flagVinculoAtivo;
	
	private Date dataUltimaAtualizacao;
	
	public RedeSocial(UsuarioRedeSocial usuarioRedeSocial) {
		this.idSocialCliente = usuarioRedeSocial.getIdSocialCliente() != null ? usuarioRedeSocial.getIdSocialCliente() : null;
		this.dataUltimaAtualizacao = usuarioRedeSocial.getDataUltimaAtualizacao() != null ? usuarioRedeSocial.getDataUltimaAtualizacao() : null;
		this.flagVinculoAtivo = usuarioRedeSocial.getFlagVinculoAtivo() != null ? usuarioRedeSocial.getFlagVinculoAtivo() : null;
		if (usuarioRedeSocial.getUsuarioPortalCliente() != null) {
			this.usuarioPortalCliente = usuarioRedeSocial.getUsuarioPortalCliente().getIdUsuario() != null ? usuarioRedeSocial.getUsuarioPortalCliente().getIdUsuario() : null;
			this.aplicacaoRedeSocial = usuarioRedeSocial.getAplicacaoRedeSocial().getTextoIdentificadorAplicacaoRedeSocial() != null ? 
					usuarioRedeSocial.getAplicacaoRedeSocial().getTextoIdentificadorAplicacaoRedeSocial() : null;
		} else {
			this.usuarioPortalCliente = null;
			this.aplicacaoRedeSocial = null;
		}

	}
	

}
