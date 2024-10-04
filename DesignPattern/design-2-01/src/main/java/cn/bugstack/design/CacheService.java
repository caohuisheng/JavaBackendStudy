package cn.bugstack.design;

import java.util.concurrent.TimeUnit;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public interface CacheService {

    String get(String key,int redisType);

    void set(String key, String value,int redisType);

    void set(String key, String value, long timeout, TimeUnit timeUnit,int redisType);

    void del(String key,int redisType);

}
