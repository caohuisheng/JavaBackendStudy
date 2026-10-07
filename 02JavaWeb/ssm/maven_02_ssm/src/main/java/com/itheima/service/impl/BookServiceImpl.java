package com.itheima.service.impl;

import com.itheima.controller.Code;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.exception.BusinessException;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    @Override
    public boolean delete(int id) {
        return bookDao.delete(id) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findById(int id) {
        //业务异常
        if(id==1){
            throw new BusinessException(Code.BUSINESS_ERR,"输入不合法");
        }
        //系统异常
//        try{
//            int i = 1/0;
//        }catch(Exception e){
//            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR,"系统异常",e);
//        }

        return bookDao.findById(id);
    }
}
