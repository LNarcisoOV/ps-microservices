package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.TipoEnvioEnum;
import com.porto.portocom.portal.cliente.v1.vo.usuario.EnviaCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoCodigoSeguranca;

import reactor.core.publisher.Mono;

@Service
public interface ICodigoAcessoService {
	
	Mono<InformacaoCodigoSeguranca> validaCodigoAcesso(String cpfCnpj,String codigoAcesso);
	
	public Mono<EnviaCodigoSeguranca> enviaCodigoAcesso(String cpfCnpj, TipoEnvioEnum tipoEnvio);

}
