package com.ccnu.chapter8.threadpool_executor;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.SynchronousQueue;

/**
 * Author: chs
 * Description: SynchronousQueue测试
 * CreateTime: 2024-08-11
 */
@Slf4j
public class SynchronousQueueTest {
    public static void main(String[] args) {
        //同步队列(容量为0, 没有线程来取是放不进去的)
        SynchronousQueue<Integer> integers = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                log.info("put 1 start...");
                integers.put(1);
                log.info("put 1 end...");

                log.info("put 2 start...");
                integers.put(2);
                log.info("put 2 end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            Sleeper.sleep(1);
            log.info("take 1...");
            integers.take();

            Sleeper.sleep(1);
            log.info("take 2...");
            integers.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
