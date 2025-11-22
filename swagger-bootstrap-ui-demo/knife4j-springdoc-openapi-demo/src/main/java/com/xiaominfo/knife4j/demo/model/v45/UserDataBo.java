package com.xiaominfo.knife4j.demo.model.v45;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2024/1/7 21:36
 * @since knife4j-springdoc-openapi-demo
 */
@Data
//@Schema(description = "用户数据")
public class UserDataBo {
    @Schema(description = "真实姓名")
    private String realName;


    @Schema(description = "年龄")
    private Long age;
}
