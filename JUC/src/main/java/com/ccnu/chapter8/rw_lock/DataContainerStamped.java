package com.ccnu.chapter8.rw_lock;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.StampedLock;

/**
 * Author: chs
 * Description: 测试StampedLock
 * CreateTime: 2024-08-17
 */
@Slf4j
public class DataContainerStamped {
    private StampedLock lock = new StampedLock();
    private int data = 0;

    private void read(){
        //尝试乐观读
        long stamp = lock.tryOptimisticRead();
        log.info("optimistic read locking...{}",stamp);
        //进行戳校验，如果通过则没有其它线程修改国数据
        if(lock.validate(stamp)){
            Sleeper.sleep(1);
            log.info("read finish...{} data:{}", stamp, data);
            return;
        }

        //升级为读锁
        log.info("update to read lock...");
        stamp = lock.readLock();
        try {
            log.info("read lock {}",stamp);
            Sleeper.sleep(1);
            log.info("read finish...{} data:{}", stamp, data);
            return;
        } finally {
            log.info("read unlock {}", stamp);
            lock.unlock(stamp);
        }
    }

    private void write(){
        long stamp = lock.writeLock();
        log.info("write lock {}", stamp);
        try {
            Sleeper.sleep(2);
            data = 10;
        } finally {
            log.info("write unlock {}",stamp);
            lock.unlock(stamp);
        }
    }

    //测试读-写（乐观读需要升级为读锁）
    private void test1(){
        new Thread(() -> {
            read();
        }).start();
        new Thread(() -> {
            write();
        }).start();
    }

    //测试读-读（直接使用乐观读即可）
    private void test2(){
        new Thread(() -> {
            read();
        }).start();
        new Thread(() -> {
            read();
        }).start();
    }

    public static void main(String[] args) {
        DataContainerStamped t = new DataContainerStamped();
        //t.test1();
        t.test2();
    }
}
