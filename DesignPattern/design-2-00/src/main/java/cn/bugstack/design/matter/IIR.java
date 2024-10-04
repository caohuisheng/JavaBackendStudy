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
public class IIR {

    private Logger log = LoggerFactory.getLogger(IIR.class);

    private Map<String, String> dataMap = new HashMap<>();

    public String get(String key){
        log.info("IIR获取数据 key:{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value){
        log.info("IIR写入数据 key:{} value:{}",key,value);
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit){
        log.info("IIR写入数据 key:{} value:{} timeout:{} timeUnit:{}",key,value,timeout,timeUnit);
    }

    public void del(String key){
        log.info("IIR删除数据 key:{}",key);
        dataMap.remove(key);
    }

}
