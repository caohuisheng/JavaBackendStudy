package cn.itcast.n3;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestFrames")
public class TestFrames {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                log.debug(Thread.currentThread() + " start");
                TestFrames.sleep(1);
                // method1(1);
                method3();
            }
        };
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                log.debug(Thread.currentThread() + " start");
                TestFrames.sleep(2);
                // method1(2);
                method3();
            }
        };
        t2.setName("t2");
        t2.start();
        log.debug(Thread.currentThread() + " end");
    }

    private static void method3() {
        for (int i = 0; i < 100000; i++) {
            TestFrames.sleep(1);
            log.debug(""+i);
        }
    }

    private static void method1(int x) {
        Object m = method2();
        log.debug(x + " " + m);
    }

    private static Object method2() {
        Object n = new Object();
        return n;
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
