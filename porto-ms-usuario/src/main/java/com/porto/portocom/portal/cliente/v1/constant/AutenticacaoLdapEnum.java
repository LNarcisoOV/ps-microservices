package com.porto.portocom.portal.cliente.v1.constant;

import lombok.Getter;

@Getter
public enum AutenticacaoLdapEnum {

	SUCESSO_AUTENTICACAO("Login autenticado", "0"), USUARIO_SENHA_INVALIDO("Usuário ou senha inválido", "1"),
	SENHA_EXPIRADA("Senha expirada", "2"), USUARIO_BLOQUEADO_TEMPORARIAMENTE("Usuário bloqueado temporariamente.", "3"),
	USUARIO_BLOQUEADO_DEFINITIVAMENTE("Usuário bloqueado definitivamente", "4"),
	SESSAO_EM_CONTIGENCIA("Senha em contigencia", "5"),
	SENHA_INVALIDA("Senha Inválida. Você tem mais de 1 tentativa.", "6"),
	SENHA_INVALIDA_ULTIMA_TENTATIVA("Senha Inválida. Você tem apenas mais 1 tentativa.", "7"),
	VARIAVEL_NAO_INFORMADA("#VARIAVEL# não informado(a)", "8"), ERRO_INESPERADO("Erro Inesperaro", "9");

	private final String valor;
	private final String mensagem;

	AutenticacaoLdapEnum(String mensagem, String valor) {
		this.mensagem = mensagem;
		this.valor = valor;
	}

}
