package cn.bugstack.design;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public interface State {

    Result updateState(String activityId, Enum<Status> afterStatus);

}
