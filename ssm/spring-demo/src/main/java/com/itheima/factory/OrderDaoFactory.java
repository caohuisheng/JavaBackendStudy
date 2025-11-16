package com.itheima.factory;

import com.itheima.dao.OrderDao;
import com.itheima.dao.imp.OrderDaoImpl;

/*
静态工厂
 */
public class OrderDaoFactory {
    public static OrderDao getOrderDao(){
        return new OrderDaoImpl();
    }
}
