package com.itheima.demo1;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        //返回委派的系统类加载器
        ClassLoader c = ClassLoader.getSystemClassLoader();
        System.out.println(c);

        //返回父类加载器进行委培
        ClassLoader c2 = c.getParent();
        System.out.println(c2);

        //null
        ClassLoader c3 = c2.getParent();
        System.out.println(c3);
    }
}
