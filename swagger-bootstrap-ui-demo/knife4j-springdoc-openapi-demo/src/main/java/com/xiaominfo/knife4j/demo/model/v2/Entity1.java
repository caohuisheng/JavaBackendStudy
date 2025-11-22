package com.xiaominfo.knife4j.demo.model.v2;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2024/3/15 14:06
 * @since knife4j-spring-boot27-demo 1
 */
@Getter
@Setter
public class Entity1 {

    @Schema(description = "姓名",allowableValues = "张飞,关羽,赵云")
    private String name;
}
