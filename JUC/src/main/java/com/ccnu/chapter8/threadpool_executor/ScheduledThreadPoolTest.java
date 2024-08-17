package com.ccnu.chapter8.threadpool_executor;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * Author: chs
 * Description: 任务调度线程池
 * CreateTime: 2024-08-11
 */
@Slf4j
public class ScheduledThreadPoolTest {

    static void test1(){
        Timer timer = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                log.info("task 1");
                Sleeper.sleep(1);
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                log.info("task 2");
            }
        };
        //timer内只有一个线程顺序执行队列中的任务,因此[任务1]的延迟, 影响了[任务2]的执行
        timer.schedule(task1, 1000);
        timer.schedule(task2, 1000);
    }

    static void test2(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        log.info("start...");
        executor.execute(() -> {
            log.info("task1 start...");
            Sleeper.sleep(1);
        });
        executor.execute(() -> {
            log.info("task2 start...");
            Sleeper.sleep(1);
        });
    }

    static void test3(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        log.info("start...");
        //按照指定的速度执行任务,如果任务需要的时间大于指定的时间,则间隔为任务的执行时间
        executor.scheduleAtFixedRate(() -> {
            log.info("task1 start...");
            Sleeper.sleep(2);
        },1,1, TimeUnit.SECONDS);
    }

    static void test4(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        log.info("start...");
        //按照指定的延迟执行任务,每次任务的间隔时间=任务实际耗时+延迟时间
        executor.scheduleWithFixedDelay(() -> {
            log.info("task1 start...");
            Sleeper.sleep(1);
        },1,1, TimeUnit.SECONDS);
    }

    static void test5(){
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        Future<Boolean> result = threadPool.submit(() -> {
            log.info("task1 start...");
            int i = 1 / 0;
            return true;
        });
        try {
            log.info("result:{}", result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        test5();
    }
}
