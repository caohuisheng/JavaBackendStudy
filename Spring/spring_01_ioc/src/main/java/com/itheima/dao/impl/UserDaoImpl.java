package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.InitializingBean;

public class UserDaoImpl implements UserDao,InitializingBean {
    private UserService userService;

    public UserDaoImpl(String name){
        System.out.println("userdao constructing, name=" + name);
    }

    public void save() {
        System.out.println("userdao save...");
    }

    public UserDaoImpl(){
        System.out.println("userdao constructing...");
    }

    public void setUserService(UserService userService) {
        System.out.println("userDao注入userService");
        this.userService = userService;
    }

    public void init(){
       System.out.println("初始化方法...");
    }

    public void destroy(){
        System.out.println("销毁方法...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       System.out.println("属性设置后执行...");
    }
}
