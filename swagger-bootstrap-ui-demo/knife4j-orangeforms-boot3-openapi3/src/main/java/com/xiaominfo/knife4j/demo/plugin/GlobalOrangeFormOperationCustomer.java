package com.xiaominfo.knife4j.demo.plugin;

import cn.hutool.core.lang.hash.Hash;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.GlobalOperationCustomizer;
import org.springframework.expression.spel.support.ReflectionHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.method.HandlerMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/3/14 22:37
 * @since:knife4j-springdoc-openapi-demo
 */
@Slf4j
@Component
public class GlobalOrangeFormOperationCustomer implements GlobalOperationCustomizer {

    /**
     * 注解包路径名称
     */
    private final static String CUSTOM_ANNOTATION_NAME="com.xiaominfo.knife4j.demo.plugin.MyRequestBody";

    private final Map<Class<?>, Set<String>> cacheClassProperties = new HashMap<>();

    final static String REF_KEY="$ref";
    final static String REF_SCHEMA_PREFIX="#/components/schemas/";
    /**
     * 扩展前缀
     */
    final static String EXTENSION_ORANGE_FORM_NAME="x-orangeforms";
    final static String EXTENSION_ORANGE_FORM_IGNORE_NAME="x-orangeforms-ignore-parameters";

    /**
     * 校验判断当前请求方法是否包含{@link MyRequestBody}注解
     * @param method 接口method
     * @return
     */
    private boolean hasBodyAnnotation(Method method){
        if (method.getParameterCount()>0){
            //必须包含参数
            Annotation[][] annotations = method.getParameterAnnotations();
            if (annotations!=null&&annotations.length>0){
                for (Annotation[] paramAnnotations:annotations){
                    if (paramAnnotations!=null&&paramAnnotations.length>0){
                        long count=Stream.of(paramAnnotations).filter(annotation -> annotation.annotationType().getName().equalsIgnoreCase(CUSTOM_ANNOTATION_NAME)).count();
                        if (count>0){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {
        log.info("operation.");
        if (handlerMethod.getMethod().getParameterCount()>0){
            Parameter[] parameters = handlerMethod.getMethod().getParameters();
            if (parameters!=null&&parameters.length>0){
                Map<String,Object> properties=new HashMap<>();
                Map<String,Object> extensions=new HashMap<>();
                Set<String> fieldNames=new HashSet<>();
                for (Parameter parameter:parameters){
                    Annotation[] annotations = parameter.getAnnotations();
                    if (annotations!=null&&annotations.length>0){
                        // 校验判断当前请求方法是否包含{@link com.xiaominfo.knife4j.demo.config.TestBody}注解
                        long count=Stream.of(annotations).filter(annotation -> annotation.annotationType().getName().equalsIgnoreCase(CUSTOM_ANNOTATION_NAME)).count();
                        if (count>0){
                            Class<?> parameterType=parameter.getType();
                            //添加忽律参数名称
                            fieldNames.addAll(getClassFields(parameterType));
                            String schemaName=parameterType.getSimpleName();
                            //处理schema注解别名的情况
                            Schema schema = parameterType.getAnnotation(Schema.class);
                            if (schema!=null&& StrUtil.isNotBlank(schema.name())){
                                schemaName=schema.name();
                            }
                            properties.put(parameter.getName(), MapUtil.builder(REF_KEY,REF_SCHEMA_PREFIX+schemaName).build());
                            log.info("paramName:{}",parameter.getName());
                        }
                    }
                }
                if (!properties.isEmpty()){
                    extensions.put("properties",properties);
                    extensions.put("type","object");
                    String generateSchemaName=handlerMethod.getMethod().getName()+"DynamicReq";

                    Map<String,Object> orangeExtensions=new HashMap<>();
                    orangeExtensions.put(generateSchemaName,extensions);
                    //增加扩展属性
                    operation.addExtension(EXTENSION_ORANGE_FORM_NAME,orangeExtensions);
                    if (!fieldNames.isEmpty()){
                        operation.addExtension(EXTENSION_ORANGE_FORM_IGNORE_NAME,fieldNames);
                    }
                }
            }

        }
        return operation;
    }


    private Set<String> getClassFields(Class<?> parameterType){
        if (parameterType==null){
            return Collections.emptySet();
        }
        if (cacheClassProperties.containsKey(parameterType)){
            return cacheClassProperties.get(parameterType);
        }
        Set<String> fieldNames=new HashSet<>();
        try{
            Field[] fields = parameterType.getDeclaredFields();
            if (fields.length>0){
                for (Field field:fields){
                    fieldNames.add(field.getName());
                }
                cacheClassProperties.put(parameterType,fieldNames);
                return fieldNames;
            }
        }catch (Exception e){
            //ignore
        }

        return Collections.emptySet();
    }
}
