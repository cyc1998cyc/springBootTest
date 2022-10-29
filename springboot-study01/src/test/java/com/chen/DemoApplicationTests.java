package com.chen;

import com.chen.entity.User;
import com.chen.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> all = userMapper.findAll();
        System.out.println(all);
    }

    @Test
    void test01(){
        System.out.println("chenyuchao"); 
    }



}
