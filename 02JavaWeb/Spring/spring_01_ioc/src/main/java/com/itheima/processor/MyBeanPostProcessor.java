package com.itheima.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean后处理器
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    //在bean初始化之前执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+":postProcessBeforeInitialization");
        return bean;
    }

    //在bean初始化之后执行
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+":postProcessAfterInitialization");
        return bean;
    }
}
