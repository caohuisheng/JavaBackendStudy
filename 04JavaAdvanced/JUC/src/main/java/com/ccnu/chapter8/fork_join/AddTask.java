package com.ccnu.chapter8.fork_join;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Author: chs
 * Description: fork_join测试
 * CreateTime: 2024-08-11
 */
@Slf4j
public class AddTask extends RecursiveTask<Integer> {
    private int begin;
    private int end;

    public AddTask(int begin,int end){
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("{%d,%d}", begin, end);
    }

    @Override
    protected Integer compute() {
        if(begin == end){
            return begin;
        }
        int mid = (begin + end)/2;
        AddTask task1 = new AddTask(begin, mid);
        task1.fork();
        AddTask task2 = new AddTask(mid+1, end);
        task2.fork();
        log.info("fork {} + {} = ?", task1, task2);

        int result = task1.join() + task2.join();
        log.info("join {} + {} = {}", task1, task2, result);
        return result;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        Integer result = pool.invoke(new AddTask(1, 10));
        log.info("{}",result);
    }
}
