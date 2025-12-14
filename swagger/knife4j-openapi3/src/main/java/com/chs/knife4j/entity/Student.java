package com.chs.knife4j.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@Schema(description = "学生实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Schema(description = "学生id")
    private Integer sid;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "性别")
    private Byte sex;

}
