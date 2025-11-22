//
package com.knife4j.demo.config;

import com.knife4j.demo.plugin.MyRequestArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.List;


@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
@EnableSwagger2WebMvc
public class SwaggerConfiguration implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new MyRequestArgumentResolver());
    }


    @Bean(value = "defaultApi")
    public Docket defaultApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("测试")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.knife4j.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Knife4j 4.4.x & Spring Boot 2.7 & Swagger2")
                .description("Knife4j 4.4.x & Spring Boot 2.7 & Swagger2")
                .termsOfServiceUrl("https://doc.xiaominfo.com/")
                .contact(new Contact("八一菜刀", "https://www.xiaominfo.com", "xiaoymin@foxmail.com"))
                .version("")
                .build();
    }
}
