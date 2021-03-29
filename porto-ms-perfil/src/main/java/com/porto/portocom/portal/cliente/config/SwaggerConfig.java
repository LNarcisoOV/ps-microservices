package com.porto.portocom.portal.cliente.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${flag.header.isObrigatorio}")
	private boolean flagHeaderIsObrigatorio;

	@Bean
	public Docket swaggerApi1() {
		ParameterBuilder aParameterBuilder = new ParameterBuilder();
		List<Parameter> aParameters = new ArrayList<>();
		if (flagHeaderIsObrigatorio) {
			aParameterBuilder.name(HeaderAplicacaoEnum.HEADER_CODIGO_AUTORIZACAO.getValor())
					.modelRef(new ModelRef("string")).parameterType("header").required(true).build();
			aParameters.add(aParameterBuilder.build());
		}
		return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true).useDefaultResponseMessages(false)
				.groupName("v1").select()
				.apis(RequestHandlerSelectors.basePackage("com.porto.portocom.portal.cliente.v1.controller")).build()
				.globalOperationParameters(aParameters)
				.apiInfo(new ApiInfoBuilder().version("1").title("API").description("Documentation API v1").build());
	}
}