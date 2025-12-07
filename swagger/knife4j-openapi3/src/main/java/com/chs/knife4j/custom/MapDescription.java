package com.chs.knife4j.custom;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author: chs
 * @date: 2025-12-05 00:06
 * @description: todo
 */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MapDescription {
    String keyDescription() default "参数键";
    String valueDescription() default "参数值";
    Class<?> keyType() default String.class;
    Class<?> valueType() default String.class;
}