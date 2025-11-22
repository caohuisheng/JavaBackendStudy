package com.xiaominfo.knife4j.demo.model.v45;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2024/1/7 21:36
 * @since knife4j-springdoc-openapi-demo
 */
@Data
@Schema(description = "用户列表数据Bo")
public class UserListBo {


    @Schema(name = "user_data_bos",description = "已经进场用户数据")
    private List<UserDataBo> userDataBos;

    @Schema(description = "已经离开用户数据")
    private List<UserDataBo> outUserDataBos;
}
