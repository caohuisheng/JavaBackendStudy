package com.ccnu.chapter4.park;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * Author: chs
 * Description: park测试
 * CreateTime: 2024-08-04
 */
@Slf4j
public class ParkTest {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    /**
     * 先park,再unpark
     */
    private static void test1(){
        Thread t = new Thread(() -> {
            log.info("start...");
            Sleeper.sleep(1);
            log.info("park...");
            //暂停当前线程
            LockSupport.park();
            log.info("resume...");
        });
        t.start();
        log.info("start...");
        Sleeper.sleep(2);
        log.info("unpark...");
        //恢复线程t的运行
        LockSupport.unpark(t);
    }

    /**
     * 先unpark,再park
     */
    private static void test2(){
        Thread t = new Thread(() -> {
            log.info("start...");
            Sleeper.sleep(2);
            log.info("park...");
            //暂停当前线程
            LockSupport.park();
            log.info("resume...");
        });
        t.start();
        log.info("start...");
        Sleeper.sleep(1);
        log.info("unpark...");
        //恢复线程t的运行
        LockSupport.unpark(t);
    }
}
