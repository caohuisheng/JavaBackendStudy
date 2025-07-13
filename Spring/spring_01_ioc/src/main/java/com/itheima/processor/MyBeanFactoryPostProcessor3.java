package com.itheima.processor;

import com.itheima.utils.BaseClassScanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Map;

public class MyBeanFactoryPostProcessor3 implements BeanDefinitionRegistryPostProcessor {
    //处理BeanDefinition注册
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        //获取使用了@MyComponent注解的类
        Map<String, Class> beanMap = BaseClassScanUtils.scanMyComponentAnnotation("com.itheima");
        //创建BeanDefinition
        beanMap.forEach((beanName,clazz)->{
            BeanDefinition beanDefinition = new RootBeanDefinition();
            beanDefinition.setBeanClassName(clazz.getName());
            beanDefinitionRegistry.registerBeanDefinition(beanName,beanDefinition);
        });
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
