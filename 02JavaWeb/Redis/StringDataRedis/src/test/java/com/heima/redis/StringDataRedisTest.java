package com.heima.redis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.heima.redis.pojo.Student;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-12-21
 */
@SpringBootTest
public class StringDataRedisTest {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testString(){
        redisTemplate.opsForValue().set("name","林更新");
        Object result = redisTemplate.opsForValue().get("name");
        System.out.println("result:" + result);
    }

    @Test
    void testObject1(){
        Student student = new Student("霍建华", 35);
        redisTemplate.opsForValue().set("student:1",student);
    }

    @Test
    void testObject2() throws JsonProcessingException {
        // 创建JSON序列化工具
        ObjectMapper objectMapper = new ObjectMapper();
        // 保存数据
        Student student = new Student("霍建华", 35);
        String jsonStr = objectMapper.writeValueAsString(student);
        stringRedisTemplate.opsForValue().set("student:1",jsonStr);

        // 获取数据
        String jsonResult = stringRedisTemplate.opsForValue().get("student:1");
        Student result = objectMapper.readValue(jsonResult, Student.class);
        System.out.println("result:" + result);
    }

}
