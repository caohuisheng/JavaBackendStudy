package cn.bugstack.design;

/**
 * Author: chs
 * Description: 懒汉模式（线程安全）
 * CreateTime: 2024-10-07
 */
public class Singleton_02 {

    private static Singleton_02 instance;

    private Singleton_02(){}

    //使用synchronized关键字保证同一时刻只有一个线程进入，最多创建一个实例
    public synchronized static Singleton_02 getInstance(){
        if(null != instance) return instance;
        instance = new Singleton_02();
        return instance;
    }

}
