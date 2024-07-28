package com.ccnu.chapter08.protocoltcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.StandardCharsets;

/**
 * Author: chs
 * Description: 客户端Handler
 * CreateTime: 2024-07-28
 */
public class MyClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count = 0;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //发送5条消息
        for (int i = 0; i < 5; i++) {
            String msg = "今天天气冷，吃火锅" + i;
            byte[] content = msg.getBytes(StandardCharsets.UTF_8);
            int len = content.length;
            //将消息封装成MessageProtocol
            MessageProtocol messageProtocol = new MessageProtocol();
            messageProtocol.setContent(content);
            messageProtocol.setLen(len);
            ctx.writeAndFlush(messageProtocol);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        int len = msg.getLen();
        byte[] content = msg.getContent();
        System.out.println("客户端收到消息：len:" + len + " content:" + new String(content, CharsetUtil.UTF_8));
        System.out.println("客户端收到消息总数：" + (++count));
    }
}
