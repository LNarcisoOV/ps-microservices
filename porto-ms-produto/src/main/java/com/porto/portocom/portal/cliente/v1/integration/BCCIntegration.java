package com.porto.portocom.portal.cliente.v1.integration;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.exception.LoginBCCException;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPF;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPJ;
import com.porto.portocom.portal.cliente.v1.vo.login.SSOResponseVO;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.client.HttpClient;

@Service
public class BCCIntegration implements IBCCIntegration {

	private ParametrosLocalCacheService parametrosLocalCacheService;

	@Value("${integration.sso.host.bcc.url}")
	private String hostUrl;
	@Value("${integration.sso.resource.realizaLogin}")
	private String recursoRealizaLogin;
	@Value("${integration.sso.resource.consultaPessoa}")
	private String recursoConsultaPessoa;
	@Value("${integration.sso.parametro.grant-type}")
	private String grantType;
	@Value("#{'${integration.sso.parametro.client-id}'.trim()}")
	private String clientId;
	@Value("#{'${integration.sso.parametro.client-secret}'.trim()}")
	private String clientSecret;
	@Value("#{'${integration.sso.parametro.username}'.trim()}")
	private String username;
	@Value("#{'${integration.sso.parametro.password}'.trim()}")
	private String password;
	@Value("${integration.sso.parametro.scope}")
	private String scope;

	private static final Logger LOG = LoggerFactory.getLogger(BCCIntegration.class);

	@Autowired
	public BCCIntegration(ParametrosLocalCacheService parametrosLocalCacheService) {
		this.parametrosLocalCacheService = parametrosLocalCacheService;
	}

	@Override
	public Mono<SSOResponseVO> loginBCC() {
		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		formData.add("grant_type", grantType);
		formData.add("client_id", clientId);
		formData.add("client_secret", clientSecret);
		formData.add("username", username);
		formData.add("password", password);
		formData.add("scope", scope);
		
		WebClient webClient = this.criarWebClientComConnectEReadTimeOuts();

		return webClient.post().uri(URI.create(hostUrl + recursoRealizaLogin))
				.contentType(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_FORM_URLENCODED)
				.header("idp", "6").header("Content-Type", "application/x-www-form-urlencoded")
				.body(BodyInserters.fromFormData(formData)).retrieve().onStatus(HttpStatus::isError, clientResponse -> {
					logResponseOnError(clientResponse);
					return Mono
							.error(new LoginBCCException(clientResponse.statusCode(), "Erro ao realizar login na BCC"));
				}).bodyToMono(SSOResponseVO.class);
	}

	@Override
	public Mono<PessoaBccPF> consultaPessoaPF(String cpf, String tokenLogin) {

		WebClient webClient = this.criarWebClientComConnectEReadTimeOuts();

		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path(recursoConsultaPessoa).queryParam("numeroCpf", cpf)
						.queryParam("listasRetornadas", "telefones,enderecosEletronicos").build())
				.headers(headers -> headers.setBearerAuth(tokenLogin)).retrieve()

				.onStatus(HttpStatus::isError, clientResponse -> {
					logResponseOnError(clientResponse);
					return Mono.error(new LoginBCCException(clientResponse.statusCode(),
							"Erro ao realizar consulta pessoa física na BCC"));
				}).bodyToMono(PessoaBccPF.class);
	}

	@Override
	public Mono<PessoaBccPJ> consultaPessoaPJ(String cnpj, String tokenLogin) {

		WebClient webClient = this.criarWebClientComConnectEReadTimeOuts();

		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path(recursoConsultaPessoa).queryParam("numeroCnpj", cnpj)
						.queryParam("listasRetornadas", "telefones,enderecosEletronicos").build())
				.headers(headers -> headers.setBearerAuth(tokenLogin)).retrieve()
				.onStatus(HttpStatus::isError, clientResponse -> {
					logResponseOnError(clientResponse);
					return Mono.error(new LoginBCCException(clientResponse.statusCode(),
							"Erro ao realizar consulta pessoa jurídica na BCC"));
				}).bodyToMono(PessoaBccPJ.class);
	}

	private static void logResponseOnError(ClientResponse response) {
		LOG.error("Response status: {}", response.statusCode());
		LOG.error("Response headers: {}", response.headers().asHttpHeaders());
		response.bodyToMono(String.class).publishOn(Schedulers.elastic())
				.subscribe(body -> LOG.error("Response body: {}", body));
	}

	private WebClient criarWebClientComConnectEReadTimeOuts() {
		int connectTimeOut = Integer.parseInt(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_LOGIN_SSO_API_CONNECT_TIMEOUT.getValor()));
		int requestTimeOut = Integer.parseInt(this.parametrosLocalCacheService
				.recuperaParametro(ChavesParamEnum.PORTO_MS_LOGIN_SSO_API_CONNECT_TIMEOUT.getValor()));

		HttpClient httpClient = HttpClient.create().tcpConfiguration(tcpClient -> {
			tcpClient = tcpClient.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectTimeOut);
			tcpClient = tcpClient.doOnConnected(
					conn -> conn.addHandlerLast(new ReadTimeoutHandler(requestTimeOut, TimeUnit.MILLISECONDS)));
			return tcpClient;
		});
		ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
		return WebClient.builder().baseUrl(hostUrl).clientConnector(connector).build();
	}
}