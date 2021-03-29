package com.porto.portocom.portal.cliente.v1.interceptor;

import java.io.IOException;

import org.slf4j.MDC;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;

@Component
public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {
 
    @Override
    public ClientHttpResponse intercept(
      HttpRequest request, 
      byte[] body, 
      ClientHttpRequestExecution execution) throws IOException {
    	String codigoAutorizacao = MDC.get(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor());
    	request.getHeaders().set(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor(), codigoAutorizacao);
    	return execution.execute(request, body);
    }

}
