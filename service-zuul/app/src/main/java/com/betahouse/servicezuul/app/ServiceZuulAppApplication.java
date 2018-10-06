package com.betahouse.servicezuul.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ImportResource;

@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@ImportResource(locations = {"classpath:spring/validator.xml"})
@SpringBootApplication
public class ServiceZuulAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulAppApplication.class, args);
    }
}
