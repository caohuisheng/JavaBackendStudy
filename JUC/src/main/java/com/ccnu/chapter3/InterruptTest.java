package com.ccnu.chapter3;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * Author: chs
 * Description: interrupt测试
 * CreateTime: 2024-07-28
 */
@Slf4j
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException{
        //test1();
        //test2();
        test3();
    }

    static void test1() throws InterruptedException{
        Thread t1 = new Thread(() -> {
            Sleeper.sleep(1);
        }, "t1");
        t1.start();

        Sleeper.sleep(0.5);
        //打断sleep的线程，会清除打断状态
        t1.interrupt();
        log.info("打断状态：{}", t1.isInterrupted());
    }

    static void test2(){
        Thread t1 = new Thread(() -> {
            while(true){
                boolean interrupted = Thread.currentThread().isInterrupted();
                if(interrupted){
                    log.info("打断状态：{}", interrupted);
                    break;
                }
            }
        });
        t1.start();

        Sleeper.sleep(0.5);
        t1.interrupt();
    }

    static void test3(){
        Thread t1 = new Thread(() -> {
            for (int i=0;i<4;i++) {
                log.info("park...");
                //打断park线程，不会清除打断标记
                LockSupport.park();
                log.info("打断状态：{}", Thread.currentThread().isInterrupted());
            }
        });
        t1.start();

        Sleeper.sleep(1);
        t1.interrupt();
    }
}
