package com.xiaominfo.knife4j.demo.extension;

import io.swagger.v3.oas.models.OpenAPI;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.OpenAPIService;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springdoc.core.customizers.OpenApiBuilderCustomizer;
import org.springframework.stereotype.Component;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/2/26 16:37
 * @since:knife4j-springdoc-openapi-demo
 */
@Slf4j
@Component
public class GlobalApiServiceCustomer implements OpenApiBuilderCustomizer {

    @Override
    public void customise(OpenAPIService openApiService) {

    }
}
