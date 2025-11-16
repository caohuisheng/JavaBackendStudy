package cn.itcast.n6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestAtomArray {

    <T> void changeArray(
            Supplier<T> arraySupplier,
            Function<T,Integer> lengthFunction,
            BiConsumer<T,Integer> putConsumer,
            Consumer<T> printConsumer
    ){
        List<Thread> threads = new ArrayList<>();
        T array = arraySupplier.get();
        int length = lengthFunction.apply(array);
        //创建数组长度的线程
        for(int i=0;i<length;i++){
            threads.add(new Thread(()->{
                //每个线程队数组进行1000次操作
                for(int k=0;k<1000;k++){
                    putConsumer.accept(array,k%length);
                }
            }));
        }
        threads.forEach(Thread::start);
        threads.forEach(thread->{
            try{
                thread.join();
            }catch(InterruptedException e){}
        });
        printConsumer.accept(array);
    }

    void test(){
        changeArray(
                ()->new int[10],
                arr->arr.length,
                (arr,index)->arr[index]++,
                arr-> System.out.println(Arrays.toString(arr))
        );
    }

    void test2(){
        changeArray(
                ()->new AtomicIntegerArray(10),
                AtomicIntegerArray::length,
                AtomicIntegerArray::getAndIncrement,
                System.out::println
        );
    }

    public static void main(String[] args) {
        new TestAtomArray().test2();
    }
}
