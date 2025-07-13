package com.itheima.test;

import com.itheima.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Author: chs
 * Description: 测试bean工厂
 * CreateTime: 2025-07-13
 */
public class Test01_BeanFactory {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("beans.xml");
        UserService userService = (UserService)beanFactory.getBean("userService");
    }
}
