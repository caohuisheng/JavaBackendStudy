package com.itheima.example;

import java.io.*;

public class copyFolder {
    public static void main(String[] args)throws IOException {
        //copySingleFolder();
        File srcFile = new File("D:\\test");
        File destFile = new File("D:\\itcast");
        copyMultiFolder(srcFile,destFile);
    }

    /*
    复制多级目录
     */
    private static void copyMultiFolder(File srcFile,File destFile) throws IOException{
        //如果源文件为目录
        if(srcFile.isDirectory()){
            //在目的地下创建和数据源srcFile名称一样的目录
            String srcFileName = srcFile.getName();
            File newFolder = new File(destFile,srcFileName);
            if(!newFolder.exists()){
                newFolder.mkdir();
            }

            //获取数据源下所有的目录和文件
            File[] files = srcFile.listFiles();
            for(File file:files){
                copyMultiFolder(file,newFolder);
            }
        }else{  //源文件为文件，直接复制
            File newFile = new File(destFile,srcFile.getName());
            copyFile(srcFile,newFile);
        }
    }

    /*
    复制单级目录
     */
    public static void copySingleFolder() throws IOException{
        File srcFolder = new File("D:\\test");
        String srcFolderName = srcFolder.getName();

        File destFolder = new File("File\\itcast");

        if(!destFolder.exists()){
            destFolder.mkdir();
        }

        File[] files = srcFolder.listFiles();
        for(File srcFile:files){
            String srcFileName = srcFile.getName();
            File destFile = new File(destFolder,srcFileName);
            copyFile(srcFile,destFile);
        }
    }

    public static void copyFile(File srcFile,File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] bys = new byte[1024];
        int len;
        while((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
        }

        bis.close();
        bos.close();
    }
}
