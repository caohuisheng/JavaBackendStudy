package com.itheima.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import org.w3c.dom.css.Counter;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "pay",enableByDefault = true)
public class PayEndPoint {

    @ReadOperation
    public Object getPay(){
        Map<String,String> payMap = new HashMap<>();
        payMap.put("level1","100");
        payMap.put("level2","200");
        payMap.put("level3","300");
        return payMap;
    }
}
