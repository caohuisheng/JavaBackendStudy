package cn.bugstack.design.matter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class EGM {

    private Logger log = LoggerFactory.getLogger(EGM.class);

    private Map<String, String> dataMap = new HashMap<>();

    public String gain(String key){
        log.info("EGM获取数据 key:{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value){
        log.info("EGM写入数据 key:{} value:{}",key,value);
        dataMap.put(key, value);
    }

    public void setEX(String key, String value, long timeout, TimeUnit timeUnit){
        log.info("EGM写入数据 key:{} value:{} timeout:{} timeUnit:{}",key,value,timeout,timeUnit);
    }

    public void delete(String key){
        log.info("EGM删除数据 key:{}",key);
        dataMap.remove(key);
    }

}
