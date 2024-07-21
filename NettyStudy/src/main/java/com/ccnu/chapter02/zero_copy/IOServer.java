package com.ccnu.chapter02.zero_copy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Author: chs
 * Description: 传统IO测试（服务端）
 * CreateTime: 2024-07-21
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8080));

        while(true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("一个服务端连接："+socketChannel.getRemoteAddress());
            FileOutputStream fos = new FileOutputStream("d:/temp/bigfile_copy.txt");
            byte[] buffer = new byte[4096];
            int len;
            try {
                while((len = socketChannel.socket().getInputStream().read(buffer)) != -1){
                    fos.write(buffer,0, len);
                }
            } catch (IOException e) {
                System.out.println("服务端取消连接...");
            }
        }
    }
}
