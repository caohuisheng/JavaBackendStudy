package com.itheima.demo2;

public class Student {
    //一个共有，一个默认，一个私有
    private String name;
    int age;
    public String address;

    public Student(){
    }

    private Student(String name){
        this.name = name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private void method(){
        System.out.println("method");
    }

    public void method1(){
        System.out.println("method1");
    }

    public void method2(String s){
        System.out.println("method2:"+s);
    }

    public String method3(String s,int i){
        return s+","+i;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
