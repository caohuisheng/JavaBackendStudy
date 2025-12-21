package com.chs.knife4j.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SpringDocConfigProperties;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.*;
import org.springframework.http.HttpHeaders;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
// @Order(Ordered.HIGHEST_PRECEDENCE)
// @Lazy(false)
// @ConditionalOnProperty(name = "springdoc.swagger-ui.enabled", matchIfMissing = true)
@Configuration
public class SwaggerConfig{

    @Autowired(required = false)
    private SpringDocConfigProperties springDocConfigProperties;
    @Autowired(required = false)
    private SwaggerUiConfigProperties swaggerUiConfigProperties;

    private void disable(){
        System.setProperty("springdoc.swagger-ui.enabled", "false");
        System.setProperty("springdoc.api-docs.enabled", "false");
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct====");
        System.out.println(springDocConfigProperties);
        System.out.println(swaggerUiConfigProperties);
        // System.setProperty("springdoc.swagger-ui.enabled", "false");
        // System.setProperty("springdoc.api-docs.enabled", "false");
        // disable();
        // System.out.println(springDocConfigProperties.getApiDocs().isEnabled());
        // System.out.println(swaggerUiConfigProperties.isEnabled());
        // springDocConfigProperties.getApiDocs().setEnabled(false);
        // swaggerUiConfigProperties.setEnabled(false);
        // System.out.println(springDocConfigProperties.getApiDocs().isEnabled());
        // System.out.println(swaggerUiConfigProperties.isEnabled());
    }

    @Bean
    public GroupedOpenApi group1() {
        return GroupedOpenApi.builder().group("default")
                .packagesToScan("com.chs.knife4j.controller")
                .pathsToMatch("/**")
                .addOperationCustomizer((operation, handlerMethod) -> {
                    return operation.addParametersItem(new HeaderParameter().name("Global_Param").example("111").description("全局参数").required(true));
                })
                .build();
    }

    // @Bean
    public GroupedOpenApi group2() {
        return GroupedOpenApi.builder().group("group2")
                .packagesToScan("com.chs.knife4j.controller")
                // .packagesToExclude("com.chs.knife4j.controller")
                .pathsToMatch("/test_new_feature/**")
                // .addOperationCustomizer((operation, handlerMethod) -> {
                //     return operation.addParametersItem(new HeaderParameter().name("Global_Param").example("111").description("全局参数").required(true));
                // })
                .build();
    }

    @Bean
    public OpenAPI customOpenApi() {
        Components components = new Components();
        components.addSecuritySchemes("AUTH_BASIC", new SecurityScheme().name("AUTH_BASIC").type(SecurityScheme.Type.HTTP).in(SecurityScheme.In.HEADER).scheme("basic"));
        // components.addSecuritySchemes("AUTH_API_KEY", new SecurityScheme().name("AUTH_API_KEY").type(SecurityScheme.Type.APIKEY).in(SecurityScheme.In.HEADER));
        // components.addSecuritySchemes("AUTH_BEARER", new SecurityScheme().name("AUTH_BEARER").type(SecurityScheme.Type.HTTP).in(SecurityScheme.In.HEADER).scheme("bearer").bearerFormat("JWT"));
        // components.addSecuritySchemes("AUTH_OAUTH2", new SecurityScheme().name("AUTH_OAUTH2").type(SecurityScheme.Type.OAUTH2).flows(
        //         new OAuthFlows().clientCredentials(new OAuthFlow().authorizationUrl("/oauth/authorize").tokenUrl("/oauth/token"))
        // ));
        return new OpenAPI()
                .info(openApiInfo())
                // 配置全局Basic验证
                // .addSecurityItem(new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION))
                .components(components);
    }

    @Bean
    public GlobalOpenApiCustomizer securityGlobalOpenApiCustomizer() {
        return openApi -> {
            // 全局添加鉴权参数
            if(openApi.getPaths()!=null){
                openApi.getPaths().forEach((s, pathItem) -> {
                    pathItem.readOperations().forEach(operation -> {
                        operation.addSecurityItem(new SecurityRequirement().addList("AUTH_BASIC"));
                        // operation.addSecurityItem(new SecurityRequirement().addList("AUTH_API_KEY"));
                        // operation.addSecurityItem(new SecurityRequirement().addList("AUTH_BEARER"));
                        // operation.addSecurityItem(new SecurityRequirement().addList("AUTH_OAUTH2"));
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
