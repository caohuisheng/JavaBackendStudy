package Set.itheima1;

import java.util.TreeSet;

public class Comparable_demo {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>();

        Student s1 = new Student("赵金麦", 20);
        Student s2 = new Student("林更新", 60);
        Student s3 = new Student("刘德华", 30);
        Student s4 = new Student("李连杰", 30);
        Student s5 = new Student("刘德华", 30);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);

        for(Student s:ts){
            System.out.println(s);
        }
    }
}
