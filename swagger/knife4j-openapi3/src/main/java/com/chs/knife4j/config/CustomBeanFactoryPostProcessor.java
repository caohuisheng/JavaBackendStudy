package com.chs.knife4j.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Component;

/**
 * @author chs
 * @date 2025-12-16 17:17
 * @description todo
 */
// @Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // Set property values here
        System.setProperty("springdoc.swagger-ui.enabled", "false");
        System.setProperty("springdoc.api-docs.enabled", "false");

        // Or modify bean definitions
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
        // Access and modify bean definitions if needed
    }
}
