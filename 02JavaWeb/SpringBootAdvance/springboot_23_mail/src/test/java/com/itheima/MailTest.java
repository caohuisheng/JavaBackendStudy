package com.itheima;

import com.itheima.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class MailTest {

    @Autowired
    private SendMailService sendMailService;

    @Test
    void test(){
        sendMailService.sendMail();
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
