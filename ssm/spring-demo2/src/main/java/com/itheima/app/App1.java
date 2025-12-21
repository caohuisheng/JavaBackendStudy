package com.itheima.app;

import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App1 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        // BookDao bookDao = ctx.getBean("bookDao", BookDao.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        bookDao.save();

        // FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        // BookDao bookDao = ctx.getBean(BookDao.class);
        // bookDao.save();

        //通过BeanFactory创建容器
//        Resource resource = new ClassPathResource("applicationContext.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(resource);
//        BookDao bookDao = (BookDao) beanFactory.getBean("bookDao");
//        bookDao.save();
    }
}
