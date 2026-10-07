package com.itheima.demo1;

public class MyInterfaceDemo {
    public static void main(String[] args) {
        useMyInterface(() -> System.out.println("hello,wolrd"));
    }
    static void useMyInterface(MyInterface myInterface){
        myInterface.show();
        //System.out.println("hello,world");
    }
}
