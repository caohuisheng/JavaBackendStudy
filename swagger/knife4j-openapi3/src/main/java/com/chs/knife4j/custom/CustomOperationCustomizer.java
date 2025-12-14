package com.chs.knife4j.custom;

import com.chs.knife4j.annotation.MapParameter;
import com.chs.knife4j.annotation.MapRequest;
import com.chs.knife4j.annotation.MapResponse;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.converter.ResolvedSchema;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.DynamicType;
import org.springdoc.core.customizers.GlobalOperationCustomizer;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import java.util.Map;


/**
 * @author: chs
 * @date: 2025-12-05 08:15
 * @description: todo
 */
@Component
public class CustomOperationCustomizer implements GlobalOperationCustomizer {

    private static Integer customModelIndex = 1;

    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {
        MapResponse mapResponse = handlerMethod.getMethodAnnotation(MapResponse.class);
        if (mapResponse != null) {
            // 修改 RequestBody
            if (operation.getResponses() != null) {
                ApiResponses responses = operation.getResponses();
                ApiResponse response = new ApiResponse();
                response.setDescription(mapResponse.description());
                Class<?> dataType = mapResponse.genericType();
                if(dataType == Void.class){
                    dataType = createClass(mapResponse.fields());
                }
                ResolvableType type = ResolvableType.forClassWithGenerics(mapResponse.rawType(), dataType);
                ResolvedSchema resolvedSchema = ModelConverters.getInstance().resolveAsResolvedSchema(new AnnotatedType(type.getType()).resolveAsRef(true));
                response.setContent(new Content().addMediaType("application/json", new MediaType().schema(resolvedSchema.schema)));
                responses.addApiResponse(mapResponse.responseCode(), response);
                for (Map.Entry<String, Schema> entry : resolvedSchema.referencedSchemas.entrySet()) {
                    CustomOpenApiCustomizer.addSchema(entry.getKey(), entry.getValue());
                }
            }
        }

        MapRequest mapRequest = handlerMethod.getMethodAnnotation(MapRequest.class);
        if(mapRequest != null){
            if(operation.getRequestBody() != null){
                MapParameter[] parameters = mapRequest.value();
                RequestBody requestBody = operation.getRequestBody();
                // MapSchema schema = new MapSchema();
                // Map<String, Schema> properties = new HashMap<>();
                // for (MapParameter parameter : parameters) {
                //     Schema s = new Schema().type(getSchemaType(parameter.type())).description(parameter.description()).example(parameter.example());
                //     properties.put(parameter.name(), s);
                // }
                // schema.setProperties(properties);
                Class<?> clazz = createClass(parameters);
                ResolvedSchema resolvedSchema = ModelConverters.getInstance().resolveAsResolvedSchema(new AnnotatedType(clazz).resolveAsRef(true));
                requestBody.setContent(new Content().addMediaType("application/json", new MediaType().schema(resolvedSchema.schema)));
                for (Map.Entry<String, Schema> entry : resolvedSchema.referencedSchemas.entrySet()) {
                    CustomOpenApiCustomizer.addSchema(entry.getKey(), entry.getValue());
                }
            }
        }
        return operation;
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

    private Class<?> createClass(MapParameter[] parameters){
        DynamicType.Builder<Object> builder = new ByteBuddy()
                .subclass(Object.class)
                .name("com.example.CustomModel" + (customModelIndex++))
                .annotateType(AnnotationDescription.Builder
                        .ofType(io.swagger.v3.oas.annotations.media.Schema.class)
                        // .define("description", "自定义实体类")
                        .build());
        for (MapParameter parameter : parameters) {
            builder = builder.defineField(parameter.name(), parameter.type(), Visibility.PUBLIC)
                    .annotateField(AnnotationDescription.Builder
                            .ofType(io.swagger.v3.oas.annotations.media.Schema.class)
                            .define("description", parameter.description())
                            .define("example", parameter.example())
                            .build());
        }

        Class<?> clazz = builder.make().load(CustomOperationCustomizer.class.getClassLoader()).getLoaded();
        return clazz;
    }

}