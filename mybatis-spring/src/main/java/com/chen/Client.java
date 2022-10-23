package com.chen;

import com.chen.entity.User;
import com.chen.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        User user = userMapper.getUser(1);
        log.info("{}",user);
    }
}
