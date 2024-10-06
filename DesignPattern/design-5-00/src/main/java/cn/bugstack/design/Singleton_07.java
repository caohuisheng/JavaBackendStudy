package cn.bugstack.design;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Author: chs
 * Description: 枚举单例（线程安全）
 * CreateTime: 2024-10-07
 */
public enum Singleton_07 {

    INSTANCE;

    public void test(){
        System.out.println("Hello,world!");
    }

}
