package com.itheima.demo2;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //使用类的属性获得该类对应的Class对象
        Class<Student> c1 = Student.class;
        System.out.println(c1);

        Class<Student> c2 = Student.class;
        System.out.println(c1==c2);
        System.out.println("--------");

        //获取对象所属类的Class对象
        Student s = new Student();
        Class<? extends Student> c3 = s.getClass();
        System.out.println(c3);
        System.out.println("--------");

        //使用Class类中的静态方法获取
        Class<?> c4 = Class.forName("com.itheima.demo2.Student");
        System.out.println(c1==c4);
    }
}
