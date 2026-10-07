package com.ccnu.chapter4.wait_notify;

import com.ccnu.chapter4.exercise.ExerciseSell;
import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: chs
 * Description: 工作场景练习(小南需要有烟才能工作，其他人不需要，送烟的人到了后小南可以开始工作)
 * CreateTime: 2024-08-03
 */
@Slf4j
public class ExerciseWork {
    private static final Object room = new Object();
    private static boolean hasCigarette = false;
    private static boolean hasTakeout = false;

    /**
     * 没烟时，小南使用sleep睡眠，直到烟送到开始干活，但是睡眠时其它干活的线程也无法工作
     */
    private void test1(){
        new Thread(() -> {
            synchronized(room){
                log.info("有烟没[{}]", hasCigarette);
                if(!hasCigarette){
                    Sleeper.sleep(2);
                }
                log.info("有烟没[{}]", hasCigarette);
                if(hasCigarette){
                    log.info("可以开始干活了");
                }
            }
        }, "小南").start();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized(room){
                    log.info("可以开始干活了");
                }
            },"其它人").start();
        }

        Sleeper.sleep(1);
        new Thread(() -> {
            hasCigarette = true;
            log.info("烟送到了");
        });
    }

    /**
     * 没烟时，小南使用wait等待，当烟送到时notify通知小南，小南可以开始干活
     */
    public void test2(){
        new Thread(() -> {
            synchronized(room){
                log.info("有烟没[{}]", hasCigarette);
                if(!hasCigarette){
                    try {
                        room.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("有烟没[{}]", hasCigarette);
                if(hasCigarette){
                    log.info("可以开始干活了");
                }
            }
        }, "小南").start();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized(room){
                    log.info("可以开始干活了");
                }
            },"其它人").start();
        }

        Sleeper.sleep(1);
        new Thread(() -> {
            synchronized(room){
                hasCigarette = true;
                log.info("烟送到了");
                //烟送到后通知小南
                room.notify();
            }
        },"送烟的").start();
    }

    /**
     * 没烟时，小南使用wait等待，当烟送到时notifyAl通知所有等待的线程
     */
    public void test3(){
        new Thread(() -> {
            synchronized(room){
                log.info("有烟没[{}]", hasCigarette);
                if(!hasCigarette){
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("有烟没[{}]", hasCigarette);
                if(hasCigarette){
                    log.info("开始干活了");
                }else{
                    log.info("没干成活");
                }
            }
        },"小南").start();

        new Thread(() -> {
            synchronized(room){
                log.info("有外卖没[{}]",hasTakeout);
                if(!hasTakeout){
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("有外卖没[{}]",hasTakeout);
                if(hasTakeout){
                    log.info("开始干活了");
                }else{
                    log.info("没干成活");
                }
            }
        },"小女").start();

        Sleeper.sleep(1);
        new Thread(() -> {
            synchronized(room){
                hasTakeout = true;
                log.info("外卖送到了");
                room.notifyAll();
            }
        },"送外卖的").start();
    }

    /**
     * 没烟时，小南使用wait等待，当外卖送到时notifyAll通知所有线程，如果烟仍未送到，小南仍wait
     */
    public void test4(){
        new Thread(() -> {
            synchronized(room){
                log.info("有烟没[{}]", hasCigarette);
                while(!hasCigarette){
                    log.info("没烟，先歇会儿");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("有烟没[{}]", hasCigarette);
                if(hasCigarette){
                    log.info("开始干活了");
                }else{
                    log.info("没干成活");
                }
            }
        },"小南").start();

        new Thread(() -> {
            synchronized(room){
                log.info("有外卖没[{}]",hasTakeout);
                if(!hasTakeout){
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("有外卖没[{}]",hasTakeout);
                if(hasTakeout){
                    log.info("开始干活了");
                }else{
                    log.info("没干成活");
                }
            }
        },"小女").start();

        Sleeper.sleep(1);
        new Thread(() -> {
            synchronized(room){
                hasTakeout = true;
                log.info("外卖送到了");
                room.notifyAll();
            }
        },"送外卖的").start();
    }

    public static void main(String[] args) {
        //new ExerciseWork().test1();
        //new ExerciseWork().test2();
        //new ExerciseWork().test3();
        new ExerciseWork().test4();
    }
}
