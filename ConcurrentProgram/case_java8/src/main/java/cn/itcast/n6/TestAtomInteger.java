package cn.itcast.n6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomInteger {
    AtomicInteger x = new AtomicInteger(0);
    int y = 0;

    void test2(){
        List<Thread> threadList = new ArrayList<>();
        for(int i=0;i<3000;i++){
            threadList.add(new Thread(()->{
                y++;
            }));
        }
        threadList.forEach(Thread::start);
        threadList.forEach(thread->{
            try{
                thread.join();
            }catch(InterruptedException e){}
        });
        System.out.println(y);
    }

    void test(){
        List<Thread> threadList = new ArrayList<>();
        for(int i=0;i<1000;i++){
            threadList.add(new Thread(()->{
                x.getAndAdd(1);
            }));
        }
        threadList.forEach(Thread::start);
        threadList.forEach(thread->{
            try{
                thread.join();
            }catch(InterruptedException e){}
        });
        System.out.println(x.get());
    }

    public static void main(String[] args) {
        new TestAtomInteger().test2();
    }
}
