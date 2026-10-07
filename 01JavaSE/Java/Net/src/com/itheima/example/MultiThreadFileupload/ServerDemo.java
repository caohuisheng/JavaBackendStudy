package com.itheima.example.MultiThreadFileupload;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务器socket对象
        ServerSocket ss = new ServerSocket(1234);

        while(true){
            //监听客户端连接，返回一个对应的socket对象
            Socket s = ss.accept();
            //为每一个客户端创建一个线程
            new Thread(new ServerThread(s)).start();
        }

        //ss.close();
    }
}
