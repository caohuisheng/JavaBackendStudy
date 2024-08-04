package com.ccnu.chapter4.dead_lock;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: chs
 * Description: 测试死锁
 * CreateTime: 2024-08-04
 */
@Slf4j
public class TestDeadLock {
    private final static Object lockA = new Object();
    private final static Object lockB = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lockA){
                log.info("lock A");
                Sleeper.sleep(1);
                synchronized (lockB){
                    log.info("lock B");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lockB){
                log.info("lock B");
                Sleeper.sleep(1);
                synchronized (lockA){
                    log.info("lock A");
                }
            }
        }).start();
    }
}
