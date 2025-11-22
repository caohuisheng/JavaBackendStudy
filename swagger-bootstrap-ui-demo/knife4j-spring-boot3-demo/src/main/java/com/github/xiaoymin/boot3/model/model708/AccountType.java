package com.github.xiaoymin.boot3.model.model708;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/7/8 12:29
 * @since knife4j-spring-boot3-demo
 */
@Schema(description = "账户类型")
public enum AccountType {
    USER, BACKEND, BACKEND_ADMIN, //企业后台管理员类型
    BACKEND_SUPER_ADMIN
}
