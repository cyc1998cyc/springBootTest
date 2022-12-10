package com.chen;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Set;

@SpringBootTest
class RedisApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("123123");
    }


    @Test
    void testRedis(){
    //    创建jedis的链接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置最大空闲时间10
        jedisPoolConfig.setMaxIdle(10);
        //设置最小空闲时间
        jedisPoolConfig.setMinIdle(5);
        //设置超时时间
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
        Jedis resource = jedisPool.getResource();


        //造作string
        //resource.set("pv", "123");
        //System.out.println(resource.get("pv"));
        //
        //resource.set("pv", "1000");
        //System.out.println(resource.get("pv"));
        //
        //System.out.println(resource.incr("pv"));

        //操作hashmap
        //resource.hset("goods", "iphone13", "10000");
        //resource.hset("goods", "macbookpro", "9000");
        //
        //resource.hincrBy("goods", "macbookpro", 3000L);
        //System.out.println(resource.hget("goods", "macbookpro"));
        //
        //System.out.println(resource.keys("*"));

        //操作list
        //resource.lpush("phonenum", "18551560669","123123","12352341234");
        //System.out.println(resource.rpop("phonenum"));
        //List<String> lrange = resource.lrange("phonenum", 0L, -1L);
        //System.out.println(lrange);

        //操作set 去重
        resource.sadd("uv", "user1");
        resource.sadd("uv", "user2");
        resource.sadd("uv", "user1");
        System.out.println(resource.scard("uv")); 


    }

}
