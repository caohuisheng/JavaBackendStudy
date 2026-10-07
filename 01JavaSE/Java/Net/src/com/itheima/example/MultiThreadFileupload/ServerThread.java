package com.itheima.example.MultiThreadFileupload;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable{
    private Socket socket;

    public ServerThread(Socket s){
        this.socket = s;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //BufferedWriter bw = new BufferedWriter(new FileWriter("Net\\copy.txt"));
            //解决名称冲突问题
            int count = 0;
            File file = new File("Net\\copy"+count+".txt");
            while(file.exists()){
                count++;
                file = new File("Net\\copy"+count+".txt");
            }

            //读取客户端传输的文件
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String line;
            while((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            //发送反馈信息
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bwServer.write("文件上传成功");
            bwServer.newLine();
            bwServer.flush();

            //释放资源
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
