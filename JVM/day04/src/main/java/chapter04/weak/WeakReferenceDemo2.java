package chapter04.weak;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * 弱引用案例 - 基本使用
 */
public class WeakReferenceDemo2 {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024 * 1024 * 100];
        WeakReference<byte[]> weakReference = new WeakReference<byte[]>(bytes);
        bytes = null;
        System.out.println(weakReference.get()); //[B@330bedb4
        // 垃圾回收时不论内存空间是否充足，软引用对象都会被垃圾回收
        System.gc();
        System.out.println(weakReference.get()); //null
    }
}
