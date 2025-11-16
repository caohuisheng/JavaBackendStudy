package cn.itcast.n3;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j(topic = "c.TestYield")
public class TestYield {
    public static void main(String[] args) {
        AtomicInteger count1 = new AtomicInteger();
        AtomicInteger count2 = new AtomicInteger();
        Runnable task1 = () -> {
            for (;;) {
                count1.incrementAndGet();
            }
        };
        Runnable task2 = () -> {
            for (;;) {
                Thread.yield();
                count2.incrementAndGet();
            }
        };
        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        // t1.setPriority(Thread.MAX_PRIORITY);
        // t2.setPriority(Thread.MIN_PRIORITY);
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
            // t1.start();
            // t2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count1=" + count1.get());
        System.out.println("count2=" + count2.get());
    }

}
