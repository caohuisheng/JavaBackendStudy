package com.ccnu.chapter08.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Author: chs
 * Description: 消息编码器
 * CreateTime: 2024-07-28
 */
public class MyMessageEncoder extends MessageToByteEncoder<MessageProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MyMessageEncoder@encode方法被调用...");
        out.writeInt(msg.getLen());
        out.writeBytes(msg.getContent());
    }
}
