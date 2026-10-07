package com.itheima.demo6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> array = new ArrayList<>();

        Class<ArrayList> c = ArrayList.class;
        Method methodAdd = c.getMethod("add", Object.class);

        methodAdd.invoke(array,"hello");
        methodAdd.invoke(array,"world");
        methodAdd.invoke(array,"java");
        methodAdd.invoke(array,"hh");
        methodAdd.invoke(array,123);
        methodAdd.invoke(array,new int[]{1,2,3});

        System.out.println(array);
    }
}
