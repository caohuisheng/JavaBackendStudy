package com.itheima01;

/**
 * 单例模式（饿汉式）
 */
public class Student {
    private Student(){}

    private static final Student s = new Student();

    public static Student getStudent(){
        return s;
    }
}
