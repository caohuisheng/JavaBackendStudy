package com.ccnu.chapter02.quickstart;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Author: chs
 * Description:NIO客户端
 * CreateTime: 2024-07-20
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        //创建SocketChannel
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //提供服务端ip和端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8081);
        //连接服务器
        if(!socketChannel.connect(inetSocketAddress)){
            while(!socketChannel.finishConnect()){
                System.out.println("连接需要一定时间，客户端此时可以做其它工作...");
            }
        }

        //连接成功，发送消息
        String str = "hello, 赵金麦！";
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        socketChannel.write(buffer);
        System.in.read();
    }
}
