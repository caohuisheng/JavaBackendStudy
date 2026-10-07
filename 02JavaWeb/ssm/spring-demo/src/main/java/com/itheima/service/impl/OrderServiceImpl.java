package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.service.OrderService;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    @Override
    public void save() {
        System.out.println("order service save...");
        orderDao.save();
    }
}
