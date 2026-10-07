package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection<Student> students = new ArrayList<>();

        Student s1 = new Student("刘德华",56);
        Student s2 = new Student("霍建华",36);
        Student s3 = new Student("赵金麦",20);

        students.add(s1);
        students.add(s2);
        students.add(s3);

        Iterator<Student> it = students.iterator();
        while(it.hasNext()){
            Student s = it.next();
            System.out.println(s);
        }
    }
}
