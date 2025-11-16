package com.itheima.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 我的bean工厂后处理器
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("beanDefinitionMap填充完毕后调用...");
        //修改某个BeanDefinition
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("orderDao");
        beanDefinition.setBeanClassName("com.itheima.service.imp.OrderServiceImpl");
//        System.out.println(beanDefinition.getBeanClassName());

    }
}
