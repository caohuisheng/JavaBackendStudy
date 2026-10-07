package com.itheima.demo5;

/*
引用构造器
 */
public class StudentDemo {
    public static void main(String[] args) {
        //Lambda表达式
        useStudentBuilder((name,age) -> new Student(name,age));

        //引用构造器
        useStudentBuilder(Student::new);    //形参全部传递给构造器作为参数
    }

    static void useStudentBuilder(StudentBuilder sb){
        Student s = new Student("赵金麦",20);
        System.out.println(s.getName()+","+s.getAge());
    }
}
