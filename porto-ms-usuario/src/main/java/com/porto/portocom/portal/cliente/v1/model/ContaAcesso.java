package com.porto.portocom.portal.cliente.v1.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class ContaAcesso implements Serializable {

	private static final long serialVersionUID = -1983085930898881844L;

    private String nome;
    private List<String> produtos;
    private String sobreNome;
    private String usuario;

}
