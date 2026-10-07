package com.itheima.service.impl;

import com.itheima.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail() {
        String from = "3372706844@qq.com";
        String to = "3343232943@qq.com";
        String title = "邀请";
        String content = "赵金麦";

        //创建信息
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);

        //发送
        javaMailSender.send(message);
        System.out.println("发送成功");
    }
}
