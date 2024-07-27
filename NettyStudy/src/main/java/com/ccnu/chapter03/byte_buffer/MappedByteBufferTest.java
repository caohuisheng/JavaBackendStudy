package com.ccnu.chapter03.byte_buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Author: chs
 * Description: MappedByteBuffer（可以让文件直接在内存修改，而如何同步到文件由操NIO完成）
 * CreateTime: 2024-07-20
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/resources/file01.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        // 将channel映射为MappedByteBuffer，读写模式为rw，范围为[0, 5)
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        // 在内存修改文件
        mappedByteBuffer.put(1, (byte)'H');
        mappedByteBuffer.put(2, (byte)'A');
        // 将修改结果写回fileChannel
        fileChannel.write(mappedByteBuffer);
        // 关闭文件
        randomAccessFile.close();
        System.out.println("修改成功~");
    }
}
