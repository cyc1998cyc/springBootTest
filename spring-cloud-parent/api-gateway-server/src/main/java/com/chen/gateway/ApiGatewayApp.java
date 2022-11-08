package com.chen.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 陈宇超
 * 15:10
 */
@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApp.class,args);
    }

}
