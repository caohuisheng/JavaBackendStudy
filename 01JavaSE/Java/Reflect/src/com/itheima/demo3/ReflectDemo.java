package com.itheima.demo3;

import com.itheima.demo2.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> c = Class.forName("com.itheima.demo2.Student");
        //获取所有共有方法
        //Constructor<?>[] cons = c.getConstructors();
        //获取所有声明了的方法
        Constructor<?>[] cons = c.getDeclaredConstructors();
        for(Constructor con:cons){
            System.out.println(con);
        }

        //获取构造方法
        Constructor<?> con = c.getConstructor();
        System.out.println(con);

        //创建一个对象
        Object object = con.newInstance();
        System.out.println(object);
    }
}
