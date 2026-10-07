package com.itheima.demo6;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        String s = "赵金麦,20";
        convert(s,ss -> ss.split(",")[1],ss->Integer.parseInt(ss),i -> (2023-20));
    }
    static void convert(String s, Function<String,String> fun1,Function<String,Integer> fun2,Function<Integer,Integer> fun3){
        int i = fun1.andThen(fun2).andThen(fun3).apply(s);
        System.out.println("赵金麦生日："+i);
    }
}
