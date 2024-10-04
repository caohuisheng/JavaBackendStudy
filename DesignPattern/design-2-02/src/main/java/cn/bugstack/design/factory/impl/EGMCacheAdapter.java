package cn.bugstack.design.factory.impl;

import cn.bugstack.design.factory.ICacheAdapter;
import cn.bugstack.design.matter.EGM;

import java.util.concurrent.TimeUnit;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEX(key,value,timeout,timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
