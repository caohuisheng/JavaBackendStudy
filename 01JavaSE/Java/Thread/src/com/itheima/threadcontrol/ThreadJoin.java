package com.itheima.threadcontrol;

public class ThreadJoin extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i=0;i<100;i++){
            System.out.println(getName()+":"+i);
        }
    }
}
