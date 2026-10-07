package com.ccnu.chapter06.group_chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: chs
 * Description: 群聊系统服务端handler
 * CreateTime: 2024-07-27
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //该方法在连接建立时执行
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将消息发送给其它客户端
        channelGroup.writeAndFlush(sdf.format(new Date()) + " [客户端]" + channel.remoteAddress() + " 加入聊天室\n");
        //将当前 channel 加入到 channelGroup
        channelGroup.add(channel);
    }

    //该方法在连接断开时执行
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将消息发送给其它客户端
        channelGroup.writeAndFlush(sdf.format(new Date()) + " [客户端]" + channel.remoteAddress() + " 离开聊天室\n");
        System.out.println("channelGroup size=" + channelGroup.size());
    }

    //该方法在对应 channel 处于活动状态时执行
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将消息发送给其它客户端
        System.out.println(sdf.format(new Date()) + " [客户端]" + channel.remoteAddress() + " 上线了");
    }

    //该方法在对应 channel 处于不活动状态时执行
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将消息发送给其它客户端
        System.out.println(sdf.format(new Date()) + " [客户端]" + channel.remoteAddress() + " 离线了");
    }

    //读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            if(ch != channel){ //不是当前channel，转发消息
                ch.writeAndFlush("[客户端]" + channel.remoteAddress() + " 发送消息：" + msg + "\n");
            }else{ //回显客户端自己发送的消息
                ch.writeAndFlush("[自己]发送消息：" + msg + "\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //发生异常时关闭通道
        ctx.close();
    }

}
