package com.itheima.web.response;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resp1")
public class responseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("resp1...");
        //重定向
        resp.setStatus(302);
        resp.setHeader("Location","/requestDemo/resp2");
        //简化
        //resp.sendRedirect("/requestDemo/resp2");
        //动态获取虚拟目录
        String context = req.getContextPath();
        resp.sendRedirect(context+"/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
