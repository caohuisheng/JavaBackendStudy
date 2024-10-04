package cn.bugstack.design;

import java.util.concurrent.TimeUnit;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public interface CacheService {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
