package com.itheima.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class example {
    public static void main(String[] args)throws IOException {
        demo1();
    }

    /*
    集合到文件
     */
    public static void demo1() throws IOException {
        String name;
        int grade;

        //创建集合
        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num1 = s1.getGrade() - s2.getGrade();
                int num2 = num1==0?s1.getName().compareTo(s2.getName()):num1;
                return num2;
            }
        });
        //输入数据并存储
        for(int i=0;i<3;i++){
            Scanner sc = new Scanner(System.in);
            System.out.println("name:");
            name = sc.nextLine();
            System.out.println("grade:wu");
            grade = sc.nextInt();
            Student s = new Student(name,grade);
            ts.add(s);
        }

        //写入文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("File\\student.txt"));
        for(Student s:ts){
            StringBuilder sb = new StringBuilder();
            sb.append(s.getName()).append(",").append(s.getGrade());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }

        bw.close();
    }
}
