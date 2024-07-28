package com.ccnu.chapter3;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: chs
 * Description: join测试
 * CreateTime: 2024-07-28
 */
@Slf4j
public class JoinTest {
    static int res1 = 0;
    static int res2 = 0;
    public static void main(String[] args) throws InterruptedException{
        //test1();
        //test2();
        test3();
    }

    static void test1() throws InterruptedException{
        Thread t1 = new Thread(() -> {
            Sleeper.sleep(1);
            res1 = 1;
        });
        t1.start();
        //等待t1执行结束
        t1.join();
        log.info("结果：" + res1);
    }

    //等待多个线程
    static void test2() throws InterruptedException{
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            Sleeper.sleep(1);
            res1 = 1;
        });
        Thread t2 = new Thread(() -> {
            Sleeper.sleep(2);
            res2 = 2;
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        log.info("r1:{} r2:{} cost:{}ms", res1, res2, (end-start));
    }

    //有时效的join
    static void test3() throws InterruptedException{
        Thread t1 = new Thread(() -> {
            Sleeper.sleep(2);
            res1 = 1;
        });
        t1.start();
        //等待t1执行结束,只等待了1.5s
        t1.join(1500);
        log.info("结果：" + res1); //0
    }
}
