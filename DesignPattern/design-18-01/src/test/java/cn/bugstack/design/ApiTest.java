package cn.bugstack.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-18
 */
public class ApiTest {

    @Test
    public void test(){
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult lotteryResult = lotteryService.doDraw("204820241018");
        System.out.println("测试结果：" + JSON.toJSONString(lotteryResult));
    }

}
