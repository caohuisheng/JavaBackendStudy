package com.ccnu.chapter8;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * Author: chs
 * Description: 测试Semaphore
 * CreateTime: 2024-08-17
 */
@Slf4j
public class SemaphoreTest {

    public static void main(String[] args) {
        //创建semaphore对象
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    //获取许可
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    log.info("running...");
                    Sleeper.sleep(1);
                    log.info("end...");
                } finally {
                    //释放许可
                    semaphore.release();
                }
            }).start();
        }
    }

}
