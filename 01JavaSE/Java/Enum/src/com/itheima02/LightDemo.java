package com.itheima02;

public class LightDemo {
    public static void main(String[] args) {
        Light l1 = Light.RED;
        System.out.println(l1);
        System.out.println("------");

        Light1 l2 = Light1.RED;
        System.out.println(l2);
        System.out.println(l2.getName());
        l2 = Light1.YELLOW;
        System.out.println(l2);
        System.out.println(l2.getName());
        System.out.println("------");

        Light2 l3 = Light2.RED;
        System.out.println(l3);
        System.out.println(l3.getName());
        l3.show();
    }
}
