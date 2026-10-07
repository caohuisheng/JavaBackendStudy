package com.itheima.dao.impl;

import com.itheima.dao.OrderDao;

public class OrderDaoImpl2 implements OrderDao {
    @Override
    public void save() {
        System.out.println("order dao2 save...");
    }
}
