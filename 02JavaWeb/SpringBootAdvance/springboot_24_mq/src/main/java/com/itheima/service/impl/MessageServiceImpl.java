package com.itheima.service.impl;

import com.itheima.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
public class MessageServiceImpl implements MessageService {

    private List<String> msgList = new ArrayList<>();

    @Override
    public void sendMessage(String id) {
        System.out.println("消息已发送，id:"+id);
        msgList.add(id);
    }

    @Override
    public String doMessage() {
        String msg = msgList.get(0);
        System.out.println("消息已处理：id:"+msg);
        return msg;
    }
}
