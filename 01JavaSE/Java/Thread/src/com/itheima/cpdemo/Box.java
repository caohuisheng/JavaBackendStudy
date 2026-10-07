package com.itheima.cpdemo;

public class Box {
    //牛奶的编号
    private int milk;
    //奶箱的状态
    private Boolean status = false;

    /*
    放入牛奶
     */
    public synchronized void put(int milk){
        //如果奶箱已经有牛奶，就等待
        if(status){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有牛奶，就放入牛奶
        this.milk = milk;
        System.out.println("送奶工放入牛奶："+milk);
        //修改状态
        status = true;
        //唤醒等待对象的其它线程
        notifyAll();
    }

    public synchronized void get(){
        //如果奶箱没有牛奶，就等待
        if(!status){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果奶箱已经有牛奶，就拿牛奶
        System.out.println("用户拿到牛奶："+milk);
        //修改状态
        status = false;
        //唤醒等待对象的其它线程
        notifyAll();
    }
}
