package com.chs.knife4j.entity.temp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: chs
 * CreateTime: 2025-11-30
 * Description: 学成实体类2（测试同名类在schemas中只显示1个的问题）
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

    @Schema(description = "性别")
    private Byte sex;

}
