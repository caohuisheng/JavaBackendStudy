package com.itheima.service.impl;

import com.itheima.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

//@Service
public class JmsMessageServiceImpl implements MessageService {

    @Autowired
    JmsMessagingTemplate messagingTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("将消息添加到队列中，id："+id);
        messagingTemplate.convertAndSend("order.queue.id",id);
    }

    @Override
    public String doMessage() {
        String id = messagingTemplate.receiveAndConvert("order.queue.id", String.class);
        System.out.println("接受消息并处理：id："+id);
        return id;
    }
}
