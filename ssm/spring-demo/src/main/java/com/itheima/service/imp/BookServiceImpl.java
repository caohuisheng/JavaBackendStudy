package com.itheima.service.imp;

import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.dao.imp.BookDaoImpl;
import com.itheima.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private UserDao userDao;

    //set注入userDao
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    //set注入bookDao
    public void setBookDao(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        System.out.println("book service save...");
        bookDao.save();
        userDao.save();
    }
}
