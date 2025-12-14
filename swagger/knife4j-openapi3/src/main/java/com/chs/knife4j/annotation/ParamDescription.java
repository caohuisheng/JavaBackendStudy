package com.chs.knife4j.annotation;

@interface ParamDescription {
    String key();
    String description();
    boolean required() default false;
    String example() default "";
}
