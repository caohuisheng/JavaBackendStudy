package com.itheima.threadcontrol;

public class ThreadControl {
    public static void main(String[] args) {
        //threadSleep();
        //threadJoin();
        ThreadDaemon();
    }

    /*
    线程休眠
     */
    static void threadSleep(){
        ThreadSleep thread1 = new ThreadSleep();
        ThreadSleep thread2 = new ThreadSleep();
        ThreadSleep thread3 = new ThreadSleep();

        thread1.setName("曹操");
        thread2.setName("关羽");
        thread3.setName("刘备");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    /*
    等待线程死亡
     */
    static void threadJoin()  {
        ThreadJoin thread1 = new ThreadJoin();
        ThreadJoin thread2 = new ThreadJoin();
        ThreadJoin thread3 = new ThreadJoin();

        thread1.setName("康熙");
        thread2.setName("四阿哥");
        thread3.setName("八阿哥");

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        thread3.start();
    }

    static void ThreadDaemon(){
        ThreadDaemon thread1 = new ThreadDaemon();
        ThreadDaemon thread2 = new ThreadDaemon();
        thread1.setName("关羽");
        thread1.setName("张飞");

        //设置当前线程为主线程
        Thread.currentThread().setName("刘备");

        //设置守护线程
        thread1.setDaemon(true);
        thread2.setDaemon(true);

        thread1.start();
        thread2.start();

        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
