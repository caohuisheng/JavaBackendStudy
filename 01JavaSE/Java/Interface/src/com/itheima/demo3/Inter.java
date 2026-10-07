package com.itheima.demo3;

public interface Inter {
    private void show(){
        System.out.println("十步杀一人");
        System.out.println("千里不留行");
        System.out.println("凤兮凤兮归故乡");
    }
    default void show1(){
        System.out.println("show1开始执行");
//        System.out.println("十步杀一人");
//        System.out.println("千里不留行");
//        System.out.println("凤兮凤兮归故乡");
        show();
        System.out.println("show1结束执行");
    }

    default void show2(){
        System.out.println("show2开始执行");
//        System.out.println("十步杀一人");
//        System.out.println("千里不留行");
//        System.out.println("凤兮凤兮归故乡");
        show();
        System.out.println("show2结束执行");
    }

    private static void method(){
        System.out.println("十步杀一人");
        System.out.println("千里不留行");
        System.out.println("凤兮凤兮归故乡");
    }

    static void method1(){
        System.out.println("method1开始执行");
//        System.out.println("十步杀一人");
//        System.out.println("千里不留行");
//        System.out.println("凤兮凤兮归故乡");
        //不可以调用非静态方法
        //show;
        method();
        System.out.println("method1结束执行");
    }

    static void method2(){
        System.out.println("method2开始执行");
//        System.out.println("十步杀一人");
//        System.out.println("千里不留行");
//        System.out.println("凤兮凤兮归故乡");
        method();
        System.out.println("method2结束执行");
    }
}
