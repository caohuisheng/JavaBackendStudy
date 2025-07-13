package com.itheima.init;

import com.itheima.config.ApplicationContextConfig;
import com.itheima.config.SpringMvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //返回带有@Configuration注解的类用来配置ContextLoaderListener
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("getRootConfigClasses...");
        return new Class[]{ApplicationContextConfig.class};
    }

    //返回带有@Configuration注解的类用来配置DispatcherServlet
    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("getServletConfigClasses...");
        return new Class[]{SpringMvcConfig.class};
    }

    //将一个或多个路径映射到DispatcherServlet
    @Override
    protected String[] getServletMappings() {
        System.out.println("getServletMappings...");
        return new String[]{"/"};
    }
}
