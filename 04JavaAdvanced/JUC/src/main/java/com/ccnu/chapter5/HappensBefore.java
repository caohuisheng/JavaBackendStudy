package com.ccnu.chapter5;

import com.ccnu.utils.Sleeper;

/**
 * Author: chs
 * Description: happens_before测试
 * CreateTime: 2024-08-10
 */
public class HappensBefore {
    private static int x;
    private static Object lock = new Object();
    private static volatile int y;

    //线程解锁lock前对变量x的写，对接下来对lock加锁的其它线程的读可见
    private static void test1(){
        new Thread(() -> {
            synchronized(lock){
                x = 10;
            }
        }).start();
        new Thread(() -> {
            synchronized (lock){
                System.out.println(x);
            }
        }).start();
    }

    //线程对volatile变量的写，对接下来其它线程对该变量的读可见
    private static void test2(){
        new Thread(() -> {
            y = 10;
        }).start();
        new Thread(() -> {
            System.out.println(y);
        }).start();
    }

    //线程结束前对变量的写，对其它线程得知它结束后的读可见
    private static void test3(){
        Thread t1 = new Thread(() -> {
            x = 10;
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(x);
    }

    //线程t2打断线程t1前对变量的写，对其它线程得知线程t1被打断后的读可见
    private static void test4(){
        Thread t1 = new Thread(() -> {
            while(true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println(x);
                    break;
                }
            }
        },"t1");
        t1.start();

        new Thread(() -> {
            Sleeper.sleep(1);
            x = 10;
            t1.interrupt();
        },"t2").start();

        while(!t1.isInterrupted()){
            Thread.yield();
        }
        System.out.println(x);
    }



    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        test4();
    }
}
