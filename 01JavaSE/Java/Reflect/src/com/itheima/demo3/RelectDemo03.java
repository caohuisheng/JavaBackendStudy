package com.itheima.demo3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
反射获取私有构造方法
 */
public class RelectDemo03 {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Class对象
        Class<?> c = Class.forName("com.itheima.demo2.Student");

        //获取私有构造方法
        Constructor<?> con = c.getDeclaredConstructor(String.class);

        //取消访问检查
        con.setAccessible(true);

        Object obj = con.newInstance("赵金麦");
        System.out.println(obj);
    }
}
