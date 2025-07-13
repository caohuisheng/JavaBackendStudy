package com.itheima.config;

import com.itheima.interceptor.MyInterceptor01;
import com.itheima.interceptor.MyInterceptor02;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        System.out.println("configureDefaultServletHandling");
        //开启DefaultServlet, 可以处理静态资源了
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor01()).addPathPatterns("/*");
        registry.addInterceptor(new MyInterceptor02()).addPathPatterns("/*");
    }
}
