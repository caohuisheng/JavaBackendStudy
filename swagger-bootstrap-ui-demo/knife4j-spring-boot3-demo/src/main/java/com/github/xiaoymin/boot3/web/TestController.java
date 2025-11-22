package com.github.xiaoymin.boot3.web;

import com.github.xiaoymin.boot3.service.HelloService;
import com.github.xiaoymin.boot3.service.TypeValueAdapterConvert;
import com.github.xiaoymin.boot3.service.TypeValueAdapterConvertImpl;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/1 14:55
 * @since knife4j-spring-boot3-demo
 */
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    final ApplicationContext applicationContext;
    final Gson gson=new Gson();

    @PostMapping("/body")
    public ResponseEntity<Object> body(@RequestBody String json){
        // 解析为Map
        JsonElement jsonElement= JsonParser.parseString(json);
        JsonObject jsonObject=jsonElement.getAsJsonObject();
        try {
            String methodName= jsonObject.get("method").getAsString();
            log.info("method:{}",methodName);
            Method[] methods=HelloService.class.getMethods();
            Method method=null;
            List<Object> paramArray=new LinkedList<>();
            TypeValueAdapterConvert convert=new TypeValueAdapterConvertImpl();
            for (Method m :methods){
                if (m.getName().equals(methodName)){
                    method=m;
                    Parameter[] parameters=m.getParameters();
                    for (Parameter param:parameters){
                        Object paramValue=convert.convertValue(param,jsonObject);
                        paramArray.add(paramValue);
                    }
                    break;
                }
            }
            Object[] paramObjects=paramArray.toArray(new Object[]{});
            Object result=method.invoke(applicationContext.getBean(HelloService.class),paramObjects);
            return ResponseEntity.ok(result);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
