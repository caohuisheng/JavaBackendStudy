package com.itheima.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NamespaceTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ctx.getBean();
    }
}
