package com.heima.jedis;

import com.heima.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * Author: chs
 * Description: 批处理测试
 * CreateTime: 2024-12-26
 */
public class BatchTest {

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
    void testMxx(){
        // 批次大小
        int batchSize = 1000;
        // 保存每个批次的key和value
        String[] arr = new String[batchSize * 2];
        long start = System.currentTimeMillis();
        // 批量添加数据到redis
        for (int i = 1; i <= 100000; i++) {
            int j = ((i-1) % batchSize) << 1;
            arr[j] = "test:key_" + i;
            arr[j+1] = "value_" + i;
            if(j == (batchSize-1) * 2){
                jedis.mset(arr);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("costTime:" + (end - start));
    }

    @Test
    void testPipeline(){
        // 创建管道
        Pipeline pipeline = jedis.pipelined();
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            // 添加命令到管道
            pipeline.set("test1:key_" + i, "value_" + i);
            if(i % 1000 == 0){
                // 每放入1000条命令，批量执行
                pipeline.sync();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("costTime:" + (end - start));
    }

    @AfterEach
    void tearDown(){
        if(jedis != null){
            jedis.close();
        }
    }

}
