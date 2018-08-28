package com.prmd.webservice.swagger;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
//import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

		
	public static final Contact DEFAULT_CONTACT = new Contact("pramod", "www.prmd.com", "pmdsingh50@gmail.com");
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("PRMD API Documentation", "Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
//		private static final ApiInfo  = null;
	  public static final HashSet<String> IO = new HashSet<String>(Arrays.asList("application/json","application/xml"));
		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(DEFAULT_API_INFO)
					.produces(IO)
					.consumes(IO);
		}
}
