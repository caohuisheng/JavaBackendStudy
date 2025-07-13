package com.itheima.test;

import com.itheima.dao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试Bean后处理器
 */
public class Test05_BeanPostProcessorTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = ctx.getBean(UserDao.class);
        userDao.save();
    }
}
