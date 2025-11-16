package cn.itcast.n3;

public class TestCpu {
    public static void main(String[] args) {
        Thread t1=new Thread(() -> {
            System.out.println(Thread.currentThread().getId()+":hello");
        },"t1");
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getId()+":hello");
        },"t2");
        System.out.println("begin");
        t1.start();
        t2.start();
        System.out.println("end");
    }
}
