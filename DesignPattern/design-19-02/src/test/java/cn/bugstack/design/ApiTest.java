package cn.bugstack.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class ApiTest {

    private Logger log = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_Editing2Check(){
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);

        StateHandler stateHandler = new StateHandler();
        Result result = stateHandler.updateState(activityId, Status.Check);

        log.info("测试结果（编辑中-审核中）:{}", JSON.toJSONString(result));
        log.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), ActivityService.queryActivityStatus(activityId));
    }

    @Test
    public void test_Editing2Open(){
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);

        StateHandler stateHandler = new StateHandler();
        Result result = stateHandler.updateState(activityId, Status.Open);

        log.info("测试结果（编辑中-活动开启）:{}", JSON.toJSONString(result));
        log.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), ActivityService.queryActivityStatus(activityId));
    }

    @Test
    public void test_Refuse2Doing(){
        String activityId = "100001";
        ActivityService.init(activityId, Status.Refuse);

        StateHandler stateHandler = new StateHandler();
        Result result = stateHandler.updateState(activityId, Status.Doing);

        log.info("测试结果（拒绝-活动中）:{}", JSON.toJSONString(result));
        log.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), ActivityService.queryActivityStatus(activityId));
    }

}
