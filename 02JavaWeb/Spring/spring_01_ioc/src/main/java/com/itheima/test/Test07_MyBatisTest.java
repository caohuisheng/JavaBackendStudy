package com.itheima.test;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 测试spring整合第三方框架
 */
public class Test07_MyBatisTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext3.xml");
        UserMapper userMapper = ctx.getBean(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }
}
