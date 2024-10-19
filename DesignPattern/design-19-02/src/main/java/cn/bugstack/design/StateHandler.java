package cn.bugstack.design;

import cn.bugstack.design.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class StateHandler {

    private Map<Enum<Status>, State> stateMap = new HashMap<>();

    public StateHandler(){
        stateMap.put(Status.Editing,  new EditingState());
        stateMap.put(Status.Check, new CheckState());
        stateMap.put(Status.Pass, new PassState());
        stateMap.put(Status.Doing, new DoingState());
        stateMap.put(Status.Refuse, new RefuseState());
        stateMap.put(Status.Open, new OpenState());
        stateMap.put(Status.Close, new CloseState());
    }

    public Result updateState(String activityId, Enum<Status> afterStatus){
        Enum<Status> beforeStatus = ActivityService.queryActivityStatus(activityId);
        State state = stateMap.get(beforeStatus);
        return state.updateState(activityId, afterStatus);
    }

}
