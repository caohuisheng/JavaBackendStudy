package cn.bugstack.design.factory;

import java.util.concurrent.TimeUnit;

/**
 * Author: chs
 * Description: 缓存适配器
 * CreateTime: 2024-10-04
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
