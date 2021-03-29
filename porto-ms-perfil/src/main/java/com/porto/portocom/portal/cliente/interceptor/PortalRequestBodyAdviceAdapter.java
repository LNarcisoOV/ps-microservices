package com.porto.portocom.portal.cliente.interceptor;

import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

@ControllerAdvice
public class PortalRequestBodyAdviceAdapter extends RequestBodyAdviceAdapter {

	@Autowired
	private HttpServletRequest httpServletRequest;

	@Override
	public boolean supports(MethodParameter methodParameter, Type type,
			Class<? extends HttpMessageConverter<?>> aClass) {
		return true;
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {

		httpServletRequest.setAttribute("requestBody", body);

		return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
	}
}
