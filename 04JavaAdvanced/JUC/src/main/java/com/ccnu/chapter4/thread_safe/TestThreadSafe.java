package com.ccnu.chapter4.thread_safe;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: chs
 * Description: 测试线程安全
 * CreateTime: 2024-08-03
 */
public class TestThreadSafe {
    static final int THREAD_NUM = 2;
    static final int LOOP_NUM = 500;

    public static void main(String[] args) {
        ThreadUnsafe threadUnsafe = new ThreadUnsafe();
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(() -> {
                threadUnsafe.method1(LOOP_NUM);
            }).start();
        }

    }

}
class ThreadUnsafe{
    List<Integer> list = new ArrayList<>();
    
    public void method1(int loopNumber){
        for (int i = 0; i < loopNumber; i++) {
            method2();
            method3();
        }
    }

    private void method2(){
        list.add(1);
    }
    private void method3(){
        list.remove(0);
    }
}
class ThreadSafe{
    public void method1(int loopNumber){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < loopNumber; i++) {
            method2(list);
            method3(list);
        }
    }

    private void method2(List<Integer> list){
        list.add(1);
    }
    private void method3(List<Integer> list){
        list.remove(0);
    }
}

