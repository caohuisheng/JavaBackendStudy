package chapter04.gc;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * 类的卸载
 */
public class ClassUnload {
    public static void main(String[] args) throws InterruptedException {
        try {
            ArrayList<Class<?>> classes = new ArrayList<>();
            ArrayList<URLClassLoader> loaders = new ArrayList<>();
            ArrayList<Object> objs = new ArrayList<>();
            while (true) {
                URLClassLoader loader = new URLClassLoader(
                        new URL[]{new URL("file:D:\\temp\\jvm\\lib\\")});
                Class<?> clazz = loader.loadClass("com.itheima.my.A");
                Object o = clazz.newInstance();
                // objs.add(o);
                loaders.add(loader);
                // classes.add(clazz);

                System.gc();
                Thread.sleep(1000);
                System.out.println("==============");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
