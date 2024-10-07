package cn.bugstack.design;

import cn.bugstack.design.mq.POPOrderDelivered;
import com.alibaba.fastjson.JSON;

/**
 * Author: chs
 * Description: 接收外部订单消息服务
 * CreateTime: 2024-10-07
 */
public class POPOrderDeliveredService {

    public void onMessage(String message){
        POPOrderDelivered popOrderDelivered = JSON.parseObject
                (message, POPOrderDelivered.class);
        popOrderDelivered.getuId();
        popOrderDelivered.getOrderId();
        popOrderDelivered.getOrderTime();

        //...处理自己的业务
    }

}
