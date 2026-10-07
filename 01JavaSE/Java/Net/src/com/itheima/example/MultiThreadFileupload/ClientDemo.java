package com.itheima.example.MultiThreadFileupload;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException{
        //创建socket对象
        Socket s = new Socket("192.168.56.1",1234);

        BufferedReader br = new BufferedReader(new FileReader("Net\\file.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        //上传文件给服务器
        String line;
        while((line = br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //关闭上传
        s.shutdownOutput();

        //接收反馈信息
        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String msg = brClient.readLine();
        System.out.println("服务器反馈："+msg);

        br.close();
        s.close();
    }
}
