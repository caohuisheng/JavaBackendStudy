package com.itheima;

import com.itheima.dao.OrderDao;
import com.itheima.dao.UserDao;
import com.itheima.factory.OrderDaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForInstanceOrder {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过静态工厂创建对象
        // OrderDao orderDao = OrderDaoFactory.getOrderDao();
        // orderDao.save();

        // 通过实例工厂创建对象
        // OrderDao orderDao = (OrderDao) ctx.getBean("userDao");
        // orderDao.save();

        // 通过FactoryBean创建对象
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        userDao.save();
    }
}
