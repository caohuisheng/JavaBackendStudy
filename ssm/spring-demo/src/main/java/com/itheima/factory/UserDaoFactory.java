package com.itheima.factory;

import com.itheima.dao.imp.UserDaoImpl;

public class UserDaoFactory {
    public UserDaoImpl getUserDaoImpl(){
        return new UserDaoImpl();
    }
}
