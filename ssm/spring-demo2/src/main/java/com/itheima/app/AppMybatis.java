package com.itheima.app;

import com.itheima.config.SpringConfig;
import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMybatis {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService service = ctx.getBean(AccountService.class);

//        service.save(account);

        //System.out.println(service);
        //System.out.println(service.findById(1));
        System.out.println(service.findById(1));

    }
}
