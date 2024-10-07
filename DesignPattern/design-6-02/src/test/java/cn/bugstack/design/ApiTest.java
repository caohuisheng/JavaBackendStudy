package cn.bugstack.design;

import cn.bugstack.design.cuisine.impl.InsideOrderAdapterImpl;
import cn.bugstack.design.cuisine.impl.POPOrderAdapterImpl;
import cn.bugstack.design.mq.CreateAccount;
import cn.bugstack.design.mq.OrderMq;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-07
 */
public class ApiTest {

    @Test
    public void test_MQAdapter() throws Exception{
        //开户消息字段适配
        CreateAccount createAccount = new CreateAccount();
        createAccount.setUId("chs");
        createAccount.setNumber("100001");
        createAccount.setAddress("湖北省.武汉市.洪山区");
        createAccount.setAccountDate(new Date());
        createAccount.setDesc("普通开户");

        Map<String,String> link01 = new HashMap<>();
        link01.put("uId","userId");
        link01.put("number","bizId");
        link01.put("accountDate","bizTime");
        link01.put("desc","desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(JSON.toJSONString(createAccount), link01);
        System.out.println("mq.CreateAccount(适配前)：" + JSON.toJSONString(createAccount));
        System.out.println("mq.CreateAccount(适配后)：" + JSON.toJSONString(rebateInfo01));

        //订单消息字段适配
        OrderMq orderMq = new OrderMq();
        orderMq.setUid("chs");
        orderMq.setOrderId("200310071621");
        orderMq.setSku("20001");
        orderMq.setCreateOrderTime(new Date());

        Map<String,String> link02 = new HashMap<>();
        link02.put("uid","userId");
        link02.put("orderId","bizId");
        link02.put("createOrderTime","bizTime");
        link02.put("sku","desc");
        RebateInfo rebateInfo02 = MQAdapter.filter(JSON.toJSONString(orderMq),link02);
        System.out.println("mq.OrderMq(适配前)：" + JSON.toJSONString(orderMq));
        System.out.println("mq.OrderMq(适配后)：" + JSON.toJSONString(rebateInfo02));
    }

    @Test
    public void test_OrderAdapter(){
        OrderAdapter insideOrderAdapter = new InsideOrderAdapterImpl();
        OrderAdapter popOrderAdapter = new POPOrderAdapterImpl();
        System.out.println("判断首单，接口适配（内部）：" + insideOrderAdapter.isFirst("10001"));
        System.out.println("判断首单，接口适配（POP）：" + popOrderAdapter.isFirst("10001"));
    }

}
