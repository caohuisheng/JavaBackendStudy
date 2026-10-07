package com.itheima.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTicket implements Runnable{
    //票的总数
    private int ticket_num = 50;
    //锁对象
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            //加锁
            lock.lock();
            if (ticket_num > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":出售票" + ticket_num);
                ticket_num--;
            }
            //释放锁
            lock.unlock();
        }
    }

}
