package com.ccnu.chapter02.quickstart;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Author: chs
 * Description:NIO服务器
 * CreateTime: 2024-07-20
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        //创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //创建Selector
        Selector selector = Selector.open();
        //绑定端口8080，在服务端监听
        serverSocketChannel.bind(new InetSocketAddress(8081));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //将serverSocketChannel注册到Selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端连接
        while(true){
            //如果等待1s仍没有客户端连接，返回
            if(selector.select(2000) == 0){
                System.out.println("服务器等待2s，无连接");
                continue;
            }
            //获取关注事件的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //使用迭代器遍历关注事件
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                //获取一个事件
                SelectionKey key = iterator.next();
                //对不同的事件进行处理
                if(key.isAcceptable()){ // 如果为OP_ACCEPT,有新客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，产生一个socketChannel:" + socketChannel);
                    //将socketChannel设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到selector，关注事件为OP_READ，同时给socketChannel关联一个ByteBuffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }else if(key.isReadable()){ //如果为OP_READ，由客户端发送消息
                    //通过key反向获取对应的channel
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    //通过channel获取关联的ByteBuffer
                    ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                    socketChannel.read(byteBuffer);
                    System.out.println(byteBuffer.position() + " " + byteBuffer.limit() + " " + byteBuffer.mark());
                    System.out.println("接受来自客户端的消息：" + new String(byteBuffer.array(),0,byteBuffer.position()));
                }
                //从集合中移除该事件，避免重复操作
                iterator.remove();
            }
        }
    }
}
