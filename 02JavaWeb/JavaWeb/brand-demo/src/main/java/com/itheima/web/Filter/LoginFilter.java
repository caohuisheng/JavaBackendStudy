package com.itheima.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/*")
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //判断访问资源路径是否与登陆注册有关
        String[] urls = {"/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};
        //String uri = req.getRequestURI();
        //System.out.println(uri);
        String url = req.getRequestURL().toString();
        for(String u:urls){
            if(url.contains(u)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }

        //获取session和user数据
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        if(user != null){
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            req.setAttribute("register_msg","您尚未登陆！");
            req.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
