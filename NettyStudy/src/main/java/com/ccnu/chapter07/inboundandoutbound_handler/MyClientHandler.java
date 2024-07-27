package com.ccnu.chapter07.inboundandoutbound_handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-07-27
 */
public class MyClientHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("收到服务端" + ctx.channel().remoteAddress() + "消息：" + msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientHandler发送消息...");
        Channel channel = ctx.channel();
        channel.writeAndFlush(100001L);
        //channel.writeAndFlush(Unpooled.copiedBuffer("abcdabcdabcdabcd", Charset.forName("utf-8")));
    }
}
