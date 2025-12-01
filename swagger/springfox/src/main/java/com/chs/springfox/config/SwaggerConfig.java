package com.chs.springfox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@Configuration
@EnableSwagger2 //启用Swagger API文档
public class SwaggerConfig {

    /**
     * 返回实例Docket(Swagger API摘要)
     * 在方法中指定扫描的控制器包路径,
     * 只有在此路径下的Controller类才会自动生成Swagger API文档
     * @return
     */
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)  // 指定 Swagger 的版本为 2
                .apiInfo(apiInfo())  // 设定 API 文档的基本信息
                .groupName("group1")
                .select()  // 进入 API 选择模式
                .apis(RequestHandlerSelectors.basePackage("com.chs.springfox.controller"))  // 指定扫描的包路径，Swagger 将扫描该包下的所有 Controller 类
                .paths(PathSelectors.any())  // 指定要包含的路径，PathSelectors.any() 表示包括所有路径
                .build();  // 完成 Docket 实例的构建
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2)  // 指定 Swagger 的版本为 2
                .apiInfo(apiInfo())  // 设定 API 文档的基本信息
                .groupName("group2")
                .select()  // 进入 API 选择模式
                .apis(RequestHandlerSelectors.basePackage("com.chs.springfox.controller"))  // 指定扫描的包路径，Swagger 将扫描该包下的所有 Controller 类
                .paths(PathSelectors.ant("/test"))  // 指定要包含的路径，PathSelectors.any() 表示包括所有路径
                .build();  // 完成 Docket 实例的构建
    }

    /**
     * 配置一些基本的显示信息,
     * 比如标题,描述,版本,服务条款,联系方式等
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger API文档") // 标题
                .description("基于SpringFox的接口文档") // 描述
                .termsOfServiceUrl("http://www.example.com") // 服务条款
                .version("1.0.0") // 版本
                .license("Apache License-2.0") // 协议
                .licenseUrl("http://www.example.com") // 协议url
                .contact(new Contact("SpringFox","http://www.example.com","test@example.com")) // 联系方式
                .build();
    }

}
