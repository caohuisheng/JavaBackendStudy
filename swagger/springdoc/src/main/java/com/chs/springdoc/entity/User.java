package com.chs.springdoc.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@Schema(description = "用户实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Schema(description = "用户id")
    private Integer uid;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "性别")
    private Byte sex;

}
