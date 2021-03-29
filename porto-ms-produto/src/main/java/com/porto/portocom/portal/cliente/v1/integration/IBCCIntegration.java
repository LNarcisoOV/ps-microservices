package com.porto.portocom.portal.cliente.v1.integration;

import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPF;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPJ;
import com.porto.portocom.portal.cliente.v1.vo.login.SSOResponseVO;

import reactor.core.publisher.Mono;

public interface IBCCIntegration {

	public Mono<SSOResponseVO> loginBCC();
	
	public Mono<PessoaBccPF> consultaPessoaPF(String cpf, String token);

	public Mono<PessoaBccPJ> consultaPessoaPJ(String cnpj, String tokenLogin);

}
