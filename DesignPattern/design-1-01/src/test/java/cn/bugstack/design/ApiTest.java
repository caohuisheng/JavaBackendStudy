package cn.bugstack.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class ApiTest {

    @Test
    public void test_awardToUser(){
        PrizeController prizeController = new PrizeController();

        System.out.println("\n****模拟发放优惠券测试****");
        AwardReq req1 = new AwardReq();
        req1.setuId("10001");
        req1.setAwardType(1);
        req1.setAwardNumber("COUPON20241004");
        req1.setBizId("400420241004");
        AwardRes awardRes1 = prizeController.awardToUser(req1);
        System.out.println("测试结果：" + JSON.toJSONString(awardRes1));

        System.out.println("\n****模拟发放实物商品****");
        AwardReq req2 = new AwardReq();
        req2.setuId("10001");
        req2.setAwardType(2);
        req2.setAwardNumber("GOODS20241004");
        req2.setBizId("500420241004");
        req2.setExtMap(new HashMap<String, String>(){{
            put("consigneeUserName","霍建华");
            put("consigneeUserPhone","17786426752");
            put("consigneeUserAddress","湖北省.武汉市.新洲区.旧街街");
        }});
        AwardRes awardRes2 = prizeController.awardToUser(req2);
        System.out.println("测试结果：" + JSON.toJSONString(awardRes2));

        System.out.println("\n****模拟发放第三方兑换卡（爱奇艺）****");
        AwardReq req3 = new AwardReq();
        req3.setuId("10001");
        req3.setAwardType(3);
        req3.setBizId("600420241004");
        AwardRes awardRes3 = prizeController.awardToUser(req3);
        System.out.println("测试结果："+JSON.toJSONString(awardRes3));
    }

}
