package com.chs.knife4j.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: chs
 * @date: 2025-12-05 14:52
 * @description: todo
 */
@Data
@AllArgsConstructor
@Schema(description = "响应返回数据对象")
public class AjaxResult {
    @Schema(
            title = "code",
            description = "响应码",
            format = "int32",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer code;

    @Schema(
            title = "msg",
            description = "响应信息",
            accessMode = Schema.AccessMode.READ_WRITE,
            example = "成功或失败",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String msg;

    @Schema(title = "data",
            description = "响应数据",
            accessMode = Schema.AccessMode.READ_WRITE)
    private Object data;
}
