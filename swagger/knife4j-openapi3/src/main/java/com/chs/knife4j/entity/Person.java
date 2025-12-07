package com.chs.knife4j.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: chs
 * @date: 2025-12-05 16:28
 * @description: todo
 */
@Data
@Schema(name = "Person",description = "Person",title = "Person")
public class Person {

    @Schema(name = "id",description = "编号",minimum = "1",maximum = "128",defaultValue = "2")
    private Integer id;

    @Schema(name = "name",description = "姓名",minLength = 4,maxLength = 10,defaultValue = "bob")
    private String name;

}