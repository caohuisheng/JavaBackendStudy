package com.ccnu.chapter4.dead_lock;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: chs
 * Description: 哲学家就餐问题
 * CreateTime: 2024-08-04
 */
@Slf4j
public class Philosopher extends Thread{
    private Chopstick left;
    private Chopstick right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        synchronized (left){ //获得左手筷子
            log.info("get left");
            Sleeper.sleep(0.5);
            synchronized (right){ //获得右手筷子
                log.info("get right");
                log.info("eating...");
            }
        }
    }

    public static void main(String[] args) {
        Chopstick c1 = new Chopstick("1");
        Chopstick c2 = new Chopstick("2");
        Chopstick c3 = new Chopstick("3");
        Chopstick c4 = new Chopstick("4");
        Chopstick c5 = new Chopstick("5");
        new Philosopher("苏格拉底",c1,c2).start();
        new Philosopher("柏拉图",c2,c3).start();
        new Philosopher("亚里士多德",c3,c4).start();
        new Philosopher("赫拉克利特",c4,c5).start();
        new Philosopher("阿基米德",c5,c1).start();
    }

    static class Chopstick{
        String name;

        public Chopstick(String name){
            this.name = name;
        }
    }
}
