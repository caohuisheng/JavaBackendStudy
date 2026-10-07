package com.itheima.demo4;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        operatorString("赵金麦",s -> System.out.println(s),
                s -> System.out.println(new StringBuilder(s).reverse().toString()));
    }

    private static void operatorString(String name, Consumer<String> con1,Consumer<String> con2){
//        con1.accept(name);
//        con2.accept(name);
        con1.andThen(con2).accept(name);
    }
}
