package com.itheima.app;

import com.itheima.service.ResourceService;
import com.itheima.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppBaidu {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        ResourceService service = ctx.getBean(ResourceService.class);
        boolean flag = service.openUrl("https://www.baidu.com","root  ");
        System.out.println(flag);
    }
}
