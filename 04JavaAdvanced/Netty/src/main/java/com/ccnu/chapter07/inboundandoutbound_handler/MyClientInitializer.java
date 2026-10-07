package com.ccnu.chapter07.inboundandoutbound_handler;

import com.ccnu.chapter07.codec.MyByteToLongDecoder;
import com.ccnu.chapter07.codec.MyLongToByteEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * Author: chs
 * Description: 客户端Initializer
 * CreateTime: 2024-07-27
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //添加一个编码器(用于发送数据)
        pipeline.addLast(new MyLongToByteEncoder());
        //添加一个解码器(用于接收数据)
        pipeline.addLast(new MyByteToLongDecoder());
        //添加一个业务handler
        pipeline.addLast(new MyClientHandler());
    }
}
