package com.itheima.udp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdressDemo {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress address = InetAddress.getByName("LAPTOP-8D0LHS2L");
        InetAddress address = InetAddress.getByName("192.168.56.1");
        String name = address.getHostName();
        String ip = address.getHostAddress();

        System.out.println("主机名："+name);
        System.out.println("ip地址："+ip);

    }
}
