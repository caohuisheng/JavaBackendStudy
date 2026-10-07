package com.ccnu.chapter8.threadpool_executor;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Author: chs
 * Description: ThreadPool测试
 * CreateTime: 2024-08-11
 */
@Slf4j
public class ThreadPoolTest {
    static void testThreadPool(ExecutorService threadPool){
        for (int i = 0; i < 6; i++) {
            final int j = i;
            threadPool.execute(() -> {
                Sleeper.sleep(1);
                log.info("thread {} end...", j);
            });
        }
        log.info("isShutdown:{} isTerminated:{}", threadPool.isShutdown(), threadPool.isTerminated());
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("isShutdown:{} isTerminated:{}", threadPool.isShutdown(), threadPool.isTerminated());
    }

    public static void main(String[] args) {
        //testThreadPool(Executors.newFixedThreadPool(3));
        //testThreadPool(Executors.newCachedThreadPool());
        testThreadPool(Executors.newSingleThreadExecutor());
    }

}
