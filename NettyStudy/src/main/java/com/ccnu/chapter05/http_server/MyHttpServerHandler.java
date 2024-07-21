package com.ccnu.chapter05.http_server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * Author: chs
 * Description: 自定义的handler(客户端和服务端通讯的消息被封装为HttpObject)
 * CreateTime: 2024-07-21
 */
public class MyHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if(msg instanceof HttpRequest){
            System.out.println("pipeline hashcode:" + ctx.pipeline().hashCode() + " MyHttpServerHandler hashcode:" + this.hashCode());
            System.out.println("msg类型：" + msg.getClass() + " 客户端地址：" + ctx.channel().remoteAddress());
            HttpRequest request = (HttpRequest) msg;
            String uri = request.getUri();
            if("/favicon.ico".equals(uri)){
                System.out.println("请求了favicon.ico，不做响应！");
                return;
            }
            // 响应消息给客户端
            ByteBuf content = Unpooled.copiedBuffer("Hello,client,I am NettyServer!", CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());

            //返回response
            ctx.writeAndFlush(response);
        }
    }

}