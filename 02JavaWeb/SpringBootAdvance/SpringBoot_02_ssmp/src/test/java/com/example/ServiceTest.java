package com.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import com.example.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void selectAll() {
        System.out.println(bookService.list());
    }

    @Test
    void getById() {
        System.out.println(bookService.getById(1));
    }

    @Test
    void insert() {
        Book book = new Book();
        book.setType("Android");
        book.setName("Android进阶之光");
        book.setDescription("Android进阶");
        bookService.save(book);
    }

    @Test
    void delete() {
        bookService.removeById(51);
    }

    @Test
    void getPage(){
        //IPage page = bookService.getPage(2,3);
//        System.out.println(page.getRecords());
//        System.out.println(page.getCurrent());
    }


}