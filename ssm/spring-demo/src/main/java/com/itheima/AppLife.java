package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.dao.OrderDao;
import com.itheima.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试bean的生命周期
 */
public class AppLife {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();

        //关闭容器
        ctx.registerShutdownHook();
        ctx.close();
    }
}
