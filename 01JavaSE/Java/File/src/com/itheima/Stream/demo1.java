package com.itheima.Stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class demo1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream1();
    }
    public static void FileOutputStream1() throws IOException {
        //创建一个字节输出流对象
        FileOutputStream fos = new FileOutputStream("File\\test.txt");
//        FileOutputStream fos2 = new FileOutputStream(new File("File\\test.txt"));
//        File file = new File("File\\test.txt");
//        FileOutputStream fos3 = new FileOutputStream(file);
        //创建一个字节数组
        byte[] bys = new byte[]{97,98,99,100};
        byte[] bys1 = "abcd".getBytes();
        fos.write(bys);

        //释放资源
        fos.close();
    }

    /*
    异常处理
     */
    public static void FileOutputStream2() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("File\\test.txt", true);
            fos.write(new byte[]{97, 98, 99, 100});
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
