package com.ccnu.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Author: chs
 * Description: 原子累加器
 * CreateTime: 2024-08-10
 */
public class AtomicAdder {

    static <T> void demo(Supplier<T> adderSupplier, Consumer<T> action){
        T adder = adderSupplier.get();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(() -> {
                //每个线程累加10000次
                for (int j = 0; j < 50000; j++) {
                    action.accept(adder);
                }
            }));
        }

        long start = System.nanoTime();
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(adder + " cost:" + (end-start)/1000_000 + "ms");
    }

    public static void main(String[] args) {
        demo(
                () -> new LongAdder(),
                adder -> adder.increment()
        ); //33ms
        demo(
                () -> new AtomicLong(),
                adder -> adder.getAndIncrement()
        ); //135ms
    }
}
