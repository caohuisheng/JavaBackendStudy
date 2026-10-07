package com.itheima01;

import java.awt.Color;

public class ColorDemo {
    public static void main(String[] args) {
        MyColor c = MyColor.RED;
        System.out.println(c);
        System.out.println("======");

        MyColor2 c2 = MyColor2.RED;
        System.out.println(c2);
        System.out.println(c2.getName());
        c2 = MyColor2.YELLOW;
        System.out.println(c2);
        System.out.println(c2.getName());
        System.out.println("======");

        MyColor3 c3 = MyColor3.RED;
        c3.show();

    }
}
