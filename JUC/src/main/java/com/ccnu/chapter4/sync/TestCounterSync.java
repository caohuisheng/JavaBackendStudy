package com.ccnu.chapter4.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: chs
 * Description: synchronized测试
 * CreateTime: 2024-08-03
 */
@Slf4j
public class TestCounterSync {
    private static int counter = 0;
    //对象锁，只有一个线程可以获取到锁
    private static Object room = new Object();

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                synchronized(room){
                    counter++;
                }
            }
        },"t1");
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                synchronized(room){
                    counter--;
                }
            }
        },"t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("counter：{}", counter);
    }

}
