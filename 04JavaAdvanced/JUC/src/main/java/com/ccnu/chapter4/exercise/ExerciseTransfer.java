package com.ccnu.chapter4.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * Author: chs
 * Description: 转账测试
 * CreateTime: 2024-08-03
 */
@Slf4j
public class ExerciseTransfer {
    //Random为线程安全的
    static Random random = new Random();
    private static int randomAmount(){
        return random.nextInt(5) + 1;
    }
    
    public static void main(String[] args) {
        Account a = new Account(1000);
        Account b = new Account(1000);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                a.transfer(b, randomAmount());
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                b.transfer(a, randomAmount());
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("money_a=" + a.getMoney() + " money_b=" + b.getMoney());
    }

    static class Account{
        private int money;
        private static Object lock = new Object();

        public Account(int money){
            this.money = money;
        }

        public int getMoney(){
            return this.money;
        }

        public void setMoney(int newMoney){
            this.money = newMoney;
        }

        public void transfer(Account target,int amount){
            //由于存在两个账户，需要锁住类
            synchronized(lock){
                if(this.money >= amount){
                    this.money = this.money - amount;
                    target.setMoney(target.getMoney() + amount);
                }
            }
        }
    }
}
