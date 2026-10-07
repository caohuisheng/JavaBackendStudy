package com.example.controller;

import com.example.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    /*@Value("${lesson}")
    private String lesson;
    @Value("${server.port}")
    private int port;
    @Value("${enterprise.subject[0]}")
    private String enterprise_0;*/

//    @Autowired
//    private Enterprise enterprise;

    @GetMapping("/{id}")
    public String findById(@PathVariable int id){
//        System.out.println("id:" + id);
//        System.out.println(enterprise.getName());
//        System.out.println(enterprise.getAge());
//        System.out.println(enterprise.getTel());
//        System.out.println(enterprise.getSubject());
        return "hello,spring boot";
    }
}
