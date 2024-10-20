package cn.bugstack.design;

/**
 * Author: chs
 * Description: 内部类懒加载（线程安全）
 * CreateTime: 2024-10-07
 */
public class Singleton_04 {

    private static class SingletonHolder{
        private static Singleton_04 instance = new Singleton_04();
    }

    public static Singleton_04 getInstance(){
        return SingletonHolder.instance;
    }

}
