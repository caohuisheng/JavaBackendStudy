package com.itheima.File;

import java.io.File;

public class FileDemo3 {
    public static void main(String[] args) {
        File f1 = new File("D:\\test");
        String[] strArray = f1.list();
        for(String str : strArray){
            System.out.println(str);
        }
        System.out.println("--------");

        File[] files = f1.listFiles();
        for(File f:files){
            System.out.println(f);
        }
    }
}
