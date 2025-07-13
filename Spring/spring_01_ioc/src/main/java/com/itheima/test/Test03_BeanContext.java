package com.itheima.test;

import com.itheima.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: chs
 * Description: 测试bean的创建
 * CreateTime: 2025-07-13
 */
public class Test03_BeanContext {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao)applicationContext.getBean("userDao");
        UserDao userDao2 = (UserDao)applicationContext.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
    }
}
