package com.xiaominfo.knife4j.demo.model.v2;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2024/3/15 14:05
 * @since knife4j-spring-boot27-demo 1
 */
@Getter
@Setter
public class ApiBaseDTO <T> implements Serializable {
    private int code;

    private String msg;

    private String extra;

    private boolean success;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime time = LocalDateTime.now();

    private T data;
}
