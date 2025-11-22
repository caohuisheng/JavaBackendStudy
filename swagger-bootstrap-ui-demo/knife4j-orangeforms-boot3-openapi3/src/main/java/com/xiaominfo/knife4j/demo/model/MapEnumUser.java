/*
 * Copyright (C) 2022 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */
package com.xiaominfo.knife4j.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;


/**
 * @since:knife4j-spring-boot27-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/12/7 12:40
 */
@Data
public class MapEnumUser {

    @Schema(description = "姓名",allowableValues = "张飞,关羽,赵云")
    @Size(min = 2,max = 10,message = "姓名长度必须在2-10之间")
    private String name;

    @Schema(description = "枚举类型")
    private CourseType courseType;
}
