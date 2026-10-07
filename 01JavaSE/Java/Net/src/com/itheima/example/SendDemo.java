package com.itheima.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        //封装键盘录入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine())!=null){
            if(line.equals("886")){
                break;
            }

            //创建数据，并将数据打包
            byte[] bys = line.getBytes(StandardCharsets.UTF_8);
            DatagramPacket dp = new DatagramPacket(bys,bys.length, InetAddress.getByName("192.168.56.1"),3306);

            //发送数据
            ds.send(dp);
        }

        ds.close();
    }
}
