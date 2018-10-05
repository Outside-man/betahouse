package com.betahouse.servicezuul;

import com.betahouse.servicezuul.core.shiro.AccessTokenSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ImportResource;

@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@ImportResource(locations = {"spring/*.xml"})
public class ServiceZuulApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessTokenSessionManager.class);

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
        LOGGER.error("aaaaa");
        LOGGER.info("bbbbbb");

    }
}
