package com.chs.knife4j.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@Data
@Schema(description = "创建用户的请求体")
public class CreateUserRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 5)
    @Schema(description = "用户名", example = "zhangsan", required = true, minLength = 3, maxLength = 20)
    private String username;

    @Schema(description = "用户邮箱", example = "zhangsan@example.com", required = true, minLength = 5, maxLength = 50)
    private String email;

    @Schema(description = "年龄", example = "25", required = true, minimum = "0", maximum = "150")
    private Integer age;

    @Schema(description = "性别 0-男 1-女", example = "0", required = true, minimum = "0", maximum = "1")
    private Integer sex;

}