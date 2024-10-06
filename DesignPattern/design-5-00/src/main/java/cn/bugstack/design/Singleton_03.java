package cn.bugstack.design;

/**
 * Author: chs
 * Description: 饿汉模式（线程安全）
 * CreateTime: 2024-10-07
 */
public class Singleton_03 {

    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03(){}

    public static Singleton_03 getInstance(){
        return instance;
    }

}
