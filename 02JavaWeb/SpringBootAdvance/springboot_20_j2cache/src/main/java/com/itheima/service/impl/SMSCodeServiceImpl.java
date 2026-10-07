package com.itheima.service.impl;

import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

//    @Autowired
    //private CacheChannel cacheChannel;

    @Autowired
    private CodeUtils codeUtils;

    @Override
    public String generateCode(String tel) {
        String code = codeUtils.generateCode(tel);
        //添加到缓存
        //cacheChannel.set("j2_cache",tel,code);
        return code;
    }

    @Override
    public boolean check(SMSCode smsCode) {
        //String cacheCode = cacheChannel.get("j2cache",smsCode.getTel()).asString();
        //从缓存中取出验证码
        String code = smsCode.getCode();
        //return code.equals(cacheCode);
        return true;
    }

}
