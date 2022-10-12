package com.chen.config;

import com.chen.Address;
import com.chen.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class MyConfiguration {

    @Bean
    @Qualifier("addr")
    public Address address(){
        return new Address();
    }

    @Bean
    public User user(@Qualifier("addr") Address address){
        User user = new User();
        user.setAddress(address);
        return user;

    }
}
