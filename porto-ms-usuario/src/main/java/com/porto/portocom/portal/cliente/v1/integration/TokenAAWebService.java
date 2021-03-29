package com.porto.portocom.portal.cliente.v1.integration;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.SiglaIntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.exception.GeraTokenAAException;
import com.porto.portocom.portal.cliente.v1.model.GeraTokenAARequest;
import com.porto.portocom.portal.cliente.v1.model.GeraTokenAAResponse;
import com.porto.portocom.portal.cliente.v1.model.ValidaTokenAARequest;
import com.porto.portocom.portal.cliente.v1.model.ValidaTokenAAResponse;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.tokenaa.BearerTokenResponse;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Service
public class TokenAAWebService implements ITokenAAWebService {


	private static final Logger LOG = LoggerFactory.getLogger(TokenAAWebService.class);


	private IPortalLogService portalLogService;

	private ParametrosLocalCacheService parametrosLocalCacheService;

	private static final  String GERA_TOKEN_AA = "geraTokenAA";
	private static final  String VALIDA_TOKEN_AA = "validaTokenAA";

	@Value("${flag.token.aa.exibetoken.log}")
	private Boolean exibeTokenAA;

	@Value("${integration.tokenaa.parametro.grant-type}")
	private String grantType;
	@Value("#{'${integration.tokenaa.parametro.client-id}'.trim()}")
	private String clientId;
	@Value("#{'${integration.tokenaa.parametro.client-secret}'.trim()}")
	private String clientSecret;

	private RestTemplate restTemplate;

	@Autowired
	public TokenAAWebService(IPortalLogService portalLogService, 
			ParametrosLocalCacheService parametrosLocalCacheService,
			RestTemplate restTemplate) {
		this.portalLogService = portalLogService;
		this.restTemplate = restTemplate;
		this.parametrosLocalCacheService = parametrosLocalCacheService;
	}


	@Override
	public Mono<GeraTokenAAResponse> geraTokenAA(String cpfCnpj, String profile) {

		long startTimeExecution = 0;
		BearerTokenResponse bearerToken = geraBearerTokenAutenticacao();
		String token = bearerToken != null && bearerToken.getAccessToken() != null ? bearerToken.getAccessToken() : "";
		String orgName = this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_ORG_NAME.getValor());

		GeraTokenAARequest geraTokenAA = new GeraTokenAARequest(cpfCnpj, orgName, profile);
		int connectTimeOut = Integer.parseInt(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_CONNECT_TIMEOUT.getValor()));
		int requestTimeOut = Integer.parseInt(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_REQUEST_TIMEOUT.getValor()));
		String urlGeraToken = this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_GERA_TOKEN_URL.getValor());

		startTimeExecution = System.currentTimeMillis();
		WebClient webClient = this.criarWebClientComConnectEReadTimeOuts(connectTimeOut, requestTimeOut);
		return Mono.just(startTimeExecution).flatMap(startTime -> {
			return webClient.post().uri(URI.create(urlGeraToken))
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
					.body(Mono.just(geraTokenAA), GeraTokenAARequest.class)
					.headers(headers -> headers.setBearerAuth(token))
					.retrieve()
					.onStatus(HttpStatus::isError, clientResponse -> {
						final Integer statusResponse  = clientResponse.statusCode().value();
						Mono<String> errorMsg = clientResponse.bodyToMono(String.class);
						return errorMsg.flatMap(error -> {
							LOG.error(error);
							long finaTimeExecution = System.currentTimeMillis() - startTime;
							portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.PORTO_MS_USUARIO.toString(),
									GERA_TOKEN_AA, cpfCnpj, geraTokenAA, clientResponse, statusResponse, startTime, finaTimeExecution,
									new Exception(error), error);
							throw new GeraTokenAAException(error, statusResponse);
						});

					})	
					.bodyToMono(GeraTokenAAResponse.class)
					.doOnSuccess((GeraTokenAAResponse response) -> {
						long finaTimeExecution = System.currentTimeMillis() - startTime;
						if (exibeTokenAA) {
							LOG.info("Token Gerado: {}", response);
						}
						portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.PORTO_MS_USUARIO.toString(),
								GERA_TOKEN_AA, cpfCnpj, geraTokenAA, response, HttpStatus.CREATED.value(), startTime, finaTimeExecution,
								null, null);
					});
		});
	}


	public Mono<ValidaTokenAAResponse> validaTokenAA(String cpfCnpj, String token, String profile) {
		long startTimeExecution = 0;

		BearerTokenResponse bearerTokenResponse = geraBearerTokenAutenticacao();
		String bearerToken = bearerTokenResponse != null && bearerTokenResponse.getAccessToken() != null ? bearerTokenResponse.getAccessToken() : "";

		String orgName = this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_ORG_NAME.getValor());

		ValidaTokenAARequest validaTokenRequest = new ValidaTokenAARequest(cpfCnpj, orgName, profile, token);
		int connectTimeOut = Integer.parseInt(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_CONNECT_TIMEOUT.getValor()));
		int requestTimeOut = Integer.parseInt(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_REQUEST_TIMEOUT.getValor()));

		String urlGeraToken = this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_VALIDA_TOKEN_URL.getValor());

		startTimeExecution = System.currentTimeMillis();
		WebClient webClient = this.criarWebClientComConnectEReadTimeOuts(connectTimeOut, requestTimeOut);
		return Mono.just(startTimeExecution).flatMap(startTime -> {
			return webClient.post().uri(URI.create(urlGeraToken))
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
					.headers(headers -> headers.setBearerAuth(bearerToken))
					.body(Mono.just(validaTokenRequest), ValidaTokenAARequest.class).retrieve()
					.onStatus(HttpStatus::isError, clientResponse -> {
						final Integer statusResponse  = clientResponse.statusCode().value();
						Mono<String> errorMsg = clientResponse.bodyToMono(String.class);
						return errorMsg.flatMap(error -> {
							LOG.error(error);
							long finaTimeExecution = System.currentTimeMillis() - startTime;
							portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.PORTO_MS_USUARIO.toString(),
									VALIDA_TOKEN_AA, cpfCnpj, validaTokenRequest, clientResponse, statusResponse, startTime, finaTimeExecution,
									new Exception(error), error);
							throw new GeraTokenAAException(error, clientResponse.statusCode().value());
						});
					})		
					.bodyToMono(ValidaTokenAAResponse.class)
					.doOnSuccess((ValidaTokenAAResponse response) -> {
						long finaTimeExecution = System.currentTimeMillis() - startTime;
						portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.PORTO_MS_USUARIO.toString(),
								VALIDA_TOKEN_AA, cpfCnpj, validaTokenRequest, response, HttpStatus.OK.value(), startTime, finaTimeExecution,
								null, null);
					});
		});
	}

	// Configuração de TimeOut
	private WebClient criarWebClientComConnectEReadTimeOuts(int connectTimeOut, long readTimeOut) {
		HttpClient httpClient = HttpClient.create().tcpConfiguration(tcpClient -> {
			tcpClient = tcpClient.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 50000);
			tcpClient = tcpClient.doOnConnected(
					conn -> conn.addHandlerLast(new ReadTimeoutHandler(50000, TimeUnit.MILLISECONDS)));
			return tcpClient;
		});
		ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient); 
		return WebClient.builder().clientConnector(connector).build();
	}


	private BearerTokenResponse geraBearerTokenAutenticacao() {
		ResponseEntity<BearerTokenResponse> response = null;

		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		Exception exception = null;
		int statusCode = 0;
		BearerTokenResponse baererResponse = null;

		String urlGeraBearerToken = this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_GERA_BEARER_TOKEN_URL.getValor());
		MultiValueMap<String, String> formData = null;
		try {

			startTimeConnection = System.currentTimeMillis();
			startTimeExecution = System.currentTimeMillis();
			Map<String, String> param = new HashMap<>();

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_FORM_URLENCODED));
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			formData = new LinkedMultiValueMap<>();
			formData.add("grant_type", grantType);
			formData.add("client_id", clientId);
			formData.add("client_secret", clientSecret);

			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(formData, headers);


			response = restTemplate.exchange(urlGeraBearerToken, HttpMethod.POST, entity,
					new ParameterizedTypeReference<BearerTokenResponse>() {
			}, param);

			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;
			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;
			
			if (response != null) {
				statusCode = response.getStatusCode().value();
				baererResponse = response.getBody();
			}

		} catch (Exception e) {
			statusCode = HttpStatus.BAD_REQUEST.value();
			exception = e;
			throw e;

		} finally {
			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.PORTO_MS_USUARIO.toString(), "geraBearerTokenAutenticacao",
					"", formData, baererResponse, statusCode, timeTakenConnection, timeTakenExecution, exception, null);
		}

		return baererResponse;

	}


}
