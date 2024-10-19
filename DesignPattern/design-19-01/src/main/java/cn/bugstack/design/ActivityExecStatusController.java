package cn.bugstack.design;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class ActivityExecStatusController {

    public Result execStatus(String activityId, Enum<Status> afterStatus){
        //查询活动当前状态
        Enum<Status> beforeStatus = ActivityService.queryActivityStatus(activityId);

        //1.编辑中 -> 提审、关闭
        if(Status.Editing.equals(beforeStatus)){
            if(Status.Check.equals(afterStatus) || Status.Close.equals(afterStatus)){
                ActivityService.execStatus(activityId, afterStatus);
                return new Result("0000", "变更状态成功");
            }else{
                return new Result("0001", "变更状态拒绝");
            }
        }

        //2.待审核 -> 审核通过、审核拒绝、编辑中、活动关闭
        if(Status.Check.equals(beforeStatus)){
            if(Status.Pass.equals(afterStatus) || Status.Refuse.equals(afterStatus) || Status.Editing.equals(afterStatus)
                    || Status.Close.equals(afterStatus)){
                ActivityService.execStatus(activityId, afterStatus);
                return new Result("0000", "变更状态成功");
            }else{
                return new Result("0001", "变更状态拒绝");
            }
        }

        //3.审核通过 -> 拒绝、关闭、活动中
        if(Status.Pass.equals(beforeStatus)){
            if(Status.Refuse.equals(afterStatus) || Status.Close.equals(afterStatus) || Status.Doing.equals(afterStatus)){
                ActivityService.execStatus(activityId, afterStatus);
                return new Result("0000", "变更状态成功");
            }else{
                return new Result("0001", "变更状态拒绝");
            }
        }

        //4.审核拒绝 -> 撤审、关闭
        if(Status.Refuse.equals(beforeStatus)){
            if(Status.Editing.equals(afterStatus) || Status.Close.equals(afterStatus)){
                ActivityService.execStatus(activityId, afterStatus);
                return new Result("0000", "变更状态成功");
            }else{
                return new Result("0001", "变更状态拒绝");
            }
        }

        //5.活动中 -> 关闭
        if(Status.Doing.equals(beforeStatus)){
            if(Status.Close.equals(afterStatus)){
                ActivityService.execStatus(activityId, afterStatus);
                return new Result("0000", "变更状态成功");
            }else{
                return new Result("0001", "变更状态拒绝");
            }
        }

        //6.活动关闭 -> 开启
        if(Status.Close.equals(beforeStatus)){
            if(Status.Open.equals(afterStatus)){
                ActivityService.execStatus(activityId, afterStatus);
                return new Result("0000", "变更状态成功");
            }else{
                return new Result("0001", "变更状态拒绝");
            }
        }

        //7.活动开启 -> 关闭
        if(Status.Open.equals(beforeStatus)){
            if(Status.Close.equals(afterStatus)){
                ActivityService.execStatus(activityId, afterStatus);
                return new Result("0000", "变更状态成功");
            }else{
                return new Result("0001", "变更状态拒绝");
            }
        }

        return new Result("0001", "非可处理的活动状态变更");
    }

}
