package com.chs.knife4j.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiMapParams {
    /**
     * 描述Map参数的总体用途
     */
    String description() default "";

    /**
     * 键值对的描述
     */
    ParamDescription[] value() default {};

    /**
     * 键的类型
     */
    Class<?> keyType() default String.class;

    /**
     * 值的类型
     */
    Class<?> valueType() default Object.class;
}
