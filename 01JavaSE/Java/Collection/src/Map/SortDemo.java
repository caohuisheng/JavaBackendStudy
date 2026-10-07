package Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        Student s1 = new Student("zhaojinmai",20);
        Student s2 = new Student("lingengxin",15);
        Student s3 = new Student("liudehua",30);

        list.add(s1);
        list.add(s2);
        list.add(s3);

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num1 = s1.getAge() - s2.getAge();
                int num2 = num1==0?s1.getName().compareTo(s2.getName()):num1;
                return num2;
            }
        });
        System.out.println(list);
    }
}
