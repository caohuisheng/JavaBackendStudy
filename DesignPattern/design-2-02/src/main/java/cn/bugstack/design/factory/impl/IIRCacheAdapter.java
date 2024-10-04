package cn.bugstack.design.factory.impl;

import cn.bugstack.design.factory.ICacheAdapter;
import cn.bugstack.design.matter.IIR;

import java.util.concurrent.TimeUnit;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class IIRCacheAdapter implements ICacheAdapter {

    private IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key,value,timeout,timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }
}
