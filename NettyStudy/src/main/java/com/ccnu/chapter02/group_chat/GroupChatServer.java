package com.ccnu.chapter02.group_chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Author: chs
 * Description: 群聊系统服务端
 * CreateTime: 2024-07-20
 */
public class GroupChatServer {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final int PORT = 8081;

    public GroupChatServer(){
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务端启动成功，监听端口：" + PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen(){
        try {
            // 循环处理
            while(true){
                //获取可用通道
                int count = selector.select();
                if(count > 0){ // 有事件处理
                    //获取SelectionKey集合
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    //遍历每一个SelectionKey
                    while(iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        //根据不同的key执行不同的操作
                        if(key.isAcceptable()){
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            System.out.println(socketChannel.getRemoteAddress() + " 上线");
                        }else if(key.isReadable()){
                            readData(key);
                        }
                        //将该key从集合中移除
                        iterator.remove();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("服务端异常终止!");
        }
    }

    /**
     * 读取key对应客户端发送的消息
     * @param key 客户端对应的key
     */
    private void readData(SelectionKey key){
        SocketChannel socketChannel = null;

        try {
            socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //读取消息
            int len = socketChannel.read(buffer);
            if(len > 0){
                String msg = new String(buffer.array(), 0, len);
                System.out.println("收到消息：" + msg);
                //将消息发送给其它客户端
                sendMsgToOtherClients(msg, socketChannel);
            }
        } catch (IOException e) {
            try {
                System.out.println(socketChannel.getRemoteAddress() + " 离线了！");
                //取消注册
                key.cancel();
                //关闭通道
                socketChannel.close();
            } catch(IOException e2){
                e2.printStackTrace();
            }
        }
    }

    /**
     * 将消息发送给其它客户端
     * @param msg 消息
     * @param senderSocketChannel 发送消息客户端对应的channel
     */
    private void sendMsgToOtherClients(String msg, SocketChannel senderSocketChannel) throws IOException{
        System.out.println("服务器转发消息中...");
        //遍历所有的SelectionKey
        for (SelectionKey key : selector.keys()) {
            SelectableChannel otherSocketChannel = key.channel();
            //如果channel类型为SocketChannel，且不是发送者的channel
            if(otherSocketChannel instanceof SocketChannel && otherSocketChannel != senderSocketChannel){
                SocketChannel channel = (SocketChannel) otherSocketChannel;
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                channel.write(buffer);
            }
        }
    }

    public static void main(String[] args) {
        new GroupChatServer().listen();
    }
}
