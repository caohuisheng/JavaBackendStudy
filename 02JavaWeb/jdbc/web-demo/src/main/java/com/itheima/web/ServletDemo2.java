package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2",loadOnStartup = 1)
public class ServletDemo2 implements Servlet {

    private ServletConfig config;

    /*
    初始化
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = config;
        System.out.println("init...");
    }

    /*
    返回ServletConfig信息
     */
    public ServletConfig getServletConfig() {
        return config;
    }

    /*
    提供服务
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello,world!");
    }

    /*
    返回Servlet信息
     */
    public String getServletInfo() {
        return null;
    }

    /*
    销毁服务
     */
    public void destroy() {
        System.out.println("destroy...");
    }
}
