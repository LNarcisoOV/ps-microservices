package com.porto.portocom.portal.cliente.v1.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.porto.portocom.portal.cliente.v1.integration.IPortalLogService;

@Component
public class PortalServiceInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(PortalServiceInterceptor.class);

	private static final String START_TIME_ATTRIBUTE = "startTime";
	private static final String SIGLA_INTEGRACAO_LOGIN = "LOGIN";

	@Autowired
	private IPortalLogService portalLogService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();

		String logMessage = String.format("[preHandle][%s][%s][%s]%s:: Start Time=%s", request.toString(),
				request.getMethod(), request.getRequestURI(), getParameters(request),
				String.valueOf(System.currentTimeMillis()));

		LOGGER.info(logMessage);

		if (request.getAttribute(START_TIME_ATTRIBUTE) == null) {
			request.setAttribute(START_TIME_ATTRIBUTE, startTime);
		}

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

		long startTime = (Long) request.getAttribute(START_TIME_ATTRIBUTE);
		long timeTaken = (System.currentTimeMillis() - startTime);

		String logMessage = String.format("Request URL::%s:: End Time=%s", request.toString(),
				String.valueOf(System.currentTimeMillis()));

		LOGGER.info(logMessage);

		logMessage = String.format("Request URL::%s:: Time Taken=%s", request.toString(), String.valueOf(timeTaken));

		LOGGER.info(logMessage);

		logMessage = String.format("[afterCompletion][%s][exception: %s]", request.toString(), exception);

		LOGGER.info(logMessage);

		Object requestBody = request.getAttribute("requestBody");
		if (requestBody != null) {
			request.removeAttribute("requestBody");
		}

		Object responseBody = request.getAttribute("responseBody");
		if (responseBody != null) {
			request.removeAttribute("responseBody");
		}

		String error = (String) request.getAttribute("error");
		String trace = (String) request.getAttribute("trace");

		Exception exceptionTrace = null;
		if (error != null && !error.isEmpty()) {
			request.removeAttribute("error");
			request.removeAttribute("trace");
			exceptionTrace = new Exception(error);
		} else {
			exceptionTrace = exception;
		}

		portalLogService.enviaLogIntegracao(SIGLA_INTEGRACAO_LOGIN, request.getRequestURI(), null, requestBody,
				responseBody, response.getStatus(), timeTaken, timeTaken, exceptionTrace, trace);
	}

	private static String getParameters(HttpServletRequest request) {
		StringBuilder posted = new StringBuilder();
		Enumeration<?> e = request.getParameterNames();
		if (e != null) {
			posted.append("?");

			while (e.hasMoreElements()) {
				if (posted.length() > 1) {
					posted.append("&");
				}
				String curr = (String) e.nextElement();
				posted.append(curr + "=");
				if (curr.contains("password") || curr.contains("pass") || curr.contains("pwd")) {
					posted.append("*****");
				} else {
					posted.append(request.getParameter(curr));
				}
			}
		}

		String ip = request.getHeader("X-FORWARDED-FOR");
		String ipAddr;
		if (ip == null) {
			ipAddr = getRemoteAddr(request);
		} else {
			ipAddr = ip;
		}

		if (ipAddr != null && !ipAddr.isEmpty()) {
			posted.append("&_psip=" + ipAddr);
		}
		return posted.toString();
	}

	private static String getRemoteAddr(HttpServletRequest request) {
		String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
		if (ipFromHeader != null && ipFromHeader.length() > 0) {
			LOGGER.debug("ip from proxy - X-FORWARDED-FOR : {}", ipFromHeader);
			return ipFromHeader;
		}
		return request.getRemoteAddr();
	}
}
