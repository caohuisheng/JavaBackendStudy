package com.itheima.app;

import com.itheima.dao.BookDao;
import com.itheima.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AOP快速开始
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        bookDao.update();

        // 测试增强后的类在容器中是否为代理对象
        System.out.println(bookDao);
        System.out.println(bookDao.getClass());
    }
}
