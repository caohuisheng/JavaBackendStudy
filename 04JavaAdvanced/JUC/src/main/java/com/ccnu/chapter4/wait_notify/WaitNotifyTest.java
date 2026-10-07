package com.ccnu.chapter4.wait_notify;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: chs
 * Description: wait_notify测试
 * CreateTime: 2024-08-03
 */
@Slf4j
public class WaitNotifyTest {
    private static final Object obj = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized(obj){
                log.info("begin...");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("end...");
            }
        }).start();
        new Thread(() -> {
            synchronized(obj){
                log.info("begin...");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("end...");
            }
        }).start();

        Sleeper.sleep(2);
        log.info("唤醒obj上其它线程");
        synchronized(obj){
            //obj.notify(); //只会唤醒等待的某一个线程
            obj.notifyAll(); //唤醒j等待的所有线程
        }
    }
}
