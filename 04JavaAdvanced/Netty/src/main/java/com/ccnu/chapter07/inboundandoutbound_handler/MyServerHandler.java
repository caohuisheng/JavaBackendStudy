package com.ccnu.chapter07.inboundandoutbound_handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Author: chs
 * Description: 服务端Handler
 * CreateTime: 2024-07-27
 */
public class MyServerHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("收到客户端" + ctx.channel().remoteAddress() + "消息：" + msg);
        //回送消息给客户端
        System.out.println("MyServerHandler回送消息...");
        ctx.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("客户端取消连接...");
        ctx.close();
    }
}
