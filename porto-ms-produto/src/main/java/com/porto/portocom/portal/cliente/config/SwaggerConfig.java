package com.porto.portocom.portal.cliente.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swaggerApi1() {
		return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true).useDefaultResponseMessages(false)
				.groupName("v1").select()
				.apis(RequestHandlerSelectors.basePackage("com.porto.portocom.portal.cliente.v1.controller")).build()
				.apiInfo(new ApiInfoBuilder().version("1").title("API").description("Documentation API v1").build());
	}
}
