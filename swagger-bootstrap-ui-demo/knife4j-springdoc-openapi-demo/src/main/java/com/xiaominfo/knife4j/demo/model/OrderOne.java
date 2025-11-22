package com.xiaominfo.knife4j.demo.model;

import lombok.Data;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2024/1/2 23:22
 * @since knife4j-springdoc-openapi-demo
 */
@Data
public class OrderOne {

    private String name;

    private MyOrderParam param;
}
