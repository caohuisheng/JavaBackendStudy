package com.ccnu.chapter07.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * Author: chs
 * Description: byte2long解码器
 * CreateTime: 2024-07-27
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {

    /**
     * @param ctx 上下文对象
     * @param in 入站的ByteBuf
     * @param out list集合，包含解码后的数据，将会传递给下一个handler
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("decode被调用");
        //当可读的字节数不小于8时，才读取一个数据添加到list集合中
        //if(in.readableBytes() >= 8){
        //    out.add(in.readLong());
        //}
        out.add(in.readLong());
    }
}
