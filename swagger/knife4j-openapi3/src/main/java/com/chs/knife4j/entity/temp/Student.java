package com.chs.knife4j.entity.temp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: chs
 * Description: 学生实体类2(测试同名实体类只显示1个问题)
 * CreateTime: 2025-11-30
 */
@Schema(description = "学生实体类2")
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

}
