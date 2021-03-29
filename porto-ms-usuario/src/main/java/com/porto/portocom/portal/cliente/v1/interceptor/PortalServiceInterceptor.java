package com.porto.portocom.portal.cliente.v1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.porto.portocom.portal.cliente.v1.constant.SiglaIntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.integration.IPortalLogService;
import com.porto.portocom.portal.cliente.v1.vo.NovoUsuarioESenhaVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.CadastroSenha;

@Component
public class PortalServiceInterceptor implements HandlerInterceptor {

	private static final String START_TIME_ATTRIBUTE = "startTime";

	@Autowired
	private IPortalLogService portalLogService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();

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

		Object requestBody = request.getAttribute("requestBody");
		if (requestBody != null) {
			request.removeAttribute("requestBody");
		}
		
		if(requestBody instanceof CadastroSenha) {
			((CadastroSenha) requestBody).setSenha("*****");
		}
		
		if(requestBody instanceof NovoUsuarioESenhaVO) {
			((NovoUsuarioESenhaVO) requestBody).setNovaSenha("*****");
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

		portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.PORTO_MS_USUARIO.toString(), request.getRequestURI(),
				null, requestBody, responseBody, response.getStatus(), 0, timeTaken, exceptionTrace, trace);
	}
}
