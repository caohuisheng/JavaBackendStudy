package com.ccnu.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Author: chs
 * Description: 原子数组
 * CreateTime: 2024-08-10
 */
public class AtomicArray {

    /**
     * @param arraySupplier 提供数组
     * @param lengthFun 获取数组长度的方法
     * @param putConsumer 自增方法，回传array, index
     * @param printConsumer 打印数组的方法
     * @param <T> 数组的类型
     */
    private static <T> void demo(
            Supplier<T> arraySupplier,
            Function<T, Integer> lengthFun,
            BiConsumer<T, Integer> putConsumer,
            Consumer<T> printConsumer){
        List<Thread> threads = new ArrayList<>();
        T array = arraySupplier.get();
        int length = lengthFun.apply(array);
        for (int i = 0; i < length; i++) {
            threads.add(new Thread(() -> {
                //每个线程对数组作1000次操作
                for(int j=0;j < 1000;j++){
                    putConsumer.accept(array, j%length);
                }
            }));
        }

        //启动所有线程
        threads.forEach(Thread::start);
        //等待所有线程结束
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        printConsumer.accept(array);
    }

    public static void main(String[] args) {
        //不安全的数组
        /*demo(
                () -> new int[10],
                (arr) -> arr.length,
                (arr, index) -> arr[index]++,
                (arr) -> System.out.println(Arrays.toString(arr))
        );*/

        //安全的数组
        demo(
                () -> new AtomicIntegerArray(10),
                (arr) -> arr.length(),
                (arr, index) -> arr.getAndIncrement(index),
                (arr) -> System.out.println(arr)
        );
    }
}

