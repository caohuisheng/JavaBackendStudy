package com.chs.knife4j.custom;

/**
 * @author chs
 * @date 2025-12-11 16:52
 * @description todo
 */
import com.chs.knife4j.annotation.MapResponse;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

// @Component
public class MapSchemaCustomizer implements GlobalOpenApiCustomizer {

    private final RequestMappingHandlerMapping handlerMapping;

    public MapSchemaCustomizer(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @Override
    public void customise(OpenAPI openAPI) {
        Map<String, Schema> schemas = openAPI.getComponents().getSchemas();
        Map<String, Schema> schemaMap = CustomOperationCustomizer.getSchemaMap();
        for (Map.Entry<String, Schema> entry : schemaMap.entrySet()) {
            if (!schemas.containsKey(entry.getKey()) ||
                    (!entry.getValue().getClass().equals(schemas.get(entry.getKey()).getClass()) && entry.getValue().getAllOf() != null)) {
                schemas.put(entry.getKey(), entry.getValue());
            }
        }
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
        //
        // handlerMethods.forEach((info, handlerMethod) -> {
        //     MapResponse mapResponse = handlerMethod.getMethod().getAnnotation(MapResponse.class);
        //     if (mapResponse != null) {
        //
        //         MethodParameter returnType = new MethodParameter(handlerMethod.getMethod(), -1);
        //         customizeMapSchema(openAPI, mapResponse);
        //     }
        // });
    }

    public Type extractParameterizedType(Class<?> rawClass, Class<?>... typeArgs) {
        // This is a simplified approach - real implementation would need
        // to handle more complex scenarios
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return typeArgs;
            }

            @Override
            public Type getRawType() {
                return rawClass;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }

    private void customizeMapSchema(OpenAPI openAPI, MapResponse mapResponse) {
        Type type = extractParameterizedType(mapResponse.rawType(), mapResponse.typeArgs());
        Schema schema = ModelConverters.getInstance().resolveAsResolvedSchema(new AnnotatedType(type)).schema;
        openAPI.getComponents().addSchemas(schema.getName(), schema);

    //     if (annotation.implementAsObject()) {
    //         // 将Map转换为对象 schema
    //         Schema<?> schema = new ObjectSchema();
    //
    //         for (MapField field : annotation.fields()) {
    //             Schema<?> propertySchema = new Schema<>();
    //             propertySchema.setType(field.type());
    //             propertySchema.setDescription(field.description());
    //             propertySchema.setFormat(field.format());
    //             propertySchema.setExample(field.example());
    //
    //             schema.addProperty(field.name(), propertySchema);
    //             if (field.required()) {
    //                 schema.addRequiredItem(field.name());
    //             }
    //         }
    //
    //         // 这里需要将schema添加到OpenAPI模型中
    //         // 实际实现可能需要更复杂的处理来确保schema被正确注册
    //         groupedOpenApi.getOpenApi().getComponents().addSchemas("CustomMapResponse", schema);
    //     } else {
    //         // 保持为Map但添加描述
    //         MapSchema mapSchema = new MapSchema();
    //         Schema<?> additionalProperties = new Schema<>();
    //
    //         // 创建一个示例schema，实际应该根据字段类型动态生成
    //         Schema<?> valueSchema = new Schema<>();
    //         valueSchema.setType("string"); // 默认类型，可根据需要调整
    //
    //         mapSchema.setAdditionalProperties(valueSchema);
    //         mapSchema.setDescription("Map containing various fields");
    //
    //         // 添加到组件中
    //         openAPI.getComponents().addSchemas("CustomMapResponse", mapSchema);
    //     }
    }
}