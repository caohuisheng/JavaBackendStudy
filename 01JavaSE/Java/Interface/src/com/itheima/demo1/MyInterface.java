package com.itheima.demo1;

public interface MyInterface {
    public void show1();
    public void show2();
    //默认方法，实现类不需要重写
    default void show3(){
        System.out.println("show3");
    }
}
