package com.ccnu.chapter03.zero_copy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Author: chs
 * Description: 普通IO拷贝测试（客户端）
 * CreateTime: 2024-07-21
 */
public class IOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",8080));
        FileInputStream fis = new FileInputStream("d:/temp/bigfile.txt");
        byte[] buffer = new byte[4096];
        long start = System.currentTimeMillis();
        int len;
        int totalLength = 0;
        while((len = fis.read(buffer)) != -1){
            socketChannel.socket().getOutputStream().write(buffer,0,len);
            totalLength += len;
            if(totalLength % (10*1024*1024)==0){
                System.out.printf("当前已传输：%dM\n", totalLength/(1024*1024));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("普通IO拷贝耗时：" + (end-start)); //2521ms
    }
}
