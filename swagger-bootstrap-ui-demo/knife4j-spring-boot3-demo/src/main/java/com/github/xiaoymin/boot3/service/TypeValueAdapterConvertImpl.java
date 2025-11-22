package com.github.xiaoymin.boot3.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/1 15:32
 * @since knife4j-spring-boot3-demo
 */
@Slf4j
public class TypeValueAdapterConvertImpl implements TypeValueAdapterConvert{
    final Gson gson=new Gson();

    @Override
    public Object convertValue(Parameter parameter, JsonObject rootObject) {
        String paramName=parameter.getName();
        log.info("param-name:{}",paramName);
        Class<?> paramType = parameter.getType();
        JsonElement paramValueJson=rootObject.get(paramName);
        Object value=null;
        if (paramType== Integer.class){
            value=paramValueJson.getAsInt();
        }else if(paramType== String.class){
            value=paramValueJson.getAsString();
        }else if(paramType== Double.class){
            value=paramValueJson.getAsDouble();
        }else if(paramType== Float.class){
            value=paramValueJson.getAsFloat();
        }else if(paramType== BigDecimal.class){
            value=paramValueJson.getAsBigDecimal();
        }else if(paramType== BigInteger.class){
            value=paramValueJson.getAsBigInteger();
        }else if(paramType==Long.class){
            value=paramValueJson.getAsLong();
        }else if(paramType==Boolean.class){
            value=paramValueJson.getAsBoolean();
        }else if(paramType== Number.class){
            value=paramValueJson.getAsNumber();
        }else if(paramType== Byte.class){
            value=paramValueJson.getAsByte();
        }else if(paramType== Short.class){
            value=paramValueJson.getAsShort();
        }else{
            log.info("非基础类型。对象类型");
            value=gson.fromJson(paramValueJson,paramType);
        }
        return value;
    }
}
