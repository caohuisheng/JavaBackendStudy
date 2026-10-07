package com.itheima02;

public class SingleTest {
    public static void main(String[] args) {
        Teacher t1 = Teacher.getTeacher();
        Teacher t2 = Teacher.getTeacher();
        System.out.println(t1==t2);
        System.out.println(t1);
        System.out.println(t2);
    }
}
