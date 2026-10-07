package com.itheima.demo4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Class对象
        Class<?> c = Class.forName("com.itheima.demo2.Student");

        //获取所有公共字段
        //Field[] fields = c.getFields();
        //获取所有字段
        Field[] fields = c.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field);
        }

        //获取address字段
        Field addressField = c.getDeclaredField("address");
        addressField.setAccessible(true);

        //获取无参构造方法
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();

        //设置address字段的值
        addressField.set(obj,"xian");
        System.out.println(obj);
    }
}
