package cn.bugstack.design;

import cn.bugstack.design.domain.Activity;
import cn.bugstack.design.domain.Stock;

import java.util.Date;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-13
 */
public class ActivityController {

    public Activity queryActivityInfo(Long id){
        Activity activity = new Activity();
        activity.setId(id);
        activity.setName("购物抽奖活动");
        activity.setDesc("购物满100元送1次抽奖机会");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());
        activity.setStock(new Stock(1000,1));
        return activity;
    }

}
