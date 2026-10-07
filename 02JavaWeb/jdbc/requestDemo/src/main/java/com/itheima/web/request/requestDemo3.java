package com.itheima.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/demo3")
public class requestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        //System.out.println("get...");

        Map<String, String[]> parameterMap = req.getParameterMap();
//        for(String key:parameterMap.keySet()){
//            System.out.print(key + ":");
//            String[] values = parameterMap.get(key);
//            for(String value:values){
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        }

        //获取多个参数值
        String[] hobbys = req.getParameterValues("hobby");
        for(String hobby:hobbys){
            System.out.println(hobby);
        }

        //获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        this.doGet(req,resp);
    }
}
