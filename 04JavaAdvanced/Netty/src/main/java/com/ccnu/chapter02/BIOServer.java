package com.ccnu.chapter02;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: chs
 * Description: BIO服务器
 * CreateTime: 2024-07-20
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("线程信息 id:" + Thread.currentThread().getId() + " name:" + Thread.currentThread().getName());
        System.out.println("服务器启动了...");
        while(true){
            System.out.println("等待客户端连接...");
            Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端...");
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    handle(socket);
                }
            });
        }
    }

    /**
     * 与连接的客户端进行通信
     * @param socket 套接字
     */
    private static void handle(Socket socket){
        try {
            System.out.println("线程信息 id:" + Thread.currentThread().getId() + " name:" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            // 获取输入字节流
            InputStream is = socket.getInputStream();
            // 循环读取信息
            int len;
            while((len = is.read(bytes)) != -1){
                System.out.println(new String(bytes, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            System.out.println("关闭与客户端的连接...");
            try {
                // 关闭与客户端的连接
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
