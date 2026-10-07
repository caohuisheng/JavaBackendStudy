package com.itheima;

import com.itheima.controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //获取IOC容器
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        ctx.getBean(BookController.class);
        System.out.println(ctx);
    }
}
