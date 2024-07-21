package com.ccnu.chapter02;

import java.nio.IntBuffer;

/**
 * Author: chs
 * Description: Buffer练习
 * CreateTime: 2024-07-20
 */
public class BasicBuffer {
    public static void main(String[] args) {
        // 创建一个Buffer, 大小为5
        IntBuffer buffer = IntBuffer.allocate(3);
        // 写入数据
        buffer.put(1);
        buffer.put(2);
        buffer.put(3);
        // 读写转换
        buffer.flip();
        // 读取数据
        while(buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
    }
}
