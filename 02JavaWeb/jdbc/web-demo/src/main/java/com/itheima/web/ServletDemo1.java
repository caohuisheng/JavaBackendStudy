package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo1")
public class ServletDemo1 implements Servlet {

    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello,world!");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("destroy...");
    }
}
