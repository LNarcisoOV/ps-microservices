package com.porto.portocom.portal.cliente.v1.constant;

public enum ConstantesEnum {
	

	CPF_CNPJ_INVALIDO("CPF/CNPJ inválido.");
	
	private String descricao;
	
	private ConstantesEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
