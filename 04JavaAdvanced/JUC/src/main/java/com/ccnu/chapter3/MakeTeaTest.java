package com.ccnu.chapter3;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: chs
 * Description: 烧水泡茶案例
 * CreateTime: 2024-07-28
 */
@Slf4j
public class MakeTeaTest {

    public static void main(String[] args) {
        //new S2().makeTea();
        new S3().makeTea();
    }

    /**
     * 小王准备号茶叶后等待老王，老王烧好水后，小王开始泡茶
     */
    static class S1{
        public void makeTea(){
            Thread t1 = new Thread(() -> {
                log.info("洗水壶");
                Sleeper.sleep(1);
                log.info("烧开水");
                Sleeper.sleep(5);
            },"老王");
            Thread t2 = new Thread(() -> {
                log.info("洗茶壶");
                Sleeper.sleep(1);
                log.info("洗茶杯");
                Sleeper.sleep(2);
                log.info("拿茶叶");
                Sleeper.sleep(1);
                try {
                    t1.join();
                    log.info("泡茶");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"小王");

            t1.start();
            t2.start();
        }
    }

    /**
     * 老王和小王完成自己的事情后通知对方，都可以泡茶
     */
    static class S2{
        private String watter = "冷水";
        private String tea = null;
        private final Object lock = new Object();
        private boolean maked = false;

        public void makeTea() {
            Thread t1 = new Thread(() -> {
                log.info("洗水壶");
                Sleeper.sleep(1);
                log.info("烧开水");
                Sleeper.sleep(5);
                synchronized (lock) {
                    watter = "开水";
                    //通知小王开水烧好了
                    lock.notifyAll();
                    //等待茶叶准备好
                    while (tea == null) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!maked) {
                        log.info("拿{}泡{}", watter, tea);
                        maked = true;
                    }
                }
            }, "老王");
            Thread t2 = new Thread(() -> {
                log.info("洗茶壶");
                Sleeper.sleep(1);
                log.info("洗茶杯");
                Sleeper.sleep(2);
                log.info("拿茶叶");
                Sleeper.sleep(1);
                synchronized (lock) {
                    tea = "花茶";
                    //通知老王茶叶准备好了
                    lock.notifyAll();
                    //等待热水烧好
                    while (watter.equals("冷水")) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!maked) {
                        log.info("拿{}泡{}", watter, tea);
                        maked = true;
                    }
                }
            }, "小王");

            t1.start();
            t2.start();
        }
    }

    static class S3{
        private String watter = "冷水";
        private String tea = null;
        private final Object lock = new Object();

        public void makeTea(){
            new Thread(() -> {
                log.info("洗水壶");
                Sleeper.sleep(1);
                log.info("烧开水");
                Sleeper.sleep(5);
                synchronized(lock){
                    watter = "开水";
                    lock.notifyAll();
                }
            },"老王").start();

            new Thread(() -> {
                log.info("洗茶壶");
                Sleeper.sleep(1);
                log.info("洗茶杯");
                Sleeper.sleep(2);
                log.info("拿茶叶");
                Sleeper.sleep(1);
                synchronized (lock){
                    tea = "花茶";
                    lock.notifyAll();
                }
            },"小王").start();

            new Thread(() -> {
                while(watter.equals("冷水") || tea == null){
                    synchronized(lock){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        log.info("拿{}泡{}",watter, tea);
                    }
                }
            },"王夫人").start();
        }
    }

}
