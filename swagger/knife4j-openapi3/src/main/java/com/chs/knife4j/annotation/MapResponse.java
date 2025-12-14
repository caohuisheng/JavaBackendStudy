package com.chs.knife4j.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chs
 * @date 2025-12-05
 * @description map响应
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapResponse {

    /**
     * 状态码
     */
    String responseCode() default "";

    /**
     * 描述
     */
    String description() default "";

    /**
     * 原始类型
     */
    Class<?> rawType() default Void.class;

    /**
     * 泛型类型
     */
    Class<?> genericType() default Void.class;

    /**
     * 字段列表
     */
    MapParameter[] fields() default {};
}