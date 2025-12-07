package com.chs.knife4j.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import java.awt.*;
import java.util.Arrays;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi group1() {
        return GroupedOpenApi.builder().group("group1")
                .packagesToScan("com.chs.knife4j.controller")
                .pathsToMatch("/**")
                .addOperationCustomizer((operation, handlerMethod) -> {
                    return operation.addParametersItem(new HeaderParameter().name("groupCode").example("测试").description("集团code").schema(new StringSchema()._default("BR").name("groupCode").description("集团code")));
                })
                .build();
    }

    @Bean
    public GroupedOpenApi group2() {
        return GroupedOpenApi.builder().group("group2")
                .packagesToScan("com.chs.knife4j.controller")
                // .packagesToExclude("com.chs.knife4j.controller")
                .pathsToMatch("/test/**")
                .addOperationCustomizer((operation, handlerMethod) -> {
                    return operation.addParametersItem(new HeaderParameter().name("groupCode").example("测试").description("集团code").schema(new StringSchema()._default("BR").name("groupCode").description("集团code")));
                })
                .build();
    }

    @Bean
    public OpenAPI customOpenApi() {
        Components components = new Components();
        components.addSecuritySchemes(HttpHeaders.AUTHORIZATION, new SecurityScheme().name(HttpHeaders.AUTHORIZATION).type(SecurityScheme.Type.HTTP).in(SecurityScheme.In.HEADER).scheme("basic"));
        return new OpenAPI()
                .info(openApiInfo())
                // 配置全局Basic验证
                // .addSecurityItem(new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION))
                .components(new Components().addSecuritySchemes(HttpHeaders.AUTHORIZATION,new SecurityScheme()
                        .name(HttpHeaders.AUTHORIZATION).type(SecurityScheme.Type.HTTP).scheme("bearer")));
    }

    @Bean
    public GlobalOpenApiCustomizer securityGlobalOpenApiCustomizer() {
        return openApi -> {
            // 全局添加鉴权参数
            if(openApi.getPaths()!=null){
                openApi.getPaths().forEach((s, pathItem) -> {
                    pathItem.readOperations().forEach(operation -> {
                        operation.addSecurityItem(new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION));
                    });
                });
            }

        };
    }

    // 文档基本信息
    private Info openApiInfo(){
        return new Info()
                .title("swagger 接口文档")
                .description("基于SpringDoc的接口文档")
                .version("1.0.0")
                .termsOfService("http://www.example.com")
                .license(new License()
                        .name("Apache License-2.0")
                        .url("http://www.example.com"))
                .contact(new Contact()
                        .name("SpringDoc")
                        .email("test@example.com")
                        .url("http://www.example.com"));
    }

}
