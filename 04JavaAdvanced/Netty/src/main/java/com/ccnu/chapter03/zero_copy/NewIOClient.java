package com.ccnu.chapter03.zero_copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * Author: chs
 * Description: 零拷贝测试（客户端）
 * CreateTime: 2024-07-21
 */
public class NewIOClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",8080));
        FileChannel fileChannel = new FileInputStream("d:/temp/bigfile.txt").getChannel();

        long start = System.currentTimeMillis();
        //使用transferTo拷贝文件(底层使用零拷贝)
        long totalCount = 0;
        while(totalCount < fileChannel.size()){
            //每次拷贝8M
            long transferCount = fileChannel.transferTo(totalCount, 1024*1024*8, socketChannel);
            totalCount += transferCount;
        }

        long end = System.currentTimeMillis();
        System.out.println("发送总字节数:" + totalCount + " 零拷贝耗时：" + (end-start)); //684ms
        fileChannel.close();
        socketChannel.close();
    }

    static void createFile(){
        try {
            byte[] bytes = new byte[1024*1024];
            int len = 512;
            FileOutputStream fos = new FileOutputStream("d:/temp/bigfile.txt");
            for (int i = 0; i < len; i++) {
                fos.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
