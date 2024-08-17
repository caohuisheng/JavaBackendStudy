package com.ccnu.chapter8;

import com.ccnu.utils.Sleeper;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-08-17
 */
public class CopyOnWriteTest {
    private static void test1(){
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int x = i;
            Thread thread = new Thread(() -> {
                list.add(x);
            });
            ts.add(thread);
        }
        ts.forEach(Thread::start);
        ts.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(list);
    }

    //迭代器弱一致性
    private static void test2(){
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iter = list.iterator();
        new Thread(() -> {
            list.remove(0);
            System.out.println(list);
        }).start();

        Sleeper.sleep(1);
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    public static void main(String[] args) {
        //test1();
        test2();
    }
}
