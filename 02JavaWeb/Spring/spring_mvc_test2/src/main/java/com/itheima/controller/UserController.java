package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

    @PostMapping("/show2")
    public String show2(@RequestBody String body) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.readValue(body, User.class);
        return "/index.jsp";
    }

    @GetMapping("/exp1")
    public String exception1(){
        int i = 1/0;
        return "Hello,Exception!";
    }

    @GetMapping("/exp2")
    public String exception2() throws FileNotFoundException {
        // File file = new File("aaa/b.txt");
        FileInputStream fis = new FileInputStream("aaa/b.txt");
        return "Hello,Exception!";
    }
}
