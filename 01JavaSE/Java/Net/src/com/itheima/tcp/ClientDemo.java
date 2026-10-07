package com.itheima.tcp;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建客户端的socket对象
        //Socket socket = new Socket(InetAddress.getByName("192.168.56.1"),3306);
        Socket socket = new Socket("192.168.56.1",1234);

        //获取输入流，写数据
        OutputStream os = socket.getOutputStream();
        os.write("hello,world".getBytes());

        //释放资源
        socket.close();
    }
}
