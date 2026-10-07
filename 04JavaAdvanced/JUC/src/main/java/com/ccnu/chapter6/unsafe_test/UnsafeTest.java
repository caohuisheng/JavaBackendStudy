package com.ccnu.chapter6.unsafe_test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Author: chs
 * Description: Unsafe测试
 * CreateTime: 2024-08-10
 */
public class UnsafeTest {

    static class Student{
        private volatile String name;
        private volatile int age;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Unsafe unsafe = UnsafeAccessor.getUnsafe();
        Field name = Student.class.getDeclaredField("name");
        Field age = Student.class.getDeclaredField("age");
        //获得成员变量的偏移量
        long nameOffset = unsafe.objectFieldOffset(name);
        long ageOffset = unsafe.objectFieldOffset(age);
        System.out.println("nameOffset:" + nameOffset + " ageOffset:" + ageOffset);

        Student student = new Student();
        //使用cas替换成员变量的值
        unsafe.compareAndSwapInt(student, ageOffset, 0, 20);
        unsafe.compareAndSwapObject(student, nameOffset, null, "张三");

        System.out.println(student);
    }
}
