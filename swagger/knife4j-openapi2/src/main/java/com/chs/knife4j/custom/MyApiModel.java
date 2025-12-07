package com.chs.knife4j.custom;

import java.lang.annotation.*;

/**
 * @author: chs
 * @date: 2025-12-04 15:32
 * @description: todo
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyApiModel {
    String value() default "";

    String description() default "";

    Class<?> parent() default Void.class;

    String discriminator() default "";

    Class<?>[] subTypes() default {};

    String reference() default "";
}