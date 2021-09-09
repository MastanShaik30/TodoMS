package com.todoms.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
                                   
		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.todoms.controllers"))
					.paths(PathSelectors.regex("/todos.*"))
					.build()
					.apiInfo(getApiInfo())
					.securityContexts(Arrays.asList(securityContext()))
				    .securitySchemes(Arrays.asList(apiKey()));
		}

		private ApiInfo getApiInfo() {
		    return new ApiInfo(
		            "Tod Service",
		            "Todo Service wit Swagger, Eureka registration",
		            "1.0",
		            null,
		            null,
		            "GNU General Public License",
		            null,
		            Collections.emptyList()
		    );
		}
		
		private ApiKey apiKey() { 
		    return new ApiKey("JWT", "Authorization", "header"); 
		}
		
		private SecurityContext securityContext() { 
		    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
		} 

		private List<SecurityReference> defaultAuth() { 
		    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
		    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
		    authorizationScopes[0] = authorizationScope; 
		    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
		}

}
