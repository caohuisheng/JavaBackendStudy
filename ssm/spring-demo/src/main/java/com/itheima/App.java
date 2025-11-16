package com.itheima;

import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App{
    public static void main(String[] args) {
        //获取IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取容器中的Bean对象
//        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
//        bookDao.save();

        //BookDao bookDao = (BookDao) ctx.getBean("bookDao");
//        BookDao bookDao1 = (BookDao) ctx.getBean("bookDao");
//        System.out.println(bookDao);
//        System.out.println(bookDao1);

//        BookService bookService = (BookService) ctx.getBean("service");
//        bookService.save();
        Object orderDao = ctx.getBean("orderDao");
        System.out.println(orderDao);

    }
}
