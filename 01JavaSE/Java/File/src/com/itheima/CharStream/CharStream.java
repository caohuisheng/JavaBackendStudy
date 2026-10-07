package com.itheima.CharStream;

import java.io.*;

public class CharStream {
    public static void main(String[] args) throws IOException{
        //demo1();
        //demo2();
        //copyJavaFile();
        //copyJavaFile1();
        //copyJavaFile2();
        copyJAvaFile3();
    }

    /*
    字符流中的编码解码问题
     */
    public static void demo1() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("File\\test.txt"),"GBK");
        osw.write("中国");
        int ch;
        osw.close();
        InputStreamReader isr = new InputStreamReader(new FileInputStream("File\\test.txt"),"GBK");
        while((ch = isr.read()) != -1){
            System.out.print((char)ch);
        }
        //chs = isr.read();
        isr.close();
    }

    /*
    字符流写数据的5种方式
     */
    public static void demo2() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("File\\test.txt"));
        osw.write(97);
        osw.flush();
        osw.close();
    }

    /*
    复制java文件
     */
    public static void copyJavaFile() throws IOException{
        //创建字符输入流、输出流对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream("File\\CharStream.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("File\\copy.txt"));

        //复制文件
        char[] chs = new char[1024];
        int len;
        while((len = isr.read(chs))!=-1){
            osw.write(chs,0,len);
        }

        isr.close();
        osw.close();
    }

    /*
    复制java文件改进
     */
    public static void copyJavaFile1() throws IOException{
        FileReader fr = new FileReader("File\\CharStream.txt");
        FileWriter fw = new FileWriter("File\\copy.txt");

        char[] chs = new char[1024];
        int len;
        while((len=fr.read(chs))!=-1){
            fw.write(chs,0,len);
        }

        fr.close();
        fw.close();
    }

    /*
    字符缓冲流复制java文件
     */
    public static void copyJavaFile2() throws IOException{
        //创建字符缓冲流输入、输出对象
        BufferedReader br = new BufferedReader(new FileReader("File\\CharStream.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("File\\copy.txt"));

        //每次读一个字节数组的数据
        char[] chs = new char[1024];
        int len;
        while((len=br.read(chs))!=-1){
            bw.write(chs,0,len);
        }

        //释放资源
        br.close();
        bw.close();
    }

    /*
    字符缓冲流特有功能
     */
    public static void copyJAvaFile3() throws IOException{
        //创建字符缓冲流输入、输出对象
        BufferedReader br = new BufferedReader(new FileReader("File\\CharStream.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("File\\copy.txt"));

        //每次读取文件的一行
        String line;
        while((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        bw.close();
    }

}
