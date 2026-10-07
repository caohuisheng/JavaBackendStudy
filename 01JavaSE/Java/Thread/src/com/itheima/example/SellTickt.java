package com.itheima.example;

public class SellTickt {
    public static void main(String[] args) {
        ThreadTicket runnable = new ThreadTicket();

        Thread thread1 = new Thread(runnable,"窗口1");
        Thread thread2 = new Thread(runnable,"窗口2");
        Thread thread3 = new Thread(runnable,"窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
