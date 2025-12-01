package com.chs.knife4j.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
                .build();
    }

    @Bean
    public GroupedOpenApi group2() {
        return GroupedOpenApi.builder().group("group2")
                .packagesToScan("com.chs.knife4j.controller")
                // .packagesToExclude("com.chs.knife4j.controller")
                .pathsToMatch("/test/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(openApiInfo());
    }

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
