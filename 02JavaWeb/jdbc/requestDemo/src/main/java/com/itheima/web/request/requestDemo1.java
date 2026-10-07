package com.itheima.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo1")
public class requestDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        //请求方法
        String method = req.getMethod();
        System.out.println(method);

        //虚拟目录（项目访问路径）
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        //url：统一资源定位符
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());

        //统一资源限定符
        String uri = req.getRequestURI();
        System.out.println(uri);

        //请求参数
        String query = req.getQueryString();
        System.out.println(query);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
