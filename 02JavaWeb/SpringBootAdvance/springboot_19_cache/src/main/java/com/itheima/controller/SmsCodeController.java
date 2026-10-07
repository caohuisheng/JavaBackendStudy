package com.itheima.controller;

import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SmsCodeController {

    @Autowired
    private SMSCodeService smsCodeService;

    @GetMapping
    public String getCode(String tel){
        return smsCodeService.generateCode(tel);
    }

    @PostMapping
    public boolean check(SMSCode smsCode){
        return smsCodeService.check(smsCode);
    }
}
