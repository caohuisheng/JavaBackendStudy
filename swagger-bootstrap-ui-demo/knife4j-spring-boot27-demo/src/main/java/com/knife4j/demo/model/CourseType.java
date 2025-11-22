/*
 * Copyright (C) 2022 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */
package com.knife4j.demo.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.knife4j.demo.plugin.CourseTypeDeserializer;
import com.knife4j.demo.plugin.enums.CommonFormEnumParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @since:knife4j-spring-boot27-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/12/10 16:19
 */
@Slf4j
@Getter
@AllArgsConstructor
@JsonDeserialize(using = CourseTypeDeserializer.class)
public enum CourseType implements CommonFormEnumParser<CourseType> {
    /**
     * 图文
     */
    PICTURE(102, "图文"),
    /**
     * 音频
     */
    AUDIO(103, "音频"),
    /**
     * 视频
     */
    VIDEO(104, "视频"),
    /**
     * 外链
     */
    URL(105, "外链");

    private final int type;
    private final String desc;



    @JsonValue
    @Override
    public String toString() {
        return this.type+":"+this.desc;
    }

    @Override
    public CourseType fromValue(String input) {
        log.info("input:{}",input);
        for (CourseType courseType : CourseType.values()) {
            if (input.startsWith(Objects.toString(courseType.getType()))) {
                return courseType;
            }
        }
        throw new IllegalArgumentException("Invalid CourseType value: " + type);
    }
}
