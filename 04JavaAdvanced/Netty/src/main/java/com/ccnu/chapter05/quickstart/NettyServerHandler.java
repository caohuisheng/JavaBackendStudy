package com.ccnu.chapter05.quickstart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * Author: chs
 * Description: NettyServer处理器
 * CreateTime: 2024-07-21
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取客户端发送的消息
     * @param ctx 上下文（包括pipeline, channel, 地址）
     * @param msg 客户端发送的消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /*假设有一个耗时任务->异步执行->提交给channel对应NioEventLoop的taskQueue执行*/
        //方案1：用户程序自定义普通任务
        ctx.channel().eventLoop().execute(() -> {
            try {
                Thread.sleep(3000);
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello,client喵2", CharsetUtil.UTF_8));
                System.out.println("channel hashcode:" + ctx.channel().hashCode());
            } catch (InterruptedException e) {
                System.out.println("服务端发生异常：" + e.getMessage());
            }
        });
        ctx.channel().eventLoop().execute(() -> {
            try {
                Thread.sleep(3000);
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello,client喵3", CharsetUtil.UTF_8));
                System.out.println("channel hashcode:" + ctx.channel().hashCode());
            } catch (InterruptedException e) {
                System.out.println("服务端发生异常：" + e.getMessage());
            }
        });

        // 方案2：用户自定义定时任务，提交到scheduledTaskQueue
        ctx.channel().eventLoop().schedule(() -> {
            try {
                Thread.sleep(3000);
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello,client喵4", CharsetUtil.UTF_8));
                System.out.println("channel hashcode:" + ctx.channel().hashCode());
            } catch (InterruptedException e) {
                System.out.println("服务端发生异常：" + e.getMessage());
            }
        }, 5, TimeUnit.SECONDS);

        /*System.out.println("服务端线程："+Thread.currentThread().getName());
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline();

        //将msg转成ByteBuf
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端地址：" + channel.remoteAddress() + " 消息：" + byteBuf.toString(CharsetUtil.UTF_8));*/
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将数据写入缓存并刷新
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,client喵", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
