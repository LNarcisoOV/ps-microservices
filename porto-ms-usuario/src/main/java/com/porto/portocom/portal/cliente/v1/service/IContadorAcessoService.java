package com.porto.portocom.portal.cliente.v1.service;

import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContador;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContadorConta;

import reactor.core.publisher.Mono;

public interface IContadorAcessoService {

	Mono<Boolean> reinicia(String cpfCnpj);

	Mono<InformacaoContador> consultaContadoresTentativaAcesso(String cpfCnpj);

	Mono<InformacaoContadorConta> adicionaTentativa(String cpfCnpj);

	Mono<Boolean> permiteAcesso(Long idUsuario);

	Mono<Boolean> registrarAcessoSucesso(String cpfCnpj);

	Mono<InformacaoContadorConta> registrarAcessoFalha(String cpfCnpj);

}
