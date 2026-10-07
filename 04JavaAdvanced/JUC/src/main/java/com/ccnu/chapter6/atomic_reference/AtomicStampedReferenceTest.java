package com.ccnu.chapter6.atomic_reference;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Author: chs
 * Description: AtomicStampedReference测试
 * CreateTime: 2024-08-10
 */
@Slf4j
public class AtomicStampedReferenceTest {
    private static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

    public static void main(String[] args) {
        String prev = ref.getReference();
        int stamp = ref.getStamp();
        log.info("版本：{}", stamp);
        other();
        Sleeper.sleep(1);
        boolean success = ref.compareAndSet(prev, "C", stamp, stamp + 1);
        log.info("change A->C {}", success);
    }

    private static void other(){
        new Thread(() -> {
            String prev = ref.getReference();
            int stamp = ref.getStamp();
            boolean success = ref.compareAndSet(prev, "B", stamp, stamp+1);
            log.info("change A->B {}, 更新版本为：{}", success, ref.getStamp());
        }).start();
        Sleeper.sleep(0.5);
        new Thread(() -> {
            String prev = ref.getReference();
            int stamp = ref.getStamp();
            boolean success = ref.compareAndSet(prev, "A", stamp, stamp+1);
            log.info("change B->A {}, 更新版本为：{}", success, ref.getStamp());
        }).start();
    }

}
