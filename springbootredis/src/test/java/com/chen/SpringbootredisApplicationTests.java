package com.chen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootredisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        System.out.println(redisTemplate);
    }

    @Test
    void test01(){
        redisTemplate.opsForValue().set("a", "b");
        Object a = redisTemplate.opsForValue().get("a");
        System.out.println(a);
    }

}
