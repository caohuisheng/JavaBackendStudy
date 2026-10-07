package com.itheima.controller;

import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    //直接注入userService进行使用
    @Autowired
    private UserService userService;

    @RequestMapping("/show")
    public String show(){
        System.out.println("show...");
        userService.show();
        return "/index.jsp";
    }

}
