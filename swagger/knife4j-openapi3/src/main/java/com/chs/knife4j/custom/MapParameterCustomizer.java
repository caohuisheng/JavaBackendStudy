package com.chs.knife4j.custom;


import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.ParameterCustomizer;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * @author: chs
 * @date: 2025-12-05 00:06
 * @description: todo
 */
@Component
public class MapParameterCustomizer implements ParameterCustomizer {

    @Override
    public Parameter customize(Parameter parameter, MethodParameter methodParameter) {
        MapDescription annotation = methodParameter.getParameterAnnotation(MapDescription.class);
        if (annotation != null && Map.class.isAssignableFrom(methodParameter.getParameterType())) {
            Schema<?> schema = parameter.getSchema();
            schema.set$ref("User");
            if (schema instanceof MapSchema) {
                // MapSchema mapSchema = (MapSchema) schema;
                // Map<String,Schema> properties = new HashMap<>();
                // Schema<?> s = new Schema<>();
                // s.setName(annotation.keyDescription());
                // s.setDescription(annotation.valueDescription());
                // properties.put(annotation.keyDescription(), s);
                // mapSchema.setProperties(properties);

                // Schema<?> additionalProperties = new Schema<>();
                // additionalProperties.setDescription(annotation.valueDescription());
                // additionalProperties.setType(getSchemaType(annotation.valueType()));
                // mapSchema.setAdditionalProperties(additionalProperties);

                // 如果需要，也可以设置key的描述（但OpenAPI规范中Map的key通常是字符串）
                Schema<?> keySchema = new Schema<>();
                keySchema.setDescription(annotation.keyDescription());
                keySchema.setType(getSchemaType(annotation.keyType()));
                // 注意：OpenAPI规范中Map的key类型设置方式可能有限制
            }
        }
        return parameter;
    }

    private String getSchemaType(Class<?> type) {
        if (type == String.class) return "string";
        if (type == Integer.class || type == int.class) return "integer";
        if (type == Long.class || type == long.class) return "integer";
        if (type == Boolean.class || type == boolean.class) return "boolean";
        if (type == Float.class || type == float.class ||
                type == Double.class || type == double.class) return "number";
        return "object";
    }
}