package com.itheima.demo07;

public class LambdaDemo {
    public static void main(String[] args) {
        /*useIter(new Iter() {
            @Override
            public void show() {
                System.out.println("show");
            }
        });

        useStudent(new Student(){
            @Override
            public void study() {
                //super.study();
                System.out.println("I am yeqiu.");
            }
        });*/
//
//        useIter(() -> {
//            System.out.println("show");
//        });

        //当参数为实体类时不可使用Lambda表达式
//        useStudent(() -> {
//            System.out.println("I am yeqiu.");
//        });


        //使用匿名内部类会产生一个单独的字节码文件，而Lambda表达式不会
        useIter(new Iter() {
            @Override
            public void show() {
                System.out.println("show");
            }
        });
        useIter(() -> {
            System.out.println("show");
        });
    }

    static void useIter(Iter iter){
        iter.show();
    }

    static void useStudent(Student stu){
        stu.study();
    }
}
