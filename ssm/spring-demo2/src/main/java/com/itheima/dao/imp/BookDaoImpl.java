package com.itheima.dao.imp;

import com.itheima.dao.BookDao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class BookDaoImpl implements BookDao {

    private String name;

    public void setName(String name){
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("book dao save..."+name);
    }

    @PostConstruct
    public void inti(){
        System.out.println("init...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy...");
    }
}
