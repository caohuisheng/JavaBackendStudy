package com.ccnu.chapter02.zero_copy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Author: chs
 * Description: 零拷贝测试（服务端）
 * CreateTime: 2024-07-21
 */
public class NewIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8080));

        while(true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("一个客户端连接：" + socketChannel.getRemoteAddress());
            ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
            FileChannel fileChannel = new FileOutputStream("d:/temp/bigfile_copy.txt").getChannel();

            long start = System.currentTimeMillis();
            int len;
            //接收的总字节数
            long totalCount = 0;
            while((len = socketChannel.read(buffer)) != -1){
                totalCount += len;
                //flip操作
                buffer.flip();
                //将buffer数据写入文件
                fileChannel.write(buffer);
                //清空buffer数据
                buffer.clear();
            }
            long end = System.currentTimeMillis();
            System.out.println("接收字节数：" + totalCount + "耗时：" + (end-start));
            fileChannel.close();
            socketChannel.close();
        }
    }
}
