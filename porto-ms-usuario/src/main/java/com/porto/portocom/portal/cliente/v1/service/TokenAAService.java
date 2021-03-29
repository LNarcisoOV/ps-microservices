package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.integration.ITokenAAWebService;
import com.porto.portocom.portal.cliente.v1.model.PinVO;
import com.porto.portocom.portal.cliente.v1.model.ValidaTokenAAResponse;

import reactor.core.publisher.Mono;

@Service
public class TokenAAService implements ITokenAAService {

	private ParametrosLocalCacheService parametrosLocalCacheService;

	private ITokenAAWebService tokenAAWS;

	public TokenAAService(ParametrosLocalCacheService parametrosLocalCacheService,
			ITokenAAWebService tokenAAWS) {
		this.parametrosLocalCacheService = parametrosLocalCacheService;
		this.tokenAAWS = tokenAAWS;
	}

	@Override
	public Mono<PinVO> geraPinServico(String cpfCnpj) {
		String profile = parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_SERVICE_PROFILE_NAME.getValor());
		return tokenAAWS.geraTokenAA(cpfCnpj, profile).map(geraPinResponse ->  new PinVO(geraPinResponse.getValidityStartTime(),
				geraPinResponse.getValidityEndTime(),
				geraPinResponse.getOtp()));

	}

	@Override
	public Mono<PinVO> geraPinCliente(String cpfCnpj) {
		String profile = parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_CLIENT_PROFILE_NAME.getValor());
		return tokenAAWS.geraTokenAA(cpfCnpj, profile).map(geraPinResponse ->  new PinVO(geraPinResponse.getValidityStartTime(), 
				geraPinResponse.getValidityEndTime(),
				geraPinResponse.getOtp()));

	}

	@Override
	public Mono<ValidaTokenAAResponse> validaTokenServico(String cpfCnpj, String token) {
		String profile = parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_SERVICE_PROFILE_NAME.getValor());
		return tokenAAWS.validaTokenAA(cpfCnpj, token, profile);
	}

	@Override
	public Mono<ValidaTokenAAResponse> validaTokenCliente(String cpfCnpj, String token) {
		String profile = parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_CLIENT_PROFILE_NAME.getValor());
		return tokenAAWS.validaTokenAA(cpfCnpj, token, profile);
	}

}
