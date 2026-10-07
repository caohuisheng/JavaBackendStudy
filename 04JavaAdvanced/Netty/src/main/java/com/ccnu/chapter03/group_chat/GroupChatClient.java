package com.ccnu.chapter03.group_chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Author: chs
 * Description: 群聊系统客户端
 * CreateTime: 2024-07-20
 */
public class GroupChatClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8081;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    public GroupChatClient() {
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(username + " is ready...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息给服务端
      * @param msg 消息
     */
    private void sendMsg(String msg){
        msg = msg + "【" + this.username + "】";
        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取消息
     */
    private void readMsg(){
        try {
            //获取可用通道
            int readChannels = selector.select();
            if(readChannels > 0){ //有可用通道
                //获取SelectionKey集合
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                //遍历每一个SelectionKey
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isReadable()){
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int len = socketChannel.read(buffer);
                        String msg = new String(new String(buffer.array(), 0, len));
                        System.out.println("收到消息：" + msg);
                    }
                    //移除当前SelectionKey，防止重复操作
                    iterator.remove();
                }
            }else {
                System.out.println("没有可用通道!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GroupChatClient client = new GroupChatClient();
        new Thread(){
            @Override
            public void run() {
                //每3s读取一次消息
                while(true){
                    client.readMsg();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        //将输入的消息发送给服务端
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String msg = sc.nextLine();
            client.sendMsg(msg);
        }
    }
}
