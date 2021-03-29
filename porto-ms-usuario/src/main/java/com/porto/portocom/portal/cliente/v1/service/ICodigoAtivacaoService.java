package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.TipoEnvioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoFluxoEnum;
import com.porto.portocom.portal.cliente.v1.vo.usuario.EnviaCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoCodigoSeguranca;

import reactor.core.publisher.Mono;

@Service
public interface ICodigoAtivacaoService {

	Mono<InformacaoCodigoSeguranca> validaCodigoAtivacao(String cpfCnpj, String codigoAtivacao);
	
	Mono<InformacaoCodigoSeguranca> validaCodigoAtivacaoCadastroSenha(String cpfCnpj, String codigoAtivacao);

	Mono<EnviaCodigoSeguranca> enviaCodigoAtivacao(String cpfCnpj, TipoEnvioEnum tipoEnvio, TipoFluxoEnum tipoCadastro);
}
