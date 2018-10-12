package com.betahouse.serviceuser.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ImportResource;

@EnableEurekaClient
@EnableDiscoveryClient
@ImportResource(locations = {"classpath:spring/validator.xml"})
@SpringBootApplication
public class ServiceUserAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUserAppApplication.class, args);
    }
}
