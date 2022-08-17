package com.chen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 陈宇超
 * 9:23
 */
@Configuration
public class AppConfig {

    @Bean
    public UserDao userDao(){
        return new UserDao();
    }

}
