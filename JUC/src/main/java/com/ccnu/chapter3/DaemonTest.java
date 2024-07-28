package com.ccnu.chapter3;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: chs
 * Description: 守护线程测试
 * CreateTime: 2024-07-28
 */
@Slf4j
public class DaemonTest {
    public static void main(String[] args) {
        log.info("start...");
        Thread t1 = new Thread(() -> {
            log.info("start...");
            Sleeper.sleep(2);
            log.info("end...");
        }, "daemon");
        //设置线程为守护线程, 会跟随主线程停止
        t1.setDaemon(true);
        t1.start();

        Sleeper.sleep(1);
        log.info("end...");
    }
}
