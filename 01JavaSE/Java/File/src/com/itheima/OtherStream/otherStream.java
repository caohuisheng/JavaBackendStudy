package com.itheima.OtherStream;

import java.io.*;

public class otherStream {
    public static void main(String[] args) throws IOException{
        //SystemIn();
        //SystemOut();
        //printStream();
        //printWriter();
        copyFile();
    }

    /*
    标准输入流
     */
    private static void SystemIn() throws IOException {
        //创建字符缓冲输入流对象
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        int by;
        while((by = br.read()) != -1){
            System.out.print((char)by);
        }
    }

    /*
    标准输出流
     */
    public static void SystemOut() throws IOException{
        PrintStream ps = System.out;
        ps.println("hello");
        ps.println("world");
    }

    /*
    字节打印流
     */
    private static void printStream() throws IOException{
        PrintStream ps = new PrintStream("File\\ps.txt");
        ps.write(97);
        ps.print(97);
    }

    /*
    字符打印流
     */
    private static void printWriter() throws IOException{
        PrintWriter pw = new PrintWriter(new FileWriter("File\\pw.txt"),true);
        pw.println("hello");
        pw.println("world");
    }

    /*
    使用字符打印流复制文件
     */
    private static void copyFile() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("File\\CharStream.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("File\\copy.txt"));
        String line;
        while((line = br.readLine())!=null){
            pw.println(line);
        }
        pw.close();
        br.close();
    }
}
