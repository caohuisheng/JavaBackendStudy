package com.itheima.web.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String username = "张三";

        //编码
        String encode = URLEncoder.encode(username,"utf-8");

        //解码
        String decode = URLDecoder.decode(encode,"iso-8859-1");
        System.out.println(decode);

        //转换为字节数据，编码
        byte[] bytes = decode.getBytes(StandardCharsets.ISO_8859_1);
        for(byte b:bytes){
            System.out.print(b + " ");
        }

        //将字节数据转换为字符串,编码
        String s = new String(bytes,"utf-8");
        System.out.println(s);
    }
}
