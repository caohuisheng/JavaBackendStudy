package com.itheima.Properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest{
    public static void main(String[] args)  throws IOException{
        //store();
        load();
    }

    /*
    保存数据
     */
    static void store() throws IOException {
        //创建属性集合对象
        Properties prop = new Properties();
        prop.setProperty("itheima001","赵金麦");
        prop.setProperty("itheima002","刘亦菲");
        prop.setProperty("itheima003","林更新");

        //使用字符输出流写入数据
        FileWriter fw = new FileWriter("File\\fw.txt");
        prop.store(fw,null);
        fw.close();
    }

    /*
    加载数据
     */
    static void load() throws IOException {
        Properties prop = new Properties();

        //使用字符输入流读取数据
        FileReader fr = new FileReader("File\\fw.txt");
        prop.load(fr);
        System.out.println(prop);
    }
}
