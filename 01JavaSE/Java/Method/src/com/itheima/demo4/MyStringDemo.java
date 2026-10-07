package com.itheima.demo4;

/*
引用类的实例方法
 */
public class MyStringDemo {
    public static void main(String[] args) {
        //Lambda表达式
        useMyString((s,x,y) -> s.substring(x,y));

        //引用类的实例方法
        useMyString(String::substring); //第一个参数作为调用者，其余参数传递给该方法作为参数
    }

    static void useMyString(MyString my){
        String s = my.mySubString("helloworld",2,4);
        System.out.println(s);
    }
}
