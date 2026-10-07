package com.itheima;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class Springboot17MongodbApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void find() {
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }

    @Test
    void save(){
        Book book = new Book();
        book.setId(3);
        book.setName("spring");
        book.setDescription("spring2");
        book.setType("spring2");
        mongoTemplate.save(book);
    }

}
