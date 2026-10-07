package com.itheima.demo2;

import java.util.Collections;
import java.util.Comparator;

public class RunnableDemo {
    public static void main(String[] args) {
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程启动了");
            }
        });
        //Collections.sort();
        startThread(() -> System.out.println(Thread.currentThread().getName()+"线程启动了"));
    }
    static void startThread(Runnable r){
        new Thread(r).start();
    }

}
