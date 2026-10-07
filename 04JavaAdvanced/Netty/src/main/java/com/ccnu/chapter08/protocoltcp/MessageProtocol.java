package com.ccnu.chapter08.protocoltcp;

/**
 * Author: chs
 * Description: 协议包
 * CreateTime: 2024-07-28
 */
public class MessageProtocol {
    int len;
    byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
