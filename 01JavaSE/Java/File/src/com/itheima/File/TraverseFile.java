package com.itheima.File;

import java.io.File;

public class TraverseFile {
    public static void main(String[] args) {
        File file = new File("D:\\test");
        getAllFilePath(file);
    }

    public static void getAllFilePath(File srcFile){
        File[] files = srcFile.listFiles();
        //if(file)
        for(File file:files){
            if(file.isDirectory()){
                getAllFilePath(file);
            }else{
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
