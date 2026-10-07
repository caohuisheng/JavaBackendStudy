package com.itheima.demo2;

public class InterDemo {
    public static void main(String[] args) {
        Inter i = new InterImpl();
        i.show();
        i.method();
        //i.test();
        //接口中的静态方法只能通过接口名调用
        Inter.test();
    }
}
