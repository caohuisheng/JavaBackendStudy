package com.ccnu.chapter4.thread_safe;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-08-03
 */
@Slf4j
public class TestInteger {
    private static Integer i = 0;
    private static Object lock = new Object();

    public static void main(String[] args){
        List<Thread> list = new ArrayList<>();
        for (int j = 0; j < 2; j++) {
            Thread thread = new Thread(() -> {
                for (int k = 0; k < 5000; k++) {
                    //此处锁住的变量是可变的，每次获取的不是同一把锁，会导致线程不安全
                    synchronized(i){
                        i++;
                    }
                }
            });
            list.add(thread);
        }
        list.stream().forEach(thread -> thread.start());
        list.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        log.info("i=" + i);
    }


}
