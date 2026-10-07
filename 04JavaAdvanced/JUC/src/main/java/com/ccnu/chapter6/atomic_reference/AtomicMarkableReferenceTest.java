package com.ccnu.chapter6.atomic_reference;

import com.ccnu.utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-08-10
 */
@Slf4j
public class AtomicMarkableReferenceTest {
    static class GarbageBag{
        private String desc;
        public GarbageBag(String desc){
            this.desc = desc;
        }

        public void setDesc(String desc){
            this.desc = desc;
        }

        @Override
        public String toString() {
            return super.toString() + " " + this.desc;
        }
    }

    public static void main(String[] args) {
        GarbageBag bag = new GarbageBag("装满了垃圾");
        AtomicMarkableReference<GarbageBag> ref = new AtomicMarkableReference<GarbageBag>(bag, true);

        GarbageBag prev = ref.getReference();
        log.info("prev:" + prev.toString());

        new Thread(() -> {
            log.info("清洁工开始更换垃圾袋...");
            GarbageBag prev_ref = ref.getReference();
            log.info("prev:" + prev_ref);
            ref.compareAndSet(bag, new GarbageBag("空垃圾袋"), true, false);
        }).start();

        Sleeper.sleep(1);
        log.info("主线程想要换一个新垃圾袋");
        boolean success = ref.compareAndSet(prev, new GarbageBag("空垃圾袋"), true, false);
        log.info("更换结果：{}", success);

        log.info(ref.getReference().toString());
    }

}
