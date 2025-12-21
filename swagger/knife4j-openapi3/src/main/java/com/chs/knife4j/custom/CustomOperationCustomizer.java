package com.chs.knife4j.custom;

import com.chs.knife4j.annotation.MapParameter;
import com.chs.knife4j.annotation.MapRequest;
import com.chs.knife4j.annotation.MapResponse;
import com.chs.knife4j.entity.Result;
import com.chs.knife4j.entity.Student;
import com.chs.knife4j.entity.User;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ResolvedSchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.DynamicType;
import org.springdoc.core.SpringDocConfiguration;
import org.springdoc.core.SpringDocUtils;
import org.springdoc.core.customizers.GlobalOperationCustomizer;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author: chs
 * @date: 2025-12-05 08:15
 * @description: todo
 */
@Component
public class CustomOperationCustomizer implements GlobalOperationCustomizer {

    private Integer customModelIndex = 1;


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
                for (Map.Entry<String, io.swagger.v3.oas.models.media.Schema> entry : resolvedSchema.referencedSchemas.entrySet()) {
                    CustomOpenApiCustomizer.addSchema(entry.getKey(), entry.getValue());
                }
            }
        }

        MapRequest mapRequest = handlerMethod.getMethodAnnotation(MapRequest.class);
        if (mapRequest != null) {
            // 修改 RequestBody
            if (operation.getRequestBody() != null) {
                RequestBody requestBody = operation.getRequestBody();
                Class<?> dataType = createClass(mapRequest.value());
                ResolvedSchema resolvedSchema = ModelConverters.getInstance().resolveAsResolvedSchema(new AnnotatedType(dataType).resolveAsRef(true));
                requestBody.setContent(new Content().addMediaType("application/json", new MediaType().schema(resolvedSchema.schema)));
                for (Map.Entry<String, io.swagger.v3.oas.models.media.Schema> entry : resolvedSchema.referencedSchemas.entrySet()) {
                    CustomOpenApiCustomizer.addSchema(entry.getKey(), entry.getValue());
                }
            }
        }
        return operation;
    }

    private Class<?> createClass(MapParameter[] fields){
        DynamicType.Builder<?> builder = new ByteBuddy().subclass(Object.class)
                .name("com.example.CustomModel" + (customModelIndex ++ ))
                .annotateType(AnnotationDescription.Builder.ofType(Schema.class)
                        // .define("description", "自定义实体")
                        .build());

        // 添加字段
        for (MapParameter field : fields) {
            builder = builder.defineField(field.name(), field.type(), Visibility.PUBLIC)
                    .annotateField(AnnotationDescription.Builder.ofType(Schema.class)
                            .define("description", field.description())
                            .define("example", field.example())
                            .build());
        }

        return builder.make()
                .load(getClass().getClassLoader())
                .getLoaded();
    }
}