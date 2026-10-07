package com.itheima.demo4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("赵金麦");
        list.add("刘亦菲");
        list.add("郑爽");
        list.add("林更新");

        //将使用流操作完的数据收集到list列表中
        /*Stream<String> listStream = list.stream().filter(s -> s.length() == 3);
        List<String> names = listStream.collect(Collectors.toList());
        for(String name:names){
            System.out.println(name);
        }*/

        Set<Integer> set = new HashSet<>();
        set.add(12);
        set.add(22);
        set.add(32);
        set.add(42);

        //将使用流操作完的数据收集到set集合中
        /*Stream<Integer> setStream = set.stream().filter(age -> age>20);
        Set<Integer> ages = setStream.collect(Collectors.toSet());
        for(int age:ages){
            System.out.println(age);
        }*/

        //将使用流操作完的数据收集到map集合中
        String[] strArray = new String[]{"赵金麦,20","刘亦菲,35","王纯,20"};
        Stream<String> arrayStream = Stream.of(strArray).filter(s -> Integer.parseInt(s.split(",")[1]) > 20);
        Map<String, Integer> map = arrayStream.collect(Collectors.toMap(s -> s.split(",")[0],
                s -> Integer.parseInt(s.split(",")[1])));
        Set<String> keySet = map.keySet();
        for(String k:keySet){
            Integer value = map.get(k);
            System.out.println(k+","+value);
        }

    }
}
