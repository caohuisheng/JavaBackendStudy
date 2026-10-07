package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserServiceImpl implements UserService, BeanFactoryAware, ApplicationContextAware {
    private UserDao userDao;
    private String username;

    public UserServiceImpl(){
        System.out.println("userservice constructing...");
    }

    public void setUserDao(UserDao userDao) {
        System.out.println("userService注入userDao");
        this.userDao = userDao;
    }

    public void setUserName(String name){
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

    public void save() {
        System.out.println("userService save...");
        userDao.save();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
    }
}
