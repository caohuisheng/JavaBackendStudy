package Set;

import Collection.Student;

import java.util.HashSet;
public class HashSet_demo2 {
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<>();

        Student s1 = new Student("赵金麦", 20);
        Student s2 = new Student("林更新", 20);
        Student s3 = new Student("刘德华", 20);
        Student s4 = new Student("刘德华", 20);

//        hs.add(s1);
//        hs.add(s2);
//        hs.add(s3);
//        hs.add(s4);
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        System.out.println(s3.equals(s4));

        for(Student s:hs){
            System.out.println(s+",");
        }
    }
}
