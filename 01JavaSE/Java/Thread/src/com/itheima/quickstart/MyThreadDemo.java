package com.itheima.quickstart;

public class MyThreadDemo {
    public static void main(String[] args) {
        ThreadPriority();
    }

    static void demo1(){
        /*MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();*/

        MyThread thread1 = new MyThread("高铁");
        MyThread thread2 = new MyThread("飞机");
        thread1.start();
        thread2.start();
    }

    /*
    线程优先级
     */
    static void ThreadPriority(){
        MyThread thread1 = new MyThread("高铁");
        MyThread thread2 = new MyThread("飞机");
        MyThread thread3 = new MyThread("火车");

        thread1.setPriority(1);
        thread2.setPriority(10);
        thread3.setPriority(5);

        thread1.start();
        thread2.start();
        thread3.start();
    }


}
