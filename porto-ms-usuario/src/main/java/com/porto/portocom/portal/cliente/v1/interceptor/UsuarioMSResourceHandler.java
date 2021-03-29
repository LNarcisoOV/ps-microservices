package com.porto.portocom.portal.cliente.v1.interceptor;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.ContadorAcessoException;
import com.porto.portocom.portal.cliente.v1.exception.GeraTokenAAException;
import com.porto.portocom.portal.cliente.v1.exception.IntegracaoKbaException;
import com.porto.portocom.portal.cliente.v1.exception.ValidacaoPinException;
import com.porto.portocom.portal.cliente.v1.handler.ResourceHandler;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.MensagemLocalCacheService;
import com.porto.portocom.portal.cliente.v1.vo.antifraude.LexisNexisResponse;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContadorConta;

@ControllerAdvice
public class UsuarioMSResourceHandler extends ResourceHandler {

	@Autowired
	private MensagemLocalCacheService mensagemLocalCacheService;

	@ExceptionHandler(ContadorAcessoException.class)
	public ResponseEntity<Response<InformacaoContadorConta>> handlerContadorAcessoException(ContadorAcessoException r) {
		Response<InformacaoContadorConta> response = new Response<>();
		response.setStatus(r.getStatusCode());
		response.setErrors(Arrays.asList(r.getMessage()));
		if (r.getInfContador() != null) {
			InformacaoContadorConta infConta = r.getInfContador();
			response.setData(infConta);
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ExceptionHandler(CodigoSegurancaException.class)
	public ResponseEntity<Response<InformacaoCodigoSeguranca>> handlerCodigoSegurancaException(
			CodigoSegurancaException r) {
		Response<InformacaoCodigoSeguranca> response = new Response<>();
		response.setStatus(r.getStatusCode());
		response.setErrors(Arrays.asList(r.getMessage()));
		if (r.getInfContador() != null) {
			InformacaoContadorConta infConta = r.getInfContador();
			InformacaoCodigoSeguranca codigoSeguranca = new InformacaoCodigoSeguranca(null, null, infConta);
			response.setData(codigoSeguranca);
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ExceptionHandler(GeraTokenAAException.class)
	public ResponseEntity<LexisNexisResponse> handlerGeraTokenAAException(GeraTokenAAException r) {
		LexisNexisResponse response = new LexisNexisResponse();
		response.setStatus(r.getStatusCode());
		if (r.getStatusCode() == HttpStatus.NOT_FOUND.value()) {
			response.setErrors(Arrays.asList(this.mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor())));
		} else {
			response.setErrors(Arrays.asList(r.getMessage()));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ExceptionHandler(IntegracaoKbaException.class)
	public ResponseEntity<LexisNexisResponse> handlerIntegracaoKbaException(IntegracaoKbaException r) {
		LexisNexisResponse response = new LexisNexisResponse();
		response.setStatus(r.getStatusCode());
		response.setErrors(Arrays.asList(r.getMessage()));
		if (r.getStatusCode() == HttpStatus.BAD_REQUEST.value()) {
			response.setErrors(Arrays.asList(this.mensagemLocalCacheService.recuperaTextoMensagem(
					MensagemChaveEnum.USUARIO_ERRO_INTEGRACAO_KBA_INSTAVEL.getValor())));
		} else {
			response.setErrors(Arrays.asList(r.getMessage()));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ExceptionHandler(ValidacaoPinException.class)
	public ResponseEntity<LexisNexisResponse> handlerIntegracaoKbaException(ValidacaoPinException r) {
		LexisNexisResponse response = new LexisNexisResponse();
		response.setStatus(r.getStatusCode());
		response.setErrors(Arrays.asList(r.getMessage()));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
