package com.itheima.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //创建接收端的socket对象
        DatagramSocket ds = new DatagramSocket(10086);

        //创建一个数据包，用于接收数据
        byte[] bys = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bys,bys.length);

        //接收数据
        ds.receive(dp);

        //解析数据包
        byte[] data = dp.getData();
        String dataString = new String(data);
        System.out.println("数据："+dataString);

        //关闭接收端
        ds.close();
    }
}
