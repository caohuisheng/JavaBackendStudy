package cn.bugstack.design;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: chs
 * Description: 静态类
 * CreateTime: 2024-10-07
 */
public class Singleton_00 {

    public static Map<String, String> cache = new ConcurrentHashMap<>();

}
