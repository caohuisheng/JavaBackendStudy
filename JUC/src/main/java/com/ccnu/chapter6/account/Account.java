package com.ccnu.chapter6.account;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: chs
 * Description: 账户接口
 * CreateTime: 2024-08-10
 */
public abstract class Account {

    public abstract Integer getBalance();

    public abstract void withdraw(Integer amount);

    public void demo(){
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(() -> {
                this.withdraw(10);
            }));
        }
        long start = System.nanoTime();
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(this.getBalance() + " cost:" + (end - start)/1000_000 + "ms");
    }

}
