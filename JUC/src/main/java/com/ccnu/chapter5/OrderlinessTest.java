package com.ccnu.chapter5;

/**
 * Author: chs
 * Description: 有序性测试
 * CreateTime: 2024-08-10
 */
public class OrderlinessTest {
    private int num = 0;
    boolean ready = false;
    private int result;

    private void actor1(){
        if(ready){
            result = num + num;
        }else{
            result = 1;
        }
    }

    private void actor2(){
        num = 2;
        ready = true;
    }

    private void test(){
        Thread t1 = new Thread(() -> {
            actor1();
        });
        Thread t2 = new Thread(() -> {
            actor2();
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            if(result == 1) System.out.println("result=" + result);
            else if(result == 4)  System.out.println("result====" + result);
            else System.out.println("result========" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OrderlinessTest orderlinessTest = new OrderlinessTest();
        for (int i = 0; i < 100; i++) {
            orderlinessTest.test();
        }
    }

}
