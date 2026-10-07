package com.ccnu.chapter06;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-07-27
 */
public class NettyByteBufTest {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello,world!", Charset.forName("utf-8"));
        if(byteBuf.hasArray()){
            byte[] content = byteBuf.array();
            System.out.println("arr_len=" + content.length);
            System.out.println(new String(content, Charset.forName("utf-8"))); //(ridx: 0, widx: 12, cap: 36)

            System.out.println("byteBuf=" + byteBuf);

            System.out.println(byteBuf.arrayOffset()); //0
            System.out.println(byteBuf.readerIndex()); //0
            System.out.println(byteBuf.writerIndex()); //12
            System.out.println(byteBuf.capacity()); //36
            System.out.println(byteBuf.getByte(0)); //104
            int len = byteBuf.readableBytes();
            System.out.println("len=" + len); //12

            for (int i = 0; i < len; i++) {
                System.out.println((char)byteBuf.getByte(i));
            }
            System.out.println(byteBuf.getCharSequence(0, 5, Charset.forName("utf-8")));
            System.out.println(byteBuf.getCharSequence(6, 5, Charset.forName("utf-8")));
        }
    }
}
