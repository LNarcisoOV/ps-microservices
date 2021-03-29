package com.porto.portocom.portal.cliente.v1.model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class ContaAcessoComSenha extends ContaAcesso {

    private static final long serialVersionUID = 4973790113190120983L;

    protected String senha;

    public ContaAcessoComSenha(String nome, List<String> produtos, String sobreNome, String usuario, String senha) {
        super(nome, produtos, sobreNome, usuario);
        this.senha = senha;
    }

}
