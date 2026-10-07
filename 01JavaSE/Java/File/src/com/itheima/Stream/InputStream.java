package com.itheima.Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStream {
    public static void main(String[] args) throws IOException{
        demo3();
    }

    public static void demo1() throws IOException {
        FileInputStream fis = new FileInputStream("File\\test.txt");
        int by;
        while((by = fis.read()) != -1){
            System.out.print((char)by);
        }
        fis.close();
    }

    public static void demo2() throws IOException{
        FileInputStream fis = new FileInputStream("File\\test.txt");
        /*//1
        byte[] bys = new byte[4];
        int len = fis.read(bys);
        System.out.println(len);
        System.out.println(new String(bys));

        //2
        bys = new byte[4];
        len = fis.read(bys);
        System.out.println(len);
        System.out.println(new String(bys));

        //3
        bys = new byte[4];
        len = fis.read(bys);
        System.out.println(len);
        System.out.println(new String(bys));*/

        byte[] bys = new byte[1024];
        int len;
        while((len = fis.read(bys))!=-1){
            System.out.println(new String(bys));
        }
        fis.close();
    }

    public static void demo3() throws IOException{
        //文件输入流
        FileInputStream fis = new FileInputStream("D:\\Users\\YeQiu\\DeskTop\\截图\\青训营\\名片.PNG");
        //文件输出流
        FileOutputStream fos = new FileOutputStream("File\\mn.jpg");

        byte[] bys = new byte[1024];
        int len = 0;
        //循环读取数据
        while((len = fis.read(bys))!=-1){
            fos.write(bys,0,len);
        }
        //关闭资源
        fis.close();
        fos.close();
    }
}
