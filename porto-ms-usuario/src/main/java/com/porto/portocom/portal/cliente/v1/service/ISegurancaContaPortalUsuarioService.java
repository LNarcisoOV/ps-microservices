package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.entity.SegurancaContaPortalUsuario;

import reactor.core.publisher.Mono;

@Service
public interface ISegurancaContaPortalUsuarioService {


	Mono<SegurancaContaPortalUsuario> obtemCodigoRecuperacao(Long usuarioId, Long codigo);

	/**
	 * Obtem o código de Ativação de conta do Banco de dados para o usuario do portal
	 * 
	 * @param usuarioId
	 * @param codigo
	 * @return SegurancaContaPortalUsuario
	 */
	Mono<SegurancaContaPortalUsuario> obtemCodigoAtivacao(Long usuarioId, Long codigo);


	/**
	 * Obtem o código de Acesso de conta do Banco de dados para o usuario do portal
	 * 
	 * @param usuarioId
	 * @param codigo
	 * @return SegurancaContaPortalUsuario
	 */
	Mono<SegurancaContaPortalUsuario> obtemCodigoAcesso(Long usuarioId, Long codigo);
	
	boolean verificaCodigoExpirado(SegurancaContaPortalUsuario codigo);
	


}
