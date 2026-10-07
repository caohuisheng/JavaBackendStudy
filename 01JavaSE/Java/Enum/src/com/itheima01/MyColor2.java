package com.itheima01;

public class MyColor2 {
    public static final MyColor2 RED = new MyColor2("red");
    public static final MyColor2 GREEN = new MyColor2("green");
    public static final MyColor2 YELLOW = new MyColor2("yellow");

    private MyColor2(String color){
        this.name = color;
    }

    private String name;

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "MyColor2{" +
                "name='" + name + '\'' +
                '}';
    }
}
