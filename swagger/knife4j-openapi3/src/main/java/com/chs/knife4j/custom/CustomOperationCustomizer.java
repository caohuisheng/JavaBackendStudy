package com.chs.knife4j.custom;

import com.chs.knife4j.annotation.MapResponse;
import com.chs.knife4j.entity.Result;
import com.chs.knife4j.entity.Student;
import com.chs.knife4j.entity.User;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ResolvedSchema;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
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
// @Component
public class CustomOperationCustomizer implements GlobalOperationCustomizer {

    // @Autowired
    // private ApplicationContext applicationContext;

    // @Lazy
    // @Autowired
    // private OpenAPI openAPI;

    // public CustomOperationCustomizer(OpenAPI openAPI) {
    //     this.openAPI = openAPI;
    // }

    // private final ObjectProvider<OpenAPI> openAPIProvider;

    // private static List<String> ;

    // public CustomOperationCustomizer(ObjectProvider<OpenAPI> openAPIProvider) {
    //     this.openAPIProvider = openAPIProvider;
    // }

    private static Map<String, Schema> schemaMap = new HashMap<>();

    public static Map<String, Schema> getSchemaMap() {
        return schemaMap;
    }

    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {
        // System.out.println(operation.getOperationId());
        MapResponse mapResponse = handlerMethod.getMethodAnnotation(MapResponse.class);
        if (mapResponse != null) {
            // OpenAPI openAPI = openAPIProvider.getIfAvailable();
            // 修改 RequestBody
            if (operation.getResponses() != null) {
                ApiResponses responses = operation.getResponses();
                ApiResponse response = new ApiResponse();
                response.setDescription(mapResponse.description());
                ResolvableType type = ResolvableType.forClassWithGenerics(mapResponse.rawType(), mapResponse.typeArgs()[0]);
                // Schema dataSchema = ModelConverters.getInstance().resolveAsResolvedSchema(new AnnotatedType(mapResponse.typeArgs()[0])).schema;
                ResolvedSchema resolvedSchema = ModelConverters.getInstance().resolveAsResolvedSchema(new AnnotatedType(type.getType()).resolveAsRef(true));
                // resultSchema.getProperties().put("data", resultSchema);
                // Schema typeSchema = ModelConverters.getInstance().resolveAsResolvedSchema(new AnnotatedType(mapResponse.typeArgs()[0])).schema;
                // resultSchema.getProperties().put("data", typeSchema);
                // String ref = "#/components/schemas/"+schema.getName();
                // schema.set$ref(ref);
                schemaMap.putAll(resolvedSchema.referencedSchemas);
                response.setContent(new Content().addMediaType("application/json", new MediaType().schema(resolvedSchema.schema)));
                responses.addApiResponse(mapResponse.responseCode(), response);
            }

        }
        return operation;
    }

    private void getType(Class<Result> clazz1, Class<User> clazz2){
        ResolvableType type = ResolvableType.forClassWithGenerics(Result.class, Student.class);
        Schema<?> schema = ModelConverters.getInstance()
                .resolveAsResolvedSchema(new AnnotatedType(type.getType()))
                .schema;
    }

    private void test(){
        ResolvableType type = ResolvableType.forClassWithGenerics(Result.class, Student.class);
        ResolvedSchema dataSchema = ModelConverters.getInstance().readAllAsResolvedSchema(User.class);
        ResolvedSchema resultSchema = ModelConverters.getInstance().readAllAsResolvedSchema(Result.class);
        resultSchema.schema.getProperties().put("data", dataSchema.schema);
        System.out.println(resultSchema);
    }

    public static void main(String[] args) {

    }
}