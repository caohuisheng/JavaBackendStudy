package com.ccnu.chapter3;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: chs
 * Description: 两阶段终止测试
 * CreateTime: 2024-07-28
 */
@Slf4j
public class TwoPhaseStopTest {
    private Thread thread;

    public void start(){
        thread = new Thread(() -> {
            while(true){
                boolean interrupted = Thread.currentThread().isInterrupted();
                if(interrupted){
                    log.info("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.info("将结果保存");
                } catch (InterruptedException e) {
                    //终止正在sleep的线程会清除标记，需要重新终止线程
                    Thread.currentThread().interrupt();
                }
            }
        },"监控线程");
        thread.start();
    }

    public void stop(){
        thread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseStopTest twoPhaseStopTest = new TwoPhaseStopTest();
        twoPhaseStopTest.start();
        Thread.sleep(3000);
        log.info("stop");
        twoPhaseStopTest.stop();
    }
}
