package com.ccnu.chapter8;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: chs
 * Description: CountdownLatch测试
 * CreateTime: 2024-08-17
 */
@Slf4j
public class CountdownLatchTest {

    private void test1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            log.info("begin...");
            Sleeper.sleep(3);
            countDownLatch.countDown();
            log.info("end... {}",countDownLatch.getCount());
        }).start();
        new Thread(() -> {
            log.info("begin...");
            Sleeper.sleep(2);
            countDownLatch.countDown();
            log.info("end... {}",countDownLatch.getCount());
        }).start();
        new Thread(() -> {
            log.info("begin...");
            Sleeper.sleep(1);
            countDownLatch.countDown();
            log.info("end... {}",countDownLatch.getCount());
        }).start();

        log.info("wait begin...");
        countDownLatch.await();
        log.info("wait end...");
    }

    private void test2(){
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        threadPool.submit(() -> {
            log.info("begin...");
            Sleeper.sleep(1);
            countDownLatch.countDown();
            log.info("end... {}", countDownLatch.getCount());
        });
        threadPool.submit(() -> {
            log.info("begin...");
            Sleeper.sleep(1.5);
            countDownLatch.countDown();
            log.info("end... {}", countDownLatch.getCount());
        });
        threadPool.submit(() -> {
            log.info("begin...");
            Sleeper.sleep(2);
            countDownLatch.countDown();
            log.info("end... {}", countDownLatch.getCount());
        });
        threadPool.submit(() -> {
            try {
                log.info("waiting...");
                countDownLatch.await();
                log.info("wait end... {}");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    //应用-等待多个线程准备完毕
    private void test3() throws InterruptedException {
        AtomicInteger num = new AtomicInteger(0);
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10, (r) -> new Thread(r, "t" + num.getAndIncrement()));
        CountDownLatch latch = new CountDownLatch(10);
        String[] a = new String[10];
        Random r = new Random();

        //创建线程并添加到线程池
        for (int i = 0; i < 10; i++) {
            int x = i;
            threadPool.submit(() -> {
                //每个线程从1加载到100
                for (int j = 1; j <= 100; j++) {
                    try {
                        Thread.sleep(r.nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a[x] = Thread.currentThread().getName() + "(" + (j+"%") + ")";
                    System.out.println(Arrays.toString(a));
                }
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("游戏开始...");
        threadPool.shutdown();
    }



    public static void main(String[] args) throws InterruptedException {
        CountdownLatchTest t = new CountdownLatchTest();
        //t.test1();
        //t.test2();
        t.test3();
    }
}
