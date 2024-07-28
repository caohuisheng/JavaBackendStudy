package com.ccnu.utils;

import java.util.concurrent.TimeUnit;

/**
 * Author: chs
 * Description: 休眠工具类
 * CreateTime: 2024-07-28
 */
public class Sleeper {
    public static void sleep(int i){
        try {
            Thread.sleep(i*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void sleep(double i){
        try {
            Thread.sleep((int)i*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
