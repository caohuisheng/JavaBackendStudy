package com.heima.jedis;

import com.heima.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-12-21
 */
public class JedisTest {

    private Jedis jedis;

    @BeforeEach
    void setUp(){
        // 1.建立连接
        // jedis = new Jedis("127.0.0.1",16379);
        jedis = JedisConnectionFactory.getJedis();
        // 2.设置密码
        // 3.选择库
        this.jedis.select(1);
    }

    @Test
    void testString(){
        // 存入数据
        String result = jedis.set("name", "林青霞");
        System.out.println("result:" + result);
        // 获取数据
        String name = jedis.get("name");
        System.out.println("name:" + name);
    }

    @Test
    void testHash(){
        // 插入hash数据
        jedis.hset("user:1","name","林青霞");
        jedis.hset("user:1","age","21");

        // 获取数据
        Map<String, String> result = jedis.hgetAll("user:1");
        System.out.println(result);
    }

    @AfterEach
    void tearDown(){
        if(jedis != null){
            jedis.close();
        }
    }

}
