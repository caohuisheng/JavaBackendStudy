package com.ccnu.chapter08.protocoltcp;

import com.google.protobuf.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * Author: chs
 * Description: 消息解码器
 * CreateTime: 2024-07-28
 */
public class MyMessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder@decode方法被调用...");
        //获取消息长度和内容
        int len = in.readInt();
        byte[] content = new byte[len];
        in.readBytes(content);

        //封装成MessageProtocol，添加到out中，传递给写一个handler处理
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(len);
        messageProtocol.setContent(content);
        out.add(messageProtocol);
    }
}
