package com.itheima;

import com.itheima.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试自动注入
 */
public class AppAutowire {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService orderService = (OrderService) ctx.getBean("orderService");
        orderService.save();
    }
}
