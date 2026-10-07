package com.itheima;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<Character,Integer> map1 = new HashMap<Character,Integer>(){{
            put('c',1);
            put('d',2);
        }};
        Map<Character,Integer> map2 = new HashMap<>();
        map1.put('c',1);
        map2.put('c',1);
        map2.put('d',0);
        // map2.put('c',0);
        // System.out.println(map.size());
        // map.put('c',0);
        System.out.println(map1.equals(map2));
        //map.remove('c');
        // map1.get
        //map1.remove
        Integer a = 1;
        Integer b = 1;
        Object s1 = new String();
        Object s2 = "abc";
        System.out.println(s1.toString());
        System.out.println(s2);
        //System.out.println(s2);
    }
}
