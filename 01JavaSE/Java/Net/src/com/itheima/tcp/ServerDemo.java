package com.itheima.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务器端的socket
        ServerSocket serverSocket = new ServerSocket(1234);

        //侦听到要连接此套接字并接受它
        Socket socket = serverSocket.accept();

        //获取输入流，读数据，并把数据显示在控制台
        InputStream is = socket.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.println("data:"+new String(bys,0,bys.length));

        //释放资源
        serverSocket.close();
        socket.close();
    }
}
