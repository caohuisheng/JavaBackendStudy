package com.itheima.demo5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        String[] strArray = {"赵金麦,20","刘岩,30","王祖贤,35","林青霞,20"};
        ArrayList<String> array = myFilter(strArray, str -> str.split(",")[0].length()==3,
                str -> Integer.parseInt(str.split(",")[1])>30);
        System.out.println(array);
    }

    //将符合要求的字符串筛选到集合中
    private static ArrayList<String> myFilter(String[] strArray, Predicate<String> pre1, Predicate<String> pre2){
        ArrayList<String> array = new ArrayList<>();
        for(String str:strArray){
            if(pre1.and(pre2).test(str)){
                array.add(str);
            }
        }
        return array;
    }
}
