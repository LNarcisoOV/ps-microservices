package com.porto.portocom.portal.cliente.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.porto.portocom.portal.cliente.v1.interceptor.PortalServiceInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private PortalServiceInterceptor portalServiceInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(portalServiceInterceptor);
	}
}
