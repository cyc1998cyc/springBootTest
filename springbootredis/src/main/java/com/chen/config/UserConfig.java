package com.chen.config;

import com.chen.condition.ClassCondition;
import com.chen.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 陈宇超
 * 19:58
 */
@Configuration
public class UserConfig {
    @Bean
    @Conditional(ClassCondition.class)
    public User user(){
        return new User();
    }
}
