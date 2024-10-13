package cn.bugstack.design.agent;

import java.lang.annotation.*;

/**
 * Author: chs
 * Description: 自定义注解
 * CreateTime: 2024-10-13
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {

    String value() default "";

}
