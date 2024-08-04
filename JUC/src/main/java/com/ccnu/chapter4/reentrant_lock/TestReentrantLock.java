package com.ccnu.chapter4.reentrant_lock;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: chs
 * Description: 测试ReentrantLock
 * CreateTime: 2024-08-04
 */
@Slf4j
public class TestReentrantLock {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        test4();
    }



    //1.测试可重入
    private static void test1(){
        new TestReentrantLock().method1();
    }

    //2.测试可打断
    private static void test2(){
        log.info("启动");
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                log.error("等锁时被打断", e);
                return;
            }
            log.info("获得了锁");
            lock.unlock();
        }, "t1");

        lock.lock();
        log.info("获得了锁");
        t1.start();

        //1s后打断线程t1
        Sleeper.sleep(1);
        t1.interrupt();
        log.info("执行打断");
        lock.unlock();
    }

    //3.测试锁超时
    private static void test3(){
        Thread t1 = new Thread(() -> {
            log.info("启动");
            try {
                if(!lock.tryLock(1, TimeUnit.SECONDS)){
                    log.info("获取锁失败");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("获得了锁");
            lock.unlock();
        }, "t1");

        lock.lock();
        log.info("获得了锁");
        t1.start();
        try {
            Sleeper.sleep(2);
        } finally {
            lock.unlock();
        }
    }

    //测试公平锁
    private static void test4(){
        //创建公平锁（强行插入，总是在最后输出）
        ReentrantLock fairLock = new ReentrantLock(true);
        fairLock.lock();
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                try {
                    fairLock.lock();
                    System.out.println(Thread.currentThread().getName() + " running...");
                } finally {
                    fairLock.unlock();
                }
            }, "t"+i).start();
        }
        Sleeper.sleep(1);
        //0.1s后争抢锁
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start...");
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + " running...");
            } finally {
                fairLock.unlock();
            }
        },"强行插入").start();
        fairLock.unlock();
    }

    private void method1(){
        log.info("execute method1...");
        try{
            lock.lock();
            method2();
        }finally {
            lock.unlock();
        }
    }

    private void method2(){
        log.info("execute method2...");
        try{
            lock.lock();
            method3();
        }finally {
            lock.unlock();
        }
    }

    private void method3(){
        log.info("execute method3...");
        try{
            lock.lock();
        }finally {
            lock.unlock();
        }
    }

}
