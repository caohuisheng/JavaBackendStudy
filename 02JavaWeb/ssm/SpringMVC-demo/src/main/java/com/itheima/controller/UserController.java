package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
//@ResponseBody
//@RestController
//@RequestMapping("/user")
@RequestMapping("/user")
public class UserController {


//    @RequestMapping("/save")
//    @ResponseBody
//    public String save(){
//        System.out.println("user save...");
//        return "{'module':'user save'}";
//    }
//
//    @RequestMapping("/delete")
//    @ResponseBody
//    public String delete(){
//        System.out.println("user delete...");
//        return "{'module':'user delete'}";
//    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String save(User user) {
        System.out.println("save"+user);
        return "{'module':'save'}";
    }

    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public String update(User user){
        System.out.println("save"+user);
        return "{'module':'save'}";
    }

    //@RequestMapping(method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String delete(int id){
        System.out.println("save"+id);
        return "{'module':'save'}";
    }

    //@RequestMapping(value="/{id}",method = RequestMethod.GET)
    @GetMapping
    public String findById(int id){
        System.out.println("findById"+id);
        return "{'module':'save'}";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(){
        System.out.println("save");
        return "{'module':'save'}";
    }

    @RequestMapping("/commonParam")
    public String commonParam(@RequestParam("name") String userName, int age){
        System.out.println("name:" + userName);
        System.out.println("age:" + age);
        return "{'module':'commonParam'}";
    }

    @RequestMapping("/listParam")
    public String commonParam(@RequestParam List<String> likes){
        System.out.println("name:" + likes);
        return "{'module':'listParam'}";
    }

    @RequestMapping("/listParamForJson")
    public String listParamForJson(@RequestBody List<String> likes){
        System.out.println("name:" + likes);
        return "{'module':'listParam'}";
    }

    @RequestMapping("/dateParam")
    public String dateParam(Date date,@DateTimeFormat(pattern = "yyyy-MM-dd") Date date1){
        System.out.println("date:" + date);
        return "{'module':'listParam'}";
    }

    @RequestMapping("/jumpPage")
    public String jumpPage(){
        System.out.println("jumpPage");
        return "index.jsp";
    }
}
