package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book){
        System.out.println(book);
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @GetMapping
    public Result findAll(){
        List<Book> data = bookService.findAll();
        Integer code = data != null ? Code.GET_OK:Code.GET_ERR;
        String msg = data != null ? "":"数据查询失败，请重试!";
        return new Result(code,data,msg);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable int id){

        Book data = bookService.findById(id);
        Integer code = data != null ? Code.GET_OK:Code.GET_ERR;
        String msg = data != null ? "":"数据查询失败，请重试!";
        return new Result(code,data,msg);
    }
}
