package Generic;

import Set.itheima1.Student;

import java.util.ArrayList;
import java.util.List;

public class Generic_demo {
    public static void main(String[] args) {
        List<?> list1 = new ArrayList<String>();
        List<?> list2 = new ArrayList<Integer>();
        List<?> list3 = new ArrayList<Number>();

//        List<? extends Number> list4 = new ArrayList<Object>();
//        List<? extends Number> list5 = new ArrayList<Integer>();
//
//        List<? super Number> list6 = new ArrayList<Object>();
//        List<? super Number> list7 = new ArrayList<Integer>();
    }
}
