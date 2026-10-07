package com.ccnu.chapter8.custom_threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: chs
 * Description: 阻塞队列
 * CreateTime: 2024-08-11
 */
@Slf4j
public class BlockingQueue<T> {
    //任务队列
    private Deque<T> queue = new ArrayDeque<>();
    //锁
    private ReentrantLock lock = new ReentrantLock();
    //消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();
    //生产者条件变量
    private Condition fullWaitSet = lock.newCondition();
    //容量
    private int capacity;

    public BlockingQueue(int capacity){
        this.capacity = capacity;
    }

    //带超时阻塞获取
    public T poll(long timeout, TimeUnit timeUnit){
        log.debug("poll...");
        try {
            lock.lock();
            long nanos = timeUnit.toNanos(timeout);
            //如果队列为空则需要等待
            while(queue.isEmpty()){
                if(nanos <= 0){
                    return null;
                }
                try {
                    //返回值为剩余等待时间
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //从队首取出一个任务
            T task = queue.removeFirst();
            //通知生产者
            fullWaitSet.signal();
            //返回任务
            return task;
        } finally {
            lock.unlock();
        }
    }

    //阻塞获取
    public T take(){
        try {
            lock.lock();
            //如果队列为空则需要等待
            while(queue.isEmpty()){
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //从队首取出一个任务
            T task = queue.removeFirst();
            //通知生产者
            fullWaitSet.signal();
            //返回任务
            return task;
        } finally {
            lock.unlock();
        }
    }

    //带超时时间阻塞添加
    public boolean offer(T task, long timeout, TimeUnit timeUnit){
        try {
            lock.lock();
            long nanos = timeUnit.toNanos(timeout);
            //队列容量已满，需要等待
            while(queue.size() == capacity){
                if(nanos <= 0){
                    return false;
                }
                try {
                    log.debug("等待加入任务队列 {} {}", task, nanos);
                    //返回剩余等待时间
                    nanos = fullWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //将任务添加到队尾
            log.debug("加入任务队列 {}", task);
            queue.addLast(task);
            return true;
        } finally {
            lock.unlock();
        }
    }

    //阻塞添加
    public boolean put(T task){
        try {
            lock.lock();
            while(queue.size() == capacity){
                try {
                    log.debug("等待加入任务队列 {}", task);
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //将任务添加到队尾
            log.debug("加入任务队列 {}", task);
            queue.addLast(task);
            //通知消费者
            emptyWaitSet.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    //获取队列长度
    public int size(){
        try {
            lock.lock();
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    //尝试添加任务
    public void tryPut(RejectPolicy<T> rejectPolicy, T task){
        try {
            lock.lock();
            if(queue.size() == capacity){
                rejectPolicy.reject(this, task);
            }else{
                log.debug("加入任务队列 {}", task);
                queue.addLast(task);
                emptyWaitSet.signal();
            }
        } finally {
            lock.unlock();
        }
    }

}
