package com.itheima.demo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bb");
        arrayList.add("ddddd");
        System.out.println("before sort:"+arrayList);
        //Collections.sort(arrayList);

        //使用指定比较器排序
        Collections.sort(arrayList,getComparator());
        System.out.println("after sort:"+arrayList);
    }

    private static Comparator<String> getComparator(){
//        return new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length()-s2.length();
//            }
//        };
        //返回值为一个函数时接口
        return (s1,s2) -> s1.length()-s2.length();
    }
}
