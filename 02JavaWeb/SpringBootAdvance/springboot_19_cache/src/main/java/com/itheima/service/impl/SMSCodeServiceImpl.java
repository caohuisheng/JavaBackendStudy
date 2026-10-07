package com.itheima.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utils.CodeUtils;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {


//    @Autowired
//    private CodeUtils codeUtils;
//
//    @CachePut(value = "smsCode",key = "#tel")
//    @Override
//    public String generateCode(String tel) {
//        return codeUtils.generateCode(tel);
//    }
//
//    @Override
//    public boolean check(SMSCode smsCode) {
//        String code = smsCode.getCode();
//        String cacheCode = codeUtils.getCacheCode(smsCode.getTel());
//        System.out.println(cacheCode);
//        return code.equals(cacheCode);
//    }


    //@CreateCache(area = "default",name = "jetcache_",expire = 3600,timeUnit = TimeUnit.SECONDS)
    @CreateCache(name = "jetcache_",expire = 3600,timeUnit = TimeUnit.SECONDS,cacheType = CacheType.BOTH)
    private Cache<String,String> jetCache;

    @Autowired
    private CodeUtils codeUtils;

    @Override
    public String generateCode(String tel) {
        String code = codeUtils.generateCode(tel);
        //添加到缓存
        jetCache.put(tel,code);
        return code;
    }

    @Override
    public boolean check(SMSCode smsCode) {
        String cacheCode = jetCache.get(smsCode.getTel());
        //从缓存中取出验证码
        String code = smsCode.getCode();
        return code.equals(cacheCode);
    }

}
