package com.itheima.web;

import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/accountServlet")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取ApplicationContext
        ServletContext servletContext = req.getServletContext();
        // ApplicationContext app = (ApplicationContext) servletContext.getAttribute("applicationContext");
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        AccountService accountService = app.getBean(AccountService.class);
        accountService.transferMoney("zs","ls",2000);
    }
}
