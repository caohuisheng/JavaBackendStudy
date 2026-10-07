package com.itheima;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CharacterStream {
    public static void main(String[] args)throws UnsupportedEncodingException {
        demo1();
    }


    public static void demo1() throws UnsupportedEncodingException {
        String str = "中国";
//        byte[] bys = str.getBytes();
        byte[] bys = str.getBytes("GBK");
        System.out.println(Arrays.toString(bys));
    }
}
