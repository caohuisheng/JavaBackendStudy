package com.itheima01;

public abstract class MyColor3 {
    public static final MyColor3 RED = new MyColor3("red"){
        @Override
        public void show() {
            System.out.println("red");
        }
    };
    public static final MyColor3 GREEN = new MyColor3("green"){
        @Override
        public void show() {
            System.out.println("green");
        }
    };
    public static final MyColor3 YELLOW = new MyColor3("yellow"){
        @Override
        public void show() {
            System.out.println("yellow");
        }
    };

    private MyColor3(String color){
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

    public abstract void show();
}
