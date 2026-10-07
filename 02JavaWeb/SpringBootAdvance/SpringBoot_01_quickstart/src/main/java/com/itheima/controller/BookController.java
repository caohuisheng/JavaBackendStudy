package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    Environment env; //所有配置信息

    @GetMapping
    public String save(){
        env.getProperty("");
        System.out.println("springboot running...");
        return "springboot running...";
    }
}
