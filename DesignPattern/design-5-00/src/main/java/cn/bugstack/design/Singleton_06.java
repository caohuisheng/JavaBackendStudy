package cn.bugstack.design;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Author: chs
 * Description: CAS（线程安全）
 * CreateTime: 2024-10-07
 */
public class Singleton_06 {

    private static final AtomicReference<Singleton_06> INSTANCE = new AtomicReference<>();

    private Singleton_06(){}

    public static Singleton_06 getInstance(){
        for(;;){
            Singleton_06 instance = INSTANCE.get();
            if(null != instance) return instance;
            boolean success = INSTANCE.compareAndSet(null, new Singleton_06());
            if(success) return INSTANCE.get();
        }
    }

}
