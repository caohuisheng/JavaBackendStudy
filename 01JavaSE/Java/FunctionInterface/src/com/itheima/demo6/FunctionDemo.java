package com.itheima.demo6;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        convert("100",s -> Integer.parseInt(s),i -> String.valueOf(i+566));
    }

    static void convert(String s, Function<String,Integer> fun1,Function<Integer,String> fun2){
//        Integer i = fun1.apply(s);
//        String ss = fun2.apply(i);
        String ss = fun1.andThen(fun2).apply(s);
        System.out.println(ss);
    }
}
