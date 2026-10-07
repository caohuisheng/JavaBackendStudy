package com.itheima.demo6;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        //读取文件配置
        FileReader fr = new FileReader("Reflect\\test.txt");

        Properties prop = new Properties();
        prop.load(fr);

        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        //获取对应的类和方法
        Class<?> c = Class.forName(className);
        Method method = c.getMethod(methodName);

        //获取对应的实例对象
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();

        method.invoke(obj);
    }
}
