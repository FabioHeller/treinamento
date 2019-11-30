package com.codenation.treinamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.codenation.treinamento.endpoints"))
                 .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiInfo());

    }
    public ApiInfo apiInfo(){
        return new ApiInfo(
                "Central de Erros - REST API",
                "Nossa Aplicação da codenation",
                "1.0.0 RELEASE",
                "Terms of service",
                new Contact("Fábio", "https://www.","fabioheller@gmail.com"),
                "License of API", "API LICENSE URL", Collections.emptyList());

    }
//        return new ApiInfoBuilder(
//                .title("Central de Erros - REST API")
//                .description("Nossa Aplicação da codenation")
//                .version("1.0.0 RELEASE")
//                .license("Apache  License Version 2.0")
//                .licenseUrl("https://www.apache.org/licenseLICENSE2.0")
//                .contact(new Contact("Fábio", "www.","email"));
//    }
}
