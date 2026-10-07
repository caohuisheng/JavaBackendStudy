package com.itheima.quickstart;

public class MyThread extends Thread {
    public MyThread(){}

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        super.run();
        for (int i=0;i<100;i++){
            System.out.println(getName()+":"+i);
        }
    }
}
