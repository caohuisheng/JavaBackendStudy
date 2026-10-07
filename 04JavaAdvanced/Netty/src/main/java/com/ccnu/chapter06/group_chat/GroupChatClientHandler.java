package com.ccnu.chapter06.group_chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Author: chs
 * Description: 群聊系统客户端handler
 * CreateTime: 2024-07-27
 */
public class GroupChatClientHandler extends SimpleChannelInboundHandler<String> {

    //读取接收到的消息
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg.trim());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
