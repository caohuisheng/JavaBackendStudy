package cn.bugstack.design;

import cn.bugstack.design.domain.Activity;
import cn.bugstack.design.domain.Stock;
import cn.bugstack.design.factory.ActivityFactory;
import cn.bugstack.design.utils.RedisUtils;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-13
 */
public class ActivityController {

    private RedisUtils redisUtils = new RedisUtils();

    public Activity queryActivityInfo(Long id){
        Activity activity = ActivityFactory.getActivity(id);
        activity.setStock(new Stock(1000,redisUtils.getStock()));
        return activity;
    }

}
