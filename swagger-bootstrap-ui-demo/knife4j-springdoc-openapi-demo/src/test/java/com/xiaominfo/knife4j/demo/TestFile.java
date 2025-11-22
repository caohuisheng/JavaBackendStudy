package com.xiaominfo.knife4j.demo;

import com.xiaominfo.knife4j.demo.model.FileResp;
import com.xiaominfo.knife4j.demo.model.MyOrderParam;
import com.xiaominfo.knife4j.demo.model.QueryFile;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/1/10 15:45
 * @since:knife4j-springdoc-openapi-demo
 */
public class TestFile {


    public static void main(String[] args) {
        Class<?> clazz=MyOrderParam.class;
        Type genericSuperclass = clazz.getGenericSuperclass();

        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument.getTypeName()); // 输出: MyOrderParam.OrderInfo
            }
        }

        System.out.println(clazz.isPrimitive());
        System.out.println(Collection.class.isAssignableFrom(clazz));
    }


    public void test1(QueryFile queryFile){

        test2(queryFile.getFileResp());
    }

    public void test2(FileResp fileResp){
        fileResp.setName("test2");
    }
}
