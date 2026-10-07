package com.itheima.threadcontrol;

public class ThreadSleep extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i=0;i<100;i++){
            System.out.println(getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
