package com.chs.knife4j.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: chs
 * @date: 2025-12-05 16:34
 * @description: todo
 */
@Data
@Schema(name = "SchemaDTO",description = "Schema实体",title = "SchemaDto",requiredProperties = {"integerData","bigDecimal"})
public class SchemaDTO {

    @Schema(name = "integerData",description = "整型数据",title = "integerData",example = "1",minimum = "1",maximum = "20")
    private Integer integerData;

    @Schema(name = "bigDecimal",description = "小数类型",title = "bigDecimal",example = "2.3")
    private BigDecimal bigDecimal;

    @Schema(name = "floatData",description = "浮点型数据",title = "floatData",example = "1.0")
    private Float floatData;

    @Schema(name = "stringData",description = "字符串类型数据",title = "stringData",example = "This is stringData",minLength = 1,maxLength = 20)
    private String stringData;

    @Schema(name = "booleanData",description = "布尔类型数据",title = "booleanData",example = "true",defaultValue = "true")
    private Boolean booleanData;

    @Schema(name = "array",description = "数组类型数据",title = "array",example = "[1,2,3,4,5]")
    private int[] array;

    @Schema(name = "personList",description = "集合类型数据",title = "personList")
    private List<Person> personList;

    @Schema(name = "person",description = "对象类型数据",title = "person")
    private Person person;

    @Schema(name = "dateData",description = "日期类型数据",title = "dateData")
    private Date dateData;
}