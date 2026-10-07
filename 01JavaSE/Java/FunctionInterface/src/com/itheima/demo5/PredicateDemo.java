package com.itheima.demo5;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        boolean b1 = checkString("hello",(s)->{
            return s.length()>6;
        });
        System.out.println(b1);
    }

    private static boolean checkString(String s, Predicate<String> pre){
        return pre.test(s);
    }
}
