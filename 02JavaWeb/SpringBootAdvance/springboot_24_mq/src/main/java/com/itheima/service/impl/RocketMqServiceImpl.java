package com.itheima.service.impl;

import com.itheima.service.MessageService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RocketMqServiceImpl implements MessageService {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("消息已添加到队列，id："+id);
        //发送消息的回调
        SendCallback callback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("消息发送异常，msg："+throwable.getMessage());
            }
        };
        //异步发送消息
        rocketMQTemplate.asyncSend("order_id",id,callback);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
