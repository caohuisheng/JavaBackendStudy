package com.itheima.demo3;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        String s = getString(() -> "赵金麦");
        System.out.println(s);
        Integer i = getInteger(() -> 1314);
        System.out.println(i);
    }

    private static Integer getInteger(Supplier<Integer> sup){
        return sup.get();
    }

    private static String getString(Supplier<String> sup){
        return sup.get();
    }
}
