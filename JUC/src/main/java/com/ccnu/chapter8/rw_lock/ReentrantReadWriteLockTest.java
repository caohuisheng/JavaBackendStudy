package com.ccnu.chapter8.rw_lock;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author: chs
 * Description: 读写锁
 * CreateTime: 2024-08-17
 */
@Slf4j
public class ReentrantReadWriteLockTest {
    private Object data;
    //数据是否有效标记
    private volatile boolean cacheValid = false;
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = rw.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = rw.writeLock();

    private Object read(){
        log.info("获取读锁");
        readLock.lock();
        try {
            log.info("读取...");
            Sleeper.sleep(1);
            return data;
        } finally {
            log.info("释放读锁");
            readLock.unlock();
        }
    }

    private void write(){
        log.info("获取写锁");
        writeLock.lock();
        try {
            log.info("写入...");
            Sleeper.sleep(1);
        } finally {
            log.info("释放写锁");
            writeLock.unlock();
        }
    }

    //测试读锁-读锁可以并发
    private void test1(){
        new Thread(() -> {
            read();
        }).start();
        new Thread(() -> {
            read();
        }).start();
    }

    //测试读锁-写锁不能并发
    private void test2(){
        new Thread(() -> {
            read();
        }).start();
        new Thread(() -> {
            write();
        }).start();
    }

    //测试写锁可以降级为读锁（重入时降级支持）
    private void test3(){
        readLock.lock();
        if(!cacheValid){
            //获取写锁前必须释放读锁
            readLock.unlock();
            writeLock.lock();
            try {
                //判断是否有其它线程已经获取到写锁、更新了缓存，避免重复更新
                if(!cacheValid){
                    data = new Object();
                    cacheValid = true;
                }
                //降级为读锁，释放写锁
                readLock.lock();
            } finally {
                writeLock.unlock();
            }
        }

        try{
            //读取数据
            System.out.println(data);
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockTest t = new ReentrantReadWriteLockTest();
        //t.test1();
        //t.test2();
        t.test3();
    }
}
