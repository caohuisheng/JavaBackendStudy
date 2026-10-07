package com.itheima.example;

public class ThreadTicket implements Runnable{
    //票的总数
    private int ticket_num = 50;
    //锁对象
    private Object obj = new Object();
    int x = 0;

    /*同步代码块
    @Override
    public void run() {
        while(true){
            //给售票的代码块加锁
            synchronized(obj){
                if(ticket_num>0){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":出售票"+ticket_num);
                    ticket_num--;
                }
            }
        }
    }
     */

    @Override
    public void run() {
        while(true){
            if(x%2==0){
                synchronized(this) {
                    if (ticket_num > 0) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ":出售票" + ticket_num);
                        ticket_num--;
                    }
                }
            }else{
                sellTicket();
            }
            x++;
        }
    }

    /*
    同步方法
     */
    public synchronized void sellTicket(){
        if(ticket_num>0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":出售票"+ticket_num);
            ticket_num--;
        }
    }
}
