package cn.bugstack.design;

import cn.bugstack.design.mq.OrderMq;
import com.alibaba.fastjson.JSON;

/**
 * Author: chs
 * Description: 接收订单消息服务
 * CreateTime: 2024-10-07
 */
public class OrderMqService {

    public void onMessage(String message){
        OrderMq orderMq = JSON.parseObject(message, OrderMq.class);
        orderMq.getUid();
        orderMq.getOrderId();
        orderMq.getCreateOrderTime();

        //...处理自己的业务
    }

}
