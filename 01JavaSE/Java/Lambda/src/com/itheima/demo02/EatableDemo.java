package com.itheima.demo02;

public class EatableDemo {
    public static void main(String[] args) {
        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("hello,world");
            }
        });
        useEatable(() -> {
            System.out.println("i love java");
        });
    }

    private static void useEatable(Eatable eatable){
        eatable.eat();
    }
}
