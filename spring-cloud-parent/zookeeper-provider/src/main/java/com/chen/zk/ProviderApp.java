package com.chen.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 陈宇超
 * 19:06
 */
@SpringBootApplication
@EnableDiscoveryClient//开启发现客户端
public class ProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class, args);

    }
}
