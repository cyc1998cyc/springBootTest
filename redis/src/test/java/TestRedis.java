import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Set;

/**
 * 陈宇超
 * 18:54
 */
public class TestRedis {
    JedisPool jedisPool;
    Jedis jedis;
    @BeforeTest
    public void beforeTest(){
    //    创建jedis的链接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMinIdle(5);
        config.setMaxWaitMillis(3000);
        //最大链接数
        config.setMaxTotal(50);
        jedisPool = new JedisPool(config, "127.0.0.1", 6379);
        jedis = jedisPool.getResource();
    }

    @AfterTest
    public void closeConnection(){
        jedis.close();
        jedisPool.close();
    }


    @Test
    public void testString(){
        String pv = jedis.set("pv", "0");
        String pv1 = jedis.get("pv");
        System.out.println(pv1);

        jedis.set("pv", "1000");
        jedis.incr("pv");
        System.out.println(jedis.get("pv"));
        jedis.incrBy("pv", 1000);
        System.out.println(jedis.get("pv"));
    }

    @Test
    public void testHash(){
        jedis.hset("goods", "iphone13", "1000000000");
        jedis.hset("goods", "macbookpro", "5000");
        Set<String> goods = jedis.hkeys("goods");
        String hget = jedis.hget("goods", "iphone13");
        System.out.println(hget);
        System.out.println(goods);
        jedis.hincrBy("goods", "iphone13", 999999L);
        System.out.println(jedis.hget("goods", "iphone13"));
    }

    @Test
    public void testList(){
        jedis.lpush("tel", "18551560669","18262361115");
        List<String> tel = jedis.lrange("tel", 0L, -1L);
        System.out.println(tel);
    }

    @Test
    public void testSet(){
        jedis.sadd("set", "chenyuchao");
        jedis.sadd("set", "xiasixiang");
        jedis.sadd("set", "chenyuchao");
        Long set = jedis.scard("set");
        System.out.println(set);
    }
}
