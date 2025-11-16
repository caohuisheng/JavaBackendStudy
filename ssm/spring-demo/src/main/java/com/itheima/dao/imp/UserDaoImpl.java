package com.itheima.dao.imp;

import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("user dao save...");
    }
}
