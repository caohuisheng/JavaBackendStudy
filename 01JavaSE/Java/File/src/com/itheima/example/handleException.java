package com.itheima.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class handleException {
    public static void main(String[] args) {

    }

    private static void copy2(){
        try(FileReader fr = new FileReader("test.txt");
            FileWriter fw = new FileWriter("test1.txt");){
            char[] bys = new char[1024];
            int len;
            while((len=fr.read(bys))!=-1){
                fw.write(bys,0,len);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void copy1(){
        FileReader fr = null;
        FileWriter fw = null;
        try{
            fr = new FileReader("test.txt");
            fw = new FileWriter("test1.txt");

            char[] bys = new char[1024];
            int len;
            while((len=fr.read(bys))!=-1){
                fw.write(bys,0,len);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void copy() throws IOException {
        FileReader fr = new FileReader("test.txt");
        FileWriter fw = new FileWriter("test1.txt");

        char[] bys = new char[1024];
        int len;
        while((len=fr.read(bys))!=-1){
            fw.write(bys,0,len);
        }

        fw.close();
        fr.close();
    }
}
