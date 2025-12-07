package com.chs.knife4j.custom;

import java.lang.annotation.*;

/**
 * @author: chs
 * @date: 2025-12-05 08:15
 * @description: todo
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomOperation {
    String requestBodyDescription() default "默认请求体描述";
    Class<?> requestBodySchema() default Void.class;
}