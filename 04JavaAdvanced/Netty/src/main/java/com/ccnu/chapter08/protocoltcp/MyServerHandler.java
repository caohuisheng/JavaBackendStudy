package com.ccnu.chapter08.protocoltcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * Author: chs
 * Description: 服务端Handler
 * CreateTime: 2024-07-28
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count = 0;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        int len = msg.getLen();
        byte[] content = msg.getContent();
        System.out.println("服务器收到消息：len:" + len + "content:" + new String(content, Charset.forName("utf-8")));
        System.out.println("服务器收到消息总数：" + (++count));

        //回复消息
        byte[] responseContent = UUID.randomUUID().toString().getBytes(Charset.forName("utf-8"));
        int responseLen = responseContent.length;
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setContent(responseContent);
        messageProtocol.setLen(responseLen);
        ctx.writeAndFlush(messageProtocol);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
