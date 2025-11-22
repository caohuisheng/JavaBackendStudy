/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * Official Web Site: http://www.xiaominfo.com.
 */
package com.knife4j.demo.config;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @since:knife4j-spring-boot27-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/16 22:53
 */
public class Tes {

    public static void main(String[] args) {
        DefaultListableBeanFactory context =
                new DefaultListableBeanFactory();

        //define and register MyOtherBean
        GenericBeanDefinition beanOtherDef = new GenericBeanDefinition();
        ConstructorArgumentValues constructorArgumentValues=new ConstructorArgumentValues();
        constructorArgumentValues.addGenericArgumentValue(DocumentationType.SWAGGER_2);
        beanOtherDef.setConstructorArgumentValues(constructorArgumentValues);
        beanOtherDef.setBeanClass(Docket.class);
        MutablePropertyValues mpv = new MutablePropertyValues();
        //mpv.addPropertyValue("otherBean", context.getBean("other"));
        //beanOtherDef.setPropertyValues(mpv);
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<1000;i++){
            stringBuilder.append(i);
        }
        System.out.println(stringBuilder.toString());
        context.registerBeanDefinition(stringBuilder.toString(), beanOtherDef);


        //using MyBean instance
        Docket bean = context.getBean(Docket.class);
        bean.groupName("abc");
        System.out.println("name:"+bean.getGroupName());
        Docket aaa=context.getBean(Docket.class);
        System.out.println("name1:"+bean.getGroupName());

    }
}
