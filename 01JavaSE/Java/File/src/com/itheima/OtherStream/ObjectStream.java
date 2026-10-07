package com.itheima.OtherStream;

import java.io.*;

public class ObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
         //ObjectOutputStream();
         ObjectInputStream();
    }

    private static void ObjectOutputStream() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("File\\oos.txt"));
        Student s = new Student("赵金麦",20);
        oos.writeObject(s);
        oos.close();
    }

    private static void ObjectInputStream() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("File\\oos.txt"));
        Object object = ois.readObject();
        Student s = (Student) object;
        System.out.println(s.getName()+","+s.getAge());
    }
}
