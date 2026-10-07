package com.itheima.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(3306);

        while(true){
            //创建数据包，用于接收数据
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys,bys.length);

            //接收数据
            ds.receive(dp);

            //解析数据包
            //System.out.println(new String(dp.getData()));
            System.out.println("data:"+new String(dp.getData(),0,dp.getLength()));
        }
//        ds.close();
    }
}
