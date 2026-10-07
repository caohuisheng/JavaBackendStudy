package com.example.controller;

import com.example.controller.utils.R;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
异常处理器
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    public R doException(Exception e){
        //发送消息给开发人员
        e.printStackTrace();
        return new R(false,null,"系统异常，请稍后重试！");
    }
}
