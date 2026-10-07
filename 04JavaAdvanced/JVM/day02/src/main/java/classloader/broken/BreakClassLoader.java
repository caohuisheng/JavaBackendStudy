package classloader.broken;//package com.itheima.jvm.chapter02.classloader.broken;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;

/**
 * 打破双亲委派机制 - 自定义类加载器
 */
public class BreakClassLoader extends ClassLoader {

    private String basePath;
    private final static String FILE_EXT = ".class";

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    private byte[] loadClassData(String name)  {
        try {
            String tempName = name.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
            FileInputStream fis = new FileInputStream(basePath + tempName + FILE_EXT);
            try {
                return IOUtils.toByteArray(fis);
            } finally {
                IOUtils.closeQuietly(fis);
            }
        } catch (Exception e) {
            System.out.println("自定义类加载器加载失败，错误原因：" + e.getMessage());
            return null;
        }
    }

    @Override
    public Class<?> loadClass(String name){
        try {
            byte[] data;
            if(name.startsWith("java.")){
                return super.loadClass(name);
            }
            data = loadClassData(name);
            return defineClass(name, data, 0, data.length);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 使用自定义类加载器加载类
    static void test1(){
        String basePath = "D:\\temp\\jvm\\lib\\";
        String className = "classloader.A";
        BreakClassLoader classLoader = new BreakClassLoader();
        classLoader.setBasePath(basePath);
        Class<?> clazz = classLoader.loadClass(className);
        System.out.println(clazz);
    }

    // 验证两次加载同一个类是不相等的
    static void test2(){
        String basePath = "D:\\temp\\jvm\\lib\\";
        String className = "com.itheima.my.A";
        // 第一次加载
        BreakClassLoader classLoader = new BreakClassLoader();
        classLoader.setBasePath(basePath);
        Class<?> clazz = classLoader.loadClass(className);
        // 第二次加载
        BreakClassLoader classLoader2 = new BreakClassLoader();
        classLoader2.setBasePath(basePath);
        Class<?> clazz2 = classLoader2.loadClass(className);
        System.out.println(clazz == clazz2); //false
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // test1();
        test2();
        System.in.read();
     }
}
