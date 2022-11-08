package com.chen.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 陈宇超
 * 14:06
 */
@SpringBootApplication
@EnableEurekaServer//这是一个eureka服务
public class EurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class, args);
    }
}
