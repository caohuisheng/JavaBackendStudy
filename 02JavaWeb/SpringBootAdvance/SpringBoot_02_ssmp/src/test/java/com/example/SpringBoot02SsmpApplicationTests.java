package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookDao;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
class SpringBoot02SsmpApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void getById(){
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void add(){
        Book book = new Book();
        book.setType("Android");
        book.setName("Android进阶之光");
        book.setDescription("Android进阶");
        System.out.println(book.getId());
        bookDao.insert(book);
    }

    @Test
    void selectByPage(){
        IPage<Book> page = new Page<Book>(1,3);
        bookDao.selectPage(page,null);
    }

    @Test
    void selectByCondition(){
        QueryWrapper<Book> qw = new QueryWrapper();
        qw.like("name","Spring");
        bookDao.selectList(qw);
    }

    @Test
    void selectByCondition1(){
        String name = "1";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper();
        lqw.like(name != null,Book::getName,name);
        bookDao.selectList(lqw);
    }

}
