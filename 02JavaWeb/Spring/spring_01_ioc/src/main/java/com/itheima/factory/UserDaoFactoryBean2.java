package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-07-13
 */
public class UserDaoFactoryBean2 {

    // 实例工厂方法实例化bean
    public UserDao getUserDao(String sex){
        return new UserDaoImpl();
    }

}
