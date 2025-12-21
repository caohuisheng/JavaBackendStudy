package com.itheima.factory;

import com.itheima.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public UserDaoImpl getUserDao(){
        return new UserDaoImpl();
    }
}
