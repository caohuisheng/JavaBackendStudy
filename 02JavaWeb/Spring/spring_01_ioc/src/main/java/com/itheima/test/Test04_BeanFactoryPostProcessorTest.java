package com.itheima.test;

import com.itheima.beans.OtherBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试Bean工厂后处理器
 */
public class Test04_BeanFactoryPostProcessorTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
//        Object userDao = ctx.getBean("userDao");
//        System.out.println(userDao);

//        Object bookDao = ctx.getBean("bookDao");
//        System.out.println(bookDao);

        OtherBean otherBean = ctx.getBean(OtherBean.class);
        System.out.println(otherBean);
    }
}
