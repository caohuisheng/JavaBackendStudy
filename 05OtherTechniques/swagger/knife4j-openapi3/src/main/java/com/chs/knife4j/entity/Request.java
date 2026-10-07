package com.chs.knife4j.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-12-14
 */
@Schema(description = "API请求结构")
@Data
public class Request<T> {

    @Schema(description = "页码")
    private Integer page;

    @Schema(description = "每页大小")
    private Integer pageSize;

    @Schema(description = "请求数据", oneOf = User.class)
    private T data;

}
