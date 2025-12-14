package com.chs.knife4j.custom;

/**
 * @author chs
 * @date 2025-12-11 16:52
 * @description todo
 */

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomOpenApiCustomizer implements GlobalOpenApiCustomizer {

    private static Map<String, Schema> schemaMap = new HashMap<>();

    public static void addSchema(String key, Schema schema) {
        if (!schemaMap.containsKey(key) ||
                (!schema.getClass().equals(schemaMap.get(key).getClass()))) {
            schemaMap.put(key, schema);
        }
    }

    @Override
    public void customise(OpenAPI openAPI) {
        Map<String, Schema> schemas = openAPI.getComponents().getSchemas();
        for (Map.Entry<String, Schema> entry : schemaMap.entrySet()) {
            String key = entry.getKey();
            Schema value = entry.getValue();
            if (!schemas.containsKey(key) ||
                    (!value.getClass().equals(schemas.get(key).getClass()))) {
                schemas.put(key, value);
            }
        }
        schemaMap.clear();
    }

}