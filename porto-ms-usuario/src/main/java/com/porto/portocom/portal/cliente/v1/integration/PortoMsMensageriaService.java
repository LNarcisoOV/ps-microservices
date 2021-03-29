package com.porto.portocom.portal.cliente.v1.integration;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.porto.portocom.portal.cliente.v1.constant.SiglaIntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.vo.mensageria.Email;
import com.porto.portocom.portal.cliente.v1.vo.mensageria.Sms;

import reactor.core.publisher.Mono;

@Service
public class PortoMsMensageriaService implements IPortoMsMensageriaService {

	private static final Logger LOG = LoggerFactory.getLogger(PortoMsMensageriaService.class);

	private RestTemplate restTemplate;

	private IPortalLogService portalLogService;
	
	@Value("#{'${integration.portomsmensageria.url}'.trim()}")
	private String url;
	@Value("${integration.portomsmensageria.url.v1.enviaEmail}")
	private String integracaoEnviaEmail;
	@Value("${integration.portomsmensageria.url.v1.enviaSms}")
	private String integracaoEnviaSms;
	
	private static final Integer BAD_REQUEST = 400;

	@Autowired
	public PortoMsMensageriaService(IPortalLogService portalLogService, RestTemplate restTemplate) {
		this.portalLogService = portalLogService;
		this.restTemplate = restTemplate;
	}

	@Override
	public Mono<Boolean> enviaEmail(String from, String to, String subject, String message, String cpfCnpj) {
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		ResponseEntity<Response<Boolean>> response = null;
		boolean enviado = false;
		Exception exception = null;
		Map<String, Object> request = new HashMap<>();
		int statusCode = 0;

		try {
			startTimeExecution = System.currentTimeMillis();

			String[] destinatarios = { to };

			Email email = new Email(from, destinatarios, subject, message);

			Map<String, Email> param = new HashMap<>();

			param.put("email", email);

			response = this.restTemplate.exchange(url + integracaoEnviaEmail, HttpMethod.POST, new HttpEntity<>(email),
					new ParameterizedTypeReference<Response<Boolean>>() {
					});

			if (response != null) {
				statusCode = response.getStatusCodeValue();

				if (response.getBody().getData() != null) {
					enviado = response.getBody().getData();
				}
			}

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;
		} catch (Exception e) {
			statusCode = BAD_REQUEST;
			exception = e;
		} finally {
			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.PORTO_MS_MENSAGERIA.toString(), "enviaEmail",
					cpfCnpj, request, enviado, statusCode, startTimeExecution, timeTakenExecution, exception, null);
		}
		return Mono.just(enviado);
	}

	@Override
	public Mono<Boolean> enviaSms(String ddd, String celular, String mensagem, String cpfCnpj) {
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		ResponseEntity<Response<Boolean>> response = null;
		boolean enviado = false;
		Exception exception = null;
		Map<String, Object> request = new HashMap<>();
		int statusCode = 0;

		try {
			startTimeExecution = System.currentTimeMillis();

			Sms sms = new Sms(ddd, celular, mensagem);

			Map<String, Sms> param = new HashMap<>();

			param.put("sms", sms);
			LOG.info("Objeto sms: {} ", sms);

			response = this.restTemplate.exchange(url + integracaoEnviaSms, HttpMethod.POST, new HttpEntity<>(sms),
					new ParameterizedTypeReference<Response<Boolean>>() {
					});

			if (response != null) {
				statusCode = response.getStatusCodeValue();

				if (response.getBody().getData() != null) {
					enviado = response.getBody().getData();
				}
			}

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;
		} catch (Exception e) {
			statusCode = BAD_REQUEST;
			exception = e;
		} finally {
			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.PORTO_MS_MENSAGERIA.toString(), "enviaSms", cpfCnpj,
					request, enviado, statusCode, 0, timeTakenExecution, exception, null);
		}
		return Mono.just(enviado);
	}
}
