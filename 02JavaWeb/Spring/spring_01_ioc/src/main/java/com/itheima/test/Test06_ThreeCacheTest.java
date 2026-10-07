package com.itheima.test;

import com.itheima.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试spring三级缓存
 */
public class Test06_ThreeCacheTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userService = ctx.getBean(UserService.class);
    }
}
