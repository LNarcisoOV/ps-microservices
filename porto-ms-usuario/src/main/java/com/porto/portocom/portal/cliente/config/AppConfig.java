package com.porto.portocom.portal.cliente.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.porto.portocom.portal.cliente.filter.AplicacaoFilter;
import com.porto.portocom.portal.cliente.v1.interceptor.PortalServiceInterceptor;
import com.porto.portocom.portal.cliente.v1.interceptor.RestTemplateHeaderModifierInterceptor;

@ComponentScan(basePackages = "com.porto")
@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private PortalServiceInterceptor portalServiceInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(portalServiceInterceptor);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder,
			RestTemplateHeaderModifierInterceptor restTemplateInterceptor) {
		return restTemplateBuilder.additionalInterceptors(restTemplateInterceptor).build();
	}

	@Bean
	public FilterRegistrationBean<AplicacaoFilter> appFilter() {
		FilterRegistrationBean<AplicacaoFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new AplicacaoFilter());
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}
}
