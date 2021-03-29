package com.porto.portocom.portal.cliente.v1.service;

import java.util.List;

import com.porto.portocom.portal.cliente.v1.vo.RedeSocial;
import com.porto.portocom.portal.cliente.v1.vo.SocialClienteConsulta;
import com.porto.portocom.portal.cliente.v1.vo.VinculoRedeSocial;

import reactor.core.publisher.Mono;

public interface IRedeSocialService {

	Mono<Boolean> desvinculaRedeSocial(String cpfCnpj, String socialCliente);

	Mono<RedeSocial> consultaPorIdRedeSocial(String idSocialCliente);

	Mono<Boolean> vinculaRedeSocial(String cpfCnpj, VinculoRedeSocial vinculoRedeSocial);

	Mono<List<RedeSocial>> consultaPorCpfCnpj(String cpfCnpj);

	Mono<List<RedeSocial>> consultaPorIdRedeSocialAndIdentificadorRedeSocial(SocialClienteConsulta redeSocialConsulta);

}
