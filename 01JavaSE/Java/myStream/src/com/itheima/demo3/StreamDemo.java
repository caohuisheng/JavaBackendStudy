package com.itheima.demo3;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("赵金麦");
        arrayList.add("林更新");
        arrayList.add("王祖贤");
        arrayList.add("鹿晗");

        Stream<String> s1 = arrayList.stream().limit(3);
        Stream<String> s2 = arrayList.stream().skip(2);

        //Stream.concat(s1,s2).forEach(System.out::println);
        System.out.println("-----");
        Stream.concat(s1,s2).distinct().forEach(System.out::println);
    }
}
