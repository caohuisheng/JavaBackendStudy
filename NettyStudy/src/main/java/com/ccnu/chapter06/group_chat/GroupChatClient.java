package com.ccnu.chapter06.group_chat;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.IOException;
import java.util.Scanner;

/**
 * Author: chs
 * Description: 群聊系统客户端
 * CreateTime: 2024-07-27
 */
public class GroupChatClient {

    private String host;
    private int port;

    public GroupChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run(){
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast(new GroupChatClientHandler());
                        }
                    });
            ChannelFuture channelFuture = b.connect(host, port).sync();
            Channel channel = channelFuture.channel();
            System.out.println("[客户端]" + channel.localAddress() + " 启动成功...");

            //将用户输入的消息发送给服务端
            Scanner sc = new Scanner(System.in);
            while(sc.hasNextLine()){
                String msg = sc.nextLine();
                System.out.println(msg);
                channel.writeAndFlush(msg + "\r\n");
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new GroupChatClient("127.0.0.1", 7000).run();
    }
}
