package com.itheima;

public class LambdaDemo {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("hello,world");
        }).start();
        Runnable r = () -> System.out.println("hello,world");
    }
}
