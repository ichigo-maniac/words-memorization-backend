package com.words.memorization.words.management.facade;

import com.words.memorization.words.common.GeneralConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.words.memorization.connector")
@PropertySource(value = {"classpath:jackson.properties"})
@ComponentScan(basePackageClasses = {WordsManagementFacadeApplication.class, GeneralConfiguration.class})
public class WordsManagementFacadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordsManagementFacadeApplication.class, args);
    }

}
