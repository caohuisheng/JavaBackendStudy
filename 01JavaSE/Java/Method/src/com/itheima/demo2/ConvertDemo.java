package com.itheima.demo2;

public class ConvertDemo {
    public static void main(String[] args) {
        //Lambda表达式
        useConvert(x -> Integer.parseInt(x));
        //引用类方法
        useConvert(Integer::parseInt);  //Lambda表达式被类方法替代时，参数都传递给引用的方法
    }

    private static void useConvert(Convert c){
        int num = c.convert("1314");
        System.out.println(num);
    }
}
