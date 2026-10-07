package com.itheima.File;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        File f1 = new File("D:\\MUXI\\hello.txt");
        System.out.println(f1);

        File f2 = new File("D:\\MUXI","hello.txt");
        System.out.println(f2);

        File f3 = new File("D:\\MUXI");
        File f4 = new File(f3,"hello.txt");
        System.out.println(f4);
    }
}
