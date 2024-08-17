package com.ccnu.chapter8;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Author: chs
 * Description: CyclicBarrier测试
 * CreateTime: 2024-08-17
 */
@Slf4j
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2);
        new Thread(() -> {
            log.info("begin...");
            try {
                //等待其它线程到达
                cb.await();
            } catch (InterruptedException|BrokenBarrierException e) {
                e.printStackTrace();
            }
            log.info("continue to running...");
        }).start();
        new Thread(() -> {
            log.info("begin...");
            Sleeper.sleep(1);
            try {
                //1s后，线程个数达到2，继续执行
                cb.await();
            } catch (InterruptedException|BrokenBarrierException e) {
                e.printStackTrace();
            }
            log.info("continue to running...");
        }).start();
    }
}
