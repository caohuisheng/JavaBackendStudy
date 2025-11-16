package cn.itcast.n5;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Singleton")
public final class Singleton {
    private Singleton() {
    }

    private static volatile Singleton INSTANCE = null;

    public static Singleton getInstance() {
        // 实例没创建，才会进入内部的 synchronized代码块
        /*if (INSTANCE == null) {
            synchronized (Singleton.class) {
                // 也许有其它线程已经创建实例，所以再判断一次
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;*/

        synchronized (Singleton.class) {
            // 也许有其它线程已经创建实例，所以再判断一次
            if (INSTANCE == null) {
                INSTANCE = new Singleton();
            }
            return INSTANCE;
        }
    }

    public static void main(String[] args) {
        log.debug("start...");
        for(int i=0;i<10;i++){
            new Thread(()->{
                //System.out.println(Singleton.getInstance());
                log.debug("instance:{}",Singleton.getInstance());
            }).start();
        }
    }
}
