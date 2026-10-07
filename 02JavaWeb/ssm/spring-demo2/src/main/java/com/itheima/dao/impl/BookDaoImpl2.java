package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository("bookDao2")
public class BookDaoImpl2 implements BookDao {

    private String name;

    public void setName(String name){
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("book dao save..."+name);
    }

    // @PostConstruct
    // public void initMethod(){
    //     System.out.println("initMethod...");
    // }
    //
    // @PreDestroy
    // public void destroyMethod(){
    //     System.out.println("destroyMethod...");
    // }
}
