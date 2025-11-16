package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println(System.currentTimeMillis());
        System.out.println("bookdao save...");
    }

    @Override
    public void update() {
        System.out.println("bookdao update...");
    }

    @Override
    public int select() {
        System.out.println("bookDao select...");
        return 100;
    }

    @Override
    public String findName(int id) {
        System.out.println("findName running...");
        if(true){
            throw new NullPointerException();
        }

        return "itheima";
    }
}
