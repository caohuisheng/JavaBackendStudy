package com.itheima.File;


import java.io.File;
import java.io.IOException;

public class FileDemo2 {
    public static void main(String[] args) throws IOException {

        //创建文件
        File f1 = new File("D:\\test\\hell0.txt");
        System.out.println(f1.createNewFile());

        //创建文件夹
        File f2 = new File("D:\\test\\dir1");
        System.out.println(f2.mkdir());

        //创建多级文件夹
        File f3 = new File("D:\\test\\web\\html");
        System.out.println(f3.mkdirs());


        File f4 = new File("D:\\test\\java.txt");
        System.out.println(f4.mkdir()); 
    }
}
