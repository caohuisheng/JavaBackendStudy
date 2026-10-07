package com.ccnu.chapter05.http_server;


import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Author: chs
 * Description: 服务端Initializer
 * CreateTime: 2024-07-21
 */
public class MyServerInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        //获取pipeline
        ChannelPipeline pipeline = ch.pipeline();
        //加入netty中的编解码器
        pipeline.addLast("HttpServerCodec",new HttpServerCodec());
        //加入自定义的HttpServerHandler
        pipeline.addLast("MyHttpServerHandler",new MyHttpServerHandler());
    }
}
