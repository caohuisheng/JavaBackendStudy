package com.heima.jedis;

import com.heima.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: chs
 * Description: bigkey测试
 * CreateTime: 2024-12-26
 */
public class BigkeyTest {

    private Jedis jedis;

    @BeforeEach
    void setUp(){
        // 1.建立连接
        // jedis = new Jedis("127.0.0.1",16379);
        jedis = JedisConnectionFactory.getJedis();
        // 2.设置密码
        // 3.选择库
        this.jedis.select(0);
    }

    @Test
    void testSetBigKey(){
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 650; i++) {
            map.put("hello_" + i, "world!");
        }
        jedis.hmset("m2", map);
    }

    @Test
    void testBigHash(){
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            map.put("key_" + i, "value_" + i);
        }
        jedis.hmset("test:big:hash", map);
    }

    @Test
    void testBigString(){
        for (int i = 0; i < 100000; i++) {
            jedis.set("test:str:key_" + i, "value_" + i);
        }
    }

    @Test
    void testSmallHash(){
        int hashSize = 100;
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= 100000; i++) {
            map.put("key_" + i, "value_" + i);
            int k = i / hashSize, t = i % hashSize;
            if(t == 0){
                jedis.hset("test:small:hash_" + k, map);
                map.clear();
            }
        }
    }

    @AfterEach
    void tearDown(){
        if(jedis != null){
            jedis.close();
        }
    }
}
