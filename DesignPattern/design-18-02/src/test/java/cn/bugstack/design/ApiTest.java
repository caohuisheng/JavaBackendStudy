package cn.bugstack.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class ApiTest {

    @Test
    public void test(){
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult lotteryResult = lotteryService.draw("204820241019");
        System.out.println("测试结果：" + JSON.toJSONString(lotteryResult));
    }

}
