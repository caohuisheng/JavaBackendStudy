package com.itheima03;

import java.io.IOException;

public class RuntimeTest {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Runtime runtime2 = Runtime.getRuntime();
        System.out.println(runtime==runtime2);

        //runtime.exec("calc");
        //runtime.exec("shutdown -s -t 1000");
        runtime.exec("shutdown -a");
    }
}
