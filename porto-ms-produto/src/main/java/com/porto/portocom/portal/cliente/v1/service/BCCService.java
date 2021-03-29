package com.porto.portocom.portal.cliente.v1.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.integration.IBCCIntegration;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPF;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPJ;
import com.porto.portocom.portal.cliente.v1.vo.login.SSOResponseVO;

import lombok.Data;
import reactor.core.publisher.Mono;

@Service
@Data
public class BCCService implements IBCCService {

	private IBCCIntegration bccIntegration;

	private LocalDateTime dataRequisicao;
	private SSOResponseVO loginResponse;

	@Autowired
	public BCCService(IBCCIntegration bccIntegration) {
		this.bccIntegration = bccIntegration;
	}

	@Override
	public Mono<SSOResponseVO> realizarLoginBCC() {
		if (Boolean.TRUE.equals(verificaAccesTokenExpiradoOuInexistente())) {
			return this.bccIntegration.loginBCC().flatMap(bccLoginResponse -> {
				this.setDataRequisicao(LocalDateTime.now());
				this.setLoginResponse(bccLoginResponse);
				return Mono.just(bccLoginResponse);
			}).onErrorResume(error -> Mono.error(error));

		} else {
			return Mono.just(getLoginResponse());
		}
	}

	@Override
	public Mono<PessoaBccPF> consultaPFBCC(final String cpf) {
		return this.realizarLoginBCC().flatMap(ssoLoginResponseVO -> {
			return this.bccIntegration.consultaPessoaPF(cpf, ssoLoginResponseVO.getAccessToken())
					.flatMap(pessoaBccResponse -> {
						PessoaBccPF pessoaBccPfVazio = new PessoaBccPF();
						pessoaBccPfVazio.setPessoas(new ArrayList<PessoaBccPF.Pessoa>());
						return Mono.just(pessoaBccResponse.getPessoas() != null ? pessoaBccResponse : pessoaBccPfVazio);
					});
		}).onErrorResume(error -> Mono.error(error));

	}

	@Override
	public Mono<PessoaBccPJ> consultaPJBCC(final String cnpj) {
		return this.realizarLoginBCC().flatMap(ssoLoginResponseVO -> {
			return this.bccIntegration.consultaPessoaPJ(cnpj, ssoLoginResponseVO.getAccessToken())
					.flatMap(pessoaBccResponse -> {
						PessoaBccPJ pessoaBccPjVazio = new PessoaBccPJ();
						pessoaBccPjVazio.setPessoas(new ArrayList<PessoaBccPJ.Pessoa>());
						return Mono.just(pessoaBccResponse.getPessoas() != null ? pessoaBccResponse : pessoaBccPjVazio);
					});
		}).onErrorResume(error -> Mono.error(error));

	}

	private Boolean verificaAccesTokenExpiradoOuInexistente() {
		if (this.getLoginResponse() != null) {
			LocalDateTime dataIncrementada = this.getDataRequisicao()
					.plusSeconds(this.getLoginResponse().getExpiresIn());
			LocalDateTime dataAtual = LocalDateTime.now();
			return dataAtual.isAfter(dataIncrementada);
		}
		return Boolean.TRUE;
	}
}
