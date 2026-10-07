package com.ccnu.chapter8.custom_threadpool;

/**
 * Author: chs
 * Description: 拒绝策略
 * CreateTime: 2024-08-11
 */
@FunctionalInterface
public interface RejectPolicy<T> {
    void reject(BlockingQueue<T> queue, T task);
}
