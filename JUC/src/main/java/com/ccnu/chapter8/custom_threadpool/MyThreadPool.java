package com.ccnu.chapter8.custom_threadpool;

import jdk.nashorn.internal.ir.Block;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Author: chs
 * Description: 自定义线程池
 * CreateTime: 2024-08-11
 */
@Slf4j
public class MyThreadPool{
    private BlockingQueue<Runnable> taskQueue;
    private Set<Worker> workers = new HashSet<>();
    private int coreSize;
    private long timeout;
    private TimeUnit timeUnit;
    private RejectPolicy<Runnable> rejectPolicy;

    public MyThreadPool(int coreSize, long timeout, TimeUnit timeUnit, int queueCapacity, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockingQueue<>(queueCapacity);
        this.rejectPolicy = rejectPolicy;
    }

    public static void main(String[] args) {
        MyThreadPool threadPool = new MyThreadPool(1, 1000, TimeUnit.MILLISECONDS, 1, (queue, task) -> {
            //1.死等
            //queue.put(task);
            //2.带超时等待
            //queue.offer(task, 1500, TimeUnit.MILLISECONDS);
            //3.让调用者放弃任务执行
            //log.debug("放弃：{}", task);
            //4.让调用者自己执行
            task.run();
        });
        for (int i = 1; i <= 4; i++) {
            int j = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("task{} end...", j);
            });
        }
    }

    //执行任务
    public void execute(Runnable task){
        synchronized(workers){
            //当任务数没有超过coreSize时，创建一个worker线程执行任务；否则添加到任务队列
            if(workers.size() < coreSize){
                Worker worker = new Worker(task);
                log.debug("新增worker:{} task:{}", worker, task);
                workers.add(worker);
                worker.start();
            }else{
                //1）死等
                //2）带超时等待
                //3）让调用者放弃任务执行
                //4）让调用者抛出异常
                //5）让调用者自己执行任务
                taskQueue.tryPut(rejectPolicy, task);
            }
        }
    }

    class Worker extends Thread{
        private Runnable task;

        public Worker(Runnable task){
            this.task = task;
        }

        @Override
        public void run() {
            while(task != null || ((task = taskQueue.poll(timeout,timeUnit)) != null)){
                try {
                    log.debug("正在执行 {}", task);
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    task = null;
                }
            }
            synchronized(workers){
                log.debug("移除worker：{}", this);
                workers.remove(this);
            }
        }
    }

}
