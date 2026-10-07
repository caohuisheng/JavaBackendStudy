package com.chs.knife4j.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@ApiModel(description = "学生实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @ApiModelProperty(value = "学生id")
    private Integer sid;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private Byte sex;

}
