package com.chs.springfox.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import java.util.Date;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@ApiModel(description = "用户实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private Byte sex;

}
