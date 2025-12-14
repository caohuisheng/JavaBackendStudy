package com.chs.knife4j.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MapParameter {
    String name() default "";

    String value() default "";

    boolean required() default false;

    Class<?> dataTypeClass() default Void.class;

    String example() default "";
}
