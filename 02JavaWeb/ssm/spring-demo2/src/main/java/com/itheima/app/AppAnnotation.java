package com.itheima.app;

import com.itheima.config.JdbcConfig;
import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnnotation {

    public static void main(String[] args) {
        //加载配置类初始化容器
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        System.out.println(bookDao);

        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);


        // JdbcConfig config = ctx.getBean(JdbcConfig.class);
        // System.out.println(config);
    }
}
