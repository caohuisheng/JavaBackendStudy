package com.chs.knife4j;

import org.springframework.core.ResolvableType;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
        System.out.println(genericType.getRawClass());
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

    public static void main(String[] args) {
        new TestGeneric().createClass();
    }

}
