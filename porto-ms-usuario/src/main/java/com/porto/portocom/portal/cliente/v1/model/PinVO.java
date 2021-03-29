package com.porto.portocom.portal.cliente.v1.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PinVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private LocalDateTime dataCriacao;
	private LocalDateTime dataExpiracao;
	private String pin;

}
