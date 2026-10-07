package com.itheima.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class InfoConfig implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("runtime",System.currentTimeMillis());
        Map<String,Object> infoMap = new HashMap<>();
        infoMap.put("buildTime","2006");
        builder.withDetails(infoMap);
    }
}
