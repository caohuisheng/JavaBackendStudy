package com.knife4j.demo.plugin.enums;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/6 07:47
 * @since knife4j-spring-boot27-demo
 */
public interface CommonFormEnumParser<T extends Enum<T>> {

    /**
     * 根据输入input实现枚举的实例化
     * @param input 输入字符
     * @return 枚举实例
     */
    T fromValue(String input);
}
