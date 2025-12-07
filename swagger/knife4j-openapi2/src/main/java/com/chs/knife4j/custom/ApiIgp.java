package com.chs.knife4j.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhenghui
 * @date 2020年9月17日17:00:49
 * @desc 排除不需要的属性的值
 */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIgp {
    Class<?> classPath();//对象的原始class地址，必填
    String modelName();//自定义 Model的名字，必填
    String values()[]; //原始对象中已经存在的对象属性名字 ，必填
    String noValues()[] default {} ;//原始对象中不存在的对象属性名字，非必填
    String noValueTypes()[] default {};//原始对象中不存在的对象属性的类型，基本类型例如：String等，非必填
    String noVlaueExplains()[] default {};//自定义变量的参数说明 非必填
}
