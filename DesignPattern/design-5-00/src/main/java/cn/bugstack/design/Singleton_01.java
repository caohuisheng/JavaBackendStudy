package cn.bugstack.design;

/**
 * Author: chs
 * Description: 懒汉模式（线程不安全）
 * CreateTime: 2024-10-07
 */
public class Singleton_01 {

    private static Singleton_01 instance;

    private Singleton_01(){}

    //多线程下可能创建多个实例
    public static Singleton_01 getInstance(){
        if(null != instance) return instance;
        instance = new Singleton_01();
        return instance;
    }

}
