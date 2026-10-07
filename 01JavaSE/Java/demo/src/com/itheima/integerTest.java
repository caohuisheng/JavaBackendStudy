package com.itheima;

import java.util.Calendar;

public class integerTest {
    public void main(String[] args) {
        /*Integer i1 = new Integer(100);
        System.out.println(i1);

        Integer i2 = new Integer("1234");
        System.out.println(i2);*/

        Integer i1 = Integer.valueOf(100);
        Integer i2 = Integer.valueOf("1234");
        System.out.println(i1);
        System.out.println(i2);

        System.out.println(String.valueOf(888));

        //1
        Integer i = Integer.valueOf("123");
        int v = i.intValue();

        //2
        int t = Integer.parseInt("abc");
        System.out.println(t);
    }
    void test1(){
        Integer i = Integer.valueOf("123");
        Integer i1 = 123;
        Integer a = i1 + 12;
    }

    void test2(){
        Calendar.getInstance();
    }
}
