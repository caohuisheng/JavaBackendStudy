package com.itheima.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 命名空间处理器
 */
public class HaohaoNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        this.registerBeanDefinitionParser("annotation-driven",new HaohaoBeanDefinitionParser());
    }
}
