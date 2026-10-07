package com.itheima.service.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "order_id",consumerGroup = "group_rocketmq")
public class RocketMessageListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("接收到消息, id："+s);
    }
}
