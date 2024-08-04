package com.ccnu.chapter4.dead_lock;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: chs
 * Description: 活锁（两个线程同时修改对方的结束条件，导致最终都无法结束）
 * CreateTime: 2024-08-04
 */
@Slf4j
public class TestLiveLock {
    private volatile static int count = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while(count>0){
                Sleeper.sleep(0.2);
                count--;
                log.info("count={}",count);
            }
        }).start();
        new Thread(() -> {
            while(count<20){
                Sleeper.sleep(0.2);
                count++;
                log.info("count={}",count);
            }
        }).start();
    }

}
