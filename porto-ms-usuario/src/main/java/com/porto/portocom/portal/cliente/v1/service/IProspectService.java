package com.porto.portocom.portal.cliente.v1.service;

import com.porto.portocom.portal.cliente.entity.TipoUsuario;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;
import com.porto.portocom.portal.cliente.v1.vo.usuario.CadastroUsuarioProspect;

import reactor.core.publisher.Mono;

public interface IProspectService {

	Mono<UsuarioPortalCliente> definirProspect(String cpfCnpj);

	Mono<TipoUsuario> consultaProspect(String cpfCnpj);

	@Deprecated
	Mono<Boolean> cadastrarProspect(String cpfCnpj, CadastroUsuarioProspect usuarioProspect);
	
	Mono<TipoUsuario> recuperaTipoUsuario(String cpfCnpj);
	
	Mono<ConsultaProdutosProspect> consultaProdutosProspect(String cpfCnpj);

	TipoUsuario aplicaRegraProspect(ConsultaProdutosProspect produtos);
}
