package com.example;

import com.example.dao.BookDao;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMybatis1ApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void testFindById() {
        Book book = bookDao.findById(3);
        System.out.println(book);
    }

}
