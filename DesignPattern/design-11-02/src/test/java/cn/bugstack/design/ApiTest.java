package cn.bugstack.design;

import cn.bugstack.design.domain.Activity;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-13
 */
public class ApiTest {

    @Test
    public void test_ActivityController() throws InterruptedException {
        ActivityController activityController = new ActivityController();
        for (int i = 0; i < 10; i++) {
            Activity activity = activityController.queryActivityInfo(10001L);
            System.out.println("测试结果：" + JSON.toJSONString(activity));
            Thread.sleep(500);
        }
    }

}
