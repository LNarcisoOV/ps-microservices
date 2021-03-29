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
			"managed/restart");

	private static final String DEFAULT_MESSAGE = "Aplicação Não Informada";

	@Value("${flag.header.isObrigatorio}")
	private boolean flagHeaderIsObrigatorio;

	@Autowired
	private AplicacaoLocalCacheService aplicacaoLocalCacheService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String codigoAutorizacao = req.getHeader(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor());
		String requestUrl = req.getRequestURI();
		boolean isPermitido = false;
		String aplicacao = null;
		isPermitido = EXCLUDE_URLS.stream().anyMatch(url -> requestUrl.contains(url));
		
		if (codigoAutorizacao != null && !codigoAutorizacao.isEmpty()) {
		    ExtraFieldPropagation.set(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor(), codigoAutorizacao);
			aplicacao = aplicacaoLocalCacheService.recuperaNomeAplicacao(codigoAutorizacao);
		}
		
		if (aplicacao != null && !aplicacao.isEmpty()) {
			ExtraFieldPropagation.set(HeaderAplicacaoEnum.NOME_APLICACAO.getValor(), aplicacao);
		}
		if (flagHeaderIsObrigatorio) {
			if ((aplicacao != null && !aplicacao.isEmpty()) || isPermitido) {
			    ExtraFieldPropagation.set(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor(), codigoAutorizacao);
			    ExtraFieldPropagation.set(HeaderAplicacaoEnum.NOME_APLICACAO.getValor(), aplicacao);
				MDC.put(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor(), codigoAutorizacao);
				MDC.put(HeaderAplicacaoEnum.NOME_APLICACAO.getValor(), aplicacao);
			} else {
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

}
