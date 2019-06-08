package com.words.memorization.words.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.words.memorization.words.service.repositories")
@EntityScan(basePackages = "com.words.memorization.words.service.entities")
@PropertySource(value = {"classpath:hibernate-jpa.properties", "classpath:jackson.properties"})
public class WordsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordsServiceApplication.class, args);
    }

}
