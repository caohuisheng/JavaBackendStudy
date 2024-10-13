package cn.bugstack.design.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: chs
 * Description: 模拟库存消耗
 * CreateTime: 2024-10-13
 */
public class RedisUtils {

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    //已消耗的库存
    private AtomicInteger stock = new AtomicInteger(0);

    public RedisUtils(){
        //定时更新库存消耗
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            stock.getAndAdd(1);
        },0,100, TimeUnit.MILLISECONDS);
    }

    public int getStock(){
        return stock.get();
    }

}
