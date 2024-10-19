package cn.bugstack.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class ApiTest {

    @Test
    public void test(){
        //初始化活动信息
        String activityId = "1000001";
        ActivityService.init(activityId, Status.Editing);

        ActivityExecStatusController activityExecStatusController = new ActivityExecStatusController();
        Result result1 = activityExecStatusController.execStatus(activityId, Status.Refuse);
        System.out.println("测试结果：" + JSON.toJSONString(result1));

        Result result2 = activityExecStatusController.execStatus(activityId, Status.Check);
        System.out.println("测试结果：" + JSON.toJSONString(result2));
    }

}
