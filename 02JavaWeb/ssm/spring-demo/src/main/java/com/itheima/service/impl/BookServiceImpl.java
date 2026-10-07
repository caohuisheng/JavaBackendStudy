package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private UserDao userDao;

    public BookServiceImpl() {
    }

    // 构造器注入
    public BookServiceImpl(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    //set注入userDao
    // public void setUserDao(UserDao userDao){
    //     this.userDao = userDao;
    // }

    //set注入bookDao
    public void setBookDao(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        System.out.println("book service save...");
        this.bookDao.save();
        // this.userDao.save();
    }

}
