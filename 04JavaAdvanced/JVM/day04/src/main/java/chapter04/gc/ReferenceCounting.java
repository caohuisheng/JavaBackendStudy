package chapter04.gc;

import java.io.IOException;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-01-13
 */
public class ReferenceCounting {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.b = b;
        b.a = a;
        // a = null;
        // b = null;
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // System.gc();
        System.out.println("===========");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class A{
    B b;
}
class B{
    A a;
}
