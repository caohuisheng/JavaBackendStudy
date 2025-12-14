package com.chs.knife4j.annotation;

import javax.xml.bind.annotation.XmlType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chs
 * @date 2025-12-05 08:15
 * @description todo
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapResponse {

    String responseCode() default "default";

    String description() default "";

    Class<?> rawType() default Void.class;

    Class<?>[] typeArgs() default {};

}