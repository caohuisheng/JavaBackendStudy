package com.itheima.config;

import com.itheima.controller.intercepter.ProjectIntercepter;
import com.itheima.controller.intercepter.ProjectIntercepter2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
//设置静态资源访问过滤，需设置为配置类，被springmvc扫描
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    private ProjectIntercepter projectIntercepter;

    @Autowired
    private ProjectIntercepter2 projectIntercepter2;

    //设置静态资源访问过滤
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //当访问/css/**时从/css资源目录下查找
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
//        super.addResourceHandlers(registry);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectIntercepter).addPathPatterns("/books","/books/*");
        registry.addInterceptor(projectIntercepter2).addPathPatterns("/books","/books/*");
    }
}
