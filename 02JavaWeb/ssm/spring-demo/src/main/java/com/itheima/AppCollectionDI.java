package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试集合注入
 */
public class AppCollectionDI {
    public static void main(String[] args) {
        //获取IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext5.xml");

        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
    }
}
