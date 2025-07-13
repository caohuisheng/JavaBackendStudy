package com.itheima.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.time.LocalTime;

public class TimeLogBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //使用动态代理对目标bean进行增强，返回proxy对象，进而存储到单例池singletonObjects中
        Object beanProxy = Proxy.newProxyInstance(
                bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy,method,args) -> {
                    //1.输出开始时间
                    System.out.println("方法："+method.getName()+"-开始执行："+ LocalTime.now());
                    //2.执行目标方法
                    Object result = method.invoke(bean, args);
                    //3.输出结束时间
                    System.out.println("方法："+method.getName()+"-开始执行："+ LocalTime.now());
                    return result;
                }
        );

        //返回代理bean对象
        return beanProxy;
    }
}
