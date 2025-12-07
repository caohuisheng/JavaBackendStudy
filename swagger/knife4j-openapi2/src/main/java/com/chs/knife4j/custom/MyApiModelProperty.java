package com.chs.knife4j.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: chs
 * @date: 2025-12-04 15:33
 * @description: todo
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyApiModelProperty {

    String value() default "";

    String name() default "";

    String allowableValues() default "";

    String access() default "";

    String notes() default "";

    String dataType() default "";

    boolean required() default false;

    int position() default 0;

    boolean hidden() default false;

    String example() default "";

    boolean readOnly() default false;

    String reference() default "";

    boolean allowEmptyValue() default false;
}