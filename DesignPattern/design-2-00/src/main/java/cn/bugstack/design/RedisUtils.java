package cn.bugstack.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class RedisUtils {

    private Logger log = LoggerFactory.getLogger(RedisUtils.class);

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key){
        log.info("Redis获取数据 key:{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value){
        log.info("Redis写入数据 key:{} value:{}",key,value);
        dataMap.put(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit){
        log.info("Redis写入数据 key:{} value:{} timeout:{} timeUnit:{}",key,value,timeout,timeUnit);
    }

    public void del(String key){
        log.info("Redis删除数据 key:{}",key);
        dataMap.remove(key);
    }

}
