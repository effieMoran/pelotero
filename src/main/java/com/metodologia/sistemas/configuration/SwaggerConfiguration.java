package com.metodologia.sistemas.configuration;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api-info")
                .apiInfo(apiInfo())
                .select()
                .apis(Predicates
                        .not(RequestHandlerSelectors
                                .basePackage("org.springframework.boot")))
                .paths(regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("REST API Pelotero Travesuras Infantiles")
                .description("REST API hecha con Spring Boot y PostgreSQL")
                .contact("Eliana Moran <eliana_474@hotmail.com>")
                .version("1.0").build();
    }
}
