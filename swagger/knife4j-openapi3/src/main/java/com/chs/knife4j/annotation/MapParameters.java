package com.chs.knife4j.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MapParameters {

    MapParameter[] properties() default {@MapParameter};

}
