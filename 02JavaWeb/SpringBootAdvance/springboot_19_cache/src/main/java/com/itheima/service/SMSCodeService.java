package com.itheima.service;

import com.itheima.domain.SMSCode;

public interface SMSCodeService {
    public String generateCode(String tel);
    public boolean check(SMSCode smsCode);
}
