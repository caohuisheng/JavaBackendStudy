package com.itheima.service;

import com.itheima.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {
    public boolean save(Book book);

    public boolean delete(int id);

    public boolean update(Book book);

    public List<Book> findAll();

    public Book findById(int id);
}
