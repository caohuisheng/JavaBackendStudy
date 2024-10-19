package cn.bugstack.design.impl;

import cn.bugstack.design.*;

/**
 * Author: chs
 * Description: 待审核状态
 * CreateTime: 2024-10-19
 */
public class CheckState implements State {

    @Override
    public Result updateState(String activityId, Enum<Status> afterStatus) {
        if(Status.Pass.equals(afterStatus) || Status.Refuse.equals(afterStatus) || Status.Editing.equals(afterStatus)
                || Status.Close.equals(afterStatus)){
            ActivityService.execStatus(activityId, afterStatus);
            return new Result("0000","状态变更成功");
        }
        return new Result("0000","状态变更拒绝");
    }

}
