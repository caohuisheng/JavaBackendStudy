package com.chs.knife4j.custom;

import com.github.xiaoymin.knife4j.annotations.DynamicParameter;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MapParameters {

    MapParameter[] properties() default {@MapParameter};

}
