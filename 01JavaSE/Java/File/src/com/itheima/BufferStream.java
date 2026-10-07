package com.itheima;

import java.io.*;

public class BufferStream {
    public static void main(String[] args) throws IOException {

        Long start = System.currentTimeMillis();
        method2();
        Long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start)+"ms");
    }

    /*
    使用字节流一次读一个字节
     */
    public static void method1() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Users\\YeQiu\\DeskTop\\微课材料\\作品与答辩材料\\作品.mp4");
        FileOutputStream fos = new FileOutputStream("File\\test.mp4");

        int len = 0;
        int by;
        while((by = fis.read())!=-1){
            fos.write(by);
        }
        fis.close();
        fos.close();
    }

    /*
    使用缓冲字节流一次读一个字节数组
     */
    public static void method2() throws IOException {
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream("D:\\Users\\YeQiu\\DeskTop\\微课材料\\作品与答辩材料\\作品.mp4"));
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("File\\test.mp4"));

        int len = 0;
        byte[] bys = new byte[1024];
        while((len = fis.read(bys))!=-1){
            fos.write(bys,0,len);
        }
        fis.close();
        fos.close();
    }
}
