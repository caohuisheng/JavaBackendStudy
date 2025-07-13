package com.itheima.handler;

import com.itheima.processor.HaohaoBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * 标签解析器
 */
public class HaohaoBeanDefinitionParser implements BeanDefinitionParser {
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        //创建HaohaoBeanPostProcessor的Beandefinition
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(HaohaoBeanPostProcessor.class);
        //注册HaohaoBeanPostProcessor
        parserContext.getRegistry().registerBeanDefinition("haohaoBeanPostProcessor",beanDefinition);
        return beanDefinition;
    }
}
