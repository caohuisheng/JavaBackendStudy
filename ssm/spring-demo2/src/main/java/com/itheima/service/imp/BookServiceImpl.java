package com.itheima.service.imp;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;

//@Component
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Override
    public void save() {
        System.out.println("book service save...");
        bookDao.save();
    }
}
