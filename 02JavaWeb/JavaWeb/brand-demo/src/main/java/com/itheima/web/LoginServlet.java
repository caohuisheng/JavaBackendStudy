package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import com.itheima.service.BrandService;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //获取是否记住
        String remember = req.getParameter("remember");

        //查询用户是否存在
        User user = userService.login(username,password);
        if(user != null){
            //将user存入session
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            //如果勾选了，保存数据
            if("1".equals(remember)){
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
                c_username.setMaxAge(3600*24*7);
                c_password.setMaxAge(3600*24*7);
                resp.addCookie(c_username);
                resp.addCookie(c_password);
            }

            //进入查询所有页面
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/selectAllServlet");
        }else{
            req.setAttribute("login_msg","账户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
