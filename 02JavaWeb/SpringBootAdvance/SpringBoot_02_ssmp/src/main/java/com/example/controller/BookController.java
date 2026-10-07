package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.utils.R;
import com.example.domain.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public R getAll(){
        List<Book> books = bookService.list();
        System.out.println("hot deployee");
        return new R(true,books);
    }

    @PostMapping
    public R save(@RequestBody Book book){
        Boolean flag = bookService.save(book);
        return new R(flag,flag ? "添加成功^_^":"添加失败-_-");
    }

    @PutMapping
    public R updateById(@RequestBody Book book){
        Boolean flag = bookService.updateById(book);
        return new R(flag);
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id){
        Boolean flag = bookService.removeById(id);
        return new R(flag);
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        System.out.println("ccc");
        if(id==1) throw new RuntimeException();
        Book book = bookService.getById(id);
        return new R(true,book);
    }

//    @GetMapping("/{currentPage}/{pagesize}")
//    public R getByPage(@PathVariable Integer currentPage,@PathVariable Integer pagesize){
//        IPage page = bookService.getPage(currentPage,pagesize);
//        //处理删除后页数大于最大页数
//        if(currentPage > page.getPages()){
//            page = bookService.getPage((int)page.getPages(),pagesize);
//        }
//        return new R(true,page);
//    }

    @GetMapping("/{currentPage}/{pagesize}")
    public R getByPage(@PathVariable Integer currentPage,@PathVariable Integer pagesize,Book book){
        IPage page = bookService.getPage(currentPage,pagesize,book);
        //处理删除后页数大于最大页数
        if(currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(),pagesize,book);
        }
        return new R(true,page);
    }
}
