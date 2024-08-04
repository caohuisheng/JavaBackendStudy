package com.ccnu.chapter4.thread_status;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: chs
 * Description: 测试wait_notify
 * CreateTime: 2024-08-04
 */
@Slf4j
public class TestWaitNotify {
    private static final Object obj= new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized(obj){
                log.info("执行...");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("其它代码...");
            }
        }).start();
        new Thread(() -> {
            synchronized(obj){
                log.info("执行...");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("其它代码...");
            }
        }).start();

        Sleeper.sleep(1);
        log.info("唤醒obj上其它线程");
        synchronized(obj){
            obj.notifyAll();
        }
    }

}
