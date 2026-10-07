package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.dao.OrderDao;
import com.itheima.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试bean的生命周期
 */
public class AppLifeCycle {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        BookDao bookDao = (BookDao) ctx.getBean("dao2");
        bookDao.save();

        //关闭容器(方法1：手动关闭)
        ctx.close();
        //关闭容器(方法2：注册钩子函数)
        // ctx.registerShutdownHook();
    }
}
