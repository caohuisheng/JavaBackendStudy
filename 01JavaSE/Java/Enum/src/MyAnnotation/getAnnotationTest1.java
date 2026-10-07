package MyAnnotation;

/*
测试框架运行原理
 */
@MyAnnotation(names = {"a","b","c","d"})
public class getAnnotationTest1 {
    public static void main(String[] args) {
        Class<getAnnotationTest1> c = getAnnotationTest1.class;
        MyAnnotation annotation = c.getAnnotation(MyAnnotation.class);
        String[] names = annotation.names();
        for(String n:names){
            System.out.println(n);
        }
//        System.out.println(names);
    }
}
