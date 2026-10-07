package com.itheima.File;

import java.io.File;
import java.io.IOException;

public class FileDemo4 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("File\\test.txt");
        System.out.println(f1.createNewFile());
        System.out.println(f1.delete());
    }
}
