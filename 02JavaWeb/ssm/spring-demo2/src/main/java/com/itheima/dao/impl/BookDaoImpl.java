package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("bookDao1")
public class BookDaoImpl implements BookDao {

    @Value("${name}")
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
