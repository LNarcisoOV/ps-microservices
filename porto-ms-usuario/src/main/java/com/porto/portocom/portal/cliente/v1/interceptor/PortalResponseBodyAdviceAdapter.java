package com.porto.portocom.portal.cliente.v1.interceptor;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class PortalResponseBodyAdviceAdapter implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
			Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
			ServerHttpResponse serverHttpResponse) {

		if (serverHttpRequest instanceof ServletServerHttpRequest
				&& serverHttpResponse instanceof ServletServerHttpResponse) {

			HttpServletRequest request = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();

			if (o instanceof LinkedHashMap<?, ?>) {
				String error = getLinkedHashMap(o).get("error");
				if (error != null) {
					request.setAttribute("error", error);

					String trace = getLinkedHashMap(o).get("trace");
					request.setAttribute("trace", trace);
				}
			}

			request.setAttribute("responseBody", o);
		}

		return o;
	}

	private static LinkedHashMap<String, String> getLinkedHashMap(Object o) {
		return (LinkedHashMap<String, String>) o;
	}
}
