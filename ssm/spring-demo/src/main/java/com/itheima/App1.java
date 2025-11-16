package com.itheima;

import com.itheima.dao.OrderDao;
import com.itheima.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过静态工厂创建对象
        /*OrderDao orderDao = OrderDaoFactory.getOrderDao();
        orderDao.save();*/

        OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
        orderDao.save();

        UserDao userDao = (UserDao) ctx.getBean("userDao");
        userDao.save();
    }
}
