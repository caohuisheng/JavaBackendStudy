package cn.bugstack.design.factory;

import cn.bugstack.design.domain.Activity;
import cn.bugstack.design.domain.Stock;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: chs
 * Description: 活动信息工厂
 * CreateTime: 2024-10-13
 */
public class ActivityFactory {

    private static Map<Long, Activity> activityMap = new HashMap<>();

    public static Activity getActivity(Long id){
        Activity activity = activityMap.get(id);
        if(null == activity){
            activity = new Activity();
            activity.setId(id);
            activity.setName("购物抽奖活动");
            activity.setDesc("购物满100元送1次抽奖机会");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activity.setStock(new Stock(1000,1));
            activityMap.put(id, activity);
        }
        return activity;
    }
}
