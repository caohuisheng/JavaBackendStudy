package cn.bugstack.design.impl;

import cn.bugstack.design.ActivityService;
import cn.bugstack.design.Result;
import cn.bugstack.design.State;
import cn.bugstack.design.Status;

/**
 * Author: chs
 * Description: 活动开启状态
 * CreateTime: 2024-10-19
 */
public class OpenState implements State {

    @Override
    public Result updateState(String activityId, Enum<Status> afterStatus) {
        if(Status.Close.equals(afterStatus)){
            ActivityService.execStatus(activityId, afterStatus);
            return new Result("0000","状态变更成功");
        }
        return new Result("0000","状态变更拒绝");
    }

}
