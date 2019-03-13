package com.words.memorization.words.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;

@Configuration
@EnableSwagger2
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfigiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .directModelSubstitute(Calendar.class, String.class)
            .apiInfo(new ApiInfo(
                "Words memorization. Words service API",
                "Words memorization. Words service API",
                "1.0",
                null,
                null,
                null,
                null,
                Collections.emptyList()
            ))
            .protocols(new HashSet<>(Arrays.asList("http", "https")))
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.ant("/api/**"))
            .build();
    }
}
