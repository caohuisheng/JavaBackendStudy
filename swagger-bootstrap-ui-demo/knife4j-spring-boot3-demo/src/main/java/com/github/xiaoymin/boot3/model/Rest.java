package com.github.xiaoymin.boot3.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/1 16:11
 * @since knife4j-spring-boot3-demo
 */
@Getter
@Setter
public class Rest<T>{

    private String code;
    private T data;
}
