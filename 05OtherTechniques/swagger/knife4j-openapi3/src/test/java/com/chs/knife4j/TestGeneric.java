package com.chs.knife4j;

import com.chs.knife4j.entity.Result;
import com.chs.knife4j.entity.User;
import com.google.common.reflect.TypeToken;
import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FieldAccessor;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-12-07
 */
public class TestGeneric {

    private void test(){
        // 表示 ArrayList<String> 的类型
        ResolvableType type = ResolvableType.forClassWithGenerics(ArrayList.class, String.class);

        // 获取原始类型
        Class<?> rawType = type.getRawClass();
        System.out.println("Raw type: " + rawType); // ArrayList.class

        // 获取泛型参数
        ResolvableType genericType = type.getGeneric(0);
        System.out.println("Generic type: " + genericType.resolve()); // String.class

        System.out.println(type.getType());
        System.out.println(genericType.getType());
    }

    void createClass(){
        // 动态创建类
        DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .name("com.example.DynamicProduct")
                .defineField("id", int.class, Visibility.PRIVATE)
                .defineField("price", double.class, Visibility.PRIVATE)
                .defineMethod("getPrice", double.class, Visibility.PUBLIC)
                .intercept(FieldAccessor.ofField("price"))
                .defineMethod("setPrice", void.class, Visibility.PUBLIC)
                .withParameters(double.class)
                .intercept(FieldAccessor.ofField("price"))
                .make();

        // 加载类
        Class<?> dynamicClass = dynamicType.load(TestGeneric.class.getClassLoader())
                .getLoaded();

        // 使用动态类
        try {
            Object product = dynamicClass.getDeclaredConstructor().newInstance();
            dynamicClass.getField("id").set(product, 1001);
            dynamicClass.getField("price").set(product, 99.99);
            System.out.println("Product ID: " + dynamicClass.getField("id").get(product));
            System.out.println("Product Price: " + dynamicClass.getMethod("getPrice").invoke(product));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    void getGenericClass1(){
        Result<String> r1 = new Result<String>() {};
        Result<String> r2 = new Result<String>();
        System.out.println(r1.getClass());
        System.out.println(r2.getClass());
    }

    void getGenericClass2(){
        TypeToken<Result<String>> typeToken = new TypeToken<Result<String>>() {};
        Class<?> rawType = typeToken.getRawType(); // 获取原始类型List.class
        Type type = typeToken.getType(); // 获取完整的泛型类型信息
        System.out.println(rawType);
        System.out.println(type);
    }

    void getGenericClass3(){
        ResolvableType resolvableType = ResolvableType.forClass(new Result<String>().getClass());
        Class<?> type = resolvableType.as(Result.class).getGeneric(0).resolve();
        System.out.println("Generic type: " + type);
    }

    void generateConfig(){
        // 通过具体子类获取
        try {
            Field field = Result.class.getDeclaredField("data");
            Type genericType = field.getGenericType();
            System.out.println(genericType);
            if (genericType instanceof ParameterizedType) {
                Type[] actualTypes = ((ParameterizedType) genericType).getActualTypeArguments();
                // 处理实际类型参数
                System.out.println(actualTypes);
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new TestGeneric().test();
    }
}
