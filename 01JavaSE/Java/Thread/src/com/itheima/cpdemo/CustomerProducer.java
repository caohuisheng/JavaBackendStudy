package com.itheima.cpdemo;

public class CustomerProducer {
    public static void main(String[] args) {
        //创建Box奶箱对象
        Box box = new Box();

        //创建Producer和Customer线程
        Producer p = new Producer(box);
        Customer c = new Customer(box);
        Thread producer = new Thread(p);
        Thread customer = new Thread(c);

        producer.start();
        customer.start();
    }
}
