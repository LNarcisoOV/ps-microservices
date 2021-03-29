package com.porto.portocom.portal.cliente.v1.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SuaClasseUtils {

	private static final Logger LOG = LoggerFactory.getLogger(SuaClasseUtils.class);

	public void gerarArquivo(Object logIntegracaoDTO) throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		try {
			String logJson = mapper.writeValueAsString(logIntegracaoDTO);

			String logInfo = "Recebendo dados Log Integração:" + logJson;
			LOG.info(logInfo);

		} catch (IOException e) {
			String mensagemErroLog = "Erro ao criar o log de integracao:" + e.getMessage();
			LOG.error(mensagemErroLog);
			throw new Exception(mensagemErroLog, e);
		}

	}

}
