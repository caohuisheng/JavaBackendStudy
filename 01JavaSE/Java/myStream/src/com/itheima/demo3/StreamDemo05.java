package com.itheima.demo3;

import java.util.ArrayList;

public class StreamDemo05 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("12");
        list.add("22");
        list.add("32");
        list.add("20");

        list.stream().map(Integer::parseInt).forEach(System.out::println);
        System.out.println("-----");
        list.stream().mapToInt(Integer::parseInt).forEach(System.out::println);
        //list.stream().mapToInt(s -> Integer.parseInt(s)).forEach(System.out::println);
        System.out.println("-----");
        int res = list.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(res);
    }
}
