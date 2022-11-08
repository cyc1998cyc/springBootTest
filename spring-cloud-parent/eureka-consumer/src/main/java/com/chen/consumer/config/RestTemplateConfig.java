package com.chen.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 陈宇超
 * 1:42
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced //进化成 ribbon的客户端
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
