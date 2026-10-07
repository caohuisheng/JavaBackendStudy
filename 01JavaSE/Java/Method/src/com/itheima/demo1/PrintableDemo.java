package com.itheima.demo1;

public class PrintableDemo {
    public static void main(String[] args) {
        //Lambda表达式
        usePrintable(x -> System.out.println(x));
        //方法引用
        usePrintable(System.out::println);
    }
    public static void usePrintable(Printable p){
        p.printInt(666);
    }
}
