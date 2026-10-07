package com.itheima.demo5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<?> c = Class.forName("com.itheima.demo2.Student");

        //获取所有公共方法
        //Method[] methods = c.getMethods();
        Method[] methods = c.getDeclaredMethods();
        for(Method m:methods){
            System.out.println(m);
        }

        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();

        Method method1 = c.getMethod("method1");
        method1.invoke(obj);

        Method method = c.getDeclaredMethod("method");
        method.setAccessible(true);
        method.invoke(obj);

        Method method2 = c.getMethod("method2", String.class);
        method2.invoke(obj,"chs");

        Method method3 = c.getMethod("method3", String.class, int.class);
        Object res = method3.invoke(obj, "赵金麦",20);
        System.out.println(res);

    }
}
