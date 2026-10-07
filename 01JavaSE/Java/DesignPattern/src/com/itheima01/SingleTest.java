package com.itheima01;

public class SingleTest {
    public static void main(String[] args) {
        Student s1 = Student.getStudent();
        Student s2 = Student.getStudent();
        System.out.println(s1==s2);
        System.out.println(s1);
        System.out.println(s2);
    }
}
