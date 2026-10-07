package com.itheima.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //目标
@Retention(RetentionPolicy.RUNTIME) //持续时间
public @interface MyComponent {
    //指定bean的beanName
    String value() default "";
}
