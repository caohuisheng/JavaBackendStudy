package com.chs.knife4j.custom;

import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.core.converter.ModelConverters;
import org.springdoc.core.customizers.GlobalOperationCustomizer;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;


/**
 * @author: chs
 * @date: 2025-12-05 08:15
 * @description: todo
 */
@Component
public class CustomOperationCustomizer implements GlobalOperationCustomizer {

    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {
        // CustomOperation annotation = handlerMethod.getMethodAnnotation(CustomOperation.class);
        // if (annotation != null) {
        //     // 修改 RequestBody
        //     if (operation.getRequestBody() != null) {
        //         operation.getRequestBody().setDescription(annotation.requestBodyDescription());
        //
        //         // 如果指定了 Schema 类，动态设置 content
        //         if (annotation.requestBodySchema() != Void.class) {
        //             Schema<?> schema = ModelConverters.getInstance()
        //                     .resolveAsResolvedSchema(new AnnotatedType(annotation.requestBodySchema()))
        //                     .schema;
        //             operation.getRequestBody().setContent(new Content()
        //                     .addMediaType("application/json", new MediaType().schema(schema)));
        //         }
        //     }
        // }
        // return operation;
        MapParameters mapParameters = handlerMethod.getMethodAnnotation(MapParameters.class);
        if(mapParameters != null){
            MapParameter[] properties = mapParameters.properties();
            if(operation.getRequestBody() != null){
                for (MapParameter property : properties) {

                }

            }
        }
    }
}