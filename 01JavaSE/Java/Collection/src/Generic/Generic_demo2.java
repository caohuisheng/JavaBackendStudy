package Generic;

import java.util.Arrays;
import java.util.List;

public class Generic_demo2 {
    public static void main(String[] args) {
        //不能增删，可以修改
//        List<String> list = Arrays.asList("hello","world","java");
//        list.add("javaee");
//        list.remove("java");
//        list.set(2,"javaee");

        //不能增删改
        List<String> list2 = List.of("hello","world","java");
        list2.add("javaee");
        list2.remove("java");
        list2.set(2,"javaee");

        System.out.println(list2);
    }
}
