package com.itheima.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized...");
        //获取ServletContext
        ServletContext servletContext = sce.getServletContext();
        String contextConfiguration = servletContext.getInitParameter("contextConfiguration").substring("classpath:".length());
        //创建spring容器
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfiguration);
        //将容器保存到到ServletContext中
        sce.getServletContext().setAttribute("applicationContext",app);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
