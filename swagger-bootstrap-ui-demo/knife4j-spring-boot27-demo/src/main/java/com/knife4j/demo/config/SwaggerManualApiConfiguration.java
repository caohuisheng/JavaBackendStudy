/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * Official Web Site: http://www.xiaominfo.com.
 */
package com.knife4j.demo.config;

import cn.hutool.core.collection.CollectionUtil;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.service.Operation;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingScannerPlugin;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;

import java.util.*;

/**
 * https://gitee.com/xiaoym/knife4j/issues/I4I1YC
 * @since:knife4j-spring-boot27-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/11 22:13
 */
@Component
public class SwaggerManualApiConfiguration implements ApiListingScannerPlugin {
    @Override
    public List<ApiDescription> apply(DocumentationContext context) {

        Parameter username = new ParameterBuilder()
                .name("username")
                .description("用户名")
                .type(new TypeResolver().resolve(String.class))
                .modelRef(new ModelRef("string"))
                .parameterType("form")
                .required(true)
                .defaultValue("admin")
                .build();
        Parameter password = new ParameterBuilder()
                .name("password")
                .description("密码")
                .type(new TypeResolver().resolve(String.class))
                .modelRef(new ModelRef("string"))
                .parameterType("form")
                .required(true)
                .defaultValue("123456")
                .build();
        //2.接口的每种请求方式(GET/POST...)为一个 Operation
        Set<String> set = new HashSet<String>();
        set.add("测试用");
        Operation loginOperation = new OperationBuilder(new CachingOperationNameGenerator())
                .method(HttpMethod.POST)
                .summary("登录")
                .uniqueId("loginIn")
                .tags(set)
                .responseMessages(CollectionUtil.newHashSet(new ResponseMessageBuilder().code(200).message("OK").build()))
                .consumes(CollectionUtil.newHashSet(MediaType.MULTIPART_FORM_DATA_VALUE))
                .produces(CollectionUtil.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                .parameters(Arrays.asList(username, password))
                .build();

        ApiDescription loginDesc = new ApiDescription("health-check-controller", "/login", "登录",
                Collections.singletonList(loginOperation), false);


        Operation logoutOperation = new OperationBuilder(new CachingOperationNameGenerator())
                .method(HttpMethod.POST)
                .summary("登出")
                .notes("退出登录")
                .uniqueId("loginOut")
                .tags(set)
                .responseMessages(CollectionUtil.newHashSet(new ResponseMessageBuilder().code(200).message("OK").build()))
                .consumes(CollectionUtil.newHashSet(MediaType.MULTIPART_FORM_DATA_VALUE))
                .produces(CollectionUtil.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                .build();
        ApiDescription logoutDesc = new ApiDescription("health-check-controller", "/logout", "注销",
                Collections.singletonList(logoutOperation), false);

        List<ApiDescription> apiDescriptions = new ArrayList<>(Arrays.asList(loginDesc, logoutDesc));

        return apiDescriptions;
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return DocumentationType.SWAGGER_2.equals(documentationType);
    }
}
