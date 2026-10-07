package com.itheima.demo1;

import java.util.ArrayList;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("赵金麦");
        arrayList.add("林更新");
        arrayList.add("王祖贤");
        arrayList.add("鹿晗");
        //stream流
        arrayList.stream().filter(s -> s.startsWith("赵")).filter(s -> s.length() == 3).forEach(System.out::println);
    }
}
