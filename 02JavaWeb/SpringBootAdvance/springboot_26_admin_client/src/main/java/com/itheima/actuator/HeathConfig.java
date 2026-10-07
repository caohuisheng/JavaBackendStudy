package com.itheima.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HeathConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        boolean condition = true;
        if(condition){
            builder.status(Status.UP);
            builder.withDetail("runtime",System.currentTimeMillis());
            Map<String,Object> infoMap = new HashMap<>();
            infoMap.put("buildTime","2006");
            builder.withDetails(infoMap);
        }else{
            builder.status(Status.DOWN);
            builder.withDetail("状态","异常");
        }
    }
}
