package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Book;

import java.util.List;

public interface BookService extends IService<Book> {
    IPage<Book> getPage(int currentPage,int pagesize,Book book);
}
