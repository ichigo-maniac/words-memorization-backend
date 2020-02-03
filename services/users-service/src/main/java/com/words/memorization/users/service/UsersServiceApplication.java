package com.words.memorization.users.service;

import com.words.memorization.words.common.GeneralConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaClient
@PropertySource(value = {"classpath:hibernate-jpa.properties", "classpath:jackson.properties"})
@ComponentScan(basePackageClasses = {UsersServiceApplication.class, GeneralConfiguration.class})
public class UsersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersServiceApplication.class, args);
    }
}
