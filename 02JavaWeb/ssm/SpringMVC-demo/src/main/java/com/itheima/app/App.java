package com.itheima.app;

import com.itheima.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        SpringConfig bean = ctx.getBean(SpringConfig.class);
        System.out.println(bean);
    }
}
