package com.itheima.demo3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Class对象
        Class<?> c = Class.forName("com.itheima.demo2.Student");

        //获取构造方法
        Constructor<?> con = c.getConstructor(String.class, int.class, String.class);
        //创建对象
        Object stu = con.newInstance("赵金麦", 20, "西安");
        System.out.println(stu);
    }
}
