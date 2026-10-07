package com.itheima;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testFindAll(){
        List<Book> all = bookService.findAll();
        System.out.println(all);
    }

    @Test
    public void save(){
        Book book = new Book();
        book.setType("计算机");
        book.setName("abc");
        book.setDescription("abc");
//        bookDao.save(book);
    }
}
