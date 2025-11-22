package com.knife4j.demo.plugin.enums;

import lombok.AllArgsConstructor;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/6 07:48
 * @since knife4j-spring-boot27-demo
 */
@AllArgsConstructor
public class GenericEnumParamParser <T extends Enum<T>> implements CommonFormEnumParser<T> {

    private final Class<T> enumClass;

    @Override
    public T fromValue(String input) {
        T[] values=enumClass.getEnumConstants();
        if (values!=null&&values.length>0){

        }

        return null;
    }
}
