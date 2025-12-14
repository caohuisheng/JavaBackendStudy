package com.chs.knife4j.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chs
 * @date 2025-12-05
 * @description map参数
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapParameter {

    /**
     * 字段名
     */
    String name() default "";

    /**
     * 字段类型
     */
    Class<?> type() default Void.class;

    /**
     * 字段描述
     */
    String description() default "";

    /**
     * 字段示例
     */
    String example() default "";

}