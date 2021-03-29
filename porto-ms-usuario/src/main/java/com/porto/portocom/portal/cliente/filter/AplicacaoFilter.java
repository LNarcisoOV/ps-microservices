package com.porto.portocom.portal.cliente.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;
import com.porto.portocom.portal.cliente.v1.service.AplicacaoLocalCacheService;

import brave.propagation.ExtraFieldPropagation;

@Component
@Order(1)
public class AplicacaoFilter implements Filter {

	private static final List<String> EXCLUDE_URLS = Arrays.asList("swagger", "api-docs", "management",
			"/v1/managed/restart");

	private static final String DEFAULT_MESSAGE = "Aplicação Não Informada";

	@Value("${flag.header.isObrigatorio}")
	private boolean flagHeaderIsObrigatorio;

	@Value("${lexis.app.desabilitado}")
	private List<String> aplicacoesOcultasLexis;

	@Autowired
	private AplicacaoLocalCacheService aplicacaoLocalCacheService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String codigoAutorizacao = req.getHeader(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor());
		String requestUrl = req.getRequestURI();
		String aplicacao = null;

		if (StringUtils.isNotBlank(codigoAutorizacao)) {
			ExtraFieldPropagation.set(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor(), codigoAutorizacao);
			aplicacao = aplicacaoLocalCacheService.recuperaNomeAplicacao(codigoAutorizacao);
			validaAplicacoesLexisNexis(req, codigoAutorizacao);
		}

		if (StringUtils.isNotBlank(aplicacao)) {
			ExtraFieldPropagation.set(HeaderAplicacaoEnum.NOME_APLICACAO.getValor(), aplicacao);
		}

		if (flagHeaderIsObrigatorio) {
			if ((aplicacao != null && !aplicacao.isEmpty()) || isPermitido(requestUrl)) {
				MDC.put(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor(), codigoAutorizacao);
				MDC.put(HeaderAplicacaoEnum.NOME_APLICACAO.getValor(), aplicacao);
			} else {
				MDC.remove(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor());
				MDC.remove(HeaderAplicacaoEnum.NOME_APLICACAO.getValor());
				resp.sendError(HttpStatus.BAD_REQUEST.value(),
						"Header codigoAutorizacao não foi informado ou não foi encontrado.");
				return;
			}
		} else {
			ExtraFieldPropagation.set(HeaderAplicacaoEnum.NOME_APLICACAO.getValor(), DEFAULT_MESSAGE);
			MDC.put(HeaderAplicacaoEnum.NOME_APLICACAO.getValor(), DEFAULT_MESSAGE);
		}

		chain.doFilter(req, resp);

	}
	
	private boolean isPermitido(String requestUrl) {
		boolean isPermitido = false;
		isPermitido = EXCLUDE_URLS.stream().anyMatch(requestUrl::contains);
		return isPermitido;
	}

	private void validaAplicacoesLexisNexis(HttpServletRequest request, String codigoAutorizacao) {
		if (!aplicacoesOcultasLexis.contains(codigoAutorizacao)) {
			String lexisNexis = request.getHeader(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor());
			if (lexisNexis != null && !lexisNexis.isEmpty()) {
				MDC.put(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), lexisNexis);
				ExtraFieldPropagation.set(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor(), lexisNexis);
			} else {
				MDC.remove(HeaderAplicacaoEnum.HEADER_LEXIS_NEXIS_REQUEST_OBJECT.getValor());
			}
		}
	}
}
