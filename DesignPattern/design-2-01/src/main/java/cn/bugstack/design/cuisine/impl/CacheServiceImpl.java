package cn.bugstack.design.cuisine.impl;

import cn.bugstack.design.CacheService;
import cn.bugstack.design.RedisUtils;
import cn.bugstack.design.matter.EGM;
import cn.bugstack.design.matter.IIR;

import java.util.concurrent.TimeUnit;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class CacheServiceImpl implements CacheService {

    private EGM egm = new EGM();
    private IIR iir = new IIR();
    private RedisUtils redisUtils = new RedisUtils();

    @Override
    public String get(String key, int redisType) {
        switch(redisType){
            case 1:return egm.gain(key);
            case 2:return iir.get(key);
            default: return redisUtils.get(key);
        }
    }

    @Override
    public void set(String key, String value, int redisType) {
        switch(redisType){
            case 1:egm.set(key,value);break;
            case 2:iir.set(key,value);break;
            case 3:redisUtils.set(key,value);
        }
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {
        switch(redisType){
            case 1:egm.setEX(key,value,timeout,timeUnit);break;
            case 2:iir.setExpire(key,value,timeout,timeUnit);break;
            default:redisUtils.set(key,value,timeout,timeUnit);
        }
    }

    @Override
    public void del(String key, int redisType) {
        switch(redisType){
            case 1:egm.delete(key);break;
            case 2:iir.del(key);break;
            default:redisUtils.del(key);
        }
    }
}
