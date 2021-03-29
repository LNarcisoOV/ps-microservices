package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPF;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPJ;
import com.porto.portocom.portal.cliente.v1.vo.login.SSOResponseVO;

import reactor.core.publisher.Mono;

@Service
public interface IBCCService {

	public Mono<SSOResponseVO> realizarLoginBCC();
	
	public Mono<PessoaBccPF> consultaPFBCC(final String cpf);
	
	public Mono<PessoaBccPJ> consultaPJBCC(final String cnpj);

}
