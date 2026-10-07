package com.itheima.web;

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //获取输入的验证码
        String checkCode = req.getParameter("checkCode");
        //程序生成的验证码
        HttpSession session = req.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        //如果验证码错误
        if(!checkCode.equalsIgnoreCase(checkCodeGen)){
            req.setAttribute("register_msg","验证码错误");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            return;
        }

        //注册
        boolean flag = userService.register(user);

        if(flag){
            //注册成功
            req.setAttribute("register_msg","注册成功，请登录");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else{
            //注册失败
            req.setAttribute("register_msg","用户名已存在");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
