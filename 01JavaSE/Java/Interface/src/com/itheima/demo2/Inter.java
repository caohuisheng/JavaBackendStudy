package com.itheima.demo2;

public interface Inter {
    void show();
    default void method(){
        System.out.println("Inter：默认方法");
    }
    static void test(){
        System.out.println("Inter：静态方法");
    }
}
