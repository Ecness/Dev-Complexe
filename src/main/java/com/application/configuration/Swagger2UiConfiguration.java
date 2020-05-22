package com.application.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration {
	@Bean
	public Docket wsTest() {
		return new Docket( DocumentationType.SWAGGER_2 )
				.groupName( "WS-CSSR-api-1.0" )
				.select()
				.apis( RequestHandlerSelectors.basePackage( "com.application.controller" ) )
				.paths( PathSelectors.regex( "/v1.*" ) ).build().apiInfo( new ApiInfoBuilder()
				.version( this.getClass().getPackage().getImplementationVersion()  )
				.title( "WS test" )
				.description( "Service de test" ).build() )
				.securitySchemes(Collections.singletonList(apiKey()))
				.useDefaultResponseMessages( false );
    }
	private ApiKey apiKey() {
	    return new ApiKey("Authorization", "Authorization", "header");
	}
 
}