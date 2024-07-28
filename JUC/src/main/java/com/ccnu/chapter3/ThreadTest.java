package com.ccnu.chapter3;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Author: chs
 * Description: 线程创建测试
 * CreateTime: 2024-07-28
 */
@Slf4j
public class ThreadTest {
    public static void main(String[] args) throws Exception{
        //方法1：通过继承Thread创建
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.info("t1 is running...");
            }
        };
        t1.start();

        //方法2：通过实现Runnable接口创建
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.info("t2 is running...");
            }
        };
        Thread t2 = new Thread(runnable, "t2");
        t2.start();

        //方法3：通过实现FutureTask接口创建
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.info("t3 is running...");
                return 666;
            }
        });
        Thread t3 = new Thread(task, "t3");
        t3.start();
        log.info("结果是：{}", task.get());
    }
}
