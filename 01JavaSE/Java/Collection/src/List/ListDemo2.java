package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo2 {
    public static void main(String[] args) {
        t1();
    }
    static void t1(){
        List<String> list = new ArrayList<>();
        String s1 = "hello";
        String s2 = "world";
        String s3 = "java";

        list.add(s1);
        list.add(s2);
        list.add(s3);

        ListIterator<String> lit = list.listIterator();
        while(lit.hasNext()){
            String s = lit.next();
            if(s.equals("java")){
                lit.add("javaee");
            }
        }
        System.out.println("test");
        System.out.println(list);
    }

    static void t2(){
        int[] arr = {1,2,3};

    }
}
