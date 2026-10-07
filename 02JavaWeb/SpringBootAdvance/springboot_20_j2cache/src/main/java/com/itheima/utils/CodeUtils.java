package com.itheima.utils;

import org.springframework.stereotype.Component;

@Component
public class CodeUtils {

    private static String [] patch = {"000000","00000","0000","000","00","0",""};

    public String generateCode(String tele){
        int hash = tele.hashCode();
        int encryption = 20206666;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String codeStr = code + "";
        int len = codeStr.length();
        return patch[len] + codeStr;
    }

}
