package com.ccnu.chapter03.byte_buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Author: chs
 * Description: FileChannel测试(写入数据)
 * CreateTime: 2024-07-20
 */
public class NIOFileChannelTest {
    public static void main(String[] args) throws IOException {
        //test01();
        //test02();
        //test03();
        test04();
    }

    static void test01() throws IOException {
        String str = "hello, 尚硅谷";
        // 创建一个输出流
        FileOutputStream fos = new FileOutputStream("d:/temp/file01.txt");
        // 获取对应的FileChannel
        FileChannel fileChannel = fos.getChannel();
        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 将str放入byteBuffer
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        // 将byteBuffer数据写入fileChannel
        fileChannel.write(byteBuffer);

        // 关闭输出流
        fos.close();
    }

    static void test02() throws IOException {
        // 创建文件并获取输入流
        File file = new File("D:/temp/file01.txt");
        FileInputStream fis = new FileInputStream(file);
        // 获取对应的FileChannel
        FileChannel fileChannel = fis.getChannel();
        // 创建ByteBuffer, 并从FileChannel读取数据
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        fileChannel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array()));
    }

    static void test03() throws IOException {
        FileInputStream fis = new FileInputStream("D:/temp/file01.txt");
        FileOutputStream fos = new FileOutputStream("D:/temp/file02.txt");
        FileChannel fileChannel01 = fis.getChannel();
        FileChannel fileChannel02 = fos.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(true){
            //清空buffer
            byteBuffer.clear();
            int len = fileChannel01.read(byteBuffer);
            //没有数据可以读了，读取结束
            if(len == -1){
                break;
            }
            //将buffer中数据写入fileChannel02
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }

        fis.close();
        fos.close();
    }

    static void test04() throws IOException{
        FileInputStream fis = new FileInputStream("d:/temp/file01.txt");
        FileOutputStream fos = new FileOutputStream("d:/temp/file02.txt");
        FileChannel srcChannel = fis.getChannel();
        FileChannel dstChannel = fos.getChannel();
        // 拷贝数据
        dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
        fis.close();
        fos.close();
        srcChannel.close();
        dstChannel.close();
    }
}
