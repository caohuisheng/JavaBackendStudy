package com.ccnu.chapter03.byte_buffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Author: chs
 * Description: Scatter和Gather
 * CreateTime: 2024-07-20
 */
public class ScatterAndGatherTest {

    public static void main(String[] args) throws IOException {
        // 创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8080);
        // 绑定端口
        serverSocketChannel.bind(inetSocketAddress);

        // 创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[]{ByteBuffer.allocate(5), ByteBuffer.allocate(3)};

        // 等待客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();
        int messageLength = 8;
        // 循环的读取
        while(true){
            // 读取的总字节数
            int readByte = 0;
            // 从socketChannel读取执行长度的消息
            while(readByte < messageLength){
                int readLength = (int)socketChannel.read(byteBuffers);
                if(readLength == -1) return;
                readByte += readLength;
                System.out.println("readLength:" + readLength);
                for(ByteBuffer buffer:byteBuffers){
                    System.out.println("position:" + buffer.position() + " limit:" + buffer.limit());
                }
            }
            // 执行flip操作
            for(ByteBuffer buffer:byteBuffers){
                buffer.flip();
            }
            // 向socketChannel写入执行长度消息
            int writeByte = 0;
            while(writeByte < messageLength){
                long writeLength = socketChannel.write(byteBuffers);
                writeByte += writeLength;
            }
            //清空byteBuffer数据
            for(ByteBuffer buffer:byteBuffers){
                buffer.clear();
            }
            System.out.println("readByte:" + readByte + " writeByte:" + writeByte);
        }
    }

}
