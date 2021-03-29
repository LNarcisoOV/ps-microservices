package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.v1.constant.TipoEnvioEnum;
import com.porto.portocom.portal.cliente.v1.vo.usuario.EnviaCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoCodigoSeguranca;

import reactor.core.publisher.Mono;

@Service
public interface ICodigoRecuperacaoService {
	
	Mono<EnviaCodigoSeguranca> enviaCodigo(String cpfCnpj, TipoEnvioEnum tipoEnvio);
	
	Mono<InformacaoCodigoSeguranca> validaCodigo(String cpfCnpj, String codigoRecuperacao);
	
	Mono<InformacaoCodigoSeguranca> validaCodigo(String codigoRecuperacao, UsuarioPortalCliente usuario);
}
