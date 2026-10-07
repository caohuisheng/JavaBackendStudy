package com.itheima.demo2;

import java.util.ArrayList;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("赵金麦");
        arrayList.add("林更新");
        arrayList.add("王祖贤");
        arrayList.add("鹿晗");

        arrayList.stream().limit(3).forEach(System.out::println);
        System.out.println("----");
        arrayList.stream().skip(3).forEach(System.out::println);
        System.out.println("----");
        arrayList.stream().skip(2).limit(2).forEach(System.out::println);
    }
}
