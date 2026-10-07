package com.ccnu.chapter3;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: chs
 * Description: yield测试
 * CreateTime: 2024-07-28
 */
@Slf4j
public class YieldTest {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            int count = 0;
            for(;;){
                log.info(++count + "============t1");
            }
        };
        Runnable task2 = () -> {
            int count = 0;
            for(;;){
                Thread.yield();
                log.info(++count + "");
            }
        };

        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task1, "t2");
        //设置优先级可以会提示调度器优先调度优先级高的线程（若cpu忙，优先级搞得线程可以获得更多的时间片，但是cpu闲时几乎没有作用）
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
