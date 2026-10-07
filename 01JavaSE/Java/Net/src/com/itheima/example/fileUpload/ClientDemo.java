package com.itheima.example.fileUpload;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.56.1",1234);

        BufferedReader br = new BufferedReader(new FileReader("Net\\file.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while((line = br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //结束输出
        s.shutdownOutput();
//        bw.write("886");
//        bw.newLine();
//        bw.flush();

        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String receiveData = brClient.readLine();
        System.out.println(receiveData);

        br.close();
        s.close();
    }
}
