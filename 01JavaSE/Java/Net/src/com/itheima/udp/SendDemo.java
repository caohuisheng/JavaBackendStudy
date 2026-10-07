package com.itheima.udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        //创建发送端的socket对象
        DatagramSocket ds = new DatagramSocket();

        //创建数据，并将数据打包
        byte[] bys = "hello,world".getBytes(StandardCharsets.UTF_8);
        InetAddress address = InetAddress.getByName("192.168.56.1");
        DatagramPacket dp = new DatagramPacket(bys,bys.length,address,10086);

        //发送数据
        ds.send(dp);

        //关闭发送端
        ds.close();
    }
}
