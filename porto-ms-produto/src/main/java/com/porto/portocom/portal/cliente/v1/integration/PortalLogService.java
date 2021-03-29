package com.porto.portocom.portal.cliente.v1.integration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.porto.portocom.portal.cliente.v1.exception.LogIntegracaoException;
import com.porto.portocom.portal.cliente.v1.utils.GerarLogIntegracaoUtils;
import com.porto.portocom.portal.cliente.v1.vo.log.LogIntegracao;
import com.porto.portocom.portal.cliente.v1.vo.log.LogIntegracao.LogIntegracaoBuilder;

@Service
public class PortalLogService implements IPortalLogService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PortalLogService.class);

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSSSSS");

	@Value("${integration.portallog.url}")
	private String url;

	@Value("${integration.portallog.isFile}")
	private boolean isFile;

	private GerarLogIntegracaoUtils gerarLogIntegracaoUtils;

	@Autowired
	PortalLogService(GerarLogIntegracaoUtils gerarLogIntegracaoUtils) {
		this.gerarLogIntegracaoUtils = gerarLogIntegracaoUtils;
	}

	private void enviaLogIntegracao(LogIntegracao logIntegracao) throws LogIntegracaoException {
		if (isFile) {
			gerarLogIntegracaoUtils.gerarArquivo(logIntegracao);
			LOGGER.debug("Log de integracao gerado em arquivo");
		} else {
			ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.POST,
					new HttpEntity<>(logIntegracao), String.class);

			String logMessage = String.format(
					"Log de integracao enviado para o microservico. StatusCode=[%s] Body[=%s]",
					response.getStatusCode(), response.getBody());

			LOGGER.debug(logMessage);
		}
	}

	public void enviaLogIntegracao(String siglaIntegracao, String metodo, String cpfCnpj, Object request,
			Object response, int responseCode, long connectionTime, long executionTime, Exception exception,
			String trace) {

		LogIntegracaoBuilder log = LogIntegracao.builder();
		log.codigoTransacao(MDC.get("X-B3-TraceId"));
		log.cpf(cpfCnpj);
		log.siglaIntegracao(siglaIntegracao);
		log.metodo(metodo);
		log.dataHoraChamada(LocalDateTime.now().format(formatter));
		log.tempoConexao(String.valueOf(connectionTime));
		log.tempoExecucao(String.valueOf(executionTime));
		log.responseCode(String.valueOf(responseCode));
		log.request(request);
		log.response(response);

		if (exception != null) {
			log.sucesso(false);
			log.tipoErro(exception.getMessage());

			if (!StringUtils.isEmpty(trace)) {
				log.stackTrace(trace);
			} else {
				log.stackTrace(exception);
			}
		} else {
			log.sucesso(true);
		}

		try {
			enviaLogIntegracao(log.build());
		} catch (LogIntegracaoException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

}
