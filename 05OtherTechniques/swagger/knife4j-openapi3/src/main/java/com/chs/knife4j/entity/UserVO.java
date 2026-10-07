package com.chs.knife4j.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-12-07
 */
@Data
@Schema(description = "用户信息响应体")
public class UserVO {

    @Schema(description = "用户唯一ID", example = "1001")
    private Long id;

    @Schema(description = "用户名", example = "zhangsan")
    private String username;

    @Schema(description = "用户邮箱", example = "zhangsan@example.com")
    private String email;

    @Schema(description = "年龄", example = "25")
    private Integer age;

    @Schema(description = "性别 0-男 1-女", example = "0")
    private Integer sex;

    @Schema(description = "账户创建时间", example = "2025-12-05 10:00:00")
    private Date createTime;
}
