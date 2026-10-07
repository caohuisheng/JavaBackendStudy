package com.itheima.config;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

// @Configuration
public class MyAnnotationConfigWebApplicationContext extends AnnotationConfigWebApplicationContext {
    public MyAnnotationConfigWebApplicationContext(){
        //注解核心配置类
        super.register(SpringMvcConfig.class);
    }
}
