package com.ccnu.chapter4.reentrant_lock;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: chs
 * Description: 测试条件变量
 * CreateTime: 2024-08-04
 */
@Slf4j
public class TestCondition {
    private static ReentrantLock lock = new ReentrantLock();
    //创建lock锁对应的条件变量
    private static Condition waitCigaretteQueue = lock.newCondition();
    private static Condition waitBreakfastQueue = lock.newCondition();
    //记录线程等待的条件
    private static boolean hasCigarette = false;
    private static boolean hasBreakfast = false;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                lock.lock();
                while(!hasCigarette){
                    try {
                        waitCigaretteQueue.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("等到了烟");
            } finally {
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            try {
                lock.lock();
                while(!hasBreakfast){
                    try {
                        waitBreakfastQueue.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("等到了早餐");
            } finally {
                lock.unlock();
            }
        }).start();

        Sleeper.sleep(1);
        sendCigarette();
        Sleeper.sleep(1);
        sendBreakfast();
    }

    private static void sendCigarette(){
        try {
            lock.lock();
            log.info("送烟来了");
            hasCigarette = true;
            waitCigaretteQueue.signal();
        } finally {
            lock.unlock();
        }
    }

    private static void sendBreakfast(){
        try {
            lock.lock();
            log.info("送早餐来了");
            hasBreakfast = true;
            waitBreakfastQueue.signal();
        } finally {
            lock.unlock();
        }
    }

}
