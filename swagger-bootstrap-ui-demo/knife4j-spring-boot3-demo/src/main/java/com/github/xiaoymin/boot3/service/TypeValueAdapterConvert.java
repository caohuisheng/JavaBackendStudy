package com.github.xiaoymin.boot3.service;

import com.google.gson.JsonObject;

import java.lang.reflect.Parameter;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/1 15:31
 * @since knife4j-spring-boot3-demo
 */
public interface TypeValueAdapterConvert {
    /**
     * 转换参数的class对象获取value值
     * @param parameter 参数
     * @param rootObject 对象
     * @return 对象值
     */
    Object convertValue(Parameter parameter, JsonObject rootObject);
}
