package com.itheima.cpdemo;

public class Producer implements Runnable{
    private Box box;

    public Producer(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        //从奶箱放入30瓶牛奶
        for(int i=1;i<=30;i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            box.put(i);
        }
    }
}
