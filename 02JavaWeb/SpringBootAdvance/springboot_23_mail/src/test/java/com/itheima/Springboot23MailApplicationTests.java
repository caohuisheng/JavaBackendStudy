package com.itheima;

import com.itheima.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot23MailApplicationTests {

    @Autowired
    private SendMailService sendMailService;

    @Test
    void testSendMail() {
        sendMailService.sendMail();
    }

    @Test
    void test(){
        sendMailService.sendMail();
    }

}
