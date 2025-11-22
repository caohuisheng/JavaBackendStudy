/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * Official Web Site: http://www.xiaominfo.com.
 */
package com.knife4j.demo.config;

import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.VendorExtension;

import java.util.List;

/**
 * @since:knife4j-spring-boot27-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/21 15:45
 */
public class HttpAuthenticationScheme extends SecurityScheme {
    public static final HttpAuthenticationBuilder BASIC_AUTH_BUILDER = new HttpAuthenticationBuilder().scheme("basic");
    public static final HttpAuthenticationBuilder JWT_BEARER_BUILDER = new HttpAuthenticationBuilder()
            .scheme("bearer")
            .bearerFormat("JWT");

    public HttpAuthenticationScheme(
            String name,
            String description,
            String type,
            String scheme,
            String bearerFormat,
            List<VendorExtension> extensions) {
        super(name, type);
    }
    protected HttpAuthenticationScheme(String name, String type) {
        super(name, type);
    }
}
