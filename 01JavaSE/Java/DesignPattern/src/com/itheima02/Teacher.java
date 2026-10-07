package com.itheima02;

import com.itheima01.Student;

/**
 * 单例模式（懒汉式）
 */
public class Teacher {
    private static Teacher t = null;

    public static Teacher getTeacher(){
        if(t == null){
            t = new Teacher();
        }
        return t;
    }
}
