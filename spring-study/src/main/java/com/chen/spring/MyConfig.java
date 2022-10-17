package com.chen.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class MyConfig {
    @Value("${bathPath}")
    private String basePath;

    @Override
    public String toString() {
        return "MyConfig{" +
                "basePath='" + basePath + '\'' +
                '}';
    }
}
