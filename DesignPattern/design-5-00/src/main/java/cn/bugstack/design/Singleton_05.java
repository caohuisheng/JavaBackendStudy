package cn.bugstack.design;

/**
 * Author: chs
 * Description: 双重检验锁（线程安全）
 * CreateTime: 2024-10-07
 */
public class Singleton_05 {

    private static Singleton_05 instance;

    private Singleton_05(){}

    public static Singleton_05 getInstance(){
        if(null != instance) return instance;
        synchronized(Singleton_05.class){
            if(null == instance) {
                instance = new Singleton_05();
            }
        }
        return instance;
    }

}
