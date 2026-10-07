package com.itheima.exp;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //返回json字符串 {"code:":404,"msg":"error","data":""}
        String json = "{\"code:\":404,\"msg\":\"error\",\"data\":\"\"}";
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
