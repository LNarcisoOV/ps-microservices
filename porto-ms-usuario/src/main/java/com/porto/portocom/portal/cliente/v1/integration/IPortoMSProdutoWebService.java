package com.porto.portocom.portal.cliente.v1.integration;

import java.util.List;

import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;

public interface IPortoMSProdutoWebService {

	ConsultaProdutosProspect consultaProdutosProspect(String cpfCnpj);
	
	List<PessoaBcp.Pessoa> consultaPessoas(String cpfCnpj);

}
